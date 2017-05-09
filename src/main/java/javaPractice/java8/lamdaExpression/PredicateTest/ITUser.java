package javaPractice.java8.lamdaExpression.PredicateTest;

/**
 * Created by anjalhussan on 4/23/16.
 */
public class ITUser {

    public ITUser(int id, String firstname, String lastname, String title){
        this.id=id;
        this.firstname=firstname;
        this.lastname=lastname;
        this.title=title;
    }

    private int id;
    private String firstname;
    private String lastname;
    private String title;


    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String gettitle() {
        return title;
    }

}
