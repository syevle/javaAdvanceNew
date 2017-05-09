package javaPractice.java8.java_8_language_capabilities.default_methods;

public interface Sail {
  default void cruise() { System.out.println("Sail::Cruise"); }
  default void turn() { System.out.println("Sail::turn"); }
}