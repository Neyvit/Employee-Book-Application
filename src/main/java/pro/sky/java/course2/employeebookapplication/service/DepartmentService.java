package pro.sky.java.course2.employeebookapplication.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeebookapplication.data.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public List<Employee> printDepartmentEmployee(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Optional<Employee> getMaxSalary(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary));
    }

    public Optional<Employee> getMinimumSalary(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary));
    }
}