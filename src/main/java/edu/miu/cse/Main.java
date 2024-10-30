package edu.miu.cse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import edu.miu.cse.model.Employee;
import edu.miu.cse.model.PensionPlan;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Employee[] arrayOfEmployee = new Employee[]{
                new Employee(1,"Daniel","Agar", LocalDate.of(2018,1,17),105945.50,
                        new PensionPlan("EX1089",LocalDate.of(2023,1,17),100.00)),
                new Employee(2,"Bernard","Shaw", LocalDate.of(2019,4,3),197750.00,
                       null),
                new Employee(3,"Carly","Agar", LocalDate.of(2014,5,16),842000.75,
                        new PensionPlan("SM2307",LocalDate.of(2019,11,4),1555.50)),
                new Employee(4,"Wesley","Scheneider", LocalDate.of(2019,10,2),74500.00,
                        null)

        };

        printAllEmployees(arrayOfEmployee);
        PrintMonthlyUpcomingEnrollees(arrayOfEmployee);


    }

    public static void printAllEmployees(Employee[] parameter){
        System.out.println("Here id the list of all employees ");
        System.out.println("__________________________________ ");

        List<Employee> myEmployeeList = Arrays.stream(parameter).sorted(Comparator.comparing(Employee::getLastName).thenComparing(Employee::getYearlySalary)).toList();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);


        try {
            String json = objectMapper.writeValueAsString(myEmployeeList);
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("__________________________________ ");

    }

    public static void PrintMonthlyUpcomingEnrollees(Employee[] parameter){
        System.out.println("Monthly Upcoming Enrollees");
        System.out.println("__________________________________ ");

        List<Employee> myEmployeeList = Arrays.stream(parameter).sorted(Comparator.comparing(Employee::getEmploymentDate)).
                filter(e->e.getPensionPlan()==null && ChronoUnit.MONTHS.between(e.getEmploymentDate(),LocalDate.now())>=5).toList();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            String json = objectMapper.writeValueAsString(myEmployeeList);
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("__________________________________ ");

    }
}