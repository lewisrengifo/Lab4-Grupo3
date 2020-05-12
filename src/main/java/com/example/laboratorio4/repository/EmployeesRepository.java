package com.example.laboratorio4.repository;


import com.example.laboratorio4.dto.RecursosHumanos;

import com.example.laboratorio4.dto.RecursosHumanosDto;
import com.example.laboratorio4.dto.SalarioMaximo;

import com.example.laboratorio4.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository





public interface EmployeesRepository extends JpaRepository<Employees,Integer> {
    @Query(value = "select e.* from employees e inner join departments d on e.department_id=d.department_id inner join locations l on d.location_id=l.location_id where l.city= ?1 or d.department_name=?2 or e.last_name=?3 or e.first_name=?4",nativeQuery = true)
    List<Employees> obtenerEmpleados(String nom1,String nom2,String nom3,String nom4);
    @Query(value ="SELECT e.first_name as nombre , e.last_name as apellido,\n" +
            "jh.start_date as fechainicio, jh.end_date as fechafin, j.job_title as puesto \n" +
            "FROM employees e\n" +
            "inner join jobs j on e.job_id=j.job_id\n" +
            "inner join job_history jh on jh.employee_id=e.employee_id " +
            "where j.max_salary>8000", nativeQuery=true)
    List<RecursosHumanosDto> obtenetListaRecursos();

    @Query(value="SELECT d.department_id as departamentoid, d.department_name as departamento," +
            " avg(e.salary) as promedio\n" +
            "FROM departments d\n" +
            "inner join  employees e   on e.department_id=d.department_id\n" +
            "inner join jobs j on j.job_id=e.job_id\n" +
            "group by d.department_id",nativeQuery=true)
    List<SalarioMaximo> maximoporDepartamento();




    @Query(value="SELECT e.manager_id as managerid, e.first_name as nombre,\n" +
            "    e.last_name as apellido, e.salary as salario ,j.job_title as cargo\n" +
            "    FROM departments d\n" +
            "    inner join  employees e   on e.department_id=d.department_id\n" +
            "    inner join jobs j on j.job_id=e.job_id\n" +
            "    where d.department_id=?",nativeQuery=true)
    List<SalarioMaximo> empleadosporDepa(int idDepartment);

}
