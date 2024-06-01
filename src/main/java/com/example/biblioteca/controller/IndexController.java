package com.example.biblioteca.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/cadastro")
    public String cadastrar(Model model){
        model.addAttribute("livro", new Livro());
        return "cadastro";
    }

    @PostMapping("/cadastro")
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
    
    @GetMapping("/atualizar/{id}")
    public String atualizar(@PathVariable("id") int id, Model model){
        LivroService cs = context.getBean(LivroService.class);
        Map<String,Object> livro = cs.obterLivro(id).get(0);
        String nome = (String) livro.get("nome");
        String categoria = (String) livro.get("categoria");
        model.addAttribute("livro", new Livro(nome,categoria));
        model.addAttribute("nome", nome);
        model.addAttribute("categoria", categoria);
        return "atualiza";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable("id") int id
        , Model model
        , @ModelAttribute Livro liv){
            LivroService cs = context.getBean(LivroService.class);
            cs.atualizarLivro(id, liv);
            return "redirect:/listar";
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable("id") int id){
        LivroService cs = context.getBean(LivroService.class);
        cs.apagarLivro(id);
        return "redirect:/listar";
    }

}
