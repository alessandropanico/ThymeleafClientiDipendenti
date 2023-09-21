package com.alessandro.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Controller
public class controllerDIPENDENTI {
	
	

	@GetMapping("/dipendenti")
	public String indexDipendenti()
	{
		return "pages/dipendenti";
	}

	
	@GetMapping("/listadipendenti")
	public ModelAndView listaClienti() {
	    ModelAndView modelAndView = new ModelAndView("pages/dipendenti");
	    
	    try {
	        // Connessione al database
	        String url = "jdbc:mysql://localhost:3306/clientidipendenti";
	        String username = "root";
	        String password = "";
	        Connection connection = DriverManager.getConnection(url, username, password);

	        // Query per recuperare la lista dei clienti
	        String query = "SELECT * FROM dipendenti";
	        PreparedStatement statement = connection.prepareStatement(query);
	        ResultSet resultSet = statement.executeQuery();

	        List<Dipendente> dipendenti = new ArrayList<>();
	        while (resultSet.next()) {
	            Dipendente dipendente = new Dipendente();
	            dipendente.setId(resultSet.getInt("id"));
	            dipendente.setNome(resultSet.getString("nome"));
	            dipendente.setCognome(resultSet.getString("cognome"));
	            dipendente.setEta(resultSet.getInt("eta"));
	            dipendenti.add(dipendente);
	        }

	        modelAndView.addObject("dipendenti", dipendenti);

	        // Chiudi le risorse
	        resultSet.close();
	        statement.close();
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        modelAndView.addObject("errore", "Errore durante l'accesso al database");
	    }
	    
	    return modelAndView;
	}
	
	
	//RICERCA COGNOME DIPENDENTE
	@GetMapping("/cognomeDipendente")
	public ModelAndView ricercaClientiPerCognome(@RequestParam(name="cognome") String cognome)
	{
	    ModelAndView modelAndView = new ModelAndView("pages/dipendenti");

	    try {
	        // Connessione al database
	        String url = "jdbc:mysql://localhost:3306/clientidipendenti";
	        String username = "root";
	        String password = "";
	        Connection connection = DriverManager.getConnection(url, username, password);

	        // Query per recuperare i clienti con il cognome specificato
	        String query = "SELECT * FROM dipendenti WHERE cognome LIKE ?";
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setString(1, "%" + cognome + "%");
	        ResultSet resultSet = statement.executeQuery();

	        List<Dipendente> dipendenti = new ArrayList<>();
	        while (resultSet.next()) {
	            Dipendente dipendente = new Dipendente();
	            dipendente.setId(resultSet.getInt("id"));
	            dipendente.setNome(resultSet.getString("nome"));
	            dipendente.setCognome(resultSet.getString("cognome"));
	            dipendente.setEta(resultSet.getInt("eta"));
	            dipendenti.add(dipendente);
	        }

	        modelAndView.addObject("dipendenti", dipendenti);

	        // Chiudi le risorse
	        resultSet.close();
	        statement.close();
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        modelAndView.addObject("errore", "Errore durante l'accesso al database");
	    }

	    return modelAndView;
	}
	
	
		//RICERCA NOME DIPENDENTE
		@GetMapping("/nomeDipendente")
		public ModelAndView ricercaClientiPerNome(@RequestParam(name="nome") String nome)
		{
		    ModelAndView modelAndView = new ModelAndView("pages/dipendenti");

		    try {
		        // Connessione al database
		        String url = "jdbc:mysql://localhost:3306/clientidipendenti";
		        String username = "root";
		        String password = "";
		        Connection connection = DriverManager.getConnection(url, username, password);

		        // Query per recuperare i clienti con il cognome specificato
		        String query = "SELECT * FROM dipendenti WHERE nome LIKE ?";
		        PreparedStatement statement = connection.prepareStatement(query);
		        statement.setString(1, "%" + nome + "%");
		        ResultSet resultSet = statement.executeQuery();

		        List<Dipendente> dipendenti = new ArrayList<>();
		        while (resultSet.next()) {
		            Dipendente dipendente = new Dipendente();
		            dipendente.setId(resultSet.getInt("id"));
		            dipendente.setNome(resultSet.getString("nome"));
		            dipendente.setCognome(resultSet.getString("cognome"));
		            dipendente.setEta(resultSet.getInt("eta"));
		            dipendenti.add(dipendente);
		        }

		        modelAndView.addObject("dipendenti", dipendenti);

		        // Chiudi le risorse
		        resultSet.close();
		        statement.close();
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		        modelAndView.addObject("errore", "Errore durante l'accesso al database");
		    }

		    return modelAndView;
		}
		
	
	
	
	
	
}
