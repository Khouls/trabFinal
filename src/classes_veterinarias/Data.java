package classes_veterinarias;

public class Data {
	private int minuto;
	private int hora;
	private int dia;
	private int mes;
	private int ano;
	
	public Data(int minuto, int hora, int dia, int mes, int ano) {
		super();
		this.minuto = minuto;
		this.hora = hora;
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
		
	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getDataFormatada() {
		String mesFormatado;
		
		switch(mes) {
		case 1:
			mesFormatado =  "Janeiro";
			break;
		case 2:
			mesFormatado =  "Fevereiro";
			break;
		case 3:
			mesFormatado =  "Março";
			break;
		case 4:
			mesFormatado =  "Abril";
			break;
		case 5:
			mesFormatado =  "Maio";
			break;
		case 6:
			mesFormatado =  "Junho";
			break;
		case 7:
			mesFormatado =  "Julho";
			break;
		case 8:
			mesFormatado =  "Agosto";
			break;
		case 9:
			mesFormatado =  "Setembro";
			break;
		case 10:
			mesFormatado =  "Outubro";
			break;
		case 11:
			mesFormatado =  "Novembro";
			break;
		case 12:
			mesFormatado =  "Dezembro";
			break;
		
		default:
			mesFormatado = "";
		
		}
		
		String dataFormatada = "" + dia + " de " + mesFormatado + " de " + ano + " às " + String.format("%02d", hora) + ":" + String.format("%02d", minuto);
		
		return dataFormatada;
			
	}
	 
	public boolean isMaisRecente(Data d) {
		return (ano >= d.getAno()) && (mes >= d.getMes()) && (dia >= d.getDia()) && (hora >= d.getHora()) && (minuto >= d.getMinuto());
		
	}
	
	

	
	
}
