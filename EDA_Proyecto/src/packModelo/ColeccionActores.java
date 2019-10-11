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
	

	public void cargarDatos() {
		
		try {
			FileReader fichero = new FileReader(new File("src/packDatos/FilmsActors20162017.txt"));
			BufferedReader buffer = new BufferedReader(fichero);
			String linea = buffer.readLine();
			Actor actor = null;
			while(linea != null) {
				String[] linea2 = linea.split(" ---> ");
				//Añadimos la peli a la Coleccion de Peliculas
				ColeccionPeliculas.getMiColeccionPeliculas().insertarPelicula(linea2[0].toString());
				//Creamos el objeto pelicula
				Pelicula peli = new Pelicula(linea2[0].toString(),0);
				String[] listaA = linea2[1].split(" &&& ");
				for (int i = 0; i < listaA.length; i++) {
					String nombre = listaA[i].toString();
					actor = buscarActor(nombre);
					if(actor == null) {
						//Si el actor no existe en la Coleccion de actores, lo añadimos 
						listaActores.insertarActor(nombre);					
					}
					//Añadimos el actor, a la lista de actores de la peli
					peli.insertarActor(nombre);
				}
				//Añadimos la pelicula a lista de peliculas del actor
				
				actor.insertarPeli(peli);
				linea = buffer.readLine();		
			}	
			buffer.close();
		}
		catch (IOException e) {
			System.err.println(e.getLocalizedMessage());
		}	
	}
		
	public ListaPeliculas obtenerPeliculasDeUnActor(String pActor) {
		Actor a = buscarActor(pActor);
		ListaPeliculas listaPelis = null;
		if(a != null)
		{
			listaPelis = a.obtenerPeliculasDeActor();
		}
		else
		{
			System.err.println("ESE ACTOR NO EXISTE");
		}
		return listaPelis;
	}
	
	public Actor buscarActor(String pNombre) 
	{
		return listaActores.buscarActor(pNombre);
	}
	
	
	public void insertarActor(String pActor)
	{
		listaActores.insertarActor(pActor);
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
			}
			//Lo eliminamos de la coleccion de actores
			listaActores.borrarActor(a);
		}
		else
		{
			System.err.println("ESE ACTOR NO EXISTE");
		}
		
		
	}
	
	public void ordenarActoresAlfabeticamente() {
		
	
	}

}
