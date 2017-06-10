package javaPractice.sunPractice.constroctor;

class Person {
    String name = "No name";
    public Person(String nm) { name = nm; }
}

class Employee extends Person {
    String empID = "0000";
    public Employee(String id) {
        super("");
        empID = id; }
}

public class EmployeeTest {
public static void main(String[]... a) {
        Employee e = new Employee("4321");
        System.out.println(e.empID);
    }
}
