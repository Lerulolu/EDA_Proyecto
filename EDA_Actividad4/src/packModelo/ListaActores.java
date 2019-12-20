package packModelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;


public class ListaActores {
	
	private HashMap<Integer,Actor> listaActores;
	
	public ListaActores() 
	{
		listaActores = new HashMap<Integer,Actor>();
	}
	
			
	public Actor buscarActor(String pNombre) 
	{	
		Iterator<Entry<Integer,Actor>> it = listaActores.entrySet().iterator();
		Boolean enc = false;
		Entry<Integer,Actor> actor = null;
		while(it.hasNext() && !enc) 
		{
			actor = it.next();
			if(pNombre.equalsIgnoreCase(actor.getValue().getNombreActor()))
			{
				enc = true;
			}
		}
		if(enc)
		{
			return actor.getValue();
		}
		else
		{
			return null;
		}
	}
	
	public void borrarActor(String pNombre, Integer pClave) 
	{
		Actor a = buscarActor(pNombre);
		if(a != null)
		{
			listaActores.remove(pClave);
		}
		else
		{
			System.out.println("ESE ACTOR NO EXISTE");
		}
	}
	
	
	public Actor insertarActor(Actor pActor, Integer pClave) 
	{	
		Actor a = buscarActor(pActor.getNombreActor());
		Actor actor = null;
		if(a == null)
		{
			actor = new Actor(pActor.getNombreActor());
			this.listaActores.put(pClave, actor);
			return actor;
		}
		else
		{
			//Devolvemos el actor que ya existia en la lista
			//System.out.println("YA EXISTE ESE ACTOR");
			return a;
		}
	}
	
	public void eliminarActorColeccion(String pActor, Integer pClave)
	{
		Actor a = this.buscarActor(pActor);
		if(a != null)
		{
			//Hay que borrarlo de las pelis en las que aparece --> Obtenemos la lista de peliculas de ese actor
			ListaPeliculas pelisActor = a.obtenerPeliculasDeActor();
			//Para cada peli de esa lista, borrar el actor
			pelisActor.eliminarActorPeli(a, pClave);
			//Lo eliminamos de la coleccion de actores
			this.borrarActor(a.getNombreActor(), pClave);
		}
		else
		{
			System.err.println("ESE ACTOR NO EXISTE");
		}
	}
	
	public ListaPeliculas obtenerPeliculasDeUnActor(String pActor) 
	{
		Actor a = buscarActor(pActor);
		ListaPeliculas listaPelis = null;
		if(a.getNombreActor().equalsIgnoreCase(pActor))
		{
			listaPelis = a.obtenerPeliculasDeActor();
		}
		else
		{
			System.err.println("ESE ACTOR NO EXISTE");
		}
		return listaPelis;
	}
				
	public int obtenerLongitudLista() 
	{
		return listaActores.size();
	}
	
	public void imprimirActores()
	{
		for(int i = 0; i < listaActores.size(); i++)
		{
			System.out.println(listaActores.get(i).getNombreActor());
		}
	}
	
	public String obtenerNombreActor(int i) 
	{
		String nombre = listaActores.get(i).getNombreActor();
		return nombre;
	}
	
	public Actor obtenerActor(int i) 
	{
		Actor a = listaActores.get(i);
		return a;
	}
	
	public void cambiarNombre(String act1, String act2) 
	{
		String aux;
		aux = act1;
		act1 = act2;
		act2 = aux;
	}
	
	public void ordenarListaActores() {
		
		Iterator<Entry<Integer,Actor>> it = listaActores.entrySet().iterator();
		
		if(listaActores == null){
			System.out.println("no hay webs que ordenar");
		}else{
			ArrayList<String> listaAct = new ArrayList<String>();
			while (it.hasNext()) {
				Entry<Integer,Actor> act = it.next();
				listaAct.add(act.getValue().getNombreActor());
			}
		Collections.sort(listaAct);
		listaAct.stream().forEach(unaUrl -> System.out.println(unaUrl));
		}
	}
		
	
}