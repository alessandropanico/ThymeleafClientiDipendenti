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
public class controllerMODIFICA {

	//ANDARE A QUESTA PAGINA PER EFFETTUARE LE MODIFICHE!
	@GetMapping("/modifica")
	public String mostraPaginaModifica() {
	    return "pages/modifica";
	}

	    
	    
	@PostMapping("/aggiungiCliente")
    public String aggiungiCliente(@RequestParam(name = "nome") String nome,
                                  @RequestParam(name = "cognome") String cognome,
                                  @RequestParam(name = "eta") int eta) {
        try {
            String url = "jdbc:mysql://localhost:3306/clientidipendenti";
            String username = "root";
            String password = "";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String query = "INSERT INTO clienti (nome, cognome, eta) VALUES (?, ?, ?)";
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setString(1, nome);
                stmt.setString(2, cognome);
                stmt.setInt(3, eta);
                stmt.executeUpdate();
            }

            return "redirect:/listaclienti?successMessage=Cliente aggiunto con successo";
        } catch (Exception e) {
            e.printStackTrace();
            // Reindirizza alla pagina di modifica con un messaggio di errore
            return "redirect:/modifica?errorMessage=Si è verificato un errore durante l'aggiunta del cliente";
        }
    }
	
	@PostMapping("/modificaCliente")
	public String modificaCliente(@RequestParam(name = "idCliente") int idCliente,
	                              @RequestParam(name = "nomeClienteMod") String nome,
	                              @RequestParam(name = "cognomeClienteMod") String cognome,
	                              @RequestParam(name = "etaClienteMod") int eta) {
	    try {
	        String url = "jdbc:mysql://localhost:3306/clientidipendenti";
	        String username = "root";
	        String password = "";

	        try (Connection connection = DriverManager.getConnection(url, username, password)) {
	            String query = "UPDATE clienti SET nome=?, cognome=?, eta=? WHERE id=?";
	            PreparedStatement stmt = connection.prepareStatement(query);
	            stmt.setString(1, nome);
	            stmt.setString(2, cognome);
	            stmt.setInt(3, eta);
	            stmt.setInt(4, idCliente);
	            stmt.executeUpdate();
	        }

	        return "redirect:/listaclienti?successMessage=Cliente modificato con successo";
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Reindirizza alla pagina di modifica con un messaggio di errore
	        return "redirect:/modifica?errorMessage=Si è verificato un errore durante la modifica del cliente";
	    }
	}

	//DIPENDENTI
	
	@PostMapping("/aggiungiDipendente")
    public String aggiungiDipendente(@RequestParam(name = "nomeDipendente") String nome,
                                  @RequestParam(name = "cognomeDipendente") String cognome,
                                  @RequestParam(name = "etaDipendente") int eta) {
        try {
            String url = "jdbc:mysql://localhost:3306/clientidipendenti";
            String username = "root";
            String password = "";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String query = "INSERT INTO dipendenti (nome, cognome, eta) VALUES (?, ?, ?)";
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setString(1, nome);
                stmt.setString(2, cognome);
                stmt.setInt(3, eta);
                stmt.executeUpdate();
            }

            return "redirect:/listadipendenti?successMessage=Dipendente aggiunto con successo";
        } catch (Exception e) {
            e.printStackTrace();
            // Reindirizza alla pagina di modifica con un messaggio di errore
            return "redirect:/modifica?errorMessage=Si è verificato un errore durante l'aggiunta del dipendente";
        }
    }
		
	
	@PostMapping("/modificaDipendente")
	public String modificaDipendente(@RequestParam(name = "idDipendente") int idDipendente,
	                              @RequestParam(name = "nomeDipendenteMod") String nome,
	                              @RequestParam(name = "cognomeDipendenteMod") String cognome,
	                              @RequestParam(name = "etaDipendenteMod") int eta) {
	    try {
	        String url = "jdbc:mysql://localhost:3306/clientidipendenti";
	        String username = "root";
	        String password = "";

	        try (Connection connection = DriverManager.getConnection(url, username, password)) {
	            String query = "UPDATE dipendenti SET nome=?, cognome=?, eta=? WHERE id=?";
	            PreparedStatement stmt = connection.prepareStatement(query);
	            stmt.setString(1, nome);
	            stmt.setString(2, cognome);
	            stmt.setInt(3, eta);
	            stmt.setInt(4, idDipendente);
	            stmt.executeUpdate();
	        }

	        return "redirect:/listadipendenti?successMessage=Dipendente modificato con successo";
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Reindirizza alla pagina di modifica con un messaggio di errore
	        return "redirect:/modifica?errorMessage=Si è verificato un errore durante la modifica del dipendente";
	    }
	}
	
	

}
