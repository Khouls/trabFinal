package classes_veterinarias;

import java.util.ArrayList;

public class Cliente {
	private String nome;
	private String cpf;
	private String email;
	private int telefone;
	
	private ArrayList<Pet> pets = new ArrayList<Pet>();
	private int petsCadastrados = 0;
	
	public Cliente(String nome, String cpf, String email, int telefone) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public ArrayList<Pet> getPets() {
		return pets;
	}

	public int getPetsCadastrados() {
		return petsCadastrados;
	}

	public void cadastrarPet(String nome, int idade, String especie, String raca) {
		Pet pet = new Pet(nome, petsCadastrados, idade, especie, raca);
		pets.add(pet);
		petsCadastrados++;
	}

	@Override
	public String toString() {
		return nome;
	}
	
	
	


}
