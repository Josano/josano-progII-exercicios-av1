package br.estacio.salario;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Ex02Class {

	public static double[] ValorCalculo(double salarioBruto) {

		double[] valorCalculo = new double[5];
		valorCalculo[0] = salarioBruto;
		
		//calculo INSS
		if(salarioBruto <= 1659.38) 
			valorCalculo[1] = salarioBruto * 0.8;
				
		if(salarioBruto >= 1659.39 && salarioBruto <= 2765.66)
			valorCalculo[1] = salarioBruto * 0.9;
		
		if(salarioBruto >= 2765.67 && salarioBruto <= 5531.31) 
			valorCalculo[1] = salarioBruto * 0.11;

		if(valorCalculo[1] > 608.45)
			valorCalculo[1] = 608.45;
		
		//salario liquido
		valorCalculo[2] = salarioBruto - valorCalculo[1];
		
		//calculo IRPF
		if(valorCalculo[2] <= 1903.98)
			valorCalculo[3] = 0.0;
		
		if(valorCalculo[2] >= 1903.99 && valorCalculo[2] <= 2826.65)
			valorCalculo[3] = ((valorCalculo[2] * 7.5) / 100) - 142.80;
		
		if(valorCalculo[2] >= 2826.66 && valorCalculo[2] <= 3751.05)
			valorCalculo[3] = ((valorCalculo[2] * 15) / 100) - 354.80;
		
		if(valorCalculo[2] >= 3751.06 && valorCalculo[2] <= 4664.68)
			valorCalculo[3] = ((valorCalculo[2] * 22.5) / 100) - 636.13;
		
		if(valorCalculo[2] > 4664.68)
			valorCalculo[3] = ((valorCalculo[2] * 27.5) / 100) - 869.36;		

		valorCalculo[4] = salarioBruto - valorCalculo[1] - valorCalculo[3];

		return valorCalculo;
	}
	
	public String formataValor(double valor, Boolean formato)
	{
		String retorno;

		if (formato) {
			DecimalFormat df = new DecimalFormat("R$ ###,###,##0.00");
			retorno = df.format(valor);
		} else {
			retorno = String.format("%.2f" ,valor);
		}
		
		return retorno;
	}	
}