package com.edu.commons;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

/**
 * @ProjectName:javaweb
 * @Titile: JWTUtil
 * @Author: Lucky
 * @Description: jwt工具类
 */
public class JWTUtil {
    //设置token的有效期：一周
    @Value("${jwt.token.expire}")
    private static   long token_expire;
    //设置一个密钥\私钥,为了安全需要定期更换
    @Value("${jwt.token.sign}")
    private  static String token_signature;

    /**
     * 生成token的方法
     * @param id 用户编号
     * @return
     */
    public static String generateToken(Integer  id,String username){
        //主体：终端，人/设备
        String subject = String.valueOf(id);
        //当前时间
        Date now = new Date();
        //租约到期时间
        long expireTime = now.getTime() + token_expire;
        //创建过期时间
        Date exp = new Date(expireTime);
        //生成token
        String token = Jwts.builder().setSubject(subject) //设置主体
                .setIssuedAt(now) //设置当前时间
                .setExpiration(exp) //设置过期时间
                .claim("id", id) // id
                .claim("username",username) //员工名称
                .signWith(SignatureAlgorithm.HS256, token_signature) //算法+签名
                .compact();
        return token;
    }
    /**
     * 檢查token的合法性
     * @param token
     */
    public static Claims validateToken(String token) {
        //容器
        Claims claims = null;
        try {
            claims = Jwts.parser().setSigningKey(token_signature)//设置签名
                    .parseClaimsJws(token) //设置解析的token
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw new ServiceException(ServiceCode.ERROR_TOKEN,"解析token异常:token已经失效");
        } catch (UnsupportedJwtException e) {
            throw new ServiceException(ServiceCode.ERROR_TOKEN,"解析token异常:不支持的token解析");
        } catch (MalformedJwtException e) {
            throw new ServiceException(ServiceCode.ERROR_TOKEN,"解析token异常:非法token格式");
        } catch (SignatureException e) {
            throw new ServiceException(ServiceCode.ERROR_TOKEN,"解析token异常：token的签名不合法");
        } catch (IllegalArgumentException e) {
            throw new ServiceException(ServiceCode.ERROR_TOKEN,"解析token异常：非法token参数");
        }
        return claims;
    }
    /**
     * 从token中获取信息
     * @param
     * @return
     */
    public static Integer getUserIdByToken(String token){
        //校验token
        Claims claims = validateToken(token);
        //获取id
        Integer id = Integer.valueOf(claims.get("id").toString());
        return id;
    }
    public static String getUsernameByToken(String token){
        //校验token
        Claims claims = validateToken(token);
        //获取username
        String username = claims.get("username").toString();
        return username;
    }
    public static void main(String[] args) {
        token_expire = 24*60*1000;
        token_signature = "acbdefg";
        String token = generateToken(456,"rose");
        String username = getUsernameByToken(token);
        Integer id = getUserIdByToken(token);
        System.out.println(id+"==="+username);
    }

}
