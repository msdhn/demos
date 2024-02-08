package eu.msdhn.ocppractice.chapter1;

import java.util.List;

public class EmployeeStatisticsImpl implements EmployeeStatistics{


    @Override
    public double getStatistics(List<Employee> employees) {
        double totalSalary = 0L;

        employees.stream().mapToInt(em -> Math.toIntExact(Long.parseLong(em.getSalary()))).average();
        
        return totalSalary / employees.size();
    }
}
