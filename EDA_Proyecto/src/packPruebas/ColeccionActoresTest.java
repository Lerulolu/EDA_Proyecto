package packPruebas;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import packModelo.ColeccionActores;

class ColeccionActoresTest {

	@Test
	void testCargarDatos() {
		assertNull(ColeccionActores.getMiColeccionActores().buscarActor("Devon, Tony"));
		
		ColeccionActores.getMiColeccionActores().cargarDatos();
		
		assertNotNull(ColeccionActores.getMiColeccionActores().buscarActor("Devon, Tony"));
	}

	@Test
	void testObtenerPeliculasDeUnActor() throws FileNotFoundException {
		assertNull(ColeccionActores.getMiColeccionActores().obtenerPeliculasDeUnActor("Devon, Tony"));
		
		ColeccionActores.getMiColeccionActores().cargarDatos();
		
		assertNotNull(ColeccionActores.getMiColeccionActores().obtenerPeliculasDeUnActor("Devon, Tony"));
	}

	@Test
	void testBuscarActor() {
		assertNull(ColeccionActores.getMiColeccionActores().buscarActor("Devon, Tony"));
		
		ColeccionActores.getMiColeccionActores().cargarDatos();	
		
		assertNotNull(ColeccionActores.getMiColeccionActores().buscarActor("Devon, Tony"));
	}

	@Test
	void testInsertarActor() {
		assertNull(ColeccionActores.getMiColeccionActores().buscarActor("Devon, Tony"));
		
		ColeccionActores.getMiColeccionActores().insertarActor("Devon, Tony");
		
		assertNotNull(ColeccionActores.getMiColeccionActores().buscarActor("Devon, Tony"));
		
		//Mensaje de que ya existe
		ColeccionActores.getMiColeccionActores().insertarActor("Devon, Tony");

	}

	@Test
	void testEliminarActor() {
		
		//Mensaje de que no existe
		ColeccionActores.getMiColeccionActores().eliminarActor("Devon, Tony");
		
		ColeccionActores.getMiColeccionActores().insertarActor("Devon, Tony");
		
		assertNotNull(ColeccionActores.getMiColeccionActores().buscarActor("Devon, Tony"));

		ColeccionActores.getMiColeccionActores().eliminarActor("Devon, Tony");
		
		assertNull(ColeccionActores.getMiColeccionActores().buscarActor("Devon, Tony"));


		
	}

	@Test
	void testOrdenarActoresAlfabeticamente() {
		ColeccionActores.getMiColeccionActores().insertarActor("Devon, Tony");
		ColeccionActores.getMiColeccionActores().insertarActor("O'Toole, Peter (I)");
		
		ColeccionActores.getMiColeccionActores().ordenarActoresAlfabeticamente();
		
		int pos = ColeccionActores.getMiColeccionActores().obtenerPosicionDeUnActorEnLista("Devon, Tony");
		int pos1 = ColeccionActores.getMiColeccionActores().obtenerPosicionDeUnActorEnLista("O'Toole, Peter (I)");
		
		assertEquals(0, pos);
		assertEquals(1, pos1);
		
		
	}

}
