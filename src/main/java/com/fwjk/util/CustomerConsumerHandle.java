package com.fwjk.util;


import com.dragonsoft.bus.kafka.consumer.ConsumerHandle;

/**
 * 自定义消费者处理器实现
 *
 * @author YanPeng
 */
public class CustomerConsumerHandle implements ConsumerHandle {

  
    public void handle(byte[] key, byte[] message) {
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        if (key != null) {
            System.out.println(new String(key));
        }
        if (message != null) {
            System.out.println(new String(message));
        }
    }

}