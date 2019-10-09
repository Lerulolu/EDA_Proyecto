package packModelo;

import java.io.FileNotFoundException;

public class ColeccionPeliculas {
	
	private static ColeccionPeliculas miColeccionPeliculas;
	private ListaPeliculas listaPeliculas;
	
	
	public static ColeccionPeliculas getMiColeccionPeliculas() {
		if (miColeccionPeliculas == null) {
			miColeccionPeliculas = new ColeccionPeliculas();
		}
		return miColeccionPeliculas;
	}
	
	private ColeccionPeliculas() {
		listaPeliculas = new ListaPeliculas();
	}
	
	public Boolean buscarPelicula(String pTitulo) throws FileNotFoundException {
		return listaPeliculas.buscarPelicula(pTitulo);
	}
	
	public void cargarPeliculas() throws FileNotFoundException {
		listaPeliculas.cargarPeliculas();
	}
	

}
