package packModelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaPeliculas {
	
	private UnorderedDoubleLinkedList<Pelicula> listaPeliculas;
	
	public ListaPeliculas() 
	{
		//listaPeliculas = new ArrayList<Pelicula>();
		listaPeliculas = new UnorderedDoubleLinkedList<Pelicula>();
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
			System.out.println("SE HA ENCONTRADO LA PELICULA: " + peli.getNombrePelicula());
			return peli;
		}
		else
		{
			System.err.println("NO SE HA ENCONTRADO LA PELICULA");
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
			listaPeliculas.addToRear(peli);
		}
		else
		{
			System.out.println("ESA PELICULA YA EXISTE");
		}
	}
	
	public void insertarPeliSinBuscar(Pelicula pPeli)
	{
		listaPeliculas.addToRear(pPeli);
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
		
	
	public void imprimirPeliculas() 
	{
		Iterator<Pelicula> it = listaPeliculas.iterator();
		Pelicula p = null;
		while(it.hasNext())
		{
			p = it.next();
			System.out.println(p.getNombrePelicula());
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
					
					Iterator<Pelicula> it = listaPeliculas.iterator();
					Pelicula p = null;
					
					while(it.hasNext())
					{
						p = it.next();
						ListaActores lA = obtenerActoresDeUnaPeli(p.getNombrePelicula());
						bfwriter.write(p.getNombrePelicula()+" ---> ");
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
		Pelicula p = buscarPelicula(pPeli);
		ListaActores listaActores = null;
		if(p != null)
		{
			listaActores = p.obtenerActoresDeUnaPelicula();
			p.imprimirActores();
		}
		else
		{
			System.err.println("ESA PELÍCULA NO EXISTE");
		}
		
		return listaActores;
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
	
	public void eliminarActorPeli(Actor a)
	{
		Iterator<Pelicula> it = listaPeliculas.iterator();
		Pelicula p = null;
		while(it.hasNext())
		{
			p = it.next();
			//Borramos el actor de la lista de actores de la peli
			p.borrarActor(a.getNombreActor());
		}
		
	}

}
