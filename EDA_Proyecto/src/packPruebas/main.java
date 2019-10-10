package packPruebas;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

import packModelo.Actor;
import packModelo.ColeccionActores;
import packModelo.ColeccionPeliculas;
import packModelo.Stopwatch;

public class main {
	
	public static void main(String args[]) throws InterruptedException, FileNotFoundException{
		
		
		
		Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        Stopwatch reloj = null;
        while (!salir) {
 
            System.out.println("1. Opcion 1");
            System.out.println("2. Opcion 2");
            System.out.println("3. Opcion 3");
            System.out.println("4. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                
                
        		reloj=new Stopwatch();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Buscar Pelicula");
                        ColeccionPeliculas.getMiColeccionPeliculas().cargarPeliculas();
                		ColeccionPeliculas.getMiColeccionPeliculas().buscarPelicula("Eager to Die");
                		System.out.println("Tiempo utilizado para la busqueda de la Pelicula: "+reloj.elapsedTime());
                        break;
                    case 2:
                        System.out.println("Buscar Actor");
                        ColeccionActores.getMiColeccionActores().cargarActores();
                        Actor a = ColeccionActores.getMiColeccionActores().buscarActor("Devon, Tony");
                        a.imprimirPelisActor();
                        System.out.println("Tiempo utilizado para la busqueda del Actor: "+reloj.elapsedTime());
                        break;
                    case 3:
                        System.out.println("Obtener peliculas de un actor");
                        ColeccionActores.getMiColeccionActores().cargarActores();
                        Actor a1 = ColeccionActores.getMiColeccionActores().buscarActor("Devon, Tony");
                        ColeccionActores.getMiColeccionActores().obtenerPeliculasDeUnActor(a1);
                        break;
                    case 4:
                        System.out.println("Ordenar lista de actores");
                        ColeccionActores.getMiColeccionActores().cargarActores();
                        //ColeccionActores.getMiColeccionActores().ordenarActores();
                        break;
                    case 5:
                        salir = true;
                        break;
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
