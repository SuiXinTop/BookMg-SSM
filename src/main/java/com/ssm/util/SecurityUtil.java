package com.ssm.util;

import org.springframework.util.DigestUtils;

/**
 * @author xxx
 * @create 2021-09-10
 */
public class SecurityUtil {
    public static String getMd5(String str) {
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }
}
