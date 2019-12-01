package classes_veterinarias;

import java.util.ArrayList;

public class Pet {

	private String nome;	
	private int idade;
	private String especie;
	private String raca;

	private int consultasRealizadas = 0;
	private int cadastro;
	private ArrayList<Consulta> consultas = new ArrayList<Consulta>();
	public ArrayList<Consulta> getConsultas() {
		return consultas;
	}

	private Data ultimaConsulta;

	
	public Pet(String nome, int cadastro, int idade, String especie, String raca) {
		super();
		this.nome = nome;
		this.cadastro = cadastro;
		this.idade = idade;
		this.especie = especie;
		this.raca = raca;
	}
	
	public void consultar(Consulta consulta) {
		consultas.add(consulta);
		
		if (consultasRealizadas == 0) {
			ultimaConsulta = consulta.getData();
		}
		
		else if (consulta.getData().isMaisRecente(ultimaConsulta)){
			ultimaConsulta = consulta.getData();
		}
		consultasRealizadas++;
	}
	
	public int getCadastro() {
		return cadastro;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	
	public int getConsultasRealizdas() {
		return consultasRealizadas;
	}
	
	public void setConsultasRealizdas(int consultasRealizdas) {
		this.consultasRealizadas = consultasRealizdas;
	}
	
	public String getEspecie() {
		return especie;
	}
	
	
	public String getRaca() {
		return raca;
	}


	public Data getUltimaConsulta() {
		return ultimaConsulta;
	}
	
	public void atualizarUltimaConsulta() {
		consultasRealizadas = consultas.size();
		
		for (int i = 0; i < consultas.size(); i++) {
			Consulta consulta = consultas.get(i);

			
			if (i == 0) {
				ultimaConsulta = consulta.getData();
			}
			
			else if (consulta.getData().isMaisRecente(ultimaConsulta)){
				ultimaConsulta = consulta.getData();
			}
		}
		
	}

	@Override
	public String toString() {
		return nome;
	}

	

	
	

}
