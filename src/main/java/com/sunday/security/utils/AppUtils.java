package com.sunday.security.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.util.StringUtils;

public class AppUtils {

    public static final String LOGO = "https://res.cloudinary.com/do3waasgr/image/upload/v1704135347/kwmfdq3r1qcnajcgvox1.jpg";

    public static String getTokenFromHttpRequest(HttpServletRequest request) {
        // Get the bearer token from the http request
        String bearerToken = request.getHeader("Authorization");

        // Extract only the Token excluding the prefix "Bearer "
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            System.out.println(bearerToken);
            return bearerToken.substring(7);
        }

        return null;
    }

    public static String applicationUrl(HttpServletRequest request) {

        return "http://" +
                request.getServerName() + ":" +
                request.getServerPort() +
                request.getContextPath();
    }

}
