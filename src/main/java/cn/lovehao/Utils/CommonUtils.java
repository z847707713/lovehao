package cn.lovehao.Utils;

import java.util.Random;

public class CommonUtils {

    private static Random random = new Random(10000);

    public static long getRandomNumber(){
        return random.nextLong();
    }

}
