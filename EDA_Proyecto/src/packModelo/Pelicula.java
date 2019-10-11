package packModelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Pelicula {
	
	private String titulo;
	private float dineroRecaudado;
	private ListaActores lActores;
	
	public Pelicula(String pNombrePeli, float pDineroRecaudado) 
	{
		titulo = pNombrePeli;
		dineroRecaudado = pDineroRecaudado;
		lActores = new ListaActores();
	}
	
	public String getNombrePelicula() {
		return titulo;
	}
	
	public float getDineroRecaudado()
	{
		return dineroRecaudado;
	}
	
	public void imprimirActores() {
		
		for (int i = 0; i < lActores.obtenerLongitudLista(); i++) 
		{
			System.out.println(lActores.toString());
		}
	}
	
	public void incrementarDinero (float pCantidad) 
	{
		this.dineroRecaudado = this.dineroRecaudado + pCantidad;
	}
	
	public void borrarActor(String pActor) 
	{
		Actor a = lActores.buscarActor(pActor);
		if(a != null)
		{
			lActores.borrarActor(a);
		}
		else
		{
			System.out.println("ESE ACTOR NO EXISTE");
		}
		
	}
	
	public ListaActores obtenerActoresDeUnaPelicula()
	{
		return lActores;
	}
	
	public void insertarActor(String pActor) 
	{
		
		lActores.insertarActor(pActor);
		
	}
	
}
