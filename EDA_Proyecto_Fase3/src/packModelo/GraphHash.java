package packModelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

import java.util.Queue;

public class GraphHash {

	HashMap<String, ArrayList<String>> g;
	String[] keys;
	ArrayList<String>[] adjList;
	int cont = 0;
	String actor = null;
	Actor a = null;
	ListaPeliculas pelisActor = null;

	public void crearGrafo(ListaActores lActores) {
		// Post: crea el grafo desde la lista de actores
		// Los nodos son nombres de actores y títulos de películas

		// Paso 1: llenar el hashmap
		// COMPLETAR CODIGO
		g = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < lActores.obtenerLongitudLista(); i++)
		{
			actor = lActores.obtenerNombreActor(i);
			if(!g.containsKey(actor))
			{
				a = lActores.obtenerActor(i);
				pelisActor = a.obtenerPeliculasDeActor();
				ArrayList<String> l = new ArrayList<String>();
				for(int j = 0; j < pelisActor.getSize(); j++)
				{
					String p = pelisActor.obtenerNombrePeli(j);
					l.add(p);
				}
				g.put(actor, l);
				cont++;
			}
		}
		
		//Paso 2: Llenar keys
		int i = 0;
		keys = new String[cont];
		for(String s : g.keySet())
		{
			keys[i] = s;
			i++;
		}

		//Paso 3: Llenar adjList
		adjList = new ArrayList[cont];
		for(int j = 0; j < adjList.length; j++)
		{
			adjList[j] = new ArrayList<String>();
		}
		String iA; //Indice de los actores
		String iP; //Indice de las pelis
		for(int k = 0; k < lActores.obtenerLongitudLista(); k++)
		{
			iA = a.getNombreActor();
			for(int l = 0; l < a.obtenerPeliculasDeActor().getSize(); l++)
			{
				iP = g.get(l).get(l);
				adjList[k].add(iP);
				adjList[l].add(iA);
			}
			
		}
	}

	public void print() {
		int i = 1;
		for (String s: g.keySet()) {
			System.out.print("Element: " + i ++ +" " + s + " --> ");
			for (String k : g.get(s))
			{
				System.out.print(k + " ### ");
			}
			System.out.println();
		}
	}

	public boolean estanConectadas(String a1, String a2) {
		
		Queue<String> porExaminar = new LinkedList<String>();
		boolean enc = false;
		String pos1 = a1;
		String pos2 = a2;
		boolean[] examinados = new boolean[g.size()];
		porExaminar.add(pos1);
		HashMap<String,String> camino = new HashMap<String, String>();
		while(!porExaminar.isEmpty() && !enc)
		{

		}
		
		return enc;
		

	}

	private ArrayList<String> imprimirConexion(String a1, String a2, HashMap<String, String> camino) {
		ArrayList<String> conexion = new ArrayList<String>();
		String aux = a2;
		conexion.add(a2);
		while (!camino.get(aux).equals(a1)) {
			conexion.add(camino.get(aux));
			aux = camino.get(aux);
		}
		conexion.add(a1);
		ArrayList<String> caminoBueno = new ArrayList<String>();
		for (int i = conexion.size() - 1; i >= 0; i--) {
			aux = conexion.get(i);
			caminoBueno.add(aux);
		}
		return caminoBueno;
		// Coste O(n + n)
	}
}
