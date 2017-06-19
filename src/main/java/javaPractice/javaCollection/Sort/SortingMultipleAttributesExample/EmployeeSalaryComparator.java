package javaPractice.javaCollection.Sort.SortingMultipleAttributesExample;

/**
 * Created by Santosh on 6/19/17.
 */
import java.util.Comparator;

/**
 * This comparator compares two employees by their salaries.
 * @author www.codejava.net
 *
 */
public class EmployeeSalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.getSalary() - emp2.getSalary();
    }
}
