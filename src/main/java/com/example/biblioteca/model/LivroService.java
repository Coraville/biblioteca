package com.example.biblioteca.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
    
    @Autowired LivroDAO cdao;
    public void inserirLivro(Livro liv){
        cdao.inserirLivro(liv);
    }

    public List<Map<String, Object>> listarLivro(){
        return cdao.listarLivro();
    }
    public void atualizarLivro(int id, Livro liv){
		cdao.atualizarLivro(id, liv);
	}

	public List<Map<String, Object>> obterLivro(int id){
		return cdao.obterLivro(id);
	}

	public void apagarLivro(int id){
		cdao.apagarLivro(id);
	}

}