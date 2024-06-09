package pro.sky.homework;

import org.springframework.stereotype.Service;
import pro.sky.homework.exceptions.EmloyeeAlreadyAddedException;
import pro.sky.homework.exceptions.EmloyeeNotFoundException;
import pro.sky.homework.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {
    private static final int MAX_COUNT = 10;
    private final List<Employee> emloyees = new ArrayList<>(MAX_COUNT);
    public void add(String firstName, String lostName){
        if (emloyees.size() >= MAX_COUNT){
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(firstName, lostName);
        if (emloyees.contains(employee)) {
            throw new EmloyeeAlreadyAddedException();
        }
        emloyees.add(employee);
    }
    public void remove(String firstName, String lostName){
        var it = emloyees.iterator();
        while (it.hasNext()){
            var employee = it.next();
            if (employee.getFirstName().equals(firstName) && employee.getLostName().equals(lostName)){
                it.remove();
                return;
            }
        }
        throw new EmloyeeNotFoundException();
    }
    public Employee find(String firstName, String lostName){
        for (Employee emloyee : emloyees) {
            if (emloyee.getFirstName().equals(firstName) && emloyee.getLostName().equals(lostName)){
                return emloyee;
            }
        }
        throw new EmloyeeNotFoundException();
    }
    public Collection<Employee> getAll(){
        return Collections.unmodifiableCollection(emloyees);
    }
}

