package javaPractice.java8Comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Test {

    private static List<Employee> getEmployees(){
        List<Employee> employees  = new ArrayList<>();
        employees.add(new Employee(1,"Lokesh", "Gupta", 32));
        employees.add(new Employee(2,"Aman", "Sharma", 28));
        employees.add(new Employee(3,"Aakash", "Yaadav", 52));
        employees.add(new Employee(4,"James", "Hedge", 72));
        employees.add(new Employee(5,"David", "Kameron", 19));
        employees.add(new Employee(6,"Yash", "Chopra", 25));
        employees.add(new Employee(7,"Karan", "Johar", 59));
        employees.add(new Employee(8,"Balaji", "Subbu", 88));
        employees.add(new Employee(9,"Vishu", "Bissi", 33));
        employees.add(new Employee(10,"Lokesh", "Ramachandran", 60));
        return employees;
    }

    public static void main(String sa[]){

        List<Employee> employees  = getEmployees();

        //Sort all employees by first name
        employees.sort(Comparator.comparing(e -> e.getFirstName()));

        //OR you can use below
        employees.sort(Comparator.comparing(Employee::getFirstName));

        //Let's print the sorted list
        System.out.println("1) Sort all employees by first name");
        System.out.println(employees);


        //Sort all employees by first name; And then reversed
        Comparator<Employee> comparator = Comparator.comparing(e -> e.getFirstName());
        employees.sort(comparator.reversed());

        //Let's print the sorted list
        System.out.println();
        System.out.println("2) Sort all employees by first name");
        System.out.println(employees);

        //Sort all employees by first name
        employees.sort(Comparator.comparing(e -> e.getLastName()));

        //OR you can use below
        employees.sort(Comparator.comparing(Employee::getLastName));

        //Let's print the sorted list
        System.out.println();
        System.out.println("3) Sort all employees by last name");
        System.out.println(employees);

        //Sorting on multiple fields; Group by.
        Comparator<Employee> groupByComparator = Comparator.comparing(Employee::getFirstName)
                .thenComparing(Employee::getLastName);
        employees.sort(groupByComparator);

        System.out.println();
        System.out.println("4) Sort By first name and then by last name (sort on multiple fields)");
        System.out.println(employees);


        //Parallel Sorting
        Employee[] employeesArray = employees.toArray(new Employee[employees.size()]);

        //Parallel sorting
        Arrays.parallelSort(employeesArray, groupByComparator);

        System.out.println();
        System.out.println("5) Using parallel sorting (with multiple threads)");
        System.out.println(employeesArray);

    }
}
