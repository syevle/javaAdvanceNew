package javaPractice.javatricky;

/*
https://www.journaldev.com/552/java-tricky-interview-questions#java-tricky-interview-question-1-answer-with-explanation

 */

class Test6 {

    public static void main(String args[]){
        long longWithL = 1000*60*60*24*365L;
        long longWithoutL = 1000*60*60*24*365;
        System.out.println(longWithL);
        System.out.println(longWithoutL);
    }
}