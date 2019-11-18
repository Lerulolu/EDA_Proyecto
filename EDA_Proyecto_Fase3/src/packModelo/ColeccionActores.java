package packModelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

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
			int j = 0;
			Actor a = null;
			while(linea != null) {
				String[] linea2 = linea.split(" ---> ");
				//Añadimos la peli a la Coleccion de Peliculas
				Pelicula p = ColeccionPeliculas.getMiColeccionPeliculas().insertarPelicula(linea2[0],0, j);
				String[] listaA = linea2[1].split(" &&& ");
				System.out.println(j);
				for (int i = 0; i < listaA.length; i++) {
					String nombre = listaA[i];
					//Insertamos el actor en el catalogo completo de actores
					a = listaActores.insertarActor(nombre,listaActores.obtenerLongitudLista()-1);
					//Añadimos el actor, a la lista de actores de la peli
					p.insertarActor(a.getNombreActor(),i);				
				}	
				//Añadimos la pelicula a lista de peliculas del actor una única vez
				a.insertarPeli(p.getNombrePelicula(),j);
				j++;
				linea = buffer.readLine();				
			}	
			buffer.close();
		}
		catch (IOException e) {
			System.err.println(e.getLocalizedMessage());
		}	
	}
		
	public ListaPeliculas obtenerPeliculasDeUnActor(String pActor) {
		Entry<Integer,Actor> a = buscarActor(pActor);
		ListaPeliculas listaPelis = null;
		if(a != null)
		{
			listaPelis = a.getValue().obtenerPeliculasDeActor();
		}
		else
		{
			System.err.println("ESE ACTOR NO EXISTE");
		}
		return listaPelis;
	}
	
	public Entry<Integer,Actor> buscarActor(String pNombre) 
	{
		return listaActores.buscarActor(pNombre);
	}
	
	
	public Actor insertarActor(String pActor, Integer num)
	{
		return listaActores.insertarActor(pActor, num);
	}
	
	public void eliminarActorColeccion(String pActor, Integer pClave)
	{
		Entry<Integer,Actor> a = listaActores.buscarActor(pActor);
		if(a != null)
		{
			//Hay que borrarlo de las pelis en las que aparece --> Obtenemos la lista de peliculas de ese actor
			ListaPeliculas pelisActor = a.getValue().obtenerPeliculasDeActor();
			//Para cada peli de esa lista, borrar el actor
			pelisActor.eliminarActorPeli(a.getValue(), pClave);
			//Lo eliminamos de la coleccion de actores
			this.listaActores.borrarActor(a.getValue().getNombreActor(),a.getKey());
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
	
	

	public void ordenarActoresAlfabeticamente() 
	{	
		listaActores.ordenarListaActores();
	}

}
