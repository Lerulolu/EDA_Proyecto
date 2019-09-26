package packPruebas;


import packModelo.ColeccionActores;
import packModelo.ListaActores;

public class main {

	public static void main(String[] args)  {
		System.out.println("EMPIEZA EL PROGRAMA");
		ColeccionActores.getColeccionActores().cargarActores();
		System.out.println("ACABADO");

	}

}
