package javaPractice.java8.venkat.singleTone;

import java.util.function.Supplier;

class Heavy {
    private static Supplier<Heavy> heavy = () -> createAndCacheHeavy();
    private Heavy() {
        System.out.println("Heavy created");
    }


    public static Heavy getHeavy() {

        return heavy.get();
    }

    private static synchronized Heavy createAndCacheHeavy() {
        class HeavyFactory implements Supplier<Heavy> {
            private final Heavy heavyInstance = new Heavy();

            public Heavy get() {
                return heavyInstance;
            }
        }
        if (!HeavyFactory.class.isInstance(heavy)) {
            heavy = new HeavyFactory();
        }
        return heavy.get();
    }


    public String toString() {
        return "quite heavy";
    }
}



