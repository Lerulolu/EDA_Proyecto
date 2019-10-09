package packPruebas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import packModelo.Actor;

public class IMBD {

	private static IMBD miIMBD;
	
	public static IMBD getMiIMBD() {
		if(miIMBD == null) {
			miIMBD = new IMBD();
		}
		return miIMBD;
	}
	
	private IMBD() {
		
	}
	
	
	public void cargarActores() {
		
		try {
			
			FileReader fichero = new FileReader(new File("src/packDatos/FilmsActors20162017.txt"));
			BufferedReader buffer = new BufferedReader(fichero);
			String linea = buffer.readLine();
			System.out.println("CARGANDO LOS ACTORES");
			while(!linea.isEmpty()) {
				
				//OBTENEMOS LA LISTA DE ACTORES
				String[] linea2 = linea.split("--->");
				for(int j = 0; j < linea.length(); j++) {
					String listaActores = linea2[1];
					String[] actor = listaActores.split("&&&");
					for (int i = 0; i<listaActores.length(); i++) {
						//SEPARAMOS ACTORES EN NOMBRE Y APELLIDO
						String[] separador = actor[i].split(",");
						String apellido = separador[0];
						String nombre = separador[1];
						/*System.out.println("ACTOR"+actor[i]);
						System.out.println("NOMBRE"+nombre);
						System.out.println("APELLIDO"+apellido);*/
						Actor act = new Actor(nombre, apellido);
						
					}
					linea = buffer.readLine();
				}
				
			}
			buffer.close();
			
		}catch (Exception e) {
			System.err.println("PROBLEM!");
		}
	}
	
	public void guardarLista() {
		
	}
}
