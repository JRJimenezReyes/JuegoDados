package org.iesalandalus.programacion.juegodados.vista;

import org.iesalandalus.programacion.juegodados.modelo.JuegoDados;
import org.iesalandalus.programacion.juegodados.modelo.Jugador;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    private Consola() {}

    public static int leerNumeroJugadores() {
        System.out.print("Introduce el número de jugadores: ");
        return Entrada.entero();
    }

    public static String leerNombreJugador(int numeroJugador) {
        String nombre;
        do {
            System.out.printf("Introduce el nombre del jugador %d: ", numeroJugador);
            nombre = Entrada.cadena();
        } while (nombre.isBlank());
        return nombre;
    }

    public static void mostrarResultados(JuegoDados juegoDados) {
        StringBuilder resultados = new StringBuilder("Resultados del juego.\n");
        resultados.append("---------------------\n");
        resultados.append(String.format("Puntuación de los jugadores: %n"));
        resultados.append(juegoDados);
        resultados.append(String.format("Puntuación máxima: %d%n", juegoDados.getPuntuacionGanadora()));
        StringBuilder ganadores = new StringBuilder();
        for (Jugador ganador : juegoDados.getGanadores()) {
            if (ganador != null) {
                if (!ganadores.isEmpty()) {
                    ganadores.append(", ");
                }
                ganadores.append(ganador.getNombre());
            }
        }
        resultados.append(String.format("Ganadores: %s", ganadores));
        System.out.println(resultados);
    }
}
