import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Employee employee1 = new Employee(2, "Kaveri", 25,80000.00,Gender.FEMALE);
        Employee employee2 = new Employee(5, "Nazriya", 26,55000.00,Gender.FEMALE);
        Employee  employee3= new Employee(8, "Nayan", 30,50000.00,Gender.FEMALE);
        Employee employee4 = new Employee(9, "Vijay", 35,50000.00,Gender.MALE);
        Employee employee5 = new Employee(10, "Surya", 36,50000.00,Gender.MALE);

        //list of employees
        List<Employee> employeeList= Arrays.asList(employee1,employee2,employee3,employee4,employee5);

        //filter the list employee age greater than 26
        List<Employee> employeeList1=employeeList.stream().
                                    filter(employee -> employee.getAge()>26)
                                    .collect(Collectors.toList());
        System.out.println("The list employee age greater than 26");
        for(Employee employee:employeeList1){
            System.out.println(employee.getName());
        }

        //filter the even id employees and map employee names
        List<String> employeeList2=employeeList.stream().filter(employeeId->employeeId.getId()%2==0).
                map(employee -> employee.getName()).collect(Collectors.toList());

        System.out.println("The even id employees and map employee names");
        for(String names:employeeList2){
            System.out.println(names);
        }

        //names starts with k and increase salary 25%
        List<Employee> employeeList3=employeeList.stream()
                .filter(names->names.getName().startsWith("K"))
                /*.peek(salary->salary.setSalary(salary.getSalary() *25.0))*/
                .map(employee -> {
                    employee.setSalary(employee.getSalary() * 25.0); // Modify the salary here
                    return employee; // Return the modified employee
                })
                .collect(Collectors.toList());


        System.out.println("Names starts with k and increase salary 25%");
        for(Employee employee:employeeList3){
            System.out.println(employee.getName()+" get the salary after the increment is "+ employee.getSalary());
        }

        //count the employees which one age greater than 26
        long countNames=employeeList.stream().filter(employee -> employee.getAge()>26).count();
        System.out.println("The age is greater than 26 employees count "+ countNames);


        //Sort the list based on the NAME
        List<Employee> employeeList4=employeeList.stream().
                sorted(Comparator.comparing(employee -> employee.getName()))
                .collect(Collectors.toList());

        System.out.println("Sorted the list based on the NAME");
        for(Employee employee:employeeList4){
            System.out.println(employee.getName());
        }


        //sort the list based on the age
        List<Employee> employeeList5=employeeList.stream().
                sorted(Comparator.comparing(empAge->empAge.getAge()))
                .collect(Collectors.toList());

        System.out.println("Sorted list based on the age");
        for(Employee employee:employeeList5){
            System.out.println(employee.getName()+" age is "+employee.getAge());
        }
    }
}