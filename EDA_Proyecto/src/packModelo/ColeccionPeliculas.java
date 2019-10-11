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
	
	public Pelicula buscarPelicula(String pTitulo) throws FileNotFoundException 
	{
		return listaPeliculas.buscarPelicula(pTitulo);
	}
	
	public Pelicula obtenerPeliculaPorPosicion(int i)
	{
		return listaPeliculas.obtenerPelicula(i);
	}
	public void insertarPelicula(String pPeli, float pDineroRecaudado) throws FileNotFoundException
	{
		Pelicula p = listaPeliculas.buscarPelicula(pPeli);
		if(p == null)
		{
			listaPeliculas.insertarPelicula(pPeli,pDineroRecaudado);
		}
		else
		{
			System.err.println("ESA PELÍCULA YA EXISTE");
		}
	}
	
	public void insertarPeliculaSinBuscar(String pPeli, float pDineroRecaudado) throws FileNotFoundException
	{
		Pelicula p = new Pelicula(pPeli, pDineroRecaudado);
		listaPeliculas.insertarPeliSinBuscar(p);
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
	
public void generarLista() {
		
		FileWriter flwriter = null;
		
		try {
			
			//crea el flujo para escribir en el archivo
			flwriter = new FileWriter("src/packDatos/ListaActualizada.txt");
			//crea un buffer o flujo intermedio antes de escribir directamente en el archivo
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			for(int i = 0; i < listaPeliculas.getSize(); i++) {
				//escribe los datos en el archivo
				Pelicula peli = listaPeliculas.obtenerPelicula(i);
				ListaActores lA = obtenerActoresDeUnaPeli(peli.getNombrePelicula());
				
				bfwriter.write(peli.getNombrePelicula()+" ---> ");
				for(int j = 0; j < lA.obtenerLongitudLista(); j++) {
					String nombreActor = lA.obtenerNombreActor(j);
					bfwriter.write(nombreActor);
				}
				bfwriter.newLine();
			}
			//cierra el buffer intermedio
			bfwriter.close();
			System.out.println("Archivo creado satisfactoriamente..");
 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
