package com.zwen.passbook.security;


/**
 * <h1>Use ThreadLocal to store the token info provided by each thread</h1>
 * 5-4
 */
public class AccessContext {
    private static final ThreadLocal<String> token = new ThreadLocal<String>();

    public static String getToken() {
        return token.get();
    }

    public static void setToken(String tokenStr) {
        token.set(tokenStr);
    }

    public static void clearAccessKey() {
        token.remove();
    }
}
