package packPruebas;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import packModelo.Actor;
import packModelo.ListaPeliculas;
import packModelo.Pelicula;

class ActorTest {

	Actor a = new Actor("Jennifer Lawrence");
	Pelicula p1 = new Pelicula("Los Juegos del Hambre", 0);

	@Test
	void testGetNombreActor() {
		assertTrue(a.getNombreActor() == "Jennifer Lawrence");
		assertFalse(a.getNombreActor() == "A");
	}

	@Test
	void testInsertarPeli() throws FileNotFoundException {
		
		a.insertarPeli(p1);
		ListaPeliculas listaPelis = a.obtenerPeliculasDeActor();
		
		assertTrue(listaPelis.getSize() == 1);
		assertNotNull(listaPelis.buscarPelicula(p1.getNombrePelicula()));
		
		a.insertarPeli(p1);
		
		assertTrue(listaPelis.getSize() == 1);
	}
	
	@Test
	void testEliminarPeli() throws FileNotFoundException {
		a.insertarPeli(p1);
		
		assertTrue(a.obtenerPeliculasDeActor().getSize() != 0);
		
		a.eliminarPeli(p1.getNombrePelicula());
		
		assertTrue(a.obtenerPeliculasDeActor().getSize() == 0);
	}

	
	@Test
	void testObtenerPeliculasDeActor() throws FileNotFoundException {
		assertTrue(a.obtenerPeliculasDeActor().getSize() == 0);

		a.insertarPeli(p1);
		a.insertarPeli(new Pelicula("Harry Potter", 0));
		
		assertTrue(a.obtenerPeliculasDeActor().getSize() == 2);
	}
	

}
