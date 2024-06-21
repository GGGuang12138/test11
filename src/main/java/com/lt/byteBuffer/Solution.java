package com.lt.byteBuffer;

import java.nio.ByteBuffer;
import java.nio.channels.Channel;

/**
 * @author Alan
 * @Description
 * @date 2024.01.13 10:44
 */
public class Solution {

    public static void main(String[] args) {
        ByteBuffer bf = ByteBuffer.allocate(10);
        bf.clear();
        bf.rewind();
        bf.put((byte) 1);
        bf.put((byte) 2);
        bf.flip();
        byte b = bf.get();
        System.out.println(b);


        bf.flip();
        bf.put((byte) 3);
        bf.flip();
        byte b1 = bf.get();
        byte b2 = bf.get();
        System.out.println(b1);
    }
}
