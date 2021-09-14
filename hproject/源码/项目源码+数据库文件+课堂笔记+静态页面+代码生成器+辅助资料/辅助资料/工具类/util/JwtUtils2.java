package com.yanzhen.util;


import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.yanzhen.model.AdminInfo;
import com.yanzhen.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Data;

import java.util.Date;
import java.util.Map;
import com.auth0.jwt.JWT;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

@Data
public class JwtUtils2 {
    //签名私钥
    private static String key="kappy";
    //签名失效时间 30 分钟
    private static Long failureTime=30 * 60 * 1000L;
    /**
     * 加密生产token
     * @param user
     * @return
     */
    public static String geneJsonWebToken(AdminInfo user){
        if(user==null||user.getId()==null||user.getUsername()==null){
            return null;
        }

        String token=Jwts.builder()
                .claim("id",user.getId())
                .claim("name",user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+failureTime))
                .signWith(SignatureAlgorithm.HS256,key).compact();

        return token ;
    }

    /**
     * 校验token
     * @param token
     * @return
     */
    public static  Claims checkJWT(String token ) {

        try {
            final Claims claims = Jwts.parser().setSigningKey(key).
                    parseClaimsJws(token).getBody();
            return claims;

        } catch (Exception e) {
        }
        return null;

    }

    /**
     * 获取用户ID
     * @param
     * @return
     */
    public static Integer getUserId(String token){
        Claims claims=JwtUtils2.checkJWT(token);
        return (Integer)claims.get("id");
    }


    /*
     * Token 是否过期验证
     */
    public static boolean isTokenExpired (Date expirationTime) {
        return expirationTime.before(new Date());
    }
}
