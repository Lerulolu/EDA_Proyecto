package packModelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

import javax.swing.plaf.synth.SynthSpinnerUI;

import java.util.Queue;

public class GraphHash {

	private static GraphHash miGrafo;
	
	public static GraphHash getMiGraphHas() {
		if(miGrafo == null) {
			miGrafo = new GraphHash();
		}
		return miGrafo;
	}
	
	HashMap<String, ArrayList<String>> g;
	ArrayList<String> keys;
	ArrayList<String>[] adjList;
	int cont = 0; //contador de actores no repetidos
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
			a = lActores.obtenerActor(i);
			actor = a.getNombreActor();
			ArrayList<String> lAP;
			
			if(!g.containsKey(actor))
			{
				pelisActor = a.obtenerPeliculasDeActor();
				
				lAP = new ArrayList<String>();
				ArrayList<String> lPA;
				
				for(int j = 0; j < pelisActor.getSize(); j++)
				{
					String p = pelisActor.obtenerNombrePeli(j);
					if(!g.containsKey(p))
					{
						lPA = new ArrayList<String>();
						lAP.add(p);
						lPA.add(actor);
						g.put(p, lPA);
					}
					else
					{
						lAP.add(p);
						lPA = g.get(p);
						lPA.add(actor);
						g.put(p, lPA);
						
					}
				}
				g.put(actor, lAP);
				cont++;
			}
		}
		
		//Paso 2: Llenar keys
		keys = new ArrayList<String>(g.keySet());
		
		//Paso 3: Llenar adjList
		adjList = new ArrayList[g.size()];

		for(int j = 0; j < adjList.length; j++)
		{
			adjList[j] = new ArrayList<String>();
		}
		String actor; 
		Integer iA = 0; //Indice de los actores
		String peli; 
		Integer iP = 0; //Indice de las pelis
		
		for(int k = 0; k < lActores.obtenerLongitudLista(); k++)
		{
			actor = lActores.obtenerNombreActor(k);

			for(int l = 0; l < g.get(actor).size(); l++)
			{
				peli = g.get(actor).get(l);
						
				iA = keys.indexOf(actor);
				iP = keys.indexOf(peli);
				
				adjList[iA].add(peli);
				adjList[iP].add(actor);
								
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

	public boolean estanConectados(String a1, String a2) {
		
		Queue<Integer> porExaminar = new LinkedList<Integer>();
		boolean enc = false;
		
		Integer pos1 = keys.indexOf(a1);
		Integer pos2 = keys.indexOf(a2);
		
		boolean[] examinados = new boolean[g.size()];
		porExaminar.add(pos1);
		HashMap<String,String> camino = new HashMap<String, String>();
		while(!porExaminar.isEmpty() && !enc)
		{
			if(adjList[pos1].contains(a2))
			{
				enc = true;
			}
			else
			{
				examinados[pos1] = true;
				pos1 = porExaminar.remove();
				Iterator<String> itr = adjList[pos1].iterator();
				String actual;
				Integer posActual;
				while(itr.hasNext())
				{
					actual = itr.next();
					posActual = keys.indexOf(actual);
					if(!examinados[posActual] && !porExaminar.contains(actual))
					{
						porExaminar.add(posActual);
						camino.put(actual, keys.get(pos1));
					}
				}
			}
		}
		System.out.println();
		if(enc == true)
		{
			System.out.println("Están conectados");
			System.out.println();
			System.out.println(imprimirConexion(a1, a2, camino).toString());
		}
		else
		{
			System.out.println("No están conectados");
		}
		System.out.println();
		System.out.println(enc);
		System.out.println();
		
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
