package com.ferremas.WebApp.controllers;

import com.ferremas.WebApp.entities.Sucursal;
import com.ferremas.WebApp.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sucursales")
public class SucursalController {

    @Autowired
    private SucursalRepository sucursalRepository;

    @GetMapping("/view")
    public String viewSucursales(Model model) {
        List<Sucursal> sucursales = sucursalRepository.findAll();
        model.addAttribute("sucursales", sucursales);
        return "sucursales/view";
    }

    @GetMapping("/add")
    public String addSucursalForm(Model model) {
        model.addAttribute("sucursal", new Sucursal());
        return "sucursales/add";
    }

    @PostMapping("/add")
    public String addSucursal(@ModelAttribute Sucursal sucursal) {
        sucursalRepository.save(sucursal);
        return "redirect:/sucursales/view";
    }

    @GetMapping("/edit/{id}")
    public String editSucursalForm(@PathVariable("id") String id, Model model) {
        Sucursal sucursal = sucursalRepository.findById(id).orElse(null);
        model.addAttribute("sucursal", sucursal);
        return "sucursales/edit";
    }

    @PostMapping("/edit/{id}")
    public String editSucursal(@PathVariable("id") String id, @ModelAttribute Sucursal sucursal) {
        sucursal.setId_sucursal(id);
        sucursalRepository.save(sucursal);
        return "redirect:/sucursales/view";
    }

    @GetMapping("/delete/{id}")
    public String deleteSucursal(@PathVariable("id") String id) {
        sucursalRepository.deleteById(id);
        return "redirect:/sucursales/view";
    }
}
