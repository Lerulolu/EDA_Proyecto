package packModelo;

import java.util.ArrayList;
import java.util.Iterator;


public class ListaActores {
	
	private ArrayList<Actor> listaActores;
	
	public ListaActores() 
	{
		listaActores = new ArrayList<Actor>();
	}
	
			
	public Actor buscarActor(String pNombre) 
	{	
		Iterator<Actor> it = listaActores.iterator();
		Actor actor = null;
		Boolean encontrado = false;
		while (it.hasNext() && !encontrado) 
		{
			actor = it.next();
			if(pNombre.equals(actor.getNombreActor()))
			{
				encontrado = true;
			}
		}
		if(encontrado)
		{
			System.out.println("ACTOR ENCONTRADO");
			return actor;
		}
		else
		{
			System.err.println("ACTOR NO ENCONTRADO");
			return null;
		}
	}
	
	public void borrarActor(String pActor) 
	{
		Actor a = buscarActor(pActor);
		
		if(a != null)
		{
			listaActores.remove(a);
		}
		else
		{
			System.out.println("ESE ACTOR NO EXISTE");
		}
	}
	
	public void insertarActor(String pActor) 
	{	
		Actor a = buscarActor(pActor);
		if(a == null)
		{
			a = new Actor(pActor);
			listaActores.add(a);
		}
		else
		{
			System.out.println("ESE ACTOR YA EXISTE");
		}
			
	}
	
	public void insertarActorSinBuscar(String pActor)
	{
		Actor a = new Actor(pActor);
		listaActores.add(a);
	}
	
	public Actor obtenerActorPorPosicion(int i)
	{
		return listaActores.get(i);
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
	
	public String obtenerNombreActor(int i) {
			
			String nombre = listaActores.get(i).getNombreActor();
			return nombre;
		}
	
	public int obtenerPosicionActor(String actor) {

		int i = 0;
		Boolean enc = false;
		while(i < listaActores.size() || !enc) {
			Actor act = listaActores.get(i);
			if(act.getNombreActor().equals(actor)) {
				enc = true;
			}
			else {
				i = i +1;
			}
		}
		return i;
		
	}

	public void cambiarNombre(String act1, String act2) {
		
		String aux;
		aux = act1;
		act1 = act2;
		act2 = aux;
	
	}
	
	
}
	

