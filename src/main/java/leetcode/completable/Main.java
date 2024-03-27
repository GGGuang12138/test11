package leetcode.completable;

import java.util.concurrent.CompletableFuture;

/**
 * @author Alan
 * @Description
 * @date 2024.03.17 12:18
 */
public class Main {

    public static void main(String[] args) {
//        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
//            try{
//                System.out.println("supplyAsync thread: " + Thread.currentThread().getName());
//                return "hello world";
//            } catch (Exception e){
//                return "failed";
//            }
//        }).thenApply(r -> {
//            System.out.println("thenApply thread: " + Thread.currentThread().getName());
//            return r;
//        });
//        future.whenComplete((res, throwable)->{
//            System.out.println(res + " " + Thread.currentThread().getName());
//        });

        CompletableFuture<String> future1 = new CompletableFuture<>();
        future1.complete("hello world");
        future1.thenApply(r -> {
            System.out.println("thenApply thread: " + Thread.currentThread().getName());
            return r;
        });
        System.out.println(future1.join());

        try{
            Thread.sleep(20000L);
        }catch (Exception e){

        }
    }
}
