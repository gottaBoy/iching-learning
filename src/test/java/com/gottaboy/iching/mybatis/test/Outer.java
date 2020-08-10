package com.gottaboy.iching.mybatis.test;

import java.io.Serializable;

public class Outer implements Serializable {
    private int rank;
    static class Inner implements Serializable {
        protected String name;
    }

    public static void main(String[] args) {
        System.out.println("aaa");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("aaa");
                }
            }
        });
        thread.start();
    }
}
