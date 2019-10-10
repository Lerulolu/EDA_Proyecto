package packModelo;

public class Actor {
	
	private String nombre;
	private ListaPeliculas lPelis;
	
	public Actor(String pNombreActor) 
	{
		nombre = pNombreActor;
		lPelis = new ListaPeliculas();
	}
		
	public String getNombreActor() 
	{
		return nombre;
	}

	public void insertarPeli(Pelicula pPeli) 
	{
		lPelis.insertarPelicula(pPeli);
	}
	
	public void imprimirPelisActor() 
	{
		lPelis.imprimirPeliculas();
		System.out.println(lPelis.getSize());
	}
	
	public ListaPeliculas obtenerPeliculasDeActor() 
	{
		//Para hacer las pruebas
		lPelis.imprimirPeliculas();
		
		return lPelis;
	}		
	
}
