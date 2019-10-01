package packPruebas;


import packModelo.ColeccionActores;
import packModelo.ListaActores;
import packModelo.ListaPeliculas;

public class main {

	public static void main(String[] args)  {
		System.out.println("EMPIEZA EL PROGRAMA");
		ColeccionActores.getMiColeccionActores().cargarActores();
		System.out.println("ACABADO");

	}

}
