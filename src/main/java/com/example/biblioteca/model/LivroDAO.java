package com.example.biblioteca.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class LivroDAO {
    @Autowired DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}

    public void inserirLivro(Livro liv){
        String sql = "INSERT INTO livro(nome,categoria)" +
        " VALUES (?,?)";
        Object[] obj = new Object[2];
        //primeiro ?
        obj[0] = liv.getNome();
        //segundo ?
        obj[1] = liv.getCategoria();
        jdbc.update(sql, obj);
    }

    public List<Map<String, Object>> listarLivro() {
    	String sql = "SELECT * FROM livro";
    	return jdbc.queryForList(sql);
    }

    public List<Map<String,Object>> obterLivro(int id){
		String sql = "SELECT * FROM livro where id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		return jdbc.queryForList(sql, obj);
	}

	public void atualizarLivro(int id, Livro liv){
		String sql = "UPDATE livro SET nome = ?," + 
		             "categoria = ? WHERE id = ?";
		Object[] obj = new Object[3];
		obj[0] = liv.getNome();
		obj[1] = liv.getCategoria();
		obj[2] = id;
		jdbc.update(sql, obj);
	}

	public void apagarLivro(int id){
		String sql = "DELETE FROM livro WHERE id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		jdbc.update(sql, obj);
	}

}