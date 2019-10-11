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
			if(pTitulo.equals(peli.getNombrePelicula()))
			{
				encontrado = true;
			}
		}
		if(encontrado)
		{
			System.out.println("Pelicula Encontrada");
			return peli;
		}
		else
		{
			System.out.println("Pelicula NO Encontrada");
			return null;
		}
	}
			
	public void incrementarCantidad(float pCantidad, String pPeli) throws FileNotFoundException 
	{
		Pelicula peli = buscarPelicula(pPeli);
		if(peli == null)
		{
			System.out.println("ESA PELI NO EXISTE");
		}
		else
		{
			peli.incrementarDinero(pCantidad);	
		}
	}
	
	public void insertarPelicula(String pPeli, float pDineroRecaudado) throws FileNotFoundException 
	{
		Pelicula peli = buscarPelicula(pPeli);
		if(peli == null)
		{
			peli = new Pelicula(pPeli, pDineroRecaudado);
			listaPeliculas.add(peli);
		}
		else
		{
			System.out.println("ESA PELICULA YA EXISTE");
		}
	}
	
	public void insertarPeliSinBuscar(Pelicula pPeli)
	{
		listaPeliculas.add(pPeli);
	}
	
	public void eliminarPelicula(String pPeli) throws FileNotFoundException 
	{
		Pelicula p = buscarPelicula(pPeli);
		if(p != null)
		{
			listaPeliculas.remove(p);

		}
		else
		{
			System.out.println("ESA PELICULA NO EXISTE");
		}
	}
	
	public Pelicula obtenerPelicula(int i)
	{
		if(i > listaPeliculas.size()-1)
		{
			System.out.println("ESE NÚMERO DE ELEMENTO NO EXISTE");
			return null;
		}
		else
		{
			return listaPeliculas.get(i);
		}
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
