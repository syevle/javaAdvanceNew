package javaPractice.thread.defogexample.CyclicBarrierExample;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//class Race implements Runnable{
//
//    @Override
//    public void run() {
//        System.out.println("All Player Ready to run");
//    }
//}

class Player extends Thread{
    CyclicBarrier waitPoint;
    public Player(CyclicBarrier waitPoint,String name){
        super(name);
        this.waitPoint = waitPoint;
    }
    public void run(){
        System.out.println("Player "+getName()+" is ready to race");
        try
        {
            waitPoint.await();
        }catch (InterruptedException e){ }
        catch (BrokenBarrierException e){}
    }
}

public class CyclicBarrierRaceDemo {
    public static void main(String[] args) {
        System.out.println("4 Leans are created race will start as soon as all player arrive");
        CyclicBarrier raceBarrier = new CyclicBarrier(4,()->System.out.println("All Player Ready to run"));
        new Player(raceBarrier,"Ferrari").start();
        new Player(raceBarrier,"BMW").start();
        new Player(raceBarrier,"Skoda").start();
        new Player(raceBarrier,"Ford").start();
        raceBarrier.reset();
        new Player(raceBarrier,"Tata").start();
        new Player(raceBarrier,"Maruti").start();
        new Player(raceBarrier,"Honad").start();
        new Player(raceBarrier,"Kona").start();

    }
}
