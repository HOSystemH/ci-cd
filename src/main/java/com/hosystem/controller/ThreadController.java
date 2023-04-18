package com.hosystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author hyh
 * @Createdate 2022/12/6 23:05
 */
@RestController
@RequestMapping("/thread")
public class ThreadController {
    private Object obj1 = new Object();
    private Object obj2 = new Object();

    @RequestMapping("/deadlock")
    @ResponseBody
    public String test() {
        new Thread(() -> {
            synchronized (obj1) {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    synchronized (obj2) {
                        System.out.printf("thread 1执行到此");
                    }
                }
            }
        }, "thread 1").start();

        new Thread(() -> {
            synchronized (obj2) {
                synchronized (obj1) {
                    System.out.printf("thread 2执行到此");
                }
            }
        }, "thread 2").start();
        return "thread test";
    }

    @RequestMapping("/endlessloop")
    @ResponseBody
    public void test1() {
        new Thread(() -> {
            while (true) {
                String str = UUID.randomUUID().toString().replaceAll("-", "");
            }
        }, "cpu demo thread").start();

        new Thread(() -> {
            while (true) {
                String str = UUID.randomUUID().toString().replaceAll("-", "");
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "cpu with sleep thread").start();
    }
}
