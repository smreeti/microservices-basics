package com.smriti.interceptorservice.utility;

import com.smriti.interceptorservice.exceptionHandler.UnauthorisedException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class JWTTokenUtility {

    private static final String secret = "8KLzTBaON1IB9yZWnn3sy4wqobqS30Yn";

    public static String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");

        if (!Objects.isNull(bearerToken) && bearerToken.startsWith("Bearer"))
            return bearerToken.substring(7, bearerToken.length());

        return null;
    }

    public static boolean validateToken(String token) {
        try {
//            String username = Jwts.parser()
//                    .setSigningKey(secret)
//                    .parseClaimsJws(token)
//                    .getBody()
//                    .getSubject();
//
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token);
//            if (claims.getBody().getExpiration().before(new Date()))
//                return false;

            return true;
        } catch (JwtException | IllegalArgumentException e) {
            throw new UnauthorisedException("Request not authorized, please contact system administrator.",
                    "Expired or invalid JWT token");
        }
    }
}
