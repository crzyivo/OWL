package facades;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Data.OwlUserVO;

public class ErrorsStrings {

	private final static List<String> LISTA_PROVINCIAS = Arrays
			.asList("Álava,Albacete,Alicante,Almería,Asturias,Ávila,Badajoz,Barcelona,Burgos,Cantabria,Castellón,Ceuta,Ciudad Real,Cuenca,Cáceres,Cádiz,Córdoba,Gerona,Granada,Guadalajara,Guipúzcoa,Huelva,Huesca,Islas Baleares,Jaén,La Coruña,La Rioja,Las Palmas,León,Lugo,Lérida,Madrid,Melilla,Murcia,Málaga,Navarra,Orense,Palencia,Pontevedra,Salamanca,Santa Cruz de Tenerife,Segovia,Soria,Tarragona,Teruel,Toledo,Valencia,Valladolid,Vizcaya,Zamora,Zaragoza"
					.split(","));
	private final static Pattern PATTERN_EMAIL = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

	/* String */
	private final static int MIN_LENGTH_EMAIL = 7;
	private final static int MAX_LENGTH_EMAIL = 90;
	private final static int MIN_LENGTH_NOMBRE = 1;
	private final static int MAX_LENGTH_NOMBRE = 90;
	private final static int MIN_LENGTH_APELLIDOS = 2;
	private final static int MAX_LENGTH_APELLIDOS = 120;
	private final static int MIN_LENGTH_CALLE = 2;
	private final static int MAX_LENGTH_CALLE = 120;
	private final static int MIN_LENGTH_POBLACION = 2;
	private final static int MAX_LENGTH_POBLACION = 120;
	private final static int MIN_LENGTH_PASSWORD = 6;
	private final static int MAX_LENGTH_PASSWORD = 500;

	/* Integer */
	private final static int MIN_NACIMIENTO = 1910;
	private final static int MAX_NACIMIENTO = Calendar.getInstance().get(Calendar.YEAR) - 17;
	private final static int MIN_TELEFONO = 10000000;
	private final static int MAX_TELEFONO = 999999999;

	public static void compruebaDatos(OwlUserVO usuario, List<String> errores) {

		final Matcher memail = PATTERN_EMAIL.matcher(usuario.getEmail());

		if (usuario.getEmail() == null || usuario.getEmail().equals("")) {
			errores.add("Debes proporcionar una dirección de correo electrónico.");
		} else if (usuario.getEmail().length() < MIN_LENGTH_EMAIL || usuario.getEmail().length() > MAX_LENGTH_EMAIL) {
			errores.add("El correo debe tener entre " + MIN_LENGTH_EMAIL + " y " + MAX_LENGTH_EMAIL + " caracteres.");
		} else if (!memail.matches()) {
			errores.add("El correo no es válido.");
		}
		if (usuario.getNombre() == null || usuario.getNombre().equals("")) {
			errores.add("Debes introducir tu nombre.");
		} else if (usuario.getNombre().length() < MIN_LENGTH_NOMBRE
				|| usuario.getNombre().length() > MAX_LENGTH_NOMBRE) {
			errores.add("El nombre debe tener entre " + MIN_LENGTH_NOMBRE + " y " + MAX_LENGTH_NOMBRE + " caracteres.");
		}
		if (usuario.getNacimiento() == null || usuario.getNacimiento().equals("")) {
			errores.add("Debes proporcionar tu año de nacimiento.");
		} else if (usuario.getNacimiento() < MIN_NACIMIENTO || usuario.getNacimiento() > MAX_NACIMIENTO) {
			errores.add("El año de nacimiento indicado no es válido.");
		}
		if (usuario.getApellidos() == null || usuario.getApellidos().equals("")) {
			errores.add("Debes introducir tus apellidos.");
		} else if (usuario.getApellidos().length() < MIN_LENGTH_APELLIDOS
				|| usuario.getApellidos().length() > MAX_LENGTH_APELLIDOS) {
			errores.add("Los apellidos deben tener entre " + MIN_LENGTH_APELLIDOS + " y " + MAX_LENGTH_APELLIDOS
					+ " caracteres.");
		}
		if (usuario.getTlfn() == null) { // tlfn.equals("")) si fuera string
			errores.add("Debes proporcionar un teléfono de contacto.");
		} else if (usuario.getTlfn() < MIN_TELEFONO || usuario.getTlfn() > MAX_TELEFONO) {
			errores.add("El teléfono de contacto debe estar entre +34" + MIN_TELEFONO + " y +34" + MAX_TELEFONO + ".");
		}
		if (usuario.getCalle() == null || usuario.getCalle().equals("")) {
			errores.add("Debes especificar tu calle.");
		} else if (usuario.getCalle().length() < MIN_LENGTH_CALLE || usuario.getCalle().length() > MAX_LENGTH_CALLE) {
			errores.add("El nombre de la calle debe tener entre " + MIN_LENGTH_CALLE + " y " + MAX_LENGTH_CALLE
					+ " caracteres.");
		}
		if (usuario.getPoblacion() == null || usuario.getPoblacion().equals("")) {
			errores.add("Debes especificar tu núcleo de población.");
		} else if (usuario.getCalle().length() < MIN_LENGTH_POBLACION
				|| usuario.getCalle().length() > MAX_LENGTH_POBLACION) {
			errores.add("El nombre de tu núcleo de población debe tener entre " + MIN_LENGTH_POBLACION + " y "
					+ MAX_LENGTH_POBLACION + " caracteres.");
		}
		if (usuario.getProvincia() == null || usuario.getProvincia().equals("")) {
			errores.add("Debes especificar tu provincia de residencia.");
		} else if (!LISTA_PROVINCIAS.contains(usuario.getProvincia())) {
			errores.add("La provincia de residencia proporcionada debe estar en la lista.");
		}
		if (usuario.getPassword() == null || usuario.getPassword().equals("")) {
			errores.add("Debes definir una contraseña.");
		} else if (usuario.getPassword().length() < MIN_LENGTH_PASSWORD
				|| usuario.getPassword().length() > MAX_LENGTH_PASSWORD) {
			errores.add("La contraseña debe tener entre " + MIN_LENGTH_PASSWORD + " y " + MAX_LENGTH_PASSWORD
					+ " caracteres.");
		}
	}
}