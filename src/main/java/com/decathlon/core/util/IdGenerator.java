package com.decathlon.core.util;

import com.baomidou.mybatisplus.toolkit.IdWorker;

import java.util.UUID;

/**
 * @Refrence:
 * @Author: jerry.Tan
 * @Date: 2017-08-23 11:10
 * @Modify:
 **/

public class IdGenerator {
    private IdGenerator(){}
    private static byte[] lock = new byte[0];

    public static String getId() {
        return String.valueOf(IdWorker.getId());
    }

    public static long getIdLong() {
        return IdWorker.getId();
    }

    public static String createCode(String var) {
        long r = 0;
        synchronized (lock) {
            r = (long) ((Math.random() * 9 + 1) * 1000);
        }
        return var + System.currentTimeMillis() + String.valueOf(r);
    }

    public static String createId(){
        return UUID.randomUUID().toString().replace("-","");
    }

}
