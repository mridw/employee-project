package org.azalio.em_project.controller;

import org.azalio.em_project.dto.Employee;
import org.azalio.em_project.services.EmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:3000") //frontend
@RestController
@RequestMapping("/employees")
public class EmController {
    //List<Employee> employees = new ArrayList<>();
    //EmService emService= new EmServiceImp();

//    Dependency Injection
    @Autowired
    EmService emService;
    @GetMapping
    public List<Employee> getAllEmployees(){
        return emService.readAllEmployees();
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id){

        return emService.readEmployee(id);
    }
    @PostMapping
    public String createEmployee(@RequestBody Employee employee){
        //employees.add(employee);
        return emService.createEmployee(employee);
    }
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id){
        if(emService.deleteEmployee(id))
            return "Deleted Successfully";
        return "Not Found";
    }
    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return emService.updateEmployee(id, employee);

    }


}
