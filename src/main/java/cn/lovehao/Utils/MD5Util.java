package cn.lovehao.Utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MD5Util {

    //加密的次数
    private static final int hashIterations = 1;
    //采用的加密算法
    private static final String algorithmName = "MD5";
    public static String getMD5(String username,String password){
        Object salt = ByteSource.Util.bytes(username);
        SimpleHash result = new SimpleHash(algorithmName, password, salt, hashIterations);
        return result.toString();
    }
}
