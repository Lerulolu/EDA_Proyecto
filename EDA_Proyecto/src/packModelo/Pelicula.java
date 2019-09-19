package packModelo;

public class Pelicula {
	
	private String nombrePelicula;
	private ListaActores listaActores;
	
	private Pelicula(String pNombrePelicula) {
		pNombrePelicula = nombrePelicula;
		
	}

	public String getNombrePelicula() {
		return nombrePelicula;
	}
}
