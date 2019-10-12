package packPruebas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import packModelo.Actor;
import packModelo.ColeccionActores;
import packModelo.ColeccionPeliculas;
import packModelo.Stopwatch;

public class main {
	
	public static void main(String args[]) throws InterruptedException, IOException{
		
		
		
		Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        Stopwatch reloj = null;
        while (!salir) {
 
            System.out.println("1. Opcion 1 - Buscar una Pelicula");
            System.out.println("2. Opcion 2 - Buscar un Actor");
            System.out.println("3. Opcion 3 - Obtener las peliculas de un actor");
            System.out.println("4. Opcion 4 - Obtener los actores de una pelicula");
            System.out.println("5. Opcion 5 - Ordenar lista de actores");
            System.out.println("6. Opcion 6 - Generar fichero");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                
                
        		reloj=new Stopwatch();

                switch (opcion) {
                    case 1:
                        System.out.println("Buscar Pelicula");
                        ColeccionActores.getMiColeccionActores().cargarDatos();
                		System.out.println("Tiempo utilizado para la carga de datos: "+reloj.elapsedTime());
                		reloj=new Stopwatch();
                		ColeccionPeliculas.getMiColeccionPeliculas().buscarPelicula("Eager to Die");
                		System.out.println("Tiempo utilizado para la busqueda de datos: "+reloj.elapsedTime());
                		break;
                    case 2:
                        System.out.println("Buscar Actor");
                        ColeccionActores.getMiColeccionActores().cargarDatos();
                		//ColeccionActores.getMiColeccionActores().imprimirActores();

                        ColeccionActores.getMiColeccionActores().buscarActor("French, Steve (VIII)");
                        System.out.println("Tiempo utilizado para la busqueda del Actor: "+reloj.elapsedTime());
                        break;
                    case 3:
                        System.out.println("Obtener peliculas de un actor");
                        ColeccionActores.getMiColeccionActores().cargarDatos();
                        ColeccionActores.getMiColeccionActores().obtenerPeliculasDeUnActor("Devon, Tony");
                        System.out.println("Tiempo utilizado para la busqueda del Actor: "+reloj.elapsedTime());
                        break;
                    case 4:
                        System.out.println("Obtener actores de una pelicula");
                        ColeccionActores.getMiColeccionActores().cargarDatos();
                        ColeccionPeliculas.getMiColeccionPeliculas().obtenerActoresDeUnaPeli("Eager to Die");
                        System.out.println("Tiempo utilizado para la busqueda del Actor: "+reloj.elapsedTime());
                        break;
                    case 5:
                        System.out.println("Ordenar lista de actores");
                        ColeccionActores.getMiColeccionActores().cargarDatos();
                        ColeccionActores.getMiColeccionActores().ordenarActoresAlfabeticamente();
                        System.out.println("Tiempo utilizado para ordenar los actores: "+reloj.elapsedTime());
                        break;
                    case 6:
                    	System.out.println("Generar un fichero");
                    	ColeccionActores.getMiColeccionActores().cargarDatos();
                    	ColeccionPeliculas.getMiColeccionPeliculas().generarLista();
                    	System.out.println("Tiempo utilizado para generar el fichero: "+reloj.elapsedTime());
                    
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }		


		
	}

}
