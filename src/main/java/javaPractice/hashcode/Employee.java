package javaPractice.hashcode;

import java.util.Objects;


public class Employee {
    private Integer id;
    private String firstname;
    private String lastName;
    private String department;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(firstname, employee.firstname) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(department, employee.department);
    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, firstname, lastName, department);
//    }


    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        return result;
    }
}
