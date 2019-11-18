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
	
			
	public Entry<Integer,Actor> buscarActor(String pNombre) 
	{	
		Iterator<Entry<Integer,Actor>> it = listaActores.entrySet().iterator();
		Entry<Integer,Actor> actor = null;
		boolean enc = false;
		while (it.hasNext() && !enc) 
		{
			actor = it.next();
			if(actor.getValue().getNombreActor().equalsIgnoreCase(pNombre))
			{
				enc = true;
			}
		}
		if(enc)
		{
			return actor;
		}
		else
		{
			return null;
		}
	}
	
	public void borrarActor(String pNombre, Integer pClave) 
	{
		Entry<Integer,Actor> a = buscarActor(pNombre);
		if(a != null)
		{
			listaActores.remove(pClave);
		}
		else
		{
			System.out.println("ESE ACTOR NO EXISTE");
		}
	}
	
	public Actor insertarActor(String pActor, Integer pClave) 
	{	
		Entry<Integer,Actor> a = buscarActor(pActor);
		Actor actor = null;
		if(a == null)
		{
			actor = new Actor(pActor);
			listaActores.put(pClave, actor);
			return actor;
		}
		else
		{
			return a.getValue();
		}
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