package packModelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaPeliculas {
	
	private ArrayList<Pelicula> listaPeliculas;
	
	public ListaPeliculas() {
		
		listaPeliculas = new ArrayList<Pelicula>();
	}
		
	public ListaActores obtenerActoresDePelicula(Pelicula pPeli) {
		
		return null;
		
	}
	
	public Boolean buscarPelicula(String pTitulo) throws FileNotFoundException  {
		
		Iterator<Pelicula> it = listaPeliculas.iterator();
		Boolean encontrado = false;
		Pelicula peli = null;
		while(it.hasNext() && !encontrado) {
			peli = it.next();
			System.out.println(peli.getNombrePelicula());
			if(pTitulo.equals(peli.getNombrePelicula())) {
				encontrado = true;
			}
		}
		if(encontrado) {
			System.out.println("ENCONTRADO");
		}
		else {
			System.out.println("NO ENCONTRADO");
		}
		return encontrado;		
	}
		
	public void incrementarCantidad(float pCantidad, Pelicula pPeli) {
		
	}
	
	public void anadirPelicula(Pelicula pPeli) {
		listaPeliculas.add(pPeli);
	}
		
	public void cargarPeliculas()  {
		
		try {
			
			FileReader fichero = new FileReader(new File("src/packDatos/FilmsActors20162017.txt"));
			BufferedReader buffer = new BufferedReader(fichero);
			String linea = buffer.readLine();
			while(linea != null) {
				String[] linea2 = linea.split("--->");
				String pelicula = linea2[0];
				Pelicula peli = new Pelicula(pelicula, 0);
				listaPeliculas.add(peli);
				/*for(int i = 0; i < listaPeliculas.size(); i++ ) {
					System.out.println(listaPeliculas.get(i).getNombrePelicula());
				}*/
				linea = buffer.readLine();
			}			
			buffer.close();	
		}
		catch (IOException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}
	
	
	
	/*
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
	*/
}
