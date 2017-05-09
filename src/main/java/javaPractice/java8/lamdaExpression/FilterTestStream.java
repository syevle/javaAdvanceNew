package javaPractice.java8.lamdaExpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by anjalhussan on 4/23/16.
 */
public class FilterTestStream {

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

    public static void filteroldJavaWay(){
        List<User> elderlyUser= new ArrayList<User>();
        for (User u:users){
            if (u.getAge()>30){
                elderlyUser.add(u);
            }
        }
        printListLamdaExpression("Old way elderly user", elderlyUser);
    }

    public static void filterNewJavaWay(){
        List<User> elderlyUser = users.stream().filter(user -> user.getAge()>30).collect(Collectors.toList());
        printListLamdaExpression("New way elderly user", elderlyUser);

    }
    private static void printListLamdaExpression(String msg, List<User> user) {
        System.out.println(msg.concat(":") );
        user.forEach(u-> System.out.println(u.getFirstname().concat(" ")
                .concat(u.getLastname()
                        .concat(" age: ")
                        .concat(String.valueOf(u.getAge())))));
    }

    public static void main(String[]args){
        filteroldJavaWay();
        filterNewJavaWay();
    }

} // end of class
