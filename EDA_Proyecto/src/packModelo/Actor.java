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

	public void insertarPeli(Pelicula pPeli) throws FileNotFoundException 
	{
		Pelicula p = lPelis.buscarPelicula(pPeli.getNombrePelicula());
		if(p == null)
		{
			lPelis.insertarPelicula(pPeli.getNombrePelicula(),pPeli.getDineroRecaudado());
		}
		else
		{
			System.out.println("ESA PELICULA YA EXISTE");
		}
	}
	
	public void insertarPeliSinBuscar(Pelicula pPeli)
	{
		lPelis.insertarPeliSinBuscar(pPeli);
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
