package com.ferremas.WebApp.controllers;

import com.ferremas.WebApp.entities.Empleado;
import com.ferremas.WebApp.repositories.EmpleadoRepository;
import com.ferremas.WebApp.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    @GetMapping("/view")
    public String viewEmpleados(Model model) {
        List<Empleado> empleados = empleadoRepository.findAll();
        model.addAttribute("empleados", empleados);
        return "empleados/view";
    }

    @GetMapping("/add")
    public String addEmpleadoForm(Model model) {
        model.addAttribute("empleado", new Empleado());
        model.addAttribute("sucursales", sucursalRepository.findAll());
        return "empleados/add";
    }

    @PostMapping("/add")
    public String addEmpleado(@ModelAttribute Empleado empleado) {
        empleadoRepository.save(empleado);
        return "redirect:/empleados/view";
    }

    @GetMapping("/edit/{id}")
    public String editEmpleadoForm(@PathVariable("id") String id, Model model) {
        Empleado empleado = empleadoRepository.findById(id).orElse(null);
        model.addAttribute("empleado", empleado);
        model.addAttribute("sucursales", sucursalRepository.findAll());
        return "empleados/edit";
    }

    @PostMapping("/edit/{id}")
    public String editEmpleado(@PathVariable("id") String id, @ModelAttribute Empleado empleado) {
        empleado.setId_empleado(id);
        empleadoRepository.save(empleado);
        return "redirect:/empleados/view";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmpleado(@PathVariable("id") String id) {
        empleadoRepository.deleteById(id);
        return "redirect:/empleados/view";
    }
}
