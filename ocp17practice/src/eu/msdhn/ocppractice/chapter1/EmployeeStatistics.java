package eu.msdhn.ocppractice.chapter1;


import java.util.List;

@FunctionalInterface
public interface EmployeeStatistics {

    //get average salary
    double getStatistics(List<Employee> employees);

}
