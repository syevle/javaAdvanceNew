package javaPractice.javatricky;

/*
The reason for this is that
the Java compiler parses the unicode character \u000d as a new line and gets transformed into:

 */

class Test8 {

    public static void main(String[] args) {

        final class Constants {
            public static final String name = "PI";
        }

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Constants.name);
            }

        });

        thread.start();
    }
}
