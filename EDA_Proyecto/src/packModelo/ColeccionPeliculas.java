package packModelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ColeccionPeliculas {
	
	private static ColeccionPeliculas miColeccionPeliculas;
	private ListaPeliculas listaPeliculas;
	
	
	public static ColeccionPeliculas getMiColeccionPeliculas() {
		if (miColeccionPeliculas == null) {
			miColeccionPeliculas = new ColeccionPeliculas();
		}
		return miColeccionPeliculas;
	}
	
	private ColeccionPeliculas() {
		listaPeliculas = new ListaPeliculas();
	}
		
	public ListaActores obtenerActoresDeUnaPeli(String pPeli) throws FileNotFoundException
	{
		Pelicula p = buscarPelicula(pPeli);
		ListaActores listaActores = null;
		if(p != null)
		{
			listaActores = p.obtenerActoresDeUnaPelicula();
		}
		else
		{
			System.err.println("ESA PELÍCULA NO EXISTE");
		}
		return listaActores;
	}
	
	public Pelicula buscarPelicula(String pTitulo) throws FileNotFoundException {
		return listaPeliculas.buscarPelicula(pTitulo);
	}
	
	public void añadirPelicula(Pelicula pPeli)
	{
		listaPeliculas.anadirPelicula(pPeli);
	}
	
	public void incrementarDineroRecaudado(String pPeli, float pCantidad) throws FileNotFoundException
	{
		Pelicula p = buscarPelicula(pPeli);
		if(p != null)
		{
			p.incrementarDinero(pCantidad);
		}
		else
		{
			System.err.println("ESA PELÍCULA NO EXISTE");
		}
	}

}
