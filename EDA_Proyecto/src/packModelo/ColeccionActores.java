package packModelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class ColeccionActores {
	
	private static ColeccionActores miColeccionActores;
	
	private ListaActores listaActores;
	
	private ColeccionActores() {
		listaActores = new ListaActores();
	}
	
	public static ColeccionActores getColeccionActores() {
		if(miColeccionActores == null) {
			miColeccionActores = new ColeccionActores();
		}
		return miColeccionActores;
	}
	
	public void cargarActores() {
		
		try {

			FileReader fichero = new FileReader(new File("src/packDatos/FilmsActors20162017.txt"));
			BufferedReader buffer = new BufferedReader(fichero);
			String linea = buffer.readLine();
			System.out.println("CARGANDO LOS ACTORES");
			while(!linea.isEmpty()) {
				String[] partes = linea.split("--->");
				String apellido = partes[0];
				String nombre = partes[1];
				partes = linea.split("&&&");
				listaActores.añadirApellidoActor(apellido);
				
				linea = buffer.readLine();
			}
			buffer.close();
		}catch (Exception e) {
			System.out.println("Ha habido un problema al cargar los datos");
		}
	}

}
