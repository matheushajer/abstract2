package entitieis;

public class PessoaFisica extends Pessoa{
	
	private Double gastoSaude;
	
	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, Double rendaAnual, Double gastoSaude) {
		super(nome, rendaAnual);
		this.gastoSaude = gastoSaude;
	}

	public Double getGastoSaude() {
		return gastoSaude;
	}

	public void setGastoSaude(Double gastoSaude) {
		this.gastoSaude = gastoSaude;
	}

	@Override
	public Double imposto() {
		double total;
		if(rendaAnual < 20000) {
			total = (rendaAnual * 0.15) - (gastoSaude * 0.50);
		}else {
			total = (rendaAnual * 0.25) - (gastoSaude * 0.50);
		}
		return total;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(getNome());
		sb.append(": R$ ");
		sb.append(String.format("%.2f", imposto()));
		
		return sb.toString();
	}
	
	
	
}
