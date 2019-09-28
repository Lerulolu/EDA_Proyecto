package packModelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaPeliculas {
	
	private ArrayList<String> listaPeliculas;
	private static ListaPeliculas miListaPeliculas;
	
	private ListaPeliculas() {
		listaPeliculas = new ArrayList<String>();
	}
	
	public static ListaPeliculas getListaPeliculas() {
		if(miListaPeliculas == null) {
			miListaPeliculas = new ListaPeliculas();
		}
		return miListaPeliculas;
	}
	
	public void cargarPeliculas() {
		try {
			
			FileReader fichero = new FileReader(new File("src/packDatos/FilmsActors20162017.txt"));
			BufferedReader buffer = new BufferedReader(fichero);
			String linea = buffer.readLine();
			System.out.println("CARGANDO DATOS");
			while(!linea.isEmpty()) {
				String[] parte = linea.split("--->");
				String nombrePeli = parte[0];
				listaPeliculas.add(nombrePeli);
				System.out.println(parte[0]);
				linea = buffer.readLine();
			}
			buffer.close();
		} catch (Exception e) {
			System.out.println("ERROR");
		}
	}
	

}
