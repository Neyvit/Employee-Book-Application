package pro.sky.java.course2.employeebookapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.employeebookapplication.data.Employee;
import pro.sky.java.course2.employeebookapplication.exceptions.EmployeeNotFoundException;
import pro.sky.java.course2.employeebookapplication.service.EmployeeService;

@RequestMapping("/employee")
@RestController
public class EmployeeBookController {
    private final EmployeeService employeeService;

    public EmployeeBookController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String surname,
                                @RequestParam String name,
                                @RequestParam String middleName,
                                @RequestParam int department,
                                @RequestParam int salary) {
        return employeeService.addEmployee(surname, name, middleName, department, salary);
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam String surname,
                                   @RequestParam String name,
                                   @RequestParam String middleName) throws EmployeeNotFoundException {
        return "Сотрудник " + employeeService.removeEmployee(surname, name, middleName) + " удалён.";
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String surname,
                                 @RequestParam String name,
                                 @RequestParam String middleName) throws EmployeeNotFoundException {
        return employeeService.findEmployee(surname, name, middleName);
    }
}