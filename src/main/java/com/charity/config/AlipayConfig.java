package com.charity.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101800711788";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCMWcOQgLFFxraIoG28WbXi+7Zn9p4MHpCgZSMs9OY0KVcYZ4a3G02D347Lon9S6bPnTLkTkFamwZbCjt5gfAQqicBiWkOPSy8sqvohE+FrE6qAvZYrQaVyuLEkqulFFcOIIpkKcDkYZ5iqjVO6ICyORFR6l1kUoe+Y1QrnaBkVrIEBu5zHWRZbIqXHhG0TtuzTOMVyxhCDwmKA6nc6gSkAU1BRutGDBcxibtyEj6PuR7XI+4xQEd2gic1VWavqx4nK9P8a7IkqQIyg+J/NGMjCJshaQq/8qj/9ghl7a30E0lr5yteEm5wqUGvJo9QZ0mSf1gmNXwOO0xt5TckuJs+/AgMBAAECggEAE74wz2v7A+i/FpsStLMd7e8gqqE7fFL0X0u61gEhPOcv1EQD5FAX6FwTVzvlk0FCyF+3jTP5rH2A+p9kUsg/Qcic4nj2FfsqiKsIgoysYgajLnb839rdLjUi3hiYtdoo5kaPprNApNk11ZAJ3h3WhrC//Xq60jcxYBtf7Ettc+nZs4udDkXUuRJ97zOxLmA+RGv+yE9E8RJXLbWCVH9zPo6JbJVyyry5IXXtPyJhlnT2Dbvq0QZCMw+dO0YoVHJdIgfncw58xU0WlifOG8wAq/hWGBhKWYkEX73PphA6ggT1nHT5k5zB5MnT+92RP5slQ0kZzL+SX0YufFzR0v9wCQKBgQDPjOzw7IPL6wap/NLX0b05AejUBzZJJjx4ywHd1ik0hbFNos049qZ1h8HrGPjGj+W1FgDUL31MYSIs27N2DxNbppAjML7JDz7QEb4B/lwY6eJ/pcd1aObkme6XpWTADqLXKzL7OIeEEMTiT8jkF7QSWmx2Dv6SeeXt7xJOWLXEfQKBgQCtHQWGkIb0jUnNQoayjUW+PX3zPpMo2hX4XwBI6wAS+Arkvsmf/DXpd9E3lxXi+4LIjyiT8jtzhrhXqy2J14Tt9SiIMW9fa63LduuigvP9PK2jBlU6lQClJkH3om93SHOO/HqJK0Y6/WxNssspZsTo4HaDlhvSYz8oalho31kF6wKBgG6FugsVt51YW2UcB977hosb9DMsYAEWBm/Akw7ho3Gfm+oevrAN0FiX4XDjDF8Yc5c5z1kurMeGlh9TIz7ECmfsy6ahp4cDwkwklo0TOVHfAkk9K3jfUsz7F63TWlJXuOlhzLUwxiFSmLV3DSBBaxe25Tj9BR1VIlbQz2u/G5Q1AoGAShfLz6Z4PJ9kYRgCMtXIbf4/tCaqMaf2E1IF+y+p3nSPpQwLnBAEuyJvR43A7l+bwF+VjIz26SFWMR+w4/h8iqSNbo1KD9s0jYsem3XVHCQmZUpGnEY9+nF/do/tiW5XF3H0uFTvQDxLaI4H6nZz/QBleTh8O/YCiDfME0bVAXUCgYEAvbsvTBMdGvrKUw4/ebhBv0gHdxqQygt4lrXNd1UjDwa3wYtxualanTdc0lb6U8zr+iH3cfHT9CjYFKPHUdL0CgmsBIvBX+bfCWhtA385m3LSWLdFCOJvG9Ehc192gHORGfV1Rf7MC8F+iRPZI7Ckjp95ogk9XNp/baZWmcfrXZI=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqWkgV+bVSyONqDzCEJPPDrDhpx/L0AzpN+gVqIDPVlFC4JhwHla+KO03RU56ycYKCW8DkQxnHXinAqUqAaLnlgaORTnM3EtjRnNceztOpCgoe7tkVKfsTTzittuWnZzsog74sGXUPzLIelqhRR17RmpDWGkOmwaKRKHwcgWj8ytzAzOGAuF1waMSCqpm45o9yP3R5PQI2e0ddVu14sPtyUPoEG0JVQg+lMcf3xnIRPFiEHeice4Z81skBxog8sJyJ187CG/qZDYQljejAguWwiABMj1EMcLTSJm5bGHWzePDkWHR1SY94dHDeKXh5X3lqr036ouzDGqw7dwEBQG4wwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/notify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/returnUrl";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "D:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}