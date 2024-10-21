package org.azalio.em_project.services;

import org.azalio.em_project.dto.Employee;
import org.azalio.em_project.entity.EmEntity;
import org.azalio.em_project.repository.EmRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmServiceImp implements EmService {
    @Autowired
    private EmRepo emRepo;

    @Override
    public String createEmployee(Employee employee) {
        EmEntity emEntity= new EmEntity();
        BeanUtils.copyProperties(employee,emEntity);
        emRepo.save(emEntity);
        //employees.add(employee);
        return "Saved SuccessFully";
    }

    @Override
    public Employee readEmployee(Long id) {
        EmEntity emEntity = emRepo.findById(id).get();
        Employee employee= new Employee();
        BeanUtils.copyProperties(emEntity,employee);
        return employee;
    }
    @Override
    public List<Employee> readAllEmployees() {
        List<EmEntity> employeesList =emRepo.findAll();
        List<Employee> employees = new ArrayList<>();
        for(EmEntity emEntity:employeesList){
            Employee emp =new Employee();
            emp.setName(emEntity.getName());
            emp.setEmail(emEntity.getEmail());
            emp.setId(emEntity.getId());
            emp.setPhone(emEntity.getPhone());
            employees.add(emp);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {

        EmEntity emp = emRepo.findById(id).get();
      emRepo.delete(emp);
        return true;
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmEntity existingEmployee= emRepo.findById(id).get();

        //existingEmployee.setId(employee.getId());
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhone(employee.getPhone());

        emRepo.save(existingEmployee);
        return "Updated.";
    }


}
