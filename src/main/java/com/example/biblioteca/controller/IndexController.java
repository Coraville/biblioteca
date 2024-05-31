package com.example.biblioteca.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.model.LivroService;

@Controller
public class IndexController {
    
    @Autowired private ApplicationContext context;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Model model){
        model.addAttribute("livro", new Livro());
        return "cadastrar";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(Model model, @ModelAttribute Livro liv){
        LivroService cs = context.getBean(LivroService.class);
		cs.inserirLivro(liv);
        return "sucesso";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        LivroService cs = context.getBean(LivroService.class);
        List<Map<String,Object>> lista = cs.listarLivro();
        model.addAttribute("lista", lista);
        return "lista";
    }

}
