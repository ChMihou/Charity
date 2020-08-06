package com.charity.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;


/**
 * 生成简单token
 */
@Component
public class Md5TokenGenerator implements TokenGenerator {

    @Override
    public String generate(String... strings) {
        long timestamp = System.currentTimeMillis();
        String tokenMeta = "";
        for (String s : strings) {
            tokenMeta = tokenMeta + s;
        }
        tokenMeta = tokenMeta + timestamp;
        String token = DigestUtils.md5DigestAsHex(tokenMeta.getBytes());
        return token;
    }
}
