package com.ferremas.WebApp.controllers;

import com.ferremas.WebApp.entities.Venta;
import com.ferremas.WebApp.repositories.EmpleadoRepository;
import com.ferremas.WebApp.repositories.ProductoRepository;
import com.ferremas.WebApp.repositories.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ventas")
public class VentasController {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/view")
    public String viewVentas(Model model) {
        List<Venta> ventas = ventaRepository.findAll();
        model.addAttribute("ventas", ventas);
        return "ventas/view";
    }

    @GetMapping("/add")
    public String addVentaForm(Model model) {
        model.addAttribute("venta", new Venta());
        model.addAttribute("empleados", empleadoRepository.findAll());
        model.addAttribute("productos", productoRepository.findAll());
        return "ventas/add";
    }

    @PostMapping("/add")
    public String addVenta(@ModelAttribute Venta venta) {
        ventaRepository.save(venta);
        return "redirect:/ventas/view";
    }

    @GetMapping("/edit/{id}")
    public String editVentaForm(@PathVariable("id") String id, Model model) {
        Venta venta = ventaRepository.findById(id).orElse(null);
        model.addAttribute("venta", venta);
        model.addAttribute("empleados", empleadoRepository.findAll());
        model.addAttribute("productos", productoRepository.findAll());
        return "ventas/edit";
    }

    @PostMapping("/edit/{id}")
    public String editVenta(@PathVariable("id") String id, @ModelAttribute Venta venta) {
        venta.setId_venta(id);
        ventaRepository.save(venta);
        return "redirect:/ventas/view";
    }

    @GetMapping("/delete/{id}")
    public String deleteVenta(@PathVariable("id") String id) {
        ventaRepository.deleteById(id);
        return "redirect:/ventas/view";
    }
}
