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

}