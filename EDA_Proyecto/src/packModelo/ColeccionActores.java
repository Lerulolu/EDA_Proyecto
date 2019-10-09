package packModelo;

public class ColeccionActores {
	
	private static ColeccionActores miColeccionActores;
	private ListaActores listaActores;
	
	private ColeccionActores() {
		listaActores = new ListaActores();
	}
	
	public static ColeccionActores getMiColeccionActores() {
		if(miColeccionActores == null) {
			miColeccionActores = new ColeccionActores();
		}
		return miColeccionActores;
	}
	
	public void cargarActores() {
		listaActores.cargarActores();
	}
	
	public Actor buscarActor(String pNombre) {
		return listaActores.buscarActor(pNombre);
	}

}
