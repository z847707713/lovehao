package utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MD5Test {

    public static void main(String[] args){
        String algorithmName = "MD5";    //使用的加密算法
        Object source = "123456";        //密码的明文
        Object salt = ByteSource.Util.bytes("zh");              //
        int hashIterations = 1;          //加密的次数
        Object result = new SimpleHash(algorithmName, source, salt, hashIterations);
        System.out.println(result);

    }
}
