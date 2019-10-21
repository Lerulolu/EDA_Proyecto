package packPruebas;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import packModelo.ListaPeliculas;

class ListaPeliculasTest {
	
	ListaPeliculas l = new ListaPeliculas();

	@Test
	void testBuscarPelicula() throws FileNotFoundException {
		
		assertNull(l.buscarPelicula("Los Juegos del Hambre"));
		l.insertarPelicula("Los Juegos del Hambre",0);
		assertNotNull(l.buscarPelicula("Los Juegos del Hambre"));
	}

	@Test
	void testIncrementarCantidad() throws FileNotFoundException {
		
		l.insertarPelicula("Los Juegos del Hambre",0);
		assertEquals(0, l.buscarPelicula("Los Juegos del Hambre").getDineroRecaudado());
		
		l.incrementarCantidad(5000,"Los Juegos del Hambre");
		assertEquals(5000, l.buscarPelicula("Los Juegos del Hambre").getDineroRecaudado());

		
		//MENSAJE POR CONSOLA
		l.incrementarCantidad(5000, "Harry Potter");
		
	}

	@Test
	void testInsertarPelicula() throws FileNotFoundException {
		assertEquals(l.getSize(),0);
		
		l.insertarPelicula("Los Juegos del Hambre",0);
		assertEquals(l.getSize(),1);
		
		l.insertarPelicula("Los Juegos del Hambre",0);
		assertEquals(l.getSize(),1);
		
		l.insertarPelicula("Harry Potter",0);
		assertEquals(l.getSize(),2);
		
	}

	@Test
	void testEliminarPelicula() throws FileNotFoundException {
		
		l.eliminarPelicula("Los Juegos del Hambre");
		assertEquals(l.getSize(),0);
		
		l.insertarPelicula("Los Juegos del Hambre",0);
		assertEquals(l.getSize(),1);
		
		l.eliminarPelicula("Los Juegos del Hambre");
		assertEquals(l.getSize(),0);

	}

	@Test
	void testObtenerPelicula() throws FileNotFoundException {
		assertEquals(l.getSize(),0);

		l.insertarPelicula("Los Juegos del Hambre",0);	
		
		assertTrue(l.obtenerPelicula(0).getNombrePelicula() == "Los Juegos del Hambre" );
		assertNull(l.obtenerPelicula(1));

	}

	
	@Test
	void testGetSize() throws FileNotFoundException {
		assertEquals(l.getSize(),0);

		l.insertarPelicula("Los Juegos del Hambre",0);	
		
		assertEquals(l.getSize(),1);
		
		l.insertarPelicula("Los Juegos del Hambre",0);	
		
		assertEquals(l.getSize(),1);

	}

}
