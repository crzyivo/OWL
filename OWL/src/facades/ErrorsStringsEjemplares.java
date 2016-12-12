package facades;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import Data.EjemplarVO;

public class ErrorsStringsEjemplares {

	// private final static List<String> LISTA_CENTIMOS_POSIBLES =
	// Arrays.asList("00,05,09,10,15,19,20,25,29,30,35,39,40,45,49,50,55,59,60,65,69,70,75,79,80,85,89,90,95,99".split(","));
	private final static List<String> LISTA_ESTADOS_CONSERVACION = Arrays
			.asList("Excelente,Bueno,Deteriorado".split(","));

	/* String */
	private final static int MIN_LENGTH_ISBN = 10;
	private final static int MAX_LENGTH_ISBN = 13;
	private final static int MIN_LENGTH_EDITORIAL = 1;
	private final static int MAX_LENGTH_EDITORIAL = 60;

	/* Integer */
	private final static int MIN_PUBLICACION = -2000;
	private final static int MAX_PUBLICACION = Calendar.getInstance().get(Calendar.YEAR);
	private final static Float MIN_EUROS = (float) 0.0;
	private final static Float MAX_EUROS = (float) 99.99;

	public static void compruebaDatos(EjemplarVO ejemplar, List<String> errores) {

		final Integer id = ejemplar.getId();
		final Integer libro = ejemplar.getLibro();
		final String editorial = ejemplar.getEditorial();
		final String estado = ejemplar.getEstado(); // excelente, bueno o
													// deteriorado
		final Float precio = ejemplar.getPrecio();
		final String vendedor = ejemplar.getVendedor();
		final String comprador = ejemplar.getComprador();
		final String ISBN = ejemplar.getISBN();
		final Integer anno = ejemplar.getAnno();

		if (editorial == null || editorial.equals("")) {
			errores.add("Debes indicar el editor o la editorial del ejemplar.");
		} else if (editorial.length() < MIN_LENGTH_EDITORIAL || editorial.length() > MAX_LENGTH_EDITORIAL) {
			errores.add("La editorial debe tener entre " + MIN_LENGTH_EDITORIAL + " y " + MAX_LENGTH_EDITORIAL
					+ " caracteres.");
		}
		if (anno != null && (anno < MIN_PUBLICACION || anno > MAX_PUBLICACION)) {
			errores.add("El año de publicación indicado no es válido.");
		}
		if (precio == null || precio.equals("")) {
			errores.add("Debes especificar un precio para el ejemplar.");
		} else if (precio < MIN_EUROS || precio > MAX_EUROS) {
			errores.add("Debes especificar un precio entre " + MIN_EUROS + " y " + MAX_EUROS + " euros.");
		}
		if (ISBN != null && (ISBN.length() < MIN_LENGTH_ISBN || ISBN.length() > MAX_LENGTH_ISBN)) {
			errores.add(
					"Debes especificar un ISBN-10 o un ISBN-13 válido. No deberías escribir guiones ni otros caracteres separadores.");
		}
		if (estado == null || estado.equals("") || !LISTA_ESTADOS_CONSERVACION.contains(estado)) {
			errores.add("Debes especificar un estado de conservación válido para el ejemplar.");
		}
	}
}