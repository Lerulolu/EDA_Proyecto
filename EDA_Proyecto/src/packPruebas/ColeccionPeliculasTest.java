package packPruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import packModelo.ColeccionActores;
import packModelo.ColeccionPeliculas;

class ColeccionPeliculasTest {

	@Test
	void testObtenerActoresDeUnaPeli() throws FileNotFoundException {
		assertNull(ColeccionPeliculas.getMiColeccionPeliculas().obtenerActoresDeUnaPeli("Eager to Die"));
		
		ColeccionActores.getMiColeccionActores().cargarDatos();
		
		assertNotNull(ColeccionPeliculas.getMiColeccionPeliculas().obtenerActoresDeUnaPeli("Eager to Die"));
	}

	@Test
	void testBuscarPelicula() throws FileNotFoundException {
		assertNull(ColeccionPeliculas.getMiColeccionPeliculas().buscarPelicula("Eager to Die"));
		
		ColeccionPeliculas.getMiColeccionPeliculas().insertarPelicula("Eager to Die", 0);
		
		assertNotNull(ColeccionPeliculas.getMiColeccionPeliculas().buscarPelicula("Eager to Die"));

	}

	@Test
	void testObtenerPeliculaPorPosicion() throws FileNotFoundException {
		assertNull(ColeccionPeliculas.getMiColeccionPeliculas().obtenerPeliculaPorPosicion(0));
		
		ColeccionPeliculas.getMiColeccionPeliculas().insertarPelicula("Eager to Die", 0);
		
		assertNotNull(ColeccionPeliculas.getMiColeccionPeliculas().obtenerPeliculaPorPosicion(0));
		assertTrue("Eager to Die" == ColeccionPeliculas.getMiColeccionPeliculas().obtenerPeliculaPorPosicion(0).getNombrePelicula());
	}

	@Test
	void testInsertarPelicula() throws FileNotFoundException {
		assertNull(ColeccionPeliculas.getMiColeccionPeliculas().obtenerPeliculaPorPosicion(0));
		
		ColeccionPeliculas.getMiColeccionPeliculas().insertarPelicula("Eager to Die", 0);
		
		assertNotNull(ColeccionPeliculas.getMiColeccionPeliculas().buscarPelicula("Eager to Die"));
		
		//Pelicula ya existe
		ColeccionPeliculas.getMiColeccionPeliculas().insertarPelicula("Eager to Die", 0);
	
	}

	@Test
	void testInsertarPeliculaSinBuscar() throws FileNotFoundException {
		assertNull(ColeccionPeliculas.getMiColeccionPeliculas().obtenerPeliculaPorPosicion(0));
		
		ColeccionPeliculas.getMiColeccionPeliculas().insertarPeliculaSinBuscar("Eager to Die", 0);
		
		assertNotNull(ColeccionPeliculas.getMiColeccionPeliculas().buscarPelicula("Eager to Die"));
		
		ColeccionPeliculas.getMiColeccionPeliculas().insertarPeliculaSinBuscar("Eager to Die", 0);
		
		//Insertamos dos veces la misma pelicula
		assertNotNull(ColeccionPeliculas.getMiColeccionPeliculas().obtenerPeliculaPorPosicion(1));
	}

	@Test
	void testIncrementarDineroRecaudado() throws FileNotFoundException {
		//Esa peli no existe
		ColeccionPeliculas.getMiColeccionPeliculas().incrementarDineroRecaudado("Eager to Die", 5000);

		
		ColeccionPeliculas.getMiColeccionPeliculas().insertarPeliculaSinBuscar("Eager to Die", 0);
		ColeccionPeliculas.getMiColeccionPeliculas().incrementarDineroRecaudado("Eager to Die", 5000);

		assertTrue(5000 == ColeccionPeliculas.getMiColeccionPeliculas().buscarPelicula("Eager to Die").getDineroRecaudado());

	}

	@Test
	void testGenerarLista() {
		fail("Not yet implemented");
	}

}
