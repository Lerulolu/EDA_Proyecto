package packModelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaActores {
	
	private ArrayList<Actor> listaActores;
	private static ListaActores miListaActores;
	
	private ListaActores() {
		listaActores = new ArrayList<Actor>();
	}
	
	public static ListaActores getListaActores() {
		if(miListaActores == null) {
			miListaActores = new ListaActores();
		}
		return miListaActores;
	}
	
	public ListaPeliculas obtenerPeliculasDeActor(Actor pActor) {
		
		return null;
		
	}
	
	public boolean buscarActor(String pActor) {
		
		boolean enc = false;
		Iterator<Actor> it = listaActores.iterator();
		while(listaActores != null && it.hasNext() && enc == false) {
			Actor actor = it.next();
			if(pActor == actor.getNombreActor()) {
				enc = true;
			}
		}
		return enc;
	}

	public void obtenerListaActores() {
		
		try {
			
			BufferedReader bf = new BufferedReader(new FileReader("src/packDatos/FilmsActors20162017.txt"));
			String line = "";
			line = bf.readLine();
			while (line != null) {
				line.split("");
				if(line.trim().length() == 0)
					continue;
				String[] parts = line.split(" ---> ");
				String nombre = parts[0];
				//ACABAR
				
				
				
				
			}
			bf.close();
		}catch (Exception e) {
			System.out.println("ERROR!");
		}
		
	}
}
