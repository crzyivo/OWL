package facades;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Data.OwlUserVO;

public class ErrorsStrings {

	private static List<String> lista_provincias = Arrays.asList("Álava,Albacete,Alicante,Almería,Asturias,Ávila,Badajoz,Barcelona,Burgos,Cantabria,Castellón,Ceuta,Ciudad Real,Cuenca,Cáceres,Cádiz,Córdoba,Gerona,Granada,Guadalajara,Guipúzcoa,Huelva,Huesca,Islas Baleares,Jaén,La Coruña,Las Palmas,León,Lugo,Lérida,Madrid,Melilla,Murcia,Málaga,Orense,Palencia,Pontevedra,Salamanca,Santa Cruz de Tenerife,Segovia,Soria,Tarragona,Teruel,Toledo,Valencia,Valladolid,Vizcaya,Zamora,Zaragoza".split(","));
	private final Pattern pattern_email = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$");
	private final Pattern pattern_tlfn = Pattern.compile("^(.*[0-9]){5}.*$");

	public void compruebaDatos(OwlUserVO usuario, List<String> errores) {
		

		Matcher memail = pattern_email.matcher(usuario.getEmail());
		Matcher mtlf = pattern_tlfn.matcher(Integer.toString(usuario.getTlfn())); // Cuestionable si tlfn deberia ser integer

		if (usuario.getEmail() == null || usuario.getEmail().equals("")) {
			errores.add("Introduzca un correo electronico");
		} else if ((usuario.getEmail()).length() < 7 || usuario.getEmail().length() > 90) {
			errores.add("El correo debe tener entre 7 y 90 caracteres");
		} else if (!memail.matches()) {
			errores.add("El correo no es válido");
		}
		if (usuario.getNombre() == null || usuario.getNombre().equals("")) {
			errores.add("Introduzca un nombre");
		} else if (usuario.getNombre().length() > 90) {
			errores.add("El nombre debe tener menos de 90 caracteres");
		}
		if (usuario.getNacimiento() == null || usuario.getNacimiento().equals("")) {
			errores.add("Introduzca un año de nacimiento");
		} else if ((usuario.getNacimiento() > 1999)||(usuario.getNacimiento() < 1920) ) {
			errores.add("Introduzca un año válido");
		}
		if (usuario.getApellidos() == null || usuario.getApellidos().equals("")) {
			errores.add("Introduzca un apellido");
		} else if (usuario.getApellidos().length() < 3 || usuario.getApellidos().length() > 120) {
			errores.add("El apellido debe tener entre 3 y 120 caracteres");
		}
		if (usuario.getTlfn() == null || !mtlf.matches()) { // tlfn.equals("")) si fuera string
			errores.add("Introduzca un telefono");
		} else if (usuario.getTlfn() < 100000000 || usuario.getTlfn() > Integer.MAX_VALUE) {// usuario.getTlfn() > 9999999999999999999) esta fuera de rango de integer
			errores.add(
					"El telefono debe tener al menos 9 dígitos y ser menor que " + Integer.toString(Integer.MAX_VALUE));
		}
		if (usuario.getCalle() == null || usuario.getCalle().equals("")) {
			errores.add("Introduzca una calle");
		} else if ((usuario.getCalle()).length() < 3 || usuario.getCalle().length() > 120) {
			errores.add("La calle debe tener entre 3 y 120 caracteres");
		}
		if (usuario.getPoblacion() == null || usuario.getPoblacion().equals("")) {
			errores.add("Introduzca una poblacion");
		} else if ((usuario.getCalle()).length() < 3 || usuario.getCalle().length() > 120) {
			errores.add("La poblacion debe tener entre 3 y 120 caracteres");
		}
		if (usuario.getProvincia() == null || usuario.getProvincia().equals("")) {
			errores.add("Seleccione una provincia");
		} else if (!lista_provincias.contains(usuario.getProvincia())) {
			errores.add("Seleccione una provincia de la lista");
		}
		if (usuario.getPassword() == null || usuario.getPassword().equals("")) {
			errores.add("Introduzca una contraseña");
		} else if ((usuario.getPassword()).length() < 6 || usuario.getPassword().length() > 500) {
			errores.add("La contraseña debe tener entre 6 y 500 caracteres");
		}
		if (usuario.getNombre() == null || usuario.getNombre().equals("")) {
			errores.add("Introduzca un nombre");
		}
	}
}
