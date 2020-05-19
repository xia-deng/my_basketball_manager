package com.lindeng.basketballmanager.util;

import java.time.Instant;
import java.util.Random;

public class RandomUtil {

    public static double nextDouble(final double min, final double max) {
        double result = min + ((max - min) * new Random().nextDouble());
        return Math.floor(result*100)/100;
    }
    public static int nextInt(final int min, int max) {
        if(max <= 0){
            return 0;
        }
        return new Random().nextInt(max) % (max-min+1) + min;
    }

    public static long randomAgoDate(){
        //int agoYear = RandomUtil.nextInt(5, 60);
        return Instant.now().toEpochMilli();
    }
}
