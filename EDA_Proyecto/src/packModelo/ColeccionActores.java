package packModelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ColeccionActores {
	
	private static ColeccionActores miColeccionActores;
	private ListaActores listaActores;
	
	private ColeccionActores() {
		listaActores = new ListaActores();
	}
	
	public static ColeccionActores getMiColeccionActores() {
		if(miColeccionActores == null) {
			miColeccionActores = new ColeccionActores();
		}
		return miColeccionActores;
	}
	
	public Actor buscarActor(String pNombre) {
		return listaActores.buscarActor(pNombre);
	}
	
	public ListaPeliculas obtenerPeliculasDeUnActor(Actor actor) {
		return actor.obtenerPeliculasDeActor();
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
						listaActores.anadirActor(actor);
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
	
	public void añadirActor(Actor pActor)
	{
		listaActores.anadirActor(pActor);
	}
	
	public void eliminarActor(String pActor)
	{
		Actor a = listaActores.buscarActor(pActor);
		if(a != null)
		{
			//Hay que borrarlo de las pelis en las que aparece --> Obtenemos la lista de peliculas de ese actor
			ListaPeliculas pelisActor = a.obtenerPeliculasDeActor();
			//Para cada peli de esa lista, borrar el actor
			for (int i = 0; i < pelisActor.getSize(); i++)
			{
				Pelicula p = pelisActor.obtenerPelicula(i);
				//Borramos el actor de la lista de actores de la peli
				p.borrarActor(a);
				//Lo eliminamos de la coleccion
				listaActores.borrarActor(a);
			}
		}
		
		listaActores.borrarActor(a);		
		
	}
	
	public void ordenarActoresAlfabeticamente() {
		
	
	}

}
