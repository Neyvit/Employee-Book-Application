package pro.sky.java.course2.employeebookapplication.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.employeebookapplication.data.Employee;

import java.util.Comparator;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static pro.sky.java.course2.employeebookapplication.constants.EmployeeServiceTestConstants.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    private final EmployeeService employeeServiceMock = mock(EmployeeService.class);
    private DepartmentService out;


    @BeforeEach
    public void initOut() {
        out = new DepartmentService(employeeServiceMock);
    }

    @Test
    void shouldGetDepartmentEmployees() {

        EMPLOYEES_SET.add(SET_EMPLOYEE1);
        EMPLOYEES_SET.add(SET_EMPLOYEE2);
        EMPLOYEES_SET.add(SET_EMPLOYEE3);
        EMPLOYEES_SET.add(SET_EMPLOYEE4);
        EMPLOYEES_SET.add(SET_EMPLOYEE5);
        EMPLOYEES_SET.add(SET_EMPLOYEE6);
        EMPLOYEES_SET.add(SET_EMPLOYEE7);
        EMPLOYEES_SET.add(SET_EMPLOYEE8);
        EMPLOYEES_SET.add(SET_EMPLOYEE9);
        EMPLOYEES_SET.add(SET_EMPLOYEE10);

        when(employeeServiceMock.getAllEmployees())
                .thenReturn(EMPLOYEES_SET);


        assertEquals(DEPARTMENT2_EMPLOYEES_SET.stream().sorted(Comparator.comparing(Employee::getSurname)
                        .thenComparing(Employee::getName)
                        .thenComparing(Employee::getMiddleName)).collect(Collectors.toList()).toString(),
                out.getDepartmentEmployee(CORRECT_DEPARTMENT).toString());
    }

    @Test
    void shouldGetMaxSalary() {

        EMPLOYEES_SET.add(SET_EMPLOYEE1);
        EMPLOYEES_SET.add(SET_EMPLOYEE2);
        EMPLOYEES_SET.add(SET_EMPLOYEE3);
        EMPLOYEES_SET.add(SET_EMPLOYEE4);
        EMPLOYEES_SET.add(SET_EMPLOYEE5);
        EMPLOYEES_SET.add(SET_EMPLOYEE6);
        EMPLOYEES_SET.add(SET_EMPLOYEE7);
        EMPLOYEES_SET.add(SET_EMPLOYEE8);
        EMPLOYEES_SET.add(SET_EMPLOYEE9);
        EMPLOYEES_SET.add(SET_EMPLOYEE10);

        when(employeeServiceMock.getAllEmployees())
                .thenReturn(EMPLOYEES_SET);

        assertEquals(MAX_MIN_SALARY_DEPT_LIST.stream().max(Comparator.comparingInt(Employee::getSalary)).orElseThrow().toString(),
                out.getMaxSalary(MAX_MIN_SALARY_DEPT).toString());
    }

    @Test
    void shouldGetMinSalary() {

        EMPLOYEES_SET.add(SET_EMPLOYEE1);
        EMPLOYEES_SET.add(SET_EMPLOYEE2);
        EMPLOYEES_SET.add(SET_EMPLOYEE3);
        EMPLOYEES_SET.add(SET_EMPLOYEE4);
        EMPLOYEES_SET.add(SET_EMPLOYEE5);
        EMPLOYEES_SET.add(SET_EMPLOYEE6);
        EMPLOYEES_SET.add(SET_EMPLOYEE7);
        EMPLOYEES_SET.add(SET_EMPLOYEE8);
        EMPLOYEES_SET.add(SET_EMPLOYEE9);
        EMPLOYEES_SET.add(SET_EMPLOYEE10);

        when(employeeServiceMock.getAllEmployees())
                .thenReturn(EMPLOYEES_SET);

        assertEquals(MAX_MIN_SALARY_DEPT_LIST.stream().min(Comparator.comparingInt(Employee::getSalary)).orElseThrow().toString(),
                out.getMinimumSalary(MAX_MIN_SALARY_DEPT).toString());
    }
}