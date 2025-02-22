package packPruebas;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

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
	void testInsertarPelicula() throws FileNotFoundException {
		assertTrue(ColeccionPeliculas.getMiColeccionPeliculas().getSize() == 0);
		
		ColeccionPeliculas.getMiColeccionPeliculas().insertarPelicula("Eager to Die", 0);
		
		assertNotNull(ColeccionPeliculas.getMiColeccionPeliculas().buscarPelicula("Eager to Die"));
		assertTrue(ColeccionPeliculas.getMiColeccionPeliculas().getSize() == 1);

		//Pelicula ya existe
		ColeccionPeliculas.getMiColeccionPeliculas().insertarPelicula("Eager to Die", 0);
		assertTrue(ColeccionPeliculas.getMiColeccionPeliculas().getSize() == 1);

	}

	@Test
	void testInsertarPeliculaSinBuscar() throws FileNotFoundException {
		assertTrue(ColeccionPeliculas.getMiColeccionPeliculas().getSize() == 0);
		
		ColeccionPeliculas.getMiColeccionPeliculas().insertarPeliculaSinBuscar("Eager to Die", 0);
		
		assertNotNull(ColeccionPeliculas.getMiColeccionPeliculas().buscarPelicula("Eager to Die"));
		
		ColeccionPeliculas.getMiColeccionPeliculas().insertarPeliculaSinBuscar("Eager to Die", 0);
		
		//Insertamos dos veces la misma pelicula
		assertTrue(ColeccionPeliculas.getMiColeccionPeliculas().getSize() == 1);

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
