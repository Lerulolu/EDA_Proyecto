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
	
	public void imprimirActores() 
	{
		lActores.imprimirActores();
	}
	
	public void incrementarDinero (float pCantidad) 
	{
		this.dineroRecaudado = this.dineroRecaudado + pCantidad;
	}
	
	public void borrarActor(String pActor) 
	{
		lActores.borrarActor(pActor);
		
	}
	
	public ListaActores obtenerActoresDeUnaPelicula()
	{
		return lActores;
	}
	
	public void insertarActor(String pActor) 
	{
		
		lActores.insertarActor(pActor);
		
	}
	
	public void insertarActorSinBuscar(String pActor)
	{
		Actor a = new Actor(pActor);
		lActores.insertarActorSinBuscar(pActor);
	}
	
}
