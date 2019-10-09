package packPruebas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import packModelo.Actor;

public class IMBD {

	private static IMBD miIMBD;
	
	public static IMBD getMiIMBD() {
		if(miIMBD == null) {
			miIMBD = new IMBD();
		}
		return miIMBD;
	}
	
	private IMBD() {
		
	}
	
	
	public void guardarLista() {
		
	}
}
