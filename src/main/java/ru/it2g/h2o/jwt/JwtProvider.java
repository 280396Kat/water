package ru.it2g.h2o.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Slf4j
@Component
public class JwtProvider {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private Long jwtExpiration; // срок действия токена

    public String generateToken(String login) { // генерируем токен на основании логина
        return Jwts.builder()
                .setSubject(login)
                .setExpiration(new Date((new Date()).getTime() + jwtExpiration))
                .signWith(jwtSecretKey(), SignatureAlgorithm.HS256)
                .compact();// указываем алоритм для создания токена
    }

    private Key jwtSecretKey() { // метод сверяет подпись
        return Keys.hmacShaKeyFor(Base64.getEncoder().encode(jwtSecret.getBytes()));
    }

    public boolean validToken(String token) { // проверка токена
        try {
            Jwts.parserBuilder()
                    .setSigningKey(jwtSecretKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException exception) {
            log.error("Неверный jwt-токен: {}", exception.getMessage());
        } catch (ExpiredJwtException exception) {
            log.error("Срок действия токена истёк: {}", exception.getMessage());
        } catch (UnsupportedJwtException exception) {
            log.error("Токен не поддерживается: {}", exception.getMessage());
        } catch (IllegalArgumentException exception) {
            log.error("Строка jwt пустая: {}", exception.getMessage());
        }
        return false;
    }

    public String getLoginByToken(String token) { //
     return Jwts.parserBuilder()
             .setSigningKey(jwtSecretKey())
             .build()
             .parseClaimsJws(token)
             .getBody()
             .getSubject();
    }
}
