package javaPractice.javaCollection.Sort.SortingMultipleAttributesExample;

/**
 * Created by Santosh on 6/19/17.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * This program demonstrates how to sort a list collection by multiple
 * attributes using a chained comparator.
 *
 * @author www.codejava.net
 *
 */
public class SortingMultipleAttributesExample {

    public static void main(String[] args) {

        System.out.println("===== SORTING BY MULTIPLE ATTRIBUTES =====");

        List<Employee> listEmployees = new ArrayList<Employee>();

        listEmployees.add(new Employee("Tom", "Developer", 45, 80000));
        listEmployees.add(new Employee("Sam", "Designer", 30, 75000));
        listEmployees.add(new Employee("Bob", "Designer", 45, 134000));
        listEmployees.add(new Employee("Peter", "Programmer", 25, 60000));
        listEmployees.add(new Employee("Tim", "Designer", 45, 130000));
        listEmployees.add(new Employee("Craig", "Programmer", 30, 52000));
        listEmployees.add(new Employee("Anne", "Programmer", 25, 51000));
        listEmployees.add(new Employee("Alex", "Designer", 30, 120000));
        listEmployees.add(new Employee("Bill", "Programmer", 22, 30000));
        listEmployees.add(new Employee("Samuel", "Developer", 28, 80000));
        listEmployees.add(new Employee("John", "Developer", 35, 67000));
        listEmployees.add(new Employee("Patrick", "Developer", 35, 140000));
        listEmployees.add(new Employee("Alice", "Programmer", 35, 80000));
        listEmployees.add(new Employee("David", "Developer", 35, 99000));
        listEmployees.add(new Employee("Jane", "Designer", 30, 82000));

        System.out.println("*** Before sorting:");

        for (Employee emp : listEmployees) {
            System.out.println(emp);
        }

        Collections.sort(listEmployees, new EmployeeChainedComparator(
                new EmployeeJobTitleComparator(),
                new EmployeeAgeComparator(),
                new EmployeeSalaryComparator())
        );

        System.out.println("\n*** After sorting:");

        for (Employee emp : listEmployees) {
            System.out.println(emp);
        }

        // Using java 8 code style.
        // Define chained comparators:
        // Great article explaining this and how to make it even neater:
        // http://blog.jooq.org/2014/01/31/java-8-friday-goodies-lambdas-and-sorting/
        Comparator<Employee> comparator = Comparator.comparing(employee -> employee.getName());
        comparator = comparator.thenComparing(Comparator.comparing(employee -> employee.getAge()));
        comparator = comparator.thenComparing(Comparator.comparing(employee -> employee.getSalary()));



        System.out.println("\n*** After sorting: Java 8 Style");

        // Sort the stream:
        Stream<Employee> employeesStream = listEmployees.stream().sorted(comparator);
        employeesStream.forEach(employee->{
            System.out.println(employee);
        });


        System.out.println("\n*** After sorting Single fields : Java 8 Style");
        Comparator<Employee> comparator1
                = (e1, e2) -> e1.getName().compareTo(e2.getName());

        Stream<Employee> employeesStream1 = listEmployees.stream().sorted(comparator1);
        employeesStream1.forEach(employee->{
            System.out.println(employee);
        });


        System.out.println("\n*** sorting using Collections.sort : Java 8 Style");
        Collections.sort(
                listEmployees, Comparator.comparing(Employee::getName).reversed());

        listEmployees.forEach(employee->{
            System.out.println(employee);
        });

        System.out.println("\n*** sorting using Collections.sort : Java 8 Style");
        Collections.sort(
                listEmployees, Comparator.comparing(Employee::getSalary).reversed());

        listEmployees.forEach(employee->{
            System.out.println(employee);
        });

        System.out.println("\n*** sorting using Collections.sort Age is primitive data type : Java 8 Style");
//        Collections.sort(
//                listEmployees, Comparator.comparing(employee -> employee.getAge()));

        Collections.sort(
                listEmployees, Comparator.comparing(Employee::getAge));

        listEmployees.forEach(employee->{
            System.out.println(employee);
        });


        System.out.println("\n*** sorting using Collections.sort : Java 8 Style");
        listEmployees.sort((lhs, rhs) -> {
            if (lhs.getName().equals(rhs.getName())) {
                return lhs.getAge() - rhs.getAge();
            } else {
                return lhs.getName().compareTo(rhs.getName());
            }
        });

        listEmployees.forEach(employee->{
            System.out.println(employee);
        });



    }
}