package com.charity.Interceptor;

import com.charity.utils.RedisUtils;
import com.charity.model.AuthToken;
import com.charity.model.ConstantKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.lang.reflect.Method;
public class AuthorizationInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    //创建redis连接
    @Autowired
    private RedisUtils redisUtils;

    //存放鉴权信息的Header名称，默认是Authorization
    private String HeaderName = "Authorization";

    //鉴权失败后返回的错误信息，默认为401 unauthorized
    private String unauthorizedErrorMessage = "401 unauthorized";

    //鉴权失败后返回的HTTP错误码，默认为401
    private int unauthorizedErrorCode = HttpServletResponse.SC_UNAUTHORIZED;

    /**
     * 存放登录用户模型Key的Request Key
     */
    public static final String REQUEST_CURRENT_KEY = "REQUEST_CURRENT_KEY";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        HttpSession   session   =   request.getSession();

        // 如果打上了AuthToken注解则需要验证token
        if (method.getAnnotation(AuthToken.class) != null || handlerMethod.getBeanType().getAnnotation(AuthToken.class) != null) {

//            String token = request.getHeader(httpHeaderName);
            String token = (String) session.getAttribute("httpHeaderName");
            String username="";
            if (token != null && token.length() != 0) {
                username = (String) redisUtils.get(token);
            }
            if (username != null && !username.trim().equals("")) {
                if(redisUtils.get(username+"Auth")==null||redisUtils.get(username+"Auth")=="null"){
                    request.getRequestDispatcher("compel1").forward(request, response);
                    return false;
                }
                redisUtils.expire(username+"Auth", ConstantKit.Auth_EXPIRE_TIME);
                Long tokeBirthTime = Long.valueOf((String) redisUtils.get(token + username));
                Long diff = System.currentTimeMillis() - tokeBirthTime;
                //重新设置Redis中的token过期时间
                if (diff > ConstantKit.TOKEN_RESET_TIME) {
                    redisUtils.expire(username, ConstantKit.TOKEN_EXPIRE_TIME);
                    redisUtils.expire(token, ConstantKit.TOKEN_EXPIRE_TIME);
                    //log.info("Reset expire time success!");
                    Long newBirthTime = System.currentTimeMillis();
                    redisUtils.set(token + username, newBirthTime.toString());
                }
                request.setAttribute(REQUEST_CURRENT_KEY, username);
                return true;
            } else {
                PrintWriter out = null;
                try {
                    request.setAttribute("msg", "您还没有登录，请先登录！");
                    request.getRequestDispatcher("middle").forward(request, response);
                    return false;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (null != out) {
                        out.flush();
                        out.close();
                    }
                }

            }

        }

        request.setAttribute(REQUEST_CURRENT_KEY, null);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
