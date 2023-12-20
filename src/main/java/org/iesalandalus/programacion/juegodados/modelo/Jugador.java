package org.iesalandalus.programacion.juegodados.modelo;

import java.util.Arrays;
import java.util.Objects;

public class Jugador {
	
	private static final int NUM_TIRADAS = 5;
	private final int[] puntuaciones = new int[NUM_TIRADAS];
	private String nombre;

	public Jugador(String nombre) {
		setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		Objects.requireNonNull(nombre, "El nombre de un jugador no puede ser nulo.");
		if (nombre.isBlank()) {
			throw new IllegalArgumentException("El nombre de un jugador no puede estar vacío.");
		}
		this.nombre = nombre;
	}
	
	public void jugar() {
		for (int i = 0; i < NUM_TIRADAS; i++) {
			puntuaciones[i] = Dado.lanzar();
		}
	}
	
	public int getPuntuacionTotal() {
		int puntuacionTotal = 0;
		for (int puntuacion : puntuaciones) {
			puntuacionTotal += puntuacion;
		}
		return puntuacionTotal;
	}

	@Override
	public String toString() {
		return String.format("Jugador [nombre=%s, puntuaciones=%s, puntuación total=%d]",
				nombre, Arrays.toString(puntuaciones), getPuntuacionTotal());
	}

}
