package packModelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;

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
	
	public Entry<Integer,Pelicula> buscarPelicula(String pTitulo) throws FileNotFoundException 
	{
		return listaPeliculas.buscarPelicula(pTitulo);
	}
	
	public Pelicula insertarPelicula(String pPeli, float pDineroRecaudado, Integer pClave) throws FileNotFoundException
	{
		Pelicula p = new Pelicula(pPeli, pDineroRecaudado);
		listaPeliculas.insertarPelicula(p, pClave);
		return p;
	}
	
	public Pelicula borrarPelicula(String pPeli) throws FileNotFoundException
	{
		Pelicula p = listaPeliculas.eliminarPelicula(pPeli);
		return p;
	}
	
	public boolean incrementarDineroRecaudado(String pPeli, float pCantidad) throws FileNotFoundException
	{
		return listaPeliculas.incrementarCantidad(pCantidad, pPeli);
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
