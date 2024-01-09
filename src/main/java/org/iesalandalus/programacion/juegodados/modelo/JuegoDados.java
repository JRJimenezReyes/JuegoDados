package org.iesalandalus.programacion.juegodados.modelo;

import java.util.Objects;

public class JuegoDados {

	private static final int MIN_JUGADORES = 2;
	private static final int MAX_JUGADORES = 10;
	
	private final Jugador[] jugadores;
	
	public JuegoDados(int numeroJugadores) {
		comprobarNumeroJugadores(numeroJugadores);
		jugadores = new Jugador[numeroJugadores];
	}
	
	private void comprobarNumeroJugadores(int numeroJugadores) {
		if (numeroJugadores < MIN_JUGADORES || numeroJugadores > MAX_JUGADORES) {
			throw new IllegalArgumentException("El número de jugadores no es válido (" + 
					MIN_JUGADORES + "-" + MAX_JUGADORES + ").");
		}
	}
	
	public void setJugador(int numeroJugador, String nombre) {
		comprobarNumeroJugador(numeroJugador);
		jugadores[numeroJugador] = new Jugador(nombre);
	}

	private void comprobarNumeroJugador(int numeroJugador) {
		if (numeroJugador < 0 || numeroJugador >= jugadores.length) {
			throw new IllegalArgumentException("El número del jugador no es válido.");
		}
	}
	
	public void jugar() {
		comprobarJugadores();
		for (Jugador jugador : jugadores) {
			jugador.jugar();
		}
	}

	private void comprobarJugadores() {
		for (Jugador jugador : jugadores) {
			Objects.requireNonNull(jugador, "Hay un jugador que no se ha creado.");
		}
	}

	public int getPuntuacionGanadora() {
		comprobarJugadores();
		int puntuacionMaxima = 0;
		for (Jugador jugador : jugadores) {
			int puntuacionJugador = jugador.getPuntuacionTotal();
			if (puntuacionJugador > puntuacionMaxima) {
				puntuacionMaxima = puntuacionJugador;
			}
		}
		return puntuacionMaxima;
	}
	
	public Jugador[] getGanadores() {
		comprobarJugadores();
		Jugador[] ganadores = new Jugador[jugadores.length];
		int puntuacionGanadora = getPuntuacionGanadora();
		int indiceGanadores = 0;
		for (Jugador jugador : jugadores) {
			if (jugador.getPuntuacionTotal() == puntuacionGanadora) {
				ganadores[indiceGanadores++] = jugador;
			}
		}
		return ganadores;
	}

	@Override
	public String toString() {
		StringBuilder jugadoresCadena = new StringBuilder();
		for (Jugador jugador : jugadores) {
			jugadoresCadena.append(String.format("%s%n", jugador));
		}
		return jugadoresCadena.toString();
	}

}
