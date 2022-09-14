package com.xhd.gulimall;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.UUID;
import java.util.concurrent.*;

public class test {
    public static ExecutorService executor = Executors.newFixedThreadPool(10);
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
        FutureTask futureTask = new FutureTask<>(new Thread3());
        new Thread(futureTask).start();
        Object o = futureTask.get();
        System.out.println("HHHHH"+ o);
//        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(
//                2,
//                50,
//                50,
//                TimeUnit.SECONDS,
//                null,
//                null,
//                null);
    }
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程:" + Thread.currentThread().getName());
            int i = 10 / 2;
            System.out.println("运行结构" + i);
            return i;
        }, executor).whenComplete((res, exception) -> {
            System.out.println("异步完成了...结果是" + res + "异常是:" + exception);
        });
        class Thread1 implements Runnable {
            @Override
            public void run() {
                System.out.println("现在的线程是" + Thread.currentThread().getName());
            }
        }
        class Thread2 extends Thread {
            @Override
            public void run() {
                System.out.println("现在的线程是" + Thread.currentThread().getName());
            }
        }
        class Thread3 implements Callable {
            @Override
            public String call() throws Exception {
                System.out.println("现在的线程是" + Thread.currentThread().getName());
                return "现在的线程是" + Thread.currentThread().getName();
            }
        }
        @Test
        public void runtogeter(){       //两任务完成，一任务执行，
            CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
                System.out.println("任务一线程开始" + Thread.currentThread().getName());
                System.out.println("任务一结束");
                return "任务一";
            }, executor);

            CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
                System.out.println("任务二线程开始" + Thread.currentThread().getName());
                System.out.println("任务二结束");
                return "任务二";
            }, executor);
//            future1.runAfterBothAsync(future2,()->{   //并不能感知前两个任务的结果
//                System.out.println("任务一，任务二结束，任务三开始");
//            },executor);
            future1.thenAcceptBothAsync(future2,(f1,f2)->{
                System.out.println("接收前两个任务的结果"+f1+"--->>>"+f2);
            },executor) ;
            System.out.println("main   end   .....");
        }
        @Test
        public  void  runEither(){
            CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
                System.out.println("任务一线程开始" + Thread.currentThread().getName());
                System.out.println("任务一结束");
                return "任务一";
            }, executor);

            CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
                System.out.println("任务二线程开始" + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                    System.out.println("任务二结束");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return "任务二结束 ";
            }, executor);
//            future1.runAfterEitherAsync(future2,()->{
//                System.out.println("任务三开始");
//            },executor);
            future2.runAfterEitherAsync(future1,()->{
                System.out.println("任务三开始");
            },executor);
            System.out.println("main   end   .....");
        }
    }
