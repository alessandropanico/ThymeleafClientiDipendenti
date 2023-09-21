package com.alessandro.demo.controller; 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


@Controller

public class controllerELIMINA {

	
	//ANDARE A QUESTA PAGINA PER EFFETTUARE LE ELIMINAZIONI!
	@GetMapping("/elimina")
	public String mostraPaginaElimina() {
		return "pages/elimina";
	}

	@PostMapping("/eliminaCliente")
	public String eliminaCliente(@RequestParam(name = "idCliente") int idCliente) {
	    try {
	        String url = "jdbc:mysql://localhost:3306/clientidipendenti";
	        String username = "root";
	        String password = "";

	        try (Connection connection = DriverManager.getConnection(url, username, password)) {
	            String query = "DELETE FROM clienti WHERE id=?";
	            PreparedStatement stmt = connection.prepareStatement(query);
	            stmt.setInt(1, idCliente);
	            stmt.executeUpdate();
	        }

	        return "redirect:/listaclienti?successMessage=Cliente eliminato con successo";
	    } catch (Exception e) {
	        e.printStackTrace();
	        
	        // Reindirizza alla pagina di lista con un messaggio di errore
	        return "redirect:/listaclienti?errorMessage=Si è verificato un errore durante l'eliminazione del cliente";
	    }
	}
	
	@PostMapping("/eliminaDipendente")
	public String eliminaDipendente(@RequestParam(name = "idDipendente") int idDipendente) {
	    try {
	        String url = "jdbc:mysql://localhost:3306/clientidipendenti";
	        String username = "root";
	        String password = "";

	        try (Connection connection = DriverManager.getConnection(url, username, password)) {
	            String query = "DELETE FROM dipendenti WHERE id=?";
	            PreparedStatement stmt = connection.prepareStatement(query);
	            stmt.setInt(1, idDipendente);
	            stmt.executeUpdate();
	        }

	        return "redirect:/listadipendenti?successMessage=Dipendente eliminato con successo";
	    } catch (Exception e) {
	        e.printStackTrace();
	        
	        // Reindirizza alla pagina di lista con un messaggio di errore
	        return "redirect:/listadipendenti?errorMessage=Si è verificato un errore durante l'eliminazione del cliente";
	    }
	}
	
	}

