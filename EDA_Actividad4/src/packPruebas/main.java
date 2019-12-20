package packPruebas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map.Entry;
import java.util.Scanner;

import packModelo.Actor;
import packModelo.ColeccionActores;
import packModelo.ColeccionPeliculas;
import packModelo.Graph;
import packModelo.GraphHash;
import packModelo.ListaActores;
import packModelo.Pelicula;
import packModelo.Stopwatch;

public class main {
	
	public static void main(String args[]) throws InterruptedException, IOException{
			
		Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        Stopwatch reloj = new Stopwatch();
		System.out.println("Cargando datos...");
        ColeccionActores.getMiColeccionActores().cargarDatos();
		System.out.println("Tiempo utilizado para la carga de datos: "+reloj.elapsedTime());
		System.out.println("");
        while (!salir) {
 
            System.out.println("1. Opcion 1 - Algortimo Page Rank");        
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                
                
        		reloj=new Stopwatch();

                switch (opcion) {
                    case 1:
                        System.out.println("PRUEBA PAGE RANK");
                        reloj=new Stopwatch();
                        HashMap<String, BigDecimal> pageRank = Graph.getMiGraph().pageRank();
                		System.out.println("Tiempo utilizado para realización del pageRank: "+reloj.elapsedTime());
                		reloj=new Stopwatch();
                		System.out.println("");
                		System.out.println("PRUEBA 1: Thomas, Emma (VI)");
                		Graph.getMiGraph().buscar("Thomas, Emma (VI)", pageRank);
                		System.out.println("Tiempo utilizado para la busqueda de datos: "+reloj.elapsedTime());
                		System.out.println("");
                		reloj=new Stopwatch();
                		System.out.println("PRUEBA 2: Gutta Story");
                		Graph.getMiGraph().buscar("Gutta Story", pageRank);
                		System.out.println("Tiempo utilizado para la busqueda de datos: "+reloj.elapsedTime());
                		System.out.println("");

                		break;
                   
                    default:
                        System.out.println("Solo opción número 1");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }		


		
	}

}
