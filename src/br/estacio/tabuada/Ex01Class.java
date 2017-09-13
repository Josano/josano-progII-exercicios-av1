package br.estacio.tabuada;

import java.util.ArrayList;
import java.util.List;

public class Ex01Class {

	private List<String> listagem = new ArrayList<>();

	/*
	 * Alimenta a listagem da tabuada
	 */
	public List<String> listarTabuada(String numero, String numeroInicial, String numeroFinal) {

		listagem = new ArrayList<>();

		for (int index = Integer.valueOf(numeroInicial); index <= Integer.valueOf(numeroFinal); index++) {		
			listagem.add(numero + "x" + String.valueOf(index) + " = "
					+ String.valueOf((Integer.valueOf(numero) * index) + " / "));
		}
		return listagem;
	}
}
