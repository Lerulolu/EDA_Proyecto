package packModelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ColeccionPeliculas {
	
	private static ColeccionPeliculas miColeccionPeliculas;
	private ListaPeliculas listaPeliculas;
	
	
	public static ColeccionPeliculas getMiColeccionPeliculas() 
	{
		if (miColeccionPeliculas == null) 
		{
			miColeccionPeliculas = new ColeccionPeliculas();
		}
		return miColeccionPeliculas;
	}
	
	private ColeccionPeliculas() 
	{
		listaPeliculas = new ListaPeliculas();
	}
		
	public ListaActores obtenerActoresDeUnaPeli(String pPeli) throws FileNotFoundException
	{
		return listaPeliculas.obtenerActoresDeUnaPeli(pPeli);
	}
	
	public Pelicula buscarPelicula(String pTitulo) throws FileNotFoundException 
	{
		return listaPeliculas.buscarPelicula(pTitulo);
	}
	
	public void insertarPelicula(String pPeli, float pDineroRecaudado) throws FileNotFoundException
	{
		listaPeliculas.insertarPelicula(pPeli, pDineroRecaudado);
	}
	
	public Pelicula insertarPeliculaSinBuscar(String pPeli, float pDineroRecaudado) throws FileNotFoundException
	{
		Pelicula p = new Pelicula(pPeli, pDineroRecaudado);
		listaPeliculas.insertarPeliSinBuscar(p);
		return p;
	}
	
	public void incrementarDineroRecaudado(String pPeli, float pCantidad) throws FileNotFoundException
	{
		listaPeliculas.incrementarCantidad(pCantidad, pPeli);
	}
	

	public void generarLista() throws IOException 
	{
		listaPeliculas.generarLista();
	}

	public int getSize()
	{
		return listaPeliculas.getSize();
	}
}
