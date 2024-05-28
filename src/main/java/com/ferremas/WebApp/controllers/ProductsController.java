package com.ferremas.WebApp.controllers;

import com.ferremas.WebApp.entities.Producto;
import com.ferremas.WebApp.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/productos")
public class ProductsController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/view")
    public String viewProducts(Model model) {
        List<Producto> productos = productoRepository.findAll();
        model.addAttribute("productos", productos);
        return "productos/products";
    }

    @GetMapping("/add")
    public String addProductForm(Model model) {
        model.addAttribute("producto", new Producto());
        return "productos/add-product";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Producto producto) {
        productoRepository.save(producto);
        return "redirect:/productos/view";
    }

    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable("id") String id, Model model) {
        Producto producto = productoRepository.findById(id).orElse(null);
        model.addAttribute("producto", producto);
        return "productos/edit-product";
    }

    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") String id, @ModelAttribute Producto producto) {
        producto.setId_producto(id);
        productoRepository.save(producto);
        return "redirect:/productos/view";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") String id) {
        productoRepository.deleteById(id);
        return "redirect:/productos/view";
    }
}
