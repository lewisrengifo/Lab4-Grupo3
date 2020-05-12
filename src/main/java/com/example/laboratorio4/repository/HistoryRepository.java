package com.example.laboratorio4.repository;

import com.example.laboratorio4.dto.RecursosHumanos;
import com.example.laboratorio4.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Integer> {

    //COMPLETAR
    @Query(value = "select e.first_name, e.last_name, j.job_title, jh.start_date, jh.end_date, timestampdiff(year, jh.start_date, jh.end_date) as 'años trabajados', month(jh.end_date) - month(jh.start_date) as \"meses trabajado\" from employees e inner join job_history jh on e.employee_id=jh.employee_id inner join jobs j on j.job_id=jh.job_id where e.employee_id=?1  order by 'años trabajados' limit 1",
            nativeQuery = true)
    List<RecursosHumanos> listarecursoshumanos();
}
