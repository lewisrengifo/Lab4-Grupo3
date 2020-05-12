package com.example.laboratorio4.repository;

import com.example.laboratorio4.dto.RecursosHumanos;
import com.example.laboratorio4.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {

    @Query(value = "select e.* from employees e inner join departments d on e.department_id=d.department_id inner join locations l on d.location_id=l.location_id where l.city= ?1, nativeQuery=true")
    List<Employees> empleadoporciudad();

    @Query(value = "select e.* from employees e inner join departments d on e.department_id=d.department_id where d.department_name =?1", nativeQuery=true)
    List<Employees> empleadopordepartamento();
    @Query(value = "select e.* from employees e where e.last_name =?1, nativeQuery=true")
    List<Employees> empleadoporapellido();
    @Query(value = "select e.* from employees e where e.first_name =?1 ")
    List<Employees> empleadopornombre();
    @Query(value = "select e.* from employees e inner join jobs j on e.job_id=j.job_id where j.job_title =?1", nativeQuery=true)
    List<Employees> empleadoportrabajo();

}
