package packModelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Pelicula {
	
	private String titulo;
	private float dineroRecaudado;
	private ListaActores lActores;
	
	public Pelicula(String pNombrePeli, float pDineroRecaudado) {
		titulo = pNombrePeli;
		dineroRecaudado = pDineroRecaudado;
		lActores = new ListaActores();
	}
	
	public String getNombrePelicula() {
		return titulo;
	}
	
	public void imprimirActores() {
		
		for (int i = 0; i < lActores.obtenerLongitudLista(); i++) {
			System.out.println(lActores.toString());
		}
	}
	
	public void incrementarDinero (float pCantidad) {
		this.dineroRecaudado = this.dineroRecaudado + pCantidad;
	}
	
	public void borrarActor(Actor pActor) {
		lActores.borrarActor(pActor);
	}
	
	public void insertarActor(Actor pActor) {
		lActores.anadirActor(pActor);
	}
	
	public void inizializarActores() {
		
		try {
			
			FileReader fichero = new FileReader(new File("src/packDatos/FilmsActors20162017.txt"));
			BufferedReader buffer = new BufferedReader(fichero);
			String linea = buffer.readLine();
			System.out.println("CARGANDO LOS ACTORES");
			while(!linea.isEmpty()) {
				
				//ELIMINAR LA PELI
				String[] linea2 = linea.split("--->");
				String listaActores = linea2[1];
				String[] actor = listaActores.split("&&&");
				while(!actor[0].isEmpty()) { //Primer nombre del actor
					System.out.println(actor[0].toString());
				}
				System.out.println("ACTORES"+lActores.obtenerLongitudLista());
				linea = buffer.readLine();
			}
			buffer.close();
			
		}catch (Exception e) {
			System.err.println("PROBLEM!");
		}
	}
	
	
}
