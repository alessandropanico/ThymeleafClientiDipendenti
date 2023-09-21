package com.alessandro.demo.controller;

public class Cliente {

		private String nome;
		private String cognome;
		private int eta;
		private int id;
		
		public Cliente() {
		}

		public Cliente(int id, String nome, String cognome, int eta) {
			this.id=id;
			this.nome=nome;
			this.cognome=cognome;
			this.eta=eta;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCognome() {
			return cognome;
		}

		public void setCognome(String cognome) {
			this.cognome = cognome;
		}

		public int getEta() {
			return eta;
		}

		public void setEta(int eta) {
			this.eta = eta;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
}