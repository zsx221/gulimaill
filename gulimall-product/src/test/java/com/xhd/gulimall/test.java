package com.xhd.gulimall;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.UUID;
import java.util.concurrent.*;

public class test {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Test
   public void redisTest() throws ExecutionException, InterruptedException {
//        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();
//        //保存
//        ops.set("hello","word"+ UUID.randomUUID().toString());
//        //查询
//        String hello = ops.get("hello");
//        Thread1 thread1=new Thread1();
//        new Thread(thread1).start();//实现runable实现异步
        System.out.println("HHHHH");
//        Thread2 thread2=new Thread2();//继承Thread实现异步
//        new Thread(thread2).start();
        FutureTask futureTask=new FutureTask<>(new  Thread3());
        new Thread(futureTask).start();
        Object o = futureTask.get();
        System.out.println("HHHHH"+ o);
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(
                2,
                50,
                50,
                TimeUnit.SECONDS,
                null,
                null,
                null);
    }
    class Thread1 implements Runnable{
        @Override
        public void run() {
            System.out.println("现在的线程是"+Thread.currentThread().getName());
        }
    }
    class Thread2 extends Thread{
        @Override
        public void run() {
            System.out.println("现在的线程是"+Thread.currentThread().getName());
        }
    }
    class Thread3 implements Callable {
        @Override
        public String call() throws Exception {
            System.out.println("现在的线程是"+Thread.currentThread().getName());
            return "现在的线程是"+Thread.currentThread().getName();
        }
    }
}
