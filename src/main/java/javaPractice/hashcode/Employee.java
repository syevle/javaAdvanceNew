package javaPractice.hashcode;

import java.util.List;
import java.util.Objects;


public class Employee {
    private Integer id;
    private String firstname;
    private String lastName;
    private String department;
    private List<String> address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!id.equals(employee.id)) return false;
        if (!firstname.equals(employee.firstname)) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        if (department != null ? !department.equals(employee.department) : employee.department != null) return false;
        return address != null ? address.equals(employee.address) : employee.address == null;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + firstname.hashCode();
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
