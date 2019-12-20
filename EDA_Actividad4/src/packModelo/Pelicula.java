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
	
	public void borrarActor(String pActor, Integer pClave) 
	{
		lActores.borrarActor(pActor, pClave);
		
	}
	
	public ListaActores obtenerActoresDeUnaPelicula()
	{
		return lActores;
	}
	
	public Actor insertarActorPelicula(Actor pActor, Integer pClave) 
	{
	
		Actor a = lActores.insertarActor(pActor, pClave);
		return a;
	}
		
	public Integer getNumActores()
	{
		return lActores.obtenerLongitudLista();
	}
}
