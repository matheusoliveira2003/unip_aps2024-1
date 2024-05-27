package classes;

public class Passageiro {
	
	private String nome;
	private String sobrenome;
	private String rg;
	private String passaporte;
	
	public Passageiro() {}
	
	public Passageiro(String nome, String sobrenome, String rg, String passaporte) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.rg = rg;
		this.passaporte = passaporte;
	}

	@Override
	public String toString() {
		return "Passageiro" 
	                +"\nNome: " + nome
	                +" " + sobrenome
	                +"\nRG: " + rg
	                +"\nPassaporte: " + passaporte
	                ;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getPassaporte() {
		return passaporte;
	}

	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}
	
}
