package com.dev.ddaangn.user.config;

/**
 * Created by Neon K.I.D on 8/9/20
 * Blog : https://blog.neonkid.xyz
 * Github : https://github.com/NEONKID
 */
public enum SocialType {
    GOOGLE("google"),
    KAKAO("kakao");

    private final String ROLE_PREFIX = "ROLE_";
    private String name;

    SocialType(String name) {
        this.name = name;
    }

    public String getRoleType() {
        return ROLE_PREFIX + name.toUpperCase();
    }

    public String getValue() {
        return name;
    }

    public boolean isEquals(String authority) {
        return this.getRoleType().equals(authority);
    }
}