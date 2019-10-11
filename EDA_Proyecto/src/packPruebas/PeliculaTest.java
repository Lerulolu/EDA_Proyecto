package packPruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import packModelo.Actor;
import packModelo.ListaActores;
import packModelo.Pelicula;

class PeliculaTest {
	
	Pelicula p1 = new Pelicula("Los Juegos del Hambre", 0);

	@Test
	void testGetNombrePelicula() {
		assertTrue(p1.getNombrePelicula() == "Los Juegos del Hambre");
		assertFalse(p1.getNombrePelicula() == "A");
	}
	
	@Test
	void testGetDineroRecaudado() {
		
		assertTrue(p1.getDineroRecaudado() == 0);
		assertFalse(p1.getDineroRecaudado() != 0);
	}

	@Test
	void testIncrementarDinero() {
		assertTrue(p1.getDineroRecaudado() == 0);
		
		p1.incrementarDinero(5000);
		
		assertTrue(p1.getDineroRecaudado() == 5000);
	}

	@Test
	void testBorrarActor() {
		p1.insertarActor("Jennifer Lawrence");
		assertTrue(p1.obtenerActoresDeUnaPelicula().obtenerLongitudLista() != 0);

		p1.borrarActor("Jennifer Lawrence");
		assertTrue(p1.obtenerActoresDeUnaPelicula().obtenerLongitudLista() == 0);
				
	}

	@Test
	void testObtenerActoresDeUnaPelicula() {
		assertTrue(p1.obtenerActoresDeUnaPelicula().obtenerLongitudLista() == 0);
		
		p1.insertarActor("Jennifer Lawrence");
		
		assertTrue(p1.obtenerActoresDeUnaPelicula().obtenerLongitudLista() != 0);
		
	}

	@Test
	void testInsertarActor() {
		assertTrue(p1.obtenerActoresDeUnaPelicula().obtenerLongitudLista() == 0);
		
		p1.insertarActor("Jennifer Lawrence");
		
		assertTrue(p1.obtenerActoresDeUnaPelicula().obtenerLongitudLista() != 0);
		
		p1.insertarActor("Jennifer Lawrence");
		
		assertTrue(p1.obtenerActoresDeUnaPelicula().obtenerLongitudLista() == 1);

	}

}
