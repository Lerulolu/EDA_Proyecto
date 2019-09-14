package packModelo;

import java.io.BufferedReader;
import java.io.FileReader;

public class cargarFicheros {
	
	private static cargarFicheros miCargarFicheros;
	
	private cargarFicheros() {
		
	}
	
	public static cargarFicheros getCargarFicheros() {
		
		if(miCargarFicheros == null) {
			miCargarFicheros = new cargarFicheros();
		}
		return miCargarFicheros;
		
	}
	
	public void cargarFichero() {
		
		try {
			
			BufferedReader bf = new BufferedReader(new FileReader("src/packDatos/FilmsActors20162017.txt"));
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	

}
