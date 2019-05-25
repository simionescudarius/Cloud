package cloud.imobiliare.security;

import java.util.Base64;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService
{
 
    @Value("${jwt.expire.hours}")
    private Long expireHours;
 
    @Value("${jwt.token.secret}")
    private String plainSecret;
    private String encodedSecret;
 
    @PostConstruct
    protected void init() {
        this.encodedSecret = generateEncodedSecret(this.plainSecret);
    }
 
    protected String generateEncodedSecret(String plainSecret)
    {
        if (StringUtils.isEmpty(plainSecret))
        {
            throw new IllegalArgumentException("JWT secret cannot be null or empty.");
        }
        return Base64
                .getEncoder()
                .encodeToString(this.plainSecret.getBytes());
    }
 
    protected Date getExpirationTime()
    {
        Date now = new Date();
        Long expireInMilis = TimeUnit.HOURS.toMillis(expireHours);
        return new Date(expireInMilis + now.getTime());
    }
 
    protected JWebTokenUser getUser(String encodedSecret, String token)
    {
        Claims claims = Jwts.parser()
                .setSigningKey(encodedSecret)
                .parseClaimsJws(token)
                .getBody();
        return new JWebTokenUser(claims.get("id").toString(), claims.getSubject(),claims.get("role").toString());
    }
 
    public JWebTokenUser getUser(String token)
    {
        return getUser(this.encodedSecret, token);
    }
 
    protected String getToken(String encodedSecret, JWebTokenUser jwtUser)
    {
        Date now = new Date();
        return Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setSubject(jwtUser.getUserName())
                .claim("id", jwtUser.getId())
                .claim("role", jwtUser.getRole())
                .setIssuedAt(now)
                .setExpiration(getExpirationTime())
                .signWith(SignatureAlgorithm.HS512, encodedSecret)
                .compact();
    }
 
    public String getToken(JWebTokenUser jwtUser)
    {
        return getToken(this.encodedSecret, jwtUser);
    }
}