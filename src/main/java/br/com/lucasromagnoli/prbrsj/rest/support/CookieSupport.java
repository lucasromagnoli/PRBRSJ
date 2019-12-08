package br.com.lucasromagnoli.prbrsj.rest.support;

import javax.servlet.http.Cookie;

public class CookieSupport {

    private CookieSupport() { }

    public static Cookie make(String name, String value, boolean optionHttpOnly,
                       boolean optionHttpsSecure, String path, int maxAge) {

        Cookie cookie = new Cookie(name, value);
        cookie.setHttpOnly(optionHttpOnly);
        cookie.setSecure(optionHttpsSecure);
        cookie.setPath(path);
        cookie.setMaxAge(maxAge);

        return cookie;
    }
}
