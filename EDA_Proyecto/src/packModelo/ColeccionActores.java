package packModelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ColeccionActores {
	
	private ListaActores listaActores;
	private ListaPeliculas listaPelis;
	private static ColeccionActores miColeccionActores;
	
	public static ColeccionActores getMiColeccionActores() {
		if(miColeccionActores == null) {
			miColeccionActores = new ColeccionActores();
		}
		return miColeccionActores;
	}
	
	private ColeccionActores() {
		listaActores = new ListaActores();
		listaPelis = new ListaPeliculas();
	}
	
	
	public void cargarActores() {
		
		try {

			FileReader fichero = new FileReader(new File("src/packDatos/FilmsActors20162017.txt"));
			BufferedReader buffer = new BufferedReader(fichero);
			String linea = buffer.readLine();
			System.out.println("CARGANDO LOS ACTORES");
			while(!linea.isEmpty()) {
				String[] linea2 = linea.split("--->");
				listaPelis.anadirPelicula(linea2.toString());
				linea2 = linea.split("&&&");
				for (int i = 0; i < linea.length(); i++) {
					listaActores.añadirActor(linea2.toString());
					System.out.println(linea2[i].toString());
				}
			}
			buffer.close();
		}catch (Exception e) {
			System.err.println("PROBLEM!");
		}
	}

}
