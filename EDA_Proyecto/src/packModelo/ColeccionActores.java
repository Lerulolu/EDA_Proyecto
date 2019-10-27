package packModelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Particle;

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
				Pelicula p = ColeccionPeliculas.getMiColeccionPeliculas().insertarPeliculaSinBuscar(linea2[0].toString(),0);
				String[] listaA = linea2[1].split(" &&& ");
				for (int i = 0; i < listaA.length; i++) {
					String nombre = listaA[i].toString();
					//Insertamos el actor en el catalogo completo de actores
					listaActores.insertarActorSinBuscar(nombre);
					//Añadimos el actor, a la lista de actores de la peli
					actor = listaActores.obtenerActorPorPosicion(i);
					p.insertarActorSinBuscar(actor.getNombreActor());
				}	
				//Añadimos la pelicula a lista de peliculas del actor
				actor.insertarPeliSinBuscar(p);
				
				linea = buffer.readLine();				
			}	
			buffer.close();
		}
		catch (IOException e) {
			System.err.println(e.getLocalizedMessage());
		}	
	}
	
	public int obtenerPosicionDeUnActorEnLista(String pActor) {
		return listaActores.obtenerPosicionActor(pActor);
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
			pelisActor.eliminarActorPeli(a);
			//Lo eliminamos de la coleccion de actores
			listaActores.borrarActor(a.getNombreActor());
		}
		else
		{
			System.err.println("ESE ACTOR NO EXISTE");
		}
	}
	
	public void imprimirActores()
	{
		
		System.out.println("EMPIEZA");
		for (int i = 0; i < listaActores.obtenerLongitudLista(); i++)
		{
			System.out.println(listaActores.obtenerNombreActor(i));
		}
		System.out.println("ACABADO!");
	}
	
	

	public void ordenarActoresAlfabeticamente() {
		
		listaActores.ordenarListaActores();
		/*for (int i = 0; i < listaActores.obtenerLongitudLista(); i++) {
			System.out.println("VUELTA"+i);
			for (int j = 0; j < listaActores.obtenerLongitudLista(); j++) {
			
				if(listaActores.obtenerNombreActor(i).4mpareTo(listaActores.obtenerNombreActor(i+1)) > 0) {
					String actor1 = listaActores.obtenerNombreActor(i);
					String actor2 = listaActores.obtenerNombreActor(i+1);
					listaActores.cambiarNombre(actor1, actor2);
					
				}
			}
		}*/
	}

}
