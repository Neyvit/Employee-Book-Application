package pro.sky.java.course2.employeebookapplication.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeebookapplication.data.Employee;
import pro.sky.java.course2.employeebookapplication.exceptions.EmployeeNotFoundException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class EmployeeService {
    private final Map<String, Employee> employees;

    private EmployeeService() {
        this.employees = new HashMap<>();
        employees.put("Gorbunov Daniil Dmitrievich", new Employee("Gorbunov", "Daniil", "Dmitrievich", 1, 100000));
        employees.put("Kirichev Kirill Alekseevich", new Employee("Kirichev", "Kirill", "Alekseevich", 1, 300000));
        employees.put("Radzhabov Tamerlan Ruslanovich", new Employee("Radzhabov", "Tamerlan", "Ruslanovich", 5, 130000));
        employees.put("Shishkin Egor Ivanovich", new Employee("Shishkin", "Egor", "Ivanovich", 3, 110000));
        employees.put("Elanova Irina Stepanovna", new Employee("Elanova", "Irina", "Stepanovna", 5, 135000));
        employees.put("Komlev Vitalii Stanislavovich", new Employee("Komlev", "Vitalii", "Stanislavovich", 4, 950007));
        employees.put("Strongman Maxim Sergeevich", new Employee("Strongman", "Maxim", "Sergeevich", 2, 500000));
        employees.put("Selieva Mariia Kirillovna", new Employee("Selieva", "Mariia", "Kirillovna", 4, 75000));
        employees.put("Starikov Dmitrii Petrovich", new Employee("Starikov", "Dmitrii", "Petrovich", 2, 110000));
        employees.put("Simikchi Zarema Askarovna", new Employee("Simikchi", "Zarema", "Askarovna", 4, 150000));
    }


    public Employee addEmployee(String surname, String name, String middleName, Integer department, Integer salary) {
        Employee newEmployee = new Employee(surname, name, middleName, department, salary);
        employees.put(surname + " " + name + " " + middleName, newEmployee);
        return employees.get(surname + " " + name + " " + middleName);
    }

    public String removeEmployee(String surname, String name, String middleName) {
        if (employees.containsKey(surname + " " + name + " " + middleName)) {
            employees.remove(surname + " " + name + " " + middleName);
            return surname + " " + name + " " + middleName;
        }
        throw new EmployeeNotFoundException();
    }

    public Employee findEmployee(String surname, String name, String middleName) {
        if (employees.containsKey(surname + " " + name + " " + middleName)) {
            return employees.get(surname + " " + name + " " + middleName);
        }
        throw new EmployeeNotFoundException();
    }

    public Set<Employee> getAllEmployees() {
        return new HashSet<>(employees.values());
    }
}