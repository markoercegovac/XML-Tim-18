package com.user.manager.jwt;

import org.springframework.beans.factory.annotation.Value;

public class JwtProperties {

    public static final String SECRET = "usermanager123";
    public static final int EXPIRATION_TIME = 864000000;//10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING =  "Authorization";

}
