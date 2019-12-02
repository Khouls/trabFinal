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
	public int getTelefone() {
		return telefone;
	}
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
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
	
	public void updatePetsCadastrados() {
		petsCadastrados = pets.size();
	}

	@Override
	public String toString() {
		return nome;
	}
	
	
	


}
