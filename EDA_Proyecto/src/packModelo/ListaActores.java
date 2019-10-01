package packModelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;


public class ListaActores {
	
	private ArrayList<String> listaActores;
	private ListaPeliculas listaPeliculas;
	
	public ListaActores() {
		listaActores = new ArrayList<String>();
	}
	
	public void añadirActor(String nombre) {
		listaActores.add(nombre);
	}
	

	
	private Iterator<String> getIterador(){
		return listaActores.iterator();
	}
	
	public void imprimirLista(ListaActores pLista) {
		Iterator<String> it = pLista.getIterador();
		while (it.hasNext())
			System.out.println(it.next());
	}
	
	
	public String obtenerNombreActor(String pActor) {
		Iterator<String> it = listaActores.iterator();
		String actor = null;
		Boolean enc = false;
		while (it.hasNext() && !enc) {
			actor = it.next();
			if(actor == pActor) {
				enc = true;
			}
		}
		if(enc) {
			return pActor;
		}
		else {
			return null;
		}
	}
	
}
	

