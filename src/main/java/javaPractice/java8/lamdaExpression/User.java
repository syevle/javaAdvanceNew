package javaPractice.java8.lamdaExpression;

/**
 * Created by anjalhussan on 4/23/16.
 */
public class User {

    public User (int id, String firstname, String lastname, int age){
        this.id=id;
        this.firstname=firstname;
        this.lastname=lastname;
        this.age=age;
    }

    private int id;
    private String firstname;
    private String lastname;
    private int age;


    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

}
