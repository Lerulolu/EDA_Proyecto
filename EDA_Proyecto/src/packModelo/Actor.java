package packModelo;

import java.util.Iterator;

public class Actor {
	
	private String nombre;
	private ListaPeliculas lPelis;
	
	public Actor(String pNombreActor) {
		nombre = pNombreActor;
		lPelis = new ListaPeliculas();
	}
		
	public String getNombreActor() {
		return nombre;
	}

	public void a�adirPeli(Pelicula pPeli) {
		lPelis.anadirPelicula(pPeli);
	}
	
	public void imprimirPelisActor() {
		lPelis.imprimirPeliculas();
		System.out.println(lPelis.getSize());
	}
		
	
}
