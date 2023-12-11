package mus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Barajeador {
    static ArrayList<String> manoJugador1 = new ArrayList<>();
    static ArrayList<String> manoJugador2 = new ArrayList<>();
    static ArrayList<String> manoJugador3 = new ArrayList<>();
    static ArrayList<String> manoJugador4 = new ArrayList<>();

    static Stack<String> baraja = new Stack<>();
    static Stack<String> barajaDescartes = new Stack<>();
    static int[] jugador1 = {0, 0, 0, 0}; // Ejemplo de cartas del jugador 1
    static int[] jugador2 = {0, 0, 0, 0}; // Ejemplo de cartas del jugador 2
    static int[] jugador3 = {0, 0, 0, 0}; // Ejemplo de cartas del jugador 3
    static int[] jugador4 = {0, 0, 0, 0}; // Ejemplo de cartas del jugador 4

    public static void main(String[] args) {
        Barajeador repartirCartasMetodos = new Barajeador();
        repartirCartasMetodos.repartir();
        new Barajeador();

        // Comparar los jugadores y determinar al ganador
        int ganadorGrande = determinarGanadorGrande(jugador1, jugador2, jugador3, jugador4);
        int ganadorChica = determinarGanadorChica(jugador1, jugador2, jugador3, jugador4);

        // Mostrar el resultado
        System.out.println("El ganador de la grande es el Jugador " + ganadorGrande);
        System.out.println("El ganador de la chica es el Jugador " + ganadorChica);
        for (int a = 0; a < 4; a++) {
            System.out.print(jugador1[a]);
        }
    }

    public void repartir() {
        Palos[] palos = Palos.values();
        Numeros[] numeros = Numeros.values();

        Stack<String> baraja = crearBaraja(palos, numeros);
        barajarCartas(baraja);

        for (int i = 0; i < 4; i++) {
            String naipe = baraja.pop();
            manoJugador1.add(naipe);
            String cadena1 = manoJugador1.toString();
            asignarValoresJugador(cadena1, jugador1, 0);
        }

        for (int i = 0; i < 4; i++) {
            String naipe = baraja.pop();
            manoJugador2.add(naipe);
            String cadena2 = manoJugador2.toString();
            asignarValoresJugador(cadena2, jugador2, 0);
        }

        for (int i = 0; i < 4; i++) {
            String naipe = baraja.pop();
            manoJugador3.add(naipe);
            String cadena3 = manoJugador3.toString();
            asignarValoresJugador(cadena3, jugador3, 0);
        }

        for (int i = 0; i < 4; i++) {
            String naipe = baraja.pop();
            manoJugador4.add(naipe);
            String cadena4 = manoJugador4.toString();
            asignarValoresJugador(cadena4, jugador4, 0);
        }
        mostrarManoJugadores();
    }

    public Stack<String> crearBaraja(Palos[] palos, Numeros[] numeros) {
        for (Palos pa : palos) {
            for (Numeros num : numeros) {
                String carta = num + " DE " + pa;
                baraja.push(carta);
            }
        }
        return baraja;
    }

    private void barajarCartas(Stack<String> baraja) {
        Collections.shuffle(baraja);
    }

    private void mostrarManoJugadores() {
        String[] nombresJugadores = {"UNO", "DOS", "TRES", "CUATRO"};
        System.out.println("------------------------------");
        System.out.println("Mano del jugador " + nombresJugadores[0]);
        System.out.println("------------------------------");
        for (String mano : manoJugador1) {
            System.out.println(mano);
        }

        System.out.println("------------------------------");
        System.out.println("Mano del jugador " + nombresJugadores[1]);
        System.out.println("------------------------------");
        for (String mano : manoJugador2) {
            System.out.println(mano);
        }

        System.out.println("------------------------------");
        System.out.println("Mano del jugador " + nombresJugadores[2]);
        System.out.println("------------------------------");
        for (String mano : manoJugador3) {
            System.out.println(mano);
        }

        System.out.println("------------------------------");
        System.out.println("Mano del jugador " + nombresJugadores[3]);
        System.out.println("------------------------------");
        for (String mano : manoJugador4) {
            System.out.println(mano);
        }
    }
	
	public static int determinarGanadorGrande(int[]... jugadores) {
		int maxReyes = 0;
		int maxCaballos = 0;
		int maxSotas = 0;
		int maxSietes = 0;
		int maxSeises = 0;
		int maxCincos = 0;
		int maxCuatros = 0;		
		int ganador = -1;

		for (int i = 0; i < jugadores.length; i++) {
			int reyes	 	= 	contarCartas(jugadores[i], 	8); // Contar Cerdos
			int caballos 	=	contarCartas(jugadores[i], 	7); // Contar Caballos
			int sotas 		= 	contarCartas(jugadores[i], 	6); // Contar Sotas
			int sietes 		= 	contarCartas(jugadores[i], 	5); // Contar Sietes
			int seises 		= 	contarCartas(jugadores[i], 	4); // Contar Seises
			int cincos 		=	contarCartas(jugadores[i], 	3); // Contar Cincos
			int cuatros 	= 	contarCartas(jugadores[i], 	2); // Contar Cuatros
			if (reyes > maxReyes ||
					(reyes == maxReyes && caballos > maxCaballos) ||
					(reyes == maxReyes && caballos == maxCaballos && sotas > maxSotas)||
					reyes == maxReyes && caballos == maxCaballos && sotas > maxSotas && sietes > maxSietes ||
					reyes == maxReyes && caballos == maxCaballos && sotas > maxSotas && sietes > maxSietes && seises > maxSeises ||
					reyes == maxReyes && caballos == maxCaballos && sotas > maxSotas && sietes > maxSietes && seises > maxSeises && cincos > maxCincos||
					reyes == maxReyes && caballos == maxCaballos && sotas > maxSotas && sietes > maxSietes && seises > maxSeises && cincos > maxCincos && cuatros > maxCuatros)
			{
				maxReyes = reyes;
				maxCaballos = caballos;
				maxSotas = sotas;
				maxSietes = sietes;
				maxSeises = seises;
				maxCincos = cincos;
				maxCuatros = cuatros;
				ganador = i + 1; // El índice del jugador ganador

			}
		}
		return ganador;
	}

	public static int determinarGanadorChica(int[]... jugadores) {
		int maxCaballos = 0;
		int maxSotas = 0;
		int maxSietes = 0;
		int maxSeises = 0;
		int maxCincos = 0;
		int maxCuatros = 0;
		int maxAses = 0;
		int ganador = -1;

		for (int i = 0; i < jugadores.length; i++) {
			int caballos = 	contarCartas(jugadores[i], 7); // Contar Caballos
			int sotas = 	contarCartas(jugadores[i], 6); // Contar Sotas
			int sietes = 	contarCartas(jugadores[i], 5); // Contar Sietes
			int seises = 	contarCartas(jugadores[i], 4); // Contar Seises
			int cincos = 	contarCartas(jugadores[i], 3); // Contar Cincos
			int cuatros = 	contarCartas(jugadores[i], 2); // Contar Cuatros)
			int ases = 		contarCartas(jugadores[i], 1); // Contar Pitos 
			if (ases > maxAses ||
					(ases == maxAses && cuatros > maxCuatros) ||
					(ases == maxAses && caballos == maxCuatros && cincos > maxCincos)||
					ases == maxAses && caballos == maxCuatros && cincos > maxCincos && seises > maxSeises ||
					ases == maxAses && caballos == maxCuatros && cincos > maxCincos && sietes> maxSietes && seises > maxSeises ||
					ases == maxAses && caballos == maxCuatros && cincos > maxCincos && sotas > maxSotas && seises > maxSeises && cincos > maxCincos||
					ases == maxAses && caballos == maxCuatros && cincos > maxCincos && caballos > maxCaballos && caballos > maxSeises && cincos > maxCincos && cuatros > maxCuatros)
			{
				maxCaballos = caballos;
				maxSotas = sotas;
				maxSietes = sietes;
				maxSeises = seises;
				maxCincos = cincos;
				maxCuatros = cuatros;
				maxAses = ases;
				ganador = i + 1; // El índice del jugador ganador

			}
		}
		return ganador;
	}

	public static int contarCartas(int[] mano, int carta) {
		int contador = 0;
		for (int valorCarta : mano) {
			if (valorCarta == carta) {
				contador++;
			}
		}
		return contador;
	}

	public static void asignarValoresJugador(String cadena, int[] jugador, int posicionInicial) {
		HashMap<String, Integer> valores = new HashMap<>();
		valores.put("AS", 1);
		valores.put("DOS", 1);
		valores.put("TRES", 8);
		valores.put("CUATRO", 2);
		valores.put("CINCO", 3);
		valores.put("SEIS", 4);
		valores.put("SIETE", 5);
		valores.put("SOTA", 6);
		valores.put("CABALLO", 7);
		valores.put("REY", 8);

		cadena = cadena.replace("[", "").replace("]", "").replaceAll("\\s+", "");

		String[] cartas = cadena.split(",");
		int cartaActual = posicionInicial;

		for (String carta : cartas) {
			String[] partes = carta.split("DE");
			if (partes.length > 1) {
				String nombreCarta = partes[0].toUpperCase().trim();
				if (valores.containsKey(nombreCarta)) {
					int valorCarta = valores.get(nombreCarta);
					if (cartaActual < jugador.length) {
						jugador[cartaActual] = valorCarta;
						cartaActual++;
					} else {
						break; // Si el jugador no tiene suficientes posiciones en su array, salir del bucle
					}
				}
			}
		}
	}

	
}