package javaPractice.java8.lamdaExpression;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by anjalhussan on 4/24/16.
 */
public class FunctionAsParameter {

    private static List<User> users = Arrays.asList(
            new User(1, "Steve", "Vai", 40),
            new User(4, "Joe", "Smith", 32),
            new User(3, "Steve", "Johnson", 57),
            new User(9, "Mike", "Stevens", 18),
            new User(10, "George", "Armstrong", 24),
            new User(2, "Jim", "Smith", 40),
            new User(8, "Chuck", "Schneider", 34),
            new User(5, "Jorje", "Gonzales", 22),
            new User(6, "Jane", "Michaels", 47),
            new User(7, "Kim", "Berlie", 60)
    );


    private static void printUser(User u){
        System.out.println("user ID: "+u.getId()+" Name: "+u.getFirstname()+ " "+u.getLastname()+" Age:"+ u.getAge());
    }

    private static void oldwayprintUser(){
        for (User u:users){
            printUser(u);
        }
    }

    private static void newWayPrintUser(Consumer<User> func){
        users.forEach(u -> func.accept(u));
    }

    /*
    This method calls for each and then takes the given Consumer object.
    The Consumer object is how we specify an instance of a function that returns void.
    If the function returns some other type such as String,
    we would instead use Function<ITUser,String>. Now that we have this function,
    we can invoke it and give it the parameter by calling accept.
    */


    private static void oldJavaWayfunction(){
        System.out.println("Oldway Format: ");
        oldwayprintUser();
        // not accepting any parameter

    };


    private static void newJavaWayfunction() {
        System.out.println("NEWWAY Format:");
        newWayPrintUser(FunctionAsParameter::printUser);
        // accepting a function as a parameter
    }


    public static void main(String[] args) {
        oldJavaWayfunction();
        newJavaWayfunction();
    }


}
