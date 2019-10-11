package packModelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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

		System.out.println(l.obtenerLongitudLista());
		
		l.borrarActor("Jennifer Lawrence");
		assertTrue(l.obtenerLongitudLista() == 0);

	}

	@Test
	void testInsertarActor() {
		fail("Not yet implemented");
	}

	@Test
	void testOrdenarLista() {
		fail("Not yet implemented");
	}

	@Test
	void testObtenerLongitudLista() {
		fail("Not yet implemented");
	}

	@Test
	void testObtenerNombreActor() {
		fail("Not yet implemented");
	}

}
