package com.edu.commons;
import io.jsonwebtoken.*;

import java.util.Date;

/**
 * @ProjectName:javaweb
 * @Titile: JWTUtil
 * @Author: Lucky
 * @Description: jwt工具类
 */
public class JWTUtil {
    //设置token的有效期：一周
    private static final long TOKEN_EXPIRE = 7*24*60*60*1000;
    //设置一个密钥\私钥,为了安全需要定期更换
    private static final String TOKEN_SECRET = "lj115533@#";


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
        long expireTime = now.getTime() + TOKEN_EXPIRE;
        //创建过期时间
        Date exp = new Date(expireTime);
        //生成token
        String token = Jwts.builder().setSubject(subject) //设置主体
                .setIssuedAt(now) //设置当前时间
                .setExpiration(exp) //设置过期时间
                .claim("id", id) // id
                .claim("name",username) //员工名称
                .signWith(SignatureAlgorithm.HS256, TOKEN_SECRET) //算法+签名
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
            claims = Jwts.parser().setSigningKey(TOKEN_SECRET)//设置签名
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
     * 从token中获取员工信息
     * @param
     * @return
     */
    /*public static Employee parseToken(String token){
        //校验token
        Claims claims = validateToken(token);
        //获取id
        Integer id = Integer.valueOf(claims.get("id").toString());
        //获取员工名称
        String empName = claims.get("name").toString();
        Employee employee = new Employee();
        employee.setEmpId(id);
        employee.setEmpName(empName);
        return employee;
    }
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setEmpId(1001);
        employee.setEmpName("admin");
        String token = generateToken(employee);
        System.out.println(token);
    }*/

}
