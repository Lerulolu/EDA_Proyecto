package packModelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ListaPeliculas {
	
	private ArrayList<String> listaPeliculas;
	private ListaActores listaActores;
	
	public ListaPeliculas() {
		
		listaPeliculas = new ArrayList<String>();
		listaActores = new ListaActores();
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
	
	public ListaPeliculas obtenerPeliculasDeActor(Actor pActor) {
		
		ListaPeliculas lista = new ListaPeliculas();
		cargarPeliculas();
		for(int i = 0; i < listaPeliculas.size(); i++) {
			
			if(listaActores.equals(pActor)) {
				lista.anadirPelicula(listaPeliculas.get(i).toString());
			}
		}
		return lista;
	}
	
	public void anadirPelicula(String pPeli) {
		listaPeliculas.add(pPeli);
	}

}
