package packModelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaPeliculas {
	
	private ArrayList<Pelicula> listaPeliculas;
	
	public ListaPeliculas() 
	{
		listaPeliculas = new ArrayList<Pelicula>();
	}
			
	public Pelicula buscarPelicula(String pTitulo) throws FileNotFoundException  
	{	
		Iterator<Pelicula> it = listaPeliculas.iterator();
		Boolean encontrado = false;
		Pelicula peli = null;
		while(it.hasNext() && !encontrado) 
		{
			peli = it.next();
			if(pTitulo == peli.getNombrePelicula())
			{
				encontrado = true;
			}
		}
		if(encontrado)
		{
			return peli;
		}
		else
		{
			return null;
		}
	}
			
	public void incrementarCantidad(float pCantidad, String pPeli) throws FileNotFoundException 
	{
		Pelicula peli = buscarPelicula(pPeli);
		peli.incrementarDinero(pCantidad);	
	}
	
	public void insertarPelicula(Pelicula pPeli) 
	{
		listaPeliculas.add(pPeli);
	}
	
	public void eliminarPelicula(Pelicula pPeli) 
	{
		listaPeliculas.remove(pPeli);
	}
	
	public Pelicula obtenerPelicula(int i)
	{
		return listaPeliculas.get(i);
	}
		
	
	public void imprimirPeliculas() 
	{
		for (int i = 0; i < listaPeliculas.size(); i++) 
		{
			System.out.println(listaPeliculas.get(i).getNombrePelicula());
		}
	}
	
	public int getSize()
	{
		return listaPeliculas.size();
	}
	
}
