package javaPractice.javaCollection.Sort.SortingMultipleAttributesExample;

/**
 * Created by Santosh on 6/19/17.
 */
import java.util.Comparator;

/**
 * This comparator compares two employees by their ages.
 * @author www.codejava.net
 *
 */
public class EmployeeAgeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.getAge() - emp2.getAge();
    }
}
