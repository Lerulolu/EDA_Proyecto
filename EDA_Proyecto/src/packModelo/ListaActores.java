package packModelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class ListaActores {
	
	private ArrayList<Actor> listaActores;
	
	public ListaActores() {
		listaActores = new ArrayList<Actor>();
	}
	
		
	public ListaPeliculas obtenerPelisActor(String pNombre) {
		Actor actor = buscarActor(pNombre);
		ListaPeliculas lista = actor.obtenerPeliculasDeActor();
		return lista;
		
	}
	
	public Actor buscarActor(String pNombre) {
		
		Iterator<Actor> it = listaActores.iterator();
		Actor actor = null;
		Boolean encontrado = false;
		while (it.hasNext() && !encontrado) {
			actor = it.next();
			if(pNombre.equals(actor.getNombreActor())) {
				encontrado = true;
			}
		}
			return actor;		
	}
	
	public void borrarActor(Actor pActor) {
		listaActores.remove(pActor);
	}
	
	public void anadirActor(Actor pActor) {
		listaActores.add(pActor);
	}
	
	public void ordenarLista() {
		
	}
	
	public int obtenerLongitudLista() {
		return listaActores.size();
	}
	
	public void cargarActores() {
		
		try {
			FileReader fichero = new FileReader(new File("src/packDatos/FilmsActors20162017.txt"));
			BufferedReader buffer = new BufferedReader(fichero);
			String linea = buffer.readLine();
			Actor actor = null;
			while(linea != null) {
				String[] linea2 = linea.split(" ---> ");
				Pelicula peli = new Pelicula(linea2[0].toString(),0);
				String[] listaA = linea2[1].split(" &&& ");
				for (int i = 0; i < listaA.length; i++) {
					String nombre = listaA[i].toString();
					actor = buscarActor(nombre);
					if(actor == null) {
						actor = new Actor(nombre);
						listaActores.add(actor);
					}
				}
				actor.añadirPeli(peli);
				linea = buffer.readLine();		
			}	
			buffer.close();
		}
		catch (IOException e) {
			System.err.println(e.getLocalizedMessage());
		}
	
	
	}
	
	public void ordenarActoresAlfabeticamente() {
		cargarActores();
		ArrayList<String> list = null;
		for(int i = 0; i < listaActores.size(); i++) {
			list.add(i, listaActores.get(i).getNombreActor());
		}
		for(int j = 0; j < list.size(); j++) {
			System.out.println(list.toString());
		}
	}
	
	/*public void cargarActoresComas() {
		
		try {
			
			FileReader fichero = new FileReader(new File("src/packDatos/FilmsActors20162017.txt"));
			BufferedReader buffer = new BufferedReader(fichero);
			String linea = buffer.readLine();
			while(linea != null) {
				String[] linea2 = linea.split(" ---> ");
				String[] listaA = linea2[1].split(" &&& ");
				int cont = 0;
				for( int i = 0; i < listaA.length; i++) {
					String[] separar = listaA[i].split(", ");
					String nombre = separar[1];
					String apellido = separar[0];
					System.out.println("LINEA"+cont);
					System.out.println("LISTA A "+listaA[i].toString());
					System.out.println("NOMBRE "+nombre+"APELLIDO "+apellido);
					cont++;
				}
				
				//separarListaDeActores(listaA);
				linea = buffer.readLine();		
			}	
			buffer.close();	
		}
		catch (IOException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}*/

	
		

	private Iterator<Actor> getIterador(){
		return listaActores.iterator();
	}

	
	
}
	

