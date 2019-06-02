package com.mreorhan.ws.security;

import com.mreorhan.ws.SpringApplicationContext;

public class SecurityConstants {
    public static final long EXPIRATION_TIME = 864000000;//10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users";

    public static final String USER_URL = "/users/";
    public static final String LOGIN_URL = USER_URL + "login";


    public static String getTokenSecret() {
        AppProperties appProperties = (AppProperties) SpringApplicationContext.getBean("AppProperties");
        return appProperties.getTokenSecret();
    }
}
