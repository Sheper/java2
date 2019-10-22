package com.log4j.pp;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

public class Main {
	// Define una variable est�tica que tiene una referencia
	// a una instancia de Logger llamada "MyApp".
	static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		// Crea una simple configuraci�n a la consola
		BasicConfigurator.configure();
		logger.info("Entrando en la aplicaci�n.");
		Bar bar = new Bar();
		bar.doIt();
		logger.info("Saliendo de la aplicaci�n.");
	}
}