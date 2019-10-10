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
	
	public Pelicula buscarPelicula(String pTitulo) throws FileNotFoundException  {
		
		Iterator<Pelicula> it = listaPeliculas.iterator();
		Boolean encontrado = false;
		Pelicula peli = null;
		while(it.hasNext() && !encontrado) {
			peli = it.next();
			if(pTitulo.equals(peli.getNombrePelicula())) {
				encontrado = true;
			}
		}if(encontrado) {
			System.out.println("EXISTE LA PELICULA!");
		}
		else {
			System.out.println("NO EXISTE LA PELICULA!");
		}
		return peli;	
	}
		
	public void incrementarCantidad(float pCantidad, String pPeli) throws FileNotFoundException {
		
		Pelicula peli = buscarPelicula(pPeli);
		peli.incrementarDinero(pCantidad);
		
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
				String[] linea2 = linea.split(" --->");
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
	
	public void imprimirPeliculas() {
		
		for (int i = 0; i < listaPeliculas.size(); i++) {
			System.out.println(listaPeliculas.get(i).getNombrePelicula());
		}

	}
	
	public int getSize(){
		return listaPeliculas.size();
	}
	
	
	
	
}
