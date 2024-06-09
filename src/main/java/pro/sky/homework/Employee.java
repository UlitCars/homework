package pro.sky.homework;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lostName;

    public Employee(String firstName, String lostName) {
        this.firstName = firstName;
        this.lostName = lostName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLostName() {
        return lostName;
    }

    @Override
    public String toString() {
        return "Emloyee{" +
                "firstName='" + firstName + '\'' +
                ", lostName='" + lostName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee emloyee = (Employee) o;
        return Objects.equals(firstName, emloyee.firstName) && Objects.equals(lostName, emloyee.lostName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lostName);
    }
}
