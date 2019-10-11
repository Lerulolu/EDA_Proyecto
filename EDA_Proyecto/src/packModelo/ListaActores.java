package packModelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class ListaActores {
	
	private ArrayList<Actor> listaActores;
	
	public ListaActores() 
	{
		listaActores = new ArrayList<Actor>();
	}
	
			
	public Actor buscarActor(String pNombre) 
	{	
		Iterator<Actor> it = listaActores.iterator();
		Actor actor = null;
		Boolean encontrado = false;
		while (it.hasNext() && !encontrado) 
		{
			actor = it.next();
			if(pNombre.equals(actor.getNombreActor()))
			{
				encontrado = true;
			}
		}
		if(encontrado)
		{
			System.out.println("ACTOR ENCONTRADO");
			return actor;
		}
		else
		{
			System.err.println("ACTOR NO ENCONTRADO");
			return null;
		}
	}
	
	public void borrarActor(String pActor) 
	{
		Actor a = buscarActor(pActor);
		
		if(a != null)
		{
			listaActores.remove(a);
		}
		else
		{
			System.out.println("ESE ACTOR NO EXISTE");
		}
	}
	
	public void insertarActor(String pActor) 
	{	
		Actor a = buscarActor(pActor);
		if(a == null)
		{
			a = new Actor(pActor);
			listaActores.add(a);
		}
		else
		{
			System.out.println("ESE ACTOR YA EXISTE");
		}
			
	}
	
	public void insertarActorSinBuscar(String pActor)
	{
		Actor a = new Actor(pActor);
		listaActores.add(a);
	}
		
	public void ordenarLista() 
	{
		
	}
	
	public int obtenerLongitudLista() 
	{
		return listaActores.size();
	}
	
	public String obtenerNombreActor(int i) {
			
			String nombre = nombre = listaActores.get(i).getNombreActor();
			return nombre;
		}
	
	/*public void cargarActoresComas() {
		
		try {
			
			FileReader fichero = new FileReader(new File("src/packDatos/FilmsActors20162017.txt"));
			BufferedReader buffer = new BufferedReader(fichero);
			String linea = buffer.readLine();
			while(linea != null) {
				String[] linea2 = linea.split(" ---> ");
				String[] listaA = linea2[1].split(" &&& ");
				int cont = 0;
				for( int i = 0; i < listaA.length; i++) {
					String[] separar = listaA[i].split(", ");
					String nombre = separar[1];
					String apellido = separar[0];
					System.out.println("LINEA"+cont);
					System.out.println("LISTA A "+listaA[i].toString());
					System.out.println("NOMBRE "+nombre+"APELLIDO "+apellido);
					cont++;
				}
				
				//separarListaDeActores(listaA);
				linea = buffer.readLine();		
			}	
			buffer.close();	
		}
		catch (IOException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}*/

	
		

	private Iterator<Actor> getIterador()
	{
		return listaActores.iterator();
	}

	
	
}
	

