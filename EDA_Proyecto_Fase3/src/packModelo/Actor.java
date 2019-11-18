package packModelo;

import java.io.FileNotFoundException;

public class Actor {
	
	private String nombre;
	private ListaPeliculas lPelis;
	
	public Actor(String pNombreActor) 
	{
		nombre = pNombreActor;
		lPelis = new ListaPeliculas();
	}
		
	public String getNombreActor() 
	{
		return nombre;
	}

	public Pelicula insertarPeli(String pPeli, Integer pClave) throws FileNotFoundException 
	{
		Pelicula p = new Pelicula(pPeli,0);
		Pelicula res = lPelis.insertarPelicula(p, pClave);
		return res;
		
	}
	
	public void eliminarPeli(String pPeli) throws FileNotFoundException 
	{
		lPelis.eliminarPelicula(pPeli);
	}
	
	public void imprimirPelisActor() 
	{
		lPelis.imprimirPeliculas();
	}
	
	public ListaPeliculas obtenerPeliculasDeActor() 
	{
		//Para hacer las pruebas
		lPelis.imprimirPeliculas();
		return lPelis;
	}		
	
}
