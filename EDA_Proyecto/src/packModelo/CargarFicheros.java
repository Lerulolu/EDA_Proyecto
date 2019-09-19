package packModelo;

import java.io.BufferedReader;
import java.io.FileReader;

public class CargarFicheros {
	
	private static CargarFicheros miCargarFicheros;
	
	private CargarFicheros() {
		
	}
	
	public static CargarFicheros getCargarFicheros() {
		
		if(miCargarFicheros == null) {
			miCargarFicheros = new CargarFicheros();
		}
		return miCargarFicheros;
		
	}
	
	public void cargarFichero() {
		
		//1.CARG
		try {
			
			BufferedReader bf = new BufferedReader(new FileReader("src/packDatos/FilmsActors20162017.txt"));
			String line = "";
			line = bf.readLine();
			while (line != null) {
				System.out.println(line);
				if(line.trim().length() == 0)
					continue;
				line = bf.readLine();
			}
			bf.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	

}
