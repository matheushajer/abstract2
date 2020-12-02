package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entitieis.Pessoa;
import entitieis.PessoaFisica;
import entitieis.PessoaJuridica;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);
		Locale.setDefault(Locale.US);
		
		List<Pessoa> contribuintes = new ArrayList<>();
		
		System.out.print("Informe o número de contribuintes: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i ++) {
			System.out.println();
			System.out.print("Pessoa fisíca ou jurídica (f/j)? ");
			char ver = sc.next().charAt(0);
			sc.nextLine();
			
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Renda anual: ");
			double rendaAnual = sc.nextDouble();
			
			if(ver == 'f') {
				System.out.print("Gasto total com saúde: ");
				double gastoSaude = sc.nextDouble();
				
				contribuintes.add(new PessoaFisica(nome, rendaAnual, gastoSaude));
			}else {
				System.out.print("Total de funcionários: ");
				int funcionarios = sc.nextInt();
				
				contribuintes.add(new PessoaJuridica(nome, rendaAnual, funcionarios));
			}	
		}
		
		double soma = 0;
		System.out.println();
		System.out.println("TAXAS:");
		for(Pessoa p : contribuintes) {
			System.out.println(p.toString());
			soma += p.imposto();
		}
		
		System.out.println();
		System.out.println("Total de contribuição: " +String.format("%.2f", soma));
		
		sc.close();
	}

}
