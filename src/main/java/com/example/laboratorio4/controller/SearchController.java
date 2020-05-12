package com.example.laboratorio4.controller;


import com.example.laboratorio4.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Search")
public class SearchController {

    @Autowired
    EmployeesRepository employeesRepository;
    @GetMapping(value = {"","/"})
    public String indice(){
        return "Search/indice";
    }

    @GetMapping(value = {"/Salario"})
    public String listaEmpleadosMayorSalrio (Model model){

            model.addAttribute("listaRecursos",employeesRepository.obtenetListaRecursos())

        return "Search/lista2";
    }

    @PostMapping("/busqueda")
    public String buscar (){

        //COMPLETAR
    }

    @GetMapping(value = "/Filtro2")
    public String reporteSalarioMaximoporDepa (Model model){
        model.addAttribute("listaDepartamentosMaximos",employeesRepository.maximoporDepartamento())

        return "/Search/salario";
    }

    @GetMapping("/info")
    public String


    @GetMapping("/listar")
    public String listarEmpleadoDep() {
        //COMPLETAR
        return "/Search/lista3";

    }


}
