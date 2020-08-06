package com.charity.utils;

import org.springframework.stereotype.Component;


/**
 * token
 */
@Component
public interface TokenGenerator {

    public String generate(String... strings);

}
