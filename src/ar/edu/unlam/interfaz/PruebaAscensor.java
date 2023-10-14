package ar.edu.unlam.interfaz;

import java.util.Scanner;

import ar.edu.unlam.dominio.Ascensor1;
import ar.edu.unlam.dominio.MenuAscensor;
import ar.edu.unlam.dominio.Persona;

public class PruebaAscensor {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		Ascensor1 subito = new Ascensor1(0, 10, 1000.0, 5);

		MenuAscensor menu = null;
		int opcion = 0;

		do {
			menuAscensor();

			opcion = ingresarOpcion(teclado);

			menu = MenuAscensor.values()[opcion - 1];

			switch (menu) {
			case ABRIR_PUERTA:

				subito.abrirPuerta();
				System.out.println("\nAbriendo puerta");

				break;
			case INGRESAR:

				System.out.println("\nCapacidad maxima de personas: " + subito.getCAPACIDAD_MAXIMA());
				System.out.println("\nPeso maximo soportado: " + subito.getPESO_MAXIMO() + " kg");

				ingresar(teclado, subito);

				break;
			case CERRAR_PUERTA:

				subito.cerrarPuerta();
				System.out.println("\nCerrando puerta");

				break;
			case SUBIR:

				subito.subir();
				System.out.println("\nSubiendo");

				break;
			case BAJAR:

				subito.bajar();
				System.out.println("\nBajando");

				break;
			case PISO_DESEADO:

				System.out.println("\nPiso maximo: " + subito.getPISO_MAXIMO());
				System.out.println("\nPiso minimo: " + subito.getPISO_MINIMO());
				System.out.println("\nPiso actual: " + subito.getPisoActual());
				System.out.println("A que piso va?");
				int pisoDeseado = teclado.nextInt();
				subito.irAlPiso(pisoDeseado);
				System.out.println("Se encuenta en el piso " + pisoDeseado);

				break;
			case CONSULTAR_PISO:

				System.out.println("\nPiso actual: " + subito.getPisoActual());

				break;
			case SALIR_DEL_ASCENSOR:

				salir(teclado, subito);

				break;
			case CANTIDAD_DE_PERSONAS_EN_ASCENSOR:

				if (subito.getPersonasIngresadas() != 0) {
					System.out.println(
							"\nActualmente hay " + subito.getPersonasIngresadas() + " personas en el ascensor");
				} else {
					System.out.println("\nActualmente no hay personas en el ascensor");
				}

				break;
			case FIN:
				System.out.println("\nFinalizando programa..");
				break;
			}

		} while (!menu.equals(MenuAscensor.FIN));

		teclado.close();
	}

	private static void salir(Scanner teclado, Ascensor1 subito) {
		System.out.println("\nCuantas personas salen?");
		int ocupantes = teclado.nextInt();
		subito.ingresarCantidadDeOcupantes(ocupantes);

		do {
			subito.salir(crearPersona(teclado));
			ocupantes--;
			System.out.println("\nQuedaron" + subito.getPersonasIngresadas() + " personas");
		} while (ocupantes != 0);
		System.out.println("\nPersonas salieron del ascensor");
	}

	private static void ingresar(Scanner teclado, Ascensor1 subito) {

		System.out.println("\nCuantas personas ingresaron?");
		int ocupantes = teclado.nextInt();
		subito.ingresarCantidadDeOcupantes(ocupantes);

		do {
			subito.ingresar(crearPersona(teclado));
			ocupantes++;
			System.out.println("\nSe han subido " + subito.getPersonasIngresadas() + " personas");
		} while (ocupantes != 0);
		System.out.println("\nTodas las personas estan dentro del ascensor.");

	}

	private static Persona crearPersona(Scanner teclado) {

		System.out.println("Ingrese el peso de la persona");
		double peso = teclado.nextDouble();

		Persona persona = new Persona(peso);

		return persona;
	}

	private static int ingresarOpcion(Scanner teclado) {
		int opcion = 0;
		do {
			System.out.println("\nIngresa una opcion: ");
			opcion = teclado.nextInt();
			if (opcion < 1 || opcion > 10) {
				System.out.println("\n Opcion invalida");
			}
		} while (opcion < 1 || opcion > 10);

		return opcion;
	}

	private static void menuAscensor() {

		System.out.println("\n 1. Abrir puerta del ascensor");
		System.out.println("2. Ingresar al ascensor");
		System.out.println("3. Cerrar puerta del ascensor");
		System.out.println("4. Subir piso");
		System.out.println("5. Bajar piso");
		System.out.println("6. Ir al piso deseado");
		System.out.println("8. Salir del ascensor");
		System.out.println("9. Consultar cantidad de personas actuales en el ascensor");
		System.out.println("10. Finalizar programa");

	}

}
