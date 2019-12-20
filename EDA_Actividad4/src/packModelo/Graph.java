package packModelo;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.omg.CORBA.LongLongSeqHelper;

public class Graph {
	
	private HashMap<String, ArrayList<String>> g;
	private ArrayList<String> keys;
	private ArrayList<String>[] adjList;
	private String actor = null;
	private Actor a = null;
	private ListaPeliculas pelisActor = null;
	private HashMap<String, BigDecimal> pageRank;
	
	private static Graph miGrafo;
	
	public static Graph getMiGraph() {
		if(miGrafo == null) {
			miGrafo = new Graph();
		}
		return miGrafo;
	}
	
	//Debido a problemas con el tamaño de los números, 
	//hemos tenido que sustituir los valores del Page Rank 
	//expresados por un Double, por el tipo BigDecimal.

	public HashMap<String, BigDecimal> pageRank()
	{
		crearGrafoActores(ColeccionActores.getMiColeccionActores().getListaActores());
		int cont = g.size(); //Numero total de nodos
		
		HashMap<String, BigDecimal> resultado = new HashMap<String, BigDecimal>();
		HashMap<String, BigDecimal> anterior = new HashMap<String, BigDecimal>();
		BigDecimal pageRankInicial = new BigDecimal(1.0/cont);
	
		// Primera iteracion para añadir el pageRankInicial
		for (int i = 0; i < keys.size(); i ++) 
		{
			resultado.put(keys.get(i), pageRankInicial);
			anterior = resultado;
		}
		
		BigDecimal sumaDiferencia = new BigDecimal(1.0);
		BigDecimal umbral = new BigDecimal(0.85);
		
		//Resto de iteraciones
		while(sumaDiferencia.compareTo(umbral) == 1)
		{
			for(int i = 0; i < keys.size(); i++)
			{
				BigDecimal suma = new BigDecimal (0.0);
				String actOPeli = keys.get(i);
				resultado.put(actOPeli, new BigDecimal (0.0));
				for(int j = 0; j < adjList[i].size(); j++)
				{
					BigDecimal numAdj =new BigDecimal(adjList[j].size());
					if(numAdj.compareTo(new BigDecimal(0)) == 0)
					{
						suma = suma.add(resultado.get(keys.get(j)));
					}
					else
					{
						BigDecimal div = resultado.get(keys.get(j)).divide(numAdj, MathContext.DECIMAL128);
						suma = suma.add(div);	
					}
				}
				resultado.put(actOPeli, suma);
			}
			sumaDiferencia = diferencia(resultado, anterior);
			anterior = resultado;
			System.out.println(sumaDiferencia);
		}
		pageRank = resultado;
		
		return pageRank;
		
	}
	
	public ArrayList<Par> buscar(String actorOPelicula, HashMap<String, BigDecimal> pageRanks) throws FileNotFoundException
	{
		//Post: El resultado es una lista de pares (actor/película, pagerank),
		//ordenadas de mayor a menor por su pagerank, de manera que en las
		//primeras posiciones aparecerán los elementos con pagerank más alto
		//Si es un actor --> devuelve las pelis ordenadas segun su pagerank.
		//Si es una peli --> devuelve sus actores ordenados segun su pagerank.
		
		ArrayList<Par> busqueda = new ArrayList<Par>();
		ListaPeliculas lP = null;
		ListaActores lA = null;
		
		//Buscar si es actor o pelicula
		Boolean esActor = false;
		Boolean existe = false;
		Actor a = ColeccionActores.getMiColeccionActores().buscarActor(actorOPelicula);
		if(a == null) //No es un actor --> Es una peli
		{
			Pelicula p = ColeccionPeliculas.getMiColeccionPeliculas().buscarPelicula(actorOPelicula).getValue();
			if(p != null) //Existe la peli --> Obtener sus actores
			{
				lA = p.obtenerActoresDeUnaPelicula();
				existe = true;
			}
			else
			{
				System.out.println("ESA PELICULA O ACTOR NO EXISTE");
			}
		}
		else //Es un actor --> Obtener sus pelis
		{
			lP = a.obtenerPeliculasDeActor();
			esActor = true;
			existe = true;
		}
		if(existe)
		{
			//Buscar en pagerank de esas pelis o actores
			//Meterlas en busqueda
			if(esActor)
			{
				for(int i = 0; i < lP.getSize(); i++) //Para cada peli de ese actor
				{
					String peli = lP.obtenerNombrePeli(i);
					BigDecimal rank = pageRanks.get(peli);
					Par p = new Par(peli, rank);
					busqueda.add(p);
				}
			}
			else
			{
				for(int i = 0; i < lA.obtenerLongitudLista(); i++) //Para cada actor de esa peli
				{
					String nombreActor = lA.obtenerNombreActor(i);
					BigDecimal rank = pageRanks.get(nombreActor);
					Par p = new Par(nombreActor, rank);
					busqueda.add(p);
				}
			}
		}
		
		//Ordenar lista de busqueda e imprimir lista
		busqueda = this.quickSort(busqueda);
		Iterator<Par> itrBusq = busqueda.iterator();
		while(itrBusq.hasNext()) {
			Par aux = itrBusq.next();
			System.out.print(this.pageRank.get(aux.actorOPelicula));
			System.out.print(" - ");
			System.out.println(aux.actorOPelicula);
		}
		return busqueda;
	
	}

	private BigDecimal diferencia(HashMap<String, BigDecimal> nuevo, HashMap<String, BigDecimal> ant) {
		BigDecimal suma = new BigDecimal(0.0);
		BigDecimal dif = new BigDecimal(0.0);
		for (int i = 0; i < keys.size(); i ++) {
			dif = (nuevo.get(keys.get(i)).subtract(ant.get(keys.get(i)))).abs();
			suma = suma.add(dif);
		}
		return suma;
	}
	
	private ArrayList<Par> quickSort(ArrayList<Par> lista)
	{
		if(lista.size() <= 1)
		{
			return lista;
		}
		else
		{
			Par pivote = lista.get(lista.size()/2);
			lista.remove(lista.size()/2);
			
			ArrayList<Par> menores = new ArrayList<Par>();
			ArrayList<Par> mayores = new ArrayList<Par>();
			
			Iterator<Par> itr = lista.iterator();
			Par pAux;
			
			while(itr.hasNext())
			{
				pAux = itr.next();
				if(this.pageRank.get(pAux.actorOPelicula).compareTo(this.pageRank.get(pivote.actorOPelicula)) > 0)
				{
					menores.add(pAux);
				}
				else
				{
					mayores.add(pAux);
				}
			}
			ArrayList<Par> devuelve = new ArrayList<Par>();
			devuelve.addAll(this.quickSort(menores));
			devuelve.add(pivote);
			devuelve.addAll(this.quickSort(mayores));
			
			return devuelve;
		}		
	}
	
	private void crearGrafoActores(ListaActores lActores) 
	{
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
}
