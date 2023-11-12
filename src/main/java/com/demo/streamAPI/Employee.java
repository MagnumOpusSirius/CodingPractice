package com.demo.streamAPI;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Employee {

    int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;

    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) 
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }
    public int getId() 
    {
        return id;
    }
    public String getName() 
    {
        return name;
    }
    public int getAge() 
    {
        return age;
    }
    public String getGender() 
    {
        return gender;
    }
    public String getDepartment() 
    {
        return department;
    }
    public int getYearOfJoining() 
    {
        return yearOfJoining;
    }
    public double getSalary() 
    {
        return salary;
    }
    @Override
    public String toString() 
    {
        return "Id : "+id
                +", Name : "+name
                +", age : "+age
                +", Gender : "+gender
                +", Department : "+department
                +", Year Of Joining : "+yearOfJoining
                +", Salary : "+salary;
    }

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
    //-----------------
//        getCountOfMaleAndFemale(employeeList);
//        getDepartmentNames(employeeList);
//        getAvgAge(employeeList);
//        getAvg(employeeList);
//        getEmployeesJoinedAfter(employeeList);
//        getNumberOfEmployees(employeeList);
//        getAvgSalary(employeeList);
//        getOldestEmployee(employeeList);
//        getAvgAndTotalSalary(employeeList);
        getEmployeesOfEachDepartment(employeeList);
        highestExperienced(employeeList);
    }

    //Get count of male and female employees:
    public static void getCountOfMaleAndFemale(List<Employee> employeeList){
        Map<String, Long> newMap= employeeList.stream()
                .collect(Collectors.groupingBy(e-> e.getGender(), Collectors.counting()));
        System.out.println(newMap);
    }

    //get names of all department in company:
    public static void getDepartmentNames(List<Employee> employeeList){
        List<String> list= employeeList.stream()
                .map(e->e.getDepartment())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(list);
    }

    //find the avg age of male and female employees:
    public static void getAvgAge(List<Employee> employeeList){
        Map<String, Double> result= employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println(result);
    }
    //find the avg age of male and female employees:
    public static void getAvg(List<Employee> employeeList){
        double avg = employeeList.stream()
                .mapToDouble(Employee::getAge)
                .average()
                .orElse(0.0);

        System.out.println(avg);
    }

    //get the names of employee who joined after 2015:
    public static void getEmployeesJoinedAfter(List<Employee> employeeList){
        List<String> result=employeeList.stream()
                .filter(e->e.getYearOfJoining()>2015)
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(result);
    }

    //count the number of employees in each department:
    public static void getNumberOfEmployees(List<Employee> employeeList){
        Map<String,Long> result= employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        System.out.println(result);
    }

    //get the avg salary of each department:
    public static void getAvgSalary(List<Employee> employeeList){
        Map<String,Double> result = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(result);
    }

    //get the oldest Employee, their age and department:
    public static void getOldestEmployee(List<Employee> employeeList){
        //find the max age and collect their age and department
        Employee result= employeeList.stream()
                .max(Comparator.comparingInt(Employee::getAge))
                .get();

        System.out.println(result.getName());
        System.out.println(result.getAge());
        System.out.println(result.getDepartment());
    }

    //get the avg and total salary of organization
    public static void getAvgAndTotalSalary(List<Employee> employeeList){
        DoubleSummaryStatistics result = employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println("Avg: "+result.getAverage());
        System.out.println("Total: "+result.getSum());
    }

    //List employees of each department:
    public static void getEmployeesOfEachDepartment(List<Employee> employeeList){
        Map<String, List<String>> result=employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(result);

    }

    //find out the highest experienced employee in company
    public static void highestExperienced(List<Employee> employeeList){
        //wanna get the min of year of joining
        Employee emp= employeeList.stream()
                .min(Comparator.comparing(Employee::getYearOfJoining))
                .get();
        System.out.println(emp.getName());
        System.out.println(emp.getYearOfJoining());

    }


 }