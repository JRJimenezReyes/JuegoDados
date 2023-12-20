package org.iesalandalus.programacion.juegodados;

import org.iesalandalus.programacion.juegodados.modelo.JuegoDados;
import org.iesalandalus.programacion.juegodados.vista.Consola;

public class Main {

	public static void main(String[] args) {
		int numeroJugadores = 0;
		JuegoDados juegoDados = null;
		System.out.printf("Juego de dados.%n---------------%n%n");
		do {
			try {
				numeroJugadores = Consola.leerNumeroJugadores();
				juegoDados = crearJuego(numeroJugadores);
			} catch (IllegalArgumentException e) {
				System.out.printf("ERROR: %s%n", e.getMessage());
			} 
		} while (juegoDados == null);
		crearJugadores(numeroJugadores, juegoDados);
		juegoDados.jugar();
		Consola.mostrarResultados(juegoDados);
	}

	private static JuegoDados crearJuego(int numeroJugadores) {
		return new JuegoDados(numeroJugadores);
	}

	private static void crearJugadores(int numeroJugadores, JuegoDados juegoDados) {
		for (int i = 0; i < numeroJugadores; i++) {
			String nombre = Consola.leerNombreJugador(i + 1);
			juegoDados.setJugador(i, nombre);
		}
	}

}
