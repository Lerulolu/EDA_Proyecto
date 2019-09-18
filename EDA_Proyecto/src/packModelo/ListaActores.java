package packModelo;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaActores {
	
	private ArrayList<Actor> listaActores;
	
	private ListaActores() {
		listaActores = new ArrayList<Actor>();
	}
	
	public ListaPeliculas obtenerPeliculasDeActor(Actor pActor) {
		
		return null;
		
	}
	
	public boolean buscarActor(String pActor) {
		
		boolean enc = false;
		Iterator<Actor> it = listaActores.iterator();
		while(listaActores != null && it.hasNext() && enc == false) {
			Actor actor = it.next();
			if(pActor == actor.getNombreActor()) {
				enc = true;
			}
		}
		return enc;
	}

}
