package com.charity.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.io.IOException;
import java.util.HashMap;

public class SendSms {
    public static HashMap<String,String> getMessageStatus(String mobile) throws IOException {
        HashMap<String,String> hashMap = new HashMap<>();
        // 第三方平台网站地址阿里
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FoZZzVvdWkmrXQTjYX8", "u6hT0sHy46UbBfEoUkDs05aV7odVGy");
        IAcsClient client = new DefaultAcsClient(profile);
        String randMun = String.valueOf(RandomUtil.getRandNum());
        System.out.println(randMun);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", "爱心献社会");
        request.putQueryParameter("TemplateCode", "SMS_184815493");
        request.putQueryParameter("TemplateParam", "{code:"+randMun+"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            //6位数验证码放入到map列表里面和赋值result=1状态码
            hashMap.put("result", "1");
            hashMap.put("code", randMun);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return hashMap;
    }

}