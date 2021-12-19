package pro.sky.java.course2.employeebookapplication.data;

import java.util.Objects;

public class Employee {
    private final String name;
    private final String surname;
    private final String middleName;
    private final int department;
    private final int salary;

    public Employee(String surname, String name, String middleName, int department, int salary) {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public String getFullName() {
        return getSurname() + " " + getName() + " " + getMiddleName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && name.equals(employee.name) && surname.equals(employee.surname) && middleName.equals(employee.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, middleName, department, salary);
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + middleName;
    }
}