package packModelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;


public class ListaActores {
	
	private ArrayList<Actor> listaActores;
	
	public ListaActores() {
		listaActores = new ArrayList<Actor>();
	}
		
	public ListaPeliculas obtenerPelisActor(Actor pActor) {
		
		return null;
		
	}
	
	public Actor buscarActor(String pNombre, String pApellido) {
		
		Iterator<Actor> it = listaActores.iterator();
		Actor actor = null;
		Boolean encontrado = false;
		while (it.hasNext() && !encontrado) {
			actor = it.next();
			if(pNombre.equals(actor.getNombreActor()) && pApellido.equals(actor.getApellidoActor())) {
				encontrado = true;
			}
		}
		if(encontrado) {
			return actor;
		}
		else {
			return null;
		}
		
	}
	
	public void borrarActor(Actor pActor) {
		listaActores.remove(pActor);
	}
	
	public void anadirActor(Actor pActor) {
		listaActores.add(pActor);
	}
	
	public void ordenarLista() {
		
	}
	
	public int obtenerLongitudLista() {
		return listaActores.size();
	}
	
	public void cargarActores() {

		try {
			
			FileReader fichero = new FileReader(new File("src/packDatos/FilmsActors20162017.txt"));
			BufferedReader buffer = new BufferedReader(fichero);
			String linea = buffer.readLine();
			System.out.println("CARGANDO LOS ACTORES");
			while(!linea.isEmpty()) {
				
				//OBTENEMOS LA LISTA DE ACTORES
				String[] linea2 = linea.split("--->");
				String listaAct = linea2[1];
				String[] actor = listaAct.split("&&&");
				for (int i = 0; i<listaAct.length(); i++) {
					//SEPARAMOS ACTORES EN NOMBRE Y APELLIDO
					String[] separador = actor[i].split(",");
					String apellido = separador[0];
					String nombre = separador[1];
					System.out.println("ACTOR"+actor[i]);
					System.out.println("NOMBRE"+nombre);
					System.out.println("APELLIDO"+apellido);
					Actor act = new Actor(nombre, apellido);
					listaActores.add(act);
					for(int j = 0; j < listaActores.size(); j++) {
						System.out.println(listaActores.get(j).getNombreActor()+""+listaActores.get(j).getApellidoActor());
					}
					
				}
				linea = buffer.readLine();
				
				
			}
			buffer.close();
			
		}catch (Exception e) {
			System.err.println("PROBLEM!");
		}
	}
	
	private Iterator<Actor> getIterador(){
		return listaActores.iterator();
	}

	
	
}
	

