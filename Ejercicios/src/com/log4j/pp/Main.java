package com.log4j.pp;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

public class Main {
	// Define una variable estática que tiene una referencia
	// a una instancia de Logger llamada "MyApp".
	static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		// Crea una simple configuración a la consola
		BasicConfigurator.configure();
		logger.info("Entrando en la aplicación.");
		Bar bar = new Bar();
		bar.doIt();
		logger.info("Saliendo de la aplicación.");
	}
}