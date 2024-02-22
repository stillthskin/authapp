package config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JwtService {
    private static final String SECRET_KEY = "9CrSsqlRlj/dLwZ6JbfNgw==";
    public String getUsername(String jwttoken){

        return "";

    }
    public Claims getAllClaims(String jwttoken)
    {
        return Jwts
                .parser()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(jwttoken)
                .getBody();

    }

    private Key getSignKey() {
        byte[] keyByte = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyByte);
    }
}
