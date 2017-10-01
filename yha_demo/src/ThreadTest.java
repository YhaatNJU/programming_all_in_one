/**
 * Author:yangsanyang
 * Time:2017/9/30 下午11:18.
 * Illustration:
 */
public class ThreadTest {
    
    Thread thread = new Thread();
    static volatile int i = 0;
    
    static class VolatileTest implements Runnable{
        @Override
        public void run() {
            for (int k = 0; k < 10000; k ++){
                i++;
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException{
    
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++){
            threads[i] = new Thread(new VolatileTest());
            threads[i].start();
        }
        
        for (int i = 0; i < 10; i++){
            threads[i].join();
        }
        
        System.out.println(i);
    }
}
