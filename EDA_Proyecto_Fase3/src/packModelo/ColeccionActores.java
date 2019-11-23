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
	
	public ListaActores getListaActores()
	{
		return 	listaActores;
	}

	public void cargarDatos() {
		
		try {
			FileReader fichero = new FileReader(new File("src/packDatos/ficheroPruebas.txt"));
			BufferedReader buffer = new BufferedReader(fichero);
			String linea = buffer.readLine();
			Actor a = null;
			while(linea != null) {		
				String[] linea2 = linea.split(" ---> ");
				//Para pruebas
				System.out.println(ColeccionPeliculas.getMiColeccionPeliculas().getSize());
				
				//Añadimos la peli a la Coleccion de Peliculas
				Pelicula p = ColeccionPeliculas.getMiColeccionPeliculas().insertarPeliculaColeccion(linea2[0], 0, ColeccionPeliculas.getMiColeccionPeliculas().getSize());
				String[] listaA = linea2[1].split(" &&& ");
				
				for (int i = 0; i < listaA.length; i++) 
				{
					String nombre = listaA[i];
					//Insertamos el actor en el catalogo completo de actores
					a = this.insertarActorColeccion(nombre,this.getSize());
					//Añadimos la pelicula a lista de peliculas del actor
					a.insertarPeliActor(p,a.getNumPelis());
					//Añadimos el actor, a la lista de actores de la peli
					p.insertarActorPelicula(a,p.getNumActores());
				}	
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
	
	
	public Actor insertarActorColeccion(String pActor, Integer pClave)
	{
		Actor a = new Actor(pActor);
		return listaActores.insertarActor(a, pClave);
	}
	
	public void eliminarActorColeccion(String pActor, Integer pClave)
	{
		this.listaActores.eliminarActorColeccion(pActor, pClave);
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
	
	public int getSize()
	{
		return listaActores.obtenerLongitudLista();
	}
	
}
