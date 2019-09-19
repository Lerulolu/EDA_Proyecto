package packPruebas;

import packModelo.CargarFicheros;
import packModelo.ListaActores;

public class main {

	public static void main(String[] args)  {
		System.out.println("EMPIEZA EL PROGRAMA");
		ListaActores.getListaActores().obtenerListaActores();
		System.out.println("ACABADO");

	}

}
