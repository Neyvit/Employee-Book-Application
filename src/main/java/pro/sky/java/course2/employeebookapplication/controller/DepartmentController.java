package pro.sky.java.course2.employeebookapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.employeebookapplication.data.Employee;
import pro.sky.java.course2.employeebookapplication.service.DepartmentService;
import pro.sky.java.course2.employeebookapplication.service.EmployeeService;

@RequestMapping("/department")
@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getMaxSalary(@RequestParam int department) {
        return departmentService.getMaxSalary(department)
                .orElseThrow();
    }

    @GetMapping("/min-salary")
    public Employee getMinSalary(@RequestParam int department) {
        return departmentService.getMinimumSalary(department)
                .orElseThrow();
    }

    @GetMapping("/all")
    public String getAllEmployees() {
        return "Сотрудники отдела 1: " + departmentService.printDepartmentEmployee(1) + System.lineSeparator() +
                "Сотрудники отдела 2: " + departmentService.printDepartmentEmployee(2) + System.lineSeparator() +
                "Сотрудники отдела 3: " + departmentService.printDepartmentEmployee(3) + System.lineSeparator() +
                "Сотрудники отдела 4: " + departmentService.printDepartmentEmployee(4) + System.lineSeparator() +
                "Сотрудники отдела 5: " + departmentService.printDepartmentEmployee(5);
    }

    @GetMapping("/print-department")
    public String printDepartmentEmployee(@RequestParam Integer department) {
        return "Сотрудники отдела " + department + ": " + departmentService.printDepartmentEmployee(department);
    }
}
