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
public class controllerCLIENTI {


	@GetMapping("/clienti")
	public String indexClienti()
	{
		return "pages/clienti";
	}
	

	//LISTA CLIENTI
	@GetMapping("/listaclienti")
	public ModelAndView listaClienti() {
	    ModelAndView modelAndView = new ModelAndView("pages/clienti");
	    
	    try {
	        // Connessione al database
	        String url = "jdbc:mysql://localhost:3306/clientidipendenti";
	        String username = "root";
	        String password = "";
	        Connection connection = DriverManager.getConnection(url, username, password);

	        // Query per recuperare la lista dei clienti
	        String query = "SELECT * FROM clienti";
	        PreparedStatement statement = connection.prepareStatement(query);
	        ResultSet resultSet = statement.executeQuery();

	        List<Cliente> clienti = new ArrayList<>();
	        while (resultSet.next()) {
	            Cliente cliente = new Cliente();
	            cliente.setId(resultSet.getInt("id"));
	            cliente.setNome(resultSet.getString("nome"));
	            cliente.setCognome(resultSet.getString("cognome"));
	            cliente.setEta(resultSet.getInt("eta"));
	            clienti.add(cliente);
	        }

	        modelAndView.addObject("clienti", clienti);

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

	//RICERCA COGNOME CLIENTE
	@GetMapping("/cognomeCliente")
	public ModelAndView ricercaClientiPerCognome(@RequestParam(name="cognome") String cognome)
	{
	    ModelAndView modelAndView = new ModelAndView("pages/clienti");

	    try {
	        // Connessione al database
	        String url = "jdbc:mysql://localhost:3306/clientidipendenti";
	        String username = "root";
	        String password = "";
	        Connection connection = DriverManager.getConnection(url, username, password);

	        // Query per recuperare i clienti con il cognome specificato
	        String query = "SELECT * FROM clienti WHERE cognome LIKE ?";
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setString(1, "%" + cognome + "%");
	        ResultSet resultSet = statement.executeQuery();

	        List<Cliente> clienti = new ArrayList<>();
	        while (resultSet.next()) {
	            Cliente cliente = new Cliente();
	            cliente.setId(resultSet.getInt("id"));
	            cliente.setNome(resultSet.getString("nome"));
	            cliente.setCognome(resultSet.getString("cognome"));
	            cliente.setEta(resultSet.getInt("eta"));
	            clienti.add(cliente);
	        }

	        modelAndView.addObject("clienti", clienti);

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


	//RICERCA NOME CLIENTE
	@GetMapping("/nomeCliente")
	public ModelAndView ricercaClientiPerNome(@RequestParam(name="nome") String nome)
	{
	    ModelAndView modelAndView = new ModelAndView("pages/clienti");

	    try {
	        // Connessione al database
	        String url = "jdbc:mysql://localhost:3306/clientidipendenti";
	        String username = "root";
	        String password = "";
	        Connection connection = DriverManager.getConnection(url, username, password);

	        // Query per recuperare i clienti con il cognome specificato
	        String query = "SELECT * FROM clienti WHERE nome LIKE ?";
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setString(1, "%" + nome + "%");
	        ResultSet resultSet = statement.executeQuery();

	        List<Cliente> clienti = new ArrayList<>();
	        while (resultSet.next()) {
	            Cliente cliente = new Cliente();
	            cliente.setId(resultSet.getInt("id"));
	            cliente.setNome(resultSet.getString("nome"));
	            cliente.setCognome(resultSet.getString("cognome"));
	            cliente.setEta(resultSet.getInt("eta"));
	            clienti.add(cliente);
	        }

	        modelAndView.addObject("clienti", clienti);

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
