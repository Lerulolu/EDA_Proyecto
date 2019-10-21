package packPruebas;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import packModelo.ListaActores;

class ListaActoresTest {
	
	ListaActores l = new ListaActores();

	@Test
	void testBuscarActor() {
		
		assertNull(l.buscarActor("Jennifer Lawrence"));
		
		l.insertarActor("Jennifer Lawrence");
		
		assertNotNull(l.buscarActor("Jennifer Lawrence"));
	}

	@Test
	void testBorrarActor() {
		l.insertarActor("Jennifer Lawrence");
		assertTrue(l.obtenerLongitudLista() == 1);
	
		l.borrarActor("Jennifer Lawrence");
		assertTrue(l.obtenerLongitudLista() == 0);
		
		l.borrarActor("Jennifer Lawrence");
		assertTrue(l.obtenerLongitudLista() == 0);

	}

	@Test
	void testInsertarActor() {
		
		l.insertarActor("Jennifer Lawrence");
		assertTrue(l.obtenerLongitudLista() == 1);
		
		l.insertarActor("Jennifer Lawrence");
		assertTrue(l.obtenerLongitudLista() == 1);
		
		l.insertarActor("Brad Pitt");
		assertTrue(l.obtenerLongitudLista() == 2);
	}

	@Test
	void testOrdenarLista() {
		//fail("Not yet implemented");
	}

	@Test
	void testObtenerLongitudLista() {
		
		l.insertarActor("Jennifer Lawrence");
		assertTrue(l.obtenerLongitudLista() == 1);
		
		l.insertarActor("Brad Pitt");
		assertTrue(l.obtenerLongitudLista() == 2);
	}

	@Test
	void testObtenerNombreActor() {
		l.insertarActor("Jennifer Lawrence");
		l.insertarActor("Brad Pitt");
		
		assertTrue(l.obtenerNombreActor(0) == "Jennifer Lawrence");
		assertTrue(l.obtenerNombreActor(1) == "Brad Pitt");

	
	}

}
