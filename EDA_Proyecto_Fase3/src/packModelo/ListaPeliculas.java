package packModelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class ListaPeliculas {
	
	private HashMap<Integer,Pelicula> listaPeliculas;
	
	public ListaPeliculas() 
	{
		//listaPeliculas = new ArrayList<Pelicula>();
		listaPeliculas = new HashMap<Integer, Pelicula>();
	}
			
	public Entry<Integer,Pelicula> buscarPelicula(String pTitulo) throws FileNotFoundException  
	{	
		Iterator<Entry<Integer,Pelicula>> it = listaPeliculas.entrySet().iterator();
		Boolean enc = false;
		Entry<Integer,Pelicula> peli = null;
		while(it.hasNext() && !enc) 
		{
			peli = it.next();
			if(peli.getValue().getNombrePelicula().equalsIgnoreCase(pTitulo))
			{
				enc = true;
			}
		}
		if(enc)
		{
			return peli;
		}
		else
		{
			return null;
		}
	}
			
	public boolean incrementarCantidad(float pCantidad, String pPeli) throws FileNotFoundException 
	{
		Entry<Integer,Pelicula> peli = buscarPelicula(pPeli);
		if(peli == null)
		{
			System.out.println("ESA PELICULA NO EXISTE");
			return false;
		}
		else
		{
			peli.getValue().incrementarDinero(pCantidad);	
			return true;
		}
	}
	
	public Pelicula insertarPelicula(Pelicula pPeli, Integer pClave) throws FileNotFoundException 
	{
		Entry<Integer,Pelicula> peli = buscarPelicula(pPeli.getNombrePelicula());
		Pelicula p = null;
		if(peli == null)
		{
			p = new Pelicula(pPeli.getNombrePelicula(), pPeli.getDineroRecaudado());
			listaPeliculas.put(pClave, p);
			return p;
		}
		else
		{
			return peli.getValue();
		}
		
	}
	
	public Pelicula eliminarPelicula(String pPeli) throws FileNotFoundException 
	{
		Entry<Integer,Pelicula> p = buscarPelicula(pPeli);
		if(p != null)
		{
			listaPeliculas.remove(p.getKey());
			return p.getValue();
		}
		else
		{
			System.out.println("ESA PELICULA NO EXISTE");
			return null;
		}
	}
		
	
	public void imprimirPeliculas() 
	{
		Iterator<Entry<Integer,Pelicula>> it = listaPeliculas.entrySet().iterator();
		Entry<Integer,Pelicula> p = null;
		while(it.hasNext())
		{
			p = it.next();
			System.out.println(p.getValue().getNombrePelicula());
		}
	}
	
	public int getSize()
	{
		return listaPeliculas.size();
	}
	
	public void generarLista() throws IOException {
			
			FileWriter flwriter = null;
			
			try {
				
				//crea el flujo para escribir en el archivo
				flwriter = new FileWriter("src/packDatos/ListaActualizada.txt");
				//crea un buffer o flujo intermedio antes de escribir directamente en el archivo
				if(flwriter.equals(null)) {
					System.out.println("NO EXISTE");
				}
				else {
					BufferedWriter bfwriter = new BufferedWriter(flwriter);
					
					Iterator<Entry<Integer,Pelicula>> it = listaPeliculas.entrySet().iterator();
					Entry<Integer,Pelicula> p = null;
					
					while(it.hasNext())
					{
						p = it.next();
						ListaActores lA = obtenerActoresDeUnaPeli(p.getValue().getNombrePelicula());
						bfwriter.write(p.getValue().getNombrePelicula()+" ---> ");
						for(int j = 0; j < lA.obtenerLongitudLista(); j++) {
							String nombreActor = lA.obtenerNombreActor(j);
							bfwriter.write(nombreActor);
							if(j != lA.obtenerLongitudLista()-1) {
								bfwriter.write(" &&& ");
							}
						}
						bfwriter.newLine();
					}
					//cierra el buffer intermedio
					bfwriter.close();
					System.out.println("Archivo creado satisfactoriamente..");
				}	
				
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	
	public ListaActores obtenerActoresDeUnaPeli(String pPeli) throws FileNotFoundException
	{
		Entry<Integer,Pelicula> p = buscarPelicula(pPeli);
		ListaActores listaActores = null;
		if(p.getValue() != null)
		{
			listaActores = p.getValue().obtenerActoresDeUnaPelicula();
			p.getValue().imprimirActores();
		}
		else
		{
			System.err.println("ESA PELÍCULA NO EXISTE");
		}
		
		return listaActores;
	}
	
	public void incrementarDineroRecaudado(String pPeli, float pCantidad) throws FileNotFoundException
	{
		Entry<Integer,Pelicula> p = buscarPelicula(pPeli);
		if(p.getValue() != null)
		{
			p.getValue().incrementarDinero(pCantidad);
		}
		else
		{
			System.err.println("ESA PELÍCULA NO EXISTE");
		}
	}
	
	public void eliminarActorPeli(Actor a, Integer pClave)
	{
		Iterator<Entry<Integer,Pelicula>> it = listaPeliculas.entrySet().iterator();
		Entry<Integer,Pelicula> p = null;
		while(it.hasNext())
		{
			p = it.next();
			//Borramos el actor de la lista de actores de la peli
			p.getValue().borrarActor(a.getNombreActor(), pClave);
		}
		
	}
	
	public String obtenerNombrePeli(int i) 
	{
		String nombre = listaPeliculas.get(i).getNombrePelicula();
		return nombre;
	}

}
