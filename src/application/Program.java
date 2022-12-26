package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		double somaPeso = 0.0;
		String maisAlto = null;
		double altAnterior = 0.0;
		double homens = 0.0;
		double mulheres = 0.0;
		double somaAlturaM = 0.0;
		
		System.out.print("Qual a quantidade de atletas? ");
		int atletas = sc.nextInt();
		
		for (int i=1; i<=atletas; i++) {
			System.out.println("Digite os dados do atleta numero " + i + ": ");
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Sexo: ");
			char sexo = sc.next().charAt(0);
			while (sexo != 'M' && sexo != 'F') {
				System.out.print("Valor invalido! Favor digitar F ou M: ");
				sexo = sc.next().charAt(0);
			}
			System.out.print("Altura: ");
			double altura = sc.nextDouble();
			while (altura <= 0) {
				System.out.print("Valor invalido! Favor digitar um valor positivo: ");
				altura = sc.nextDouble();
			}
			if (altura > altAnterior) {
				altAnterior = altura;
				maisAlto = nome;
			}
			if (sexo == 'M') {
				homens = homens + 1;
			}else {
				mulheres = mulheres + 1;
				somaAlturaM = somaAlturaM + altura;
			}
			System.out.print("Peso: ");
			double peso = sc.nextDouble();
			while (peso <= 0) {
				System.out.print("Valor invalido! Favor digitar um valor positivo: ");
				peso = sc.nextDouble();
			}
			somaPeso = somaPeso + peso;
		}
		
		double pesoMedio = somaPeso / atletas;
		double percentH = (homens * 100) / atletas;
		double alturaMediaM = somaAlturaM / mulheres;
		
		System.out.println();
		System.out.println("RELATÓRIO:");
		System.out.println("Peso médio dos atletas: " + String.format("%.2f", pesoMedio));
		System.out.println("Atleta mais alto: " + maisAlto);
		System.out.println("Porcentagem de homens: " + String.format("%.1f", percentH) + " %");
		if (mulheres == 0) {
			System.out.println("Não há mulheres cadastradas");
		}else {
			System.out.println("Altura média das mulheres: " + String.format("%.2f", alturaMediaM));
		}
		sc.close();
	}

}
