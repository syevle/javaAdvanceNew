package javaPractice.java8.venkat.a01_high_ceremony;

public class Sample {
//  public static void main(String[] args) {
//    Thread th = new Thread(new Runnable() {
//      public void run() {
//        System.out.println("In another thread");
//      }
//    });
//    th.start();
//
//    System.out.println("In main");
//  }
  public static void main(String[] args){
    Thread th = new Thread(new Runnable(){
      public void run(){
        System.out.println("In other thread");
      }
    });
    th.start();

    System.out.println("In Main");
  }
}