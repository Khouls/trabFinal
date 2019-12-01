package classes_veterinarias;

public class Consulta {
	Data data;
	String veterinario;
	Cliente cliente;
	Pet petConsultado;

	
	public Consulta(Data data, String veterinario, Cliente cliente, Pet petConsultado) {
		super();
		this.data = data;
		this.veterinario = veterinario;
		this.cliente = cliente;
		this.petConsultado = petConsultado;
	}


	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public String getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(String veterinario) {
		this.veterinario = veterinario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pet getPetConsultado() {
		return petConsultado;
	}

	public void setPetConsultado(Pet petConsultado) {
		this.petConsultado = petConsultado;
	}



	public String formatar() {
		return data.getDataFormatada() + " - Veterinario: " + veterinario + ", no pet:" + petConsultado.getNome() +
				" (Cadastro número " + petConsultado.getCadastro() + ") de: "  + cliente.getNome() + ".";
	}
	
	@Override
	public String toString() {
		return data.getDataFormatada() + ", " + petConsultado.getNome();
	}
	
	
	
	
	
	

}
