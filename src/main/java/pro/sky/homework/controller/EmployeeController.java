package pro.sky.homework.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework.Employee;
import pro.sky.homework.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public void add(@RequestParam String firstName, @RequestParam String lostName){
        service.add(firstName, lostName);
    }
    @GetMapping("/remove")
    public void remove(@RequestParam String firstName, @RequestParam String lostName){
        service.remove(firstName, lostName);
    }
    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lostName){
        return service.find(firstName, lostName);
    }
    @GetMapping("/all")
    public Collection<Employee> getAll(){
        return service.getAll();
    }
}
