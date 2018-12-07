package com.kevin.kglib.net.cookie;

import com.kevin.kglib.utils.SharedPreferencesUtils;
import okhttp3.Cookie;

import java.util.ArrayList;
import java.util.List;

/**
 * cookie 管理
 * Created by kevin on 16/8/9.
 */

public enum CookieManager {

    INSTANCE;

    public static final String COOKIE = "cookie_";
    public static final String COOKIE_SIZE = "cookie_size";

    /**
     * sava the cookies
     *
     * @param cookies
     */
    public static void saveCookie(List<Cookie> cookies) {
        if (cookies == null || cookies.size() == 0)
            return;

        for (int i = 0; i < cookies.size(); i++) {
            SharedPreferencesUtils.save(COOKIE + i, cookies.get(i).toString());
        }

        SharedPreferencesUtils.save(COOKIE_SIZE, cookies.size());
    }

    /**
     * get the cookie
     *
     * @return
     */
    public static List<String> getCookie() {
        List<String> cookies = new ArrayList<>();

        int size = SharedPreferencesUtils.get(COOKIE_SIZE, 0);

        for (int i = 0; i < size; i++) {
            String cookieString = SharedPreferencesUtils.get(COOKIE + i, "");
            cookies.add(cookieString);
        }
        return cookies;
    }

    public static void clearCookie() {
        int size = SharedPreferencesUtils.get(COOKIE_SIZE, 0);

        for (int i = 0; i < size; i++) {
            SharedPreferencesUtils.save(COOKIE + i, "");
        }
    }
}
