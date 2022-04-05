package pro.sky.java.course2.employeebookapplication.service;

import org.junit.jupiter.api.Test;
import pro.sky.java.course2.employeebookapplication.data.Employee;
import pro.sky.java.course2.employeebookapplication.exceptions.EmployeeNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.employeebookapplication.constants.EmployeeServiceTestConstants.*;

class EmployeeServiceTest {

    private final EmployeeService out = new EmployeeService();

    @Test
    public void shouldAddEmployeePetrovPetrPetrovich() {
        Employee result = out.addEmployee(SURNAME, NAME, MIDDLE_NAME, DEPARTMENT, SALARY);
        assertEquals(TEST_EMPLOYEE, result);
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenNameIsEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    out.addEmployee(SURNAME, EMPTY_FIELD, MIDDLE_NAME, DEPARTMENT, SALARY);
                });
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenSurnameIsEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    out.addEmployee(EMPTY_FIELD, NAME, MIDDLE_NAME, DEPARTMENT, SALARY);
                });
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenMiddleNameIsEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    out.addEmployee(SURNAME, NAME, EMPTY_FIELD, DEPARTMENT, SALARY);
                });
    }

    @Test
    public void shouldReturnNullPointerExceptionWhenSurnameIsNull() {
        assertThrows(NullPointerException.class,
                () -> {
                    out.addEmployee(null, NAME, MIDDLE_NAME, DEPARTMENT, SALARY);
                });
    }

    @Test
    public void shouldReturnNullPointerExceptionWhenNameIsNull() {
        assertThrows(NullPointerException.class,
                () -> {
                    out.addEmployee(SURNAME, null, MIDDLE_NAME, DEPARTMENT, SALARY);
                });
    }

    @Test
    public void shouldReturnNullPointerExceptionWhenMiddleNameIsNull() {
        assertThrows(NullPointerException.class,
                () -> {
                    out.addEmployee(SURNAME, NAME, null, DEPARTMENT, SALARY);
                });
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenSurnameIsSpace() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    out.addEmployee(ONLY_SPACES_NAME, NAME, MIDDLE_NAME, DEPARTMENT, SALARY);
                });
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenNameIsSpace() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    out.addEmployee(SURNAME, ONLY_SPACES_NAME, MIDDLE_NAME, DEPARTMENT, SALARY);
                });
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenMiddleNameIsSpace() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    out.addEmployee(SURNAME, ONLY_SPACES_NAME, MIDDLE_NAME, DEPARTMENT, SALARY);
                });
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenSurnameContainsInvalidCharacters() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    out.addEmployee(SURNAME, NAME, MIDDLE_NAME, DEPARTMENT, SALARY);
                    throw new IllegalArgumentException();
                });
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenDepartmentIsNotFound() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    out.addEmployee(SURNAME, NAME, MIDDLE_NAME, NOT_EXISTING_DEPARTMENT, SALARY);
                });
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenSalaryIsNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    out.addEmployee(SURNAME, NAME, MIDDLE_NAME, DEPARTMENT, NEGATIVE_SALARY);
                });
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenSurnameContainsInvalidChars() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    out.addEmployee(ILLEGAL_CHARACTERS_SURNAME, NAME, MIDDLE_NAME, DEPARTMENT, SALARY);
                });
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenNameContainsInvalidChars() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    out.addEmployee(SURNAME, ILLEGAL_CHARACTERS_NAME, MIDDLE_NAME, DEPARTMENT, SALARY);
                });
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenMiddleNameContainsInvalidChars() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    out.addEmployee(SURNAME, NAME, ILLEGAL_CHARACTERS_MIDDLE_NAME, DEPARTMENT, SALARY);
                });
    }

    @Test
    void shouldFindEmployee() {
        Employee addedEmployee = out.addEmployee(SURNAME, NAME, MIDDLE_NAME, DEPARTMENT, SALARY);
        Employee findResult = out.findEmployee(SURNAME, NAME, MIDDLE_NAME);
        assertEquals(addedEmployee, findResult);
    }

    @Test
    void shouldThrowEmployeeNotFoundExceptionWhenEmployeeNotFound() {
        assertThrows(EmployeeNotFoundException.class,
                () -> {
                    out.findEmployee(SURNAME, NAME, MIDDLE_NAME);
                });
    }

    @Test
    void shouldRemoveEmployee() {
        Employee existingEmployee = out.addEmployee(EMPLOYEE_TO_DELETE_SURNAME,
                EMPLOYEE_TO_DELETE_NAME,
                EMPLOYEE_TO_DELETE_MIDDLE_NAME,
                EMPLOYEE_TO_DELETE_MIDDLE_DEPARTMENT,
                EMPLOYEE_TO_DELETE_MIDDLE_SALARY);
        String deletedEmployee = out.removeEmployee(EMPLOYEE_TO_DELETE_SURNAME,
                EMPLOYEE_TO_DELETE_NAME,
                EMPLOYEE_TO_DELETE_MIDDLE_NAME);
        assertEquals(existingEmployee.toString(), deletedEmployee);
    }

    @Test
    void shouldThrowEmployeeNotFoundExceptionWhenEmployeeIsAbsent() {
        assertThrows(EmployeeNotFoundException.class,
                () -> {
                    out.removeEmployee(SURNAME, NAME, MIDDLE_NAME);
                });
    }

}