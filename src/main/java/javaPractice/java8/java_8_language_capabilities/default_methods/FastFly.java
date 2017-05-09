package javaPractice.java8.java_8_language_capabilities.default_methods;

public interface FastFly extends Fly {
  default void takeOff() { System.out.println("FastFly::takeOff"); }
}