package pro.sky.java.course2.employeebookapplication.constants;

import pro.sky.java.course2.employeebookapplication.data.Employee;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeServiceTestConstants {
    public static final int DEPARTMENT = 3;
    public static final int SALARY = 120000;
    public static final String EMPTY_FIELD = "";
    public static final int NOT_EXISTING_DEPARTMENT = 12;
    public static final String ONLY_SPACES_NAME = "    ";
    public static final int NEGATIVE_SALARY = -500000;
    public static final String ILLEGAL_CHARACTERS_SURNAME = "PETROV1";
    public static final String ILLEGAL_CHARACTERS_NAME = "PETR1";
    public static final String ILLEGAL_CHARACTERS_MIDDLE_NAME = "PETROVICH1";
    public static final String EMPLOYEE_TO_DELETE_NAME = "Will";
    public static final String EMPLOYEE_TO_DELETE_SURNAME = "Smith";
    public static final String EMPLOYEE_TO_DELETE_MIDDLE_NAME = "Senior";
    public static final int EMPLOYEE_TO_DELETE_MIDDLE_DEPARTMENT = 1;
    public static final int EMPLOYEE_TO_DELETE_MIDDLE_SALARY = 100000;

    public static final String NAME = "Petr";
    public static final String SURNAME = "Petrov";
    public static final String MIDDLE_NAME = "Petrovich";
    public static final Employee TEST_EMPLOYEE = new Employee(SURNAME, NAME, MIDDLE_NAME, DEPARTMENT, SALARY);

    public static final Employee SET_EMPLOYEE1 = new Employee("Gorbunov", "Daniil", "Dmitrievich", 1, 100000);
    public static final Employee SET_EMPLOYEE2 = new Employee("Kirichev", "Kirill", "Alekseevich", 1, 300000);
    public static final Employee SET_EMPLOYEE3 = new Employee("Radzhabov", "Tamerlan", "Ruslanovich", 5, 130000);
    public static final Employee SET_EMPLOYEE4 = new Employee("Shishkin", "Egor", "Ivanovich", 3, 110000);
    public static final Employee SET_EMPLOYEE5 = new Employee("Elanova", "Irina", "Stepanovna", 5, 135000);
    public static final Employee SET_EMPLOYEE6 = new Employee("Komlev", "Vitalii", "Stanislavovich", 4, 95000);
    public static final Employee SET_EMPLOYEE7 = new Employee("Strongman", "Maxim", "Sergeevich", 2, 500000);
    public static final Employee SET_EMPLOYEE8 = new Employee("Selieva", "Mariia", "Kirillovna", 4, 75000);
    public static final Employee SET_EMPLOYEE9 = new Employee("Starikov", "Dmitrii", "Petrovich", 2, 110000);
    public static final Employee SET_EMPLOYEE10 = new Employee("Simikchi", "Zarema", "Askarovna", 4, 150000);


    public static final Set<Employee> EMPLOYEES_SET = new HashSet<Employee>();
    public static final Collection<Employee> DEPARTMENT2_EMPLOYEES_SET = List.of(SET_EMPLOYEE7, SET_EMPLOYEE9);

    public static final int CORRECT_DEPARTMENT = 2;
    public static final int MAX_MIN_SALARY_DEPT = 4;
    public static final Collection<Employee> MAX_MIN_SALARY_DEPT_LIST = List.of(SET_EMPLOYEE6, SET_EMPLOYEE8, SET_EMPLOYEE10);


}