package com.charity.controller;


import com.alibaba.fastjson.JSON;
import com.charity.model.AuthToken;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/websocket/{username}")
@Controller
public class WebsocketController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 在线人数
     */
    public static int onlineNumber = 0;
    /**
     * 以用户的姓名为key，WebSocket为对象保存起来
     */
    private static Map<String, WebsocketController> clients = new ConcurrentHashMap<String, WebsocketController>();
    /**
     * 会话
     */
    private Session session;
    /**
     * 用户名称
     */
    private String username;


    /**
     * 进入聊天室 --> 项目中读取用户信息获取用户名
     */
    @RequestMapping("websocket")
    @AuthToken
    public String webSocket(Model model, HttpSession session) {

        //定义随机时间戳名称
        String name = (String) session.getAttribute("username");
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String ip = inetAddress.toString();
        String localhost = StringUtils.substringAfterLast(ip, "/");
        //websock链接地址+游客名-->  项目中请定义在配置文件 -->或直接读取服务器，ip 端口
        String path = "ws://" + localhost + ":8080/websocket/";
        model.addAttribute("path", path);
        model.addAttribute("username", name);
        return "chatroom";
    }


    /**
     * 监听连接（有用户连接，立马到来执行这个方法）
     * session 发生变化
     *
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam("username") String username, Session session) {
        onlineNumber++;
        //把新用户名赋给变量
        this.username = username;
        //把新用户的 session 信息赋给变量
        this.session = session;
        //输出 websocket 信息
        logger.info("现在来连接的客户id：" + session.getId() + "用户名：" + username);
        logger.info("有新连接加入！ 当前在线人数" + onlineNumber);
        try {
            //把自己的信息加入到map当中去，this=当前类（把当前类作为对象保存起来）
            clients.put(username, this);
            //获得所有的用户
            Set<String> lists = clients.keySet();

            // 先给所有人发送通知，说我上线了
            //messageType 1代表上线 2代表下线 3代表在线名单 4代表普通消息
            Map<String, Object> map1 = new HashMap();
            //  把所有用户列表
            map1.put("onlineUsers", lists);
            //  返回上线状态
            map1.put("messageType", 1);
            //  返回用户名
            map1.put("username", username);
            //  返回在线人数
            map1.put("number", onlineNumber);
            //  发送全体信息（用户上线信息）
            sendMessageAll(JSON.toJSONString(map1), username);


            // 给自己发一条消息：告诉自己现在都有谁在线
            Map<String, Object> map2 = new HashMap();
            //messageType 1代表上线 2代表下线 3代表在线名单 4代表普通消息
            map2.put("messageType", 3);
            //把所有用户放入map2
            map2.put("onlineUsers", lists);
            //返回在线人数
            map2.put("number", onlineNumber);
            // 消息发送指定人（所有的在线用户信息）
            sendMessageTo(JSON.toJSONString(map2), username);
        } catch (IOException e) {
            logger.info(username + "上线的时候通知所有人发生了错误");
        }
    }


    /**
     * 监听连接断开（有用户退出，会立马到来执行这个方法）
     */
    @OnClose
    public void onClose() {
        onlineNumber--;
        //所有在线用户中去除下线用户
        clients.remove(username);
        try {
            //messageType 1代表上线 2代表下线 3代表在线名单  4代表普通消息
            Map<String, Object> map1 = new HashMap();
            map1.put("messageType", 2);
            //所有在线用户
            map1.put("onlineUsers", clients.keySet());
            //下线用户的用户名
            map1.put("username", username);
            //返回在线人数
            map1.put("number", onlineNumber);
            //发送信息，所有人，通知谁下线了
            sendMessageAll(JSON.toJSONString(map1), username);
        } catch (IOException e) {
            logger.info(username + "下线的时候通知所有人发生了错误");
        }
        logger.info("有连接关闭！ 当前在线人数" + onlineNumber);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        logger.info("服务端发生了错误" + error.getMessage());
        //error.printStackTrace();
    }

    /**
     * 监听消息（收到客户端的消息立即执行）
     *
     * @param message 消息
     * @param session 会话
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        try {
            logger.info("来自客户端消息：" + message + "客户端的id是：" + session.getId());
            //用户发送的信息
            com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(message);
            //发送的内容
            String textMessage = jsonObject.getString("message");
            //发送人
            String fromusername = jsonObject.getString("username");
            //接收人  to=all 发送消息给所有人 || to= !all   to == 用户名
            String tousername = jsonObject.getString("to");

            //发送消息  -- messageType 1代表上线 2代表下线 3代表在线名单  4代表消息
            Map<String, Object> map1 = new HashMap();
            map1.put("messageType", 4);
            map1.put("textMessage", textMessage);
            map1.put("fromusername", fromusername);
            if (tousername.equals("All")) {
                //消息发送所有人（同步）
                map1.put("tousername", "所有人");
                sendMessageAll(JSON.toJSONString(map1), fromusername);
            } else {
                //消息发送指定人（同步）
                map1.put("tousername", tousername);
                sendMessageTo(JSON.toJSONString(map1), tousername);
            }
        } catch (Exception e) {
            logger.info("发生了错误了");
        }
    }

    /**
     * 消息发送指定人
     */
    public void sendMessageTo(String message, String ToUserName) throws IOException {
        //遍历所有用户
        for (WebsocketController item : clients.values()) {
            if (item.username.equals(ToUserName)) {
                //消息发送指定人（同步）
                item.session.getBasicRemote().sendText(message);
                break;
            }
        }
    }

    /**
     * 消息发送所有人
     */
    public void sendMessageAll(String message, String FromUserName) throws IOException {
        for (WebsocketController item : clients.values()) {
            //消息发送所有人（同步）getAsyncRemote
            item.session.getBasicRemote().sendText(message);
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineNumber;
    }
}





/*
 *  注解说明
 *  @MessageMapping(value = "/chat")   // 匹配客户端 send 消息时的URL
 *  @SendTo("/topic/getResponse")      //用于给客户端订阅广播消息
 *  @SendToUser(value = "/personal")   //用于给客户端订阅点对点消息；
 *  @Payload：使用客户端 STOMP 帧的 body 赋值
 *  @Header(“xxx”)：使用客户端 STOMP 帧的 headers 中的 xxx 赋值
 *
 **/

/**
 * 广播推送
 * <p>
 * 点对点推送
 * <p>
 * 异常信息推送
 */
//    @MessageMapping(value = "/chat") // 匹配客户端 send 消息时的URL
//    @SendTo("/topic/getResponse")   //分别用于给客户端订阅广播消息
//    public String talk(@Payload String text, @Header("simpSessionId") String sessionId) throws Exception {
//        return "【" + sessionId + "】说:【" + text + "】";
//    }

/**
 * 点对点推送
 */
/*
    @MessageMapping(value = "/speak")  // 匹配客户端 send 消息时的URL
    @SendToUser(value = "/personal")   //分别用于给客户端订阅点对点消息；
    public String speak(@Payload String text, @Header("simpSessionId") String sessionId) throws Exception {
        return text;
    }
    */

/**
 * 异常信息推送
 */
/*
    @MessageExceptionHandler
    @SendToUser(value = "/errors")
    public String handleException(Throwable exception) {
        return exception.getMessage();
    }*/
