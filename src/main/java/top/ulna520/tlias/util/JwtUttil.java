package top.ulna520.tlias.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import top.ulna520.tlias.model.User;

import javax.crypto.SecretKey;
import java.util.Map;

@Component
@Data
@NoArgsConstructor
public class JwtUttil {

    SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String constructJwt(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new java.util.Date(System.currentTimeMillis() + 3600 * 1000)) // 1 hour expiration
                .signWith(key)
                .compact();
    }

    public Boolean validateJwt(String jwt) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Map<String, Object> parseJwt(String jwt) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
    }
}
