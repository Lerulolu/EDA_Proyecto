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

	private HashMap<String, ArrayList<String>> g;
	private ArrayList<String> keys;
	private ArrayList<String>[] adjList;
	private String actor = null;
	private Actor a = null;
	private ListaPeliculas pelisActor = null;
	
	private static int n=5000000;
	private static GraphHash miGrafo;
	private HashMap<Integer, Double> pageRank;
	private ArrayList<Integer>[] invAdjList = (ArrayList<Integer>[]) new ArrayList[n];
	
	public static GraphHash getMiGraphHas() {
		if(miGrafo == null) {
			miGrafo = new GraphHash();
		}
		return miGrafo;
	}
	
	

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
			ArrayList<String> lAP; //Lista de Actores con las peliculas en las que aparecen
			
			if(!g.containsKey(actor))
			{
				pelisActor = a.obtenerPeliculasDeActor();
				
				lAP = new ArrayList<String>();
				ArrayList<String> lPA; //Lista de Peliculas con los actores que aparecen en cada una
				
				for(int j = 0; j < pelisActor.getSize(); j++)
				{
					String p = pelisActor.obtenerNombrePeli(j);
					if(!g.containsKey(p)) //No existe esa peli en el HashMap
					{
						lPA = new ArrayList<String>(); //Creamos su lista de actores
						lAP.add(p); //Añadimos la pelicula a la lista de pelis del actor
						lPA.add(actor); //Añadimos el actor a la lista de actores de la peli
						g.put(p, lPA); //Lo añadimos al HashMap
					}
					else //La peli ya existe en el HashMap
					{
						lAP.add(p); //Añadimos la pelicula a la lista de pelis del actor
						lPA = g.get(p); //Obtenemos la lista de actores de la pelicula
						lPA.add(actor); //Añadimos el nuevo actor a la peli
						g.put(p, lPA); //Actualizamos la lista de actores de la pelicula en el HashMap
						
					}
				}
				g.put(actor, lAP); //Añadimos el actor con su lista de peliculas al HashMap
			}
		}
		
		//Paso 2: Llenar keys --> Obtenemos todas las claves del HashMap
		keys = new ArrayList<String>(g.keySet()); 
		
		//Paso 3: Llenar adjList --> Realizamos los enlaces entre pelis y actores
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

	public boolean estanConectados(String a1, String a2) {
		
		Queue<Integer> porExaminar = new LinkedList<Integer>(); //Elementos no examinados
		boolean enc = false;
		Integer llamadas = 1;
		
		Integer pos1 = keys.indexOf(a1);
		//Integer pos2 = keys.indexOf(a2);
		
		boolean[] examinados = new boolean[g.size()];
		porExaminar.add(pos1); //Añadimos el primer elemento
		HashMap<String,String> camino = new HashMap<String, String>(); //Creamos el objeto que guardará el camino entre a1 y a2
		
		while(!porExaminar.isEmpty() && !enc)
		{
			if(adjList[pos1].contains(a2)) //Se ha encontrado el final
			{
				enc = true;
			}
			else //No se ha encontrado el final
			{
				examinados[pos1] = true; //Marcamos como examinado
				pos1 = porExaminar.remove(); //Lo eliminamos de los elementos a examinar
				Iterator<String> itr = adjList[pos1].iterator(); 
				String actual;
				Integer posActual;
				while(itr.hasNext())
				{
					actual = itr.next(); //Cogemos el siguiente elemento
					posActual = keys.indexOf(actual);
					if(!examinados[posActual] && !porExaminar.contains(actual)) //Si no está examinado
					{
						porExaminar.add(posActual); //Lo añadimos a los elementos a examinar
						camino.put(actual, keys.get(pos1)); //Lo añadimos al camino
					}
					llamadas++;
				}
			}
		}
		System.out.println();
		if(enc == true) //Se ha encontrado un camino
		{
			System.out.println("Están conectados");
			System.out.println("Se han realizado: "+llamadas+" comprobaciones de relaciones");
			System.out.println();

			System.out.println(imprimirConexion(a1, a2, camino).toString());
		}
		else //No se ha encontrado un camino
		{
			System.out.println("No están conectados");
			System.out.println("Se han realizado: "+llamadas+" comprobaciones de relaciones");

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
		
		while (!camino.get(aux).equals(a1)) 
		{
			conexion.add(camino.get(aux));
			aux = camino.get(aux);
		}
		conexion.add(a1);
		ArrayList<String> caminoBueno = new ArrayList<String>();
		
		for (int i = conexion.size() - 1; i >= 0; i--) 
		{
			aux = conexion.get(i);
			caminoBueno.add(aux);
		}
		return caminoBueno;
		// Coste O(n + n)
	}
}
