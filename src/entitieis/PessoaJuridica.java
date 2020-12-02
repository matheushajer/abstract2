package entitieis;

public class PessoaJuridica extends Pessoa{
	
	private Integer funcionarios;
	
	public PessoaJuridica(){
		super();
	}

	public PessoaJuridica(String nome, Double rendaAnual, Integer funcionarios) {
		super(nome, rendaAnual);
		this.funcionarios = funcionarios;
	}

	public Integer getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Integer funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public Double imposto() {
		double total;
		if(funcionarios >= 10) {
			total = rendaAnual * 0.14;
		}else {
			total = rendaAnual * 0.16;
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
