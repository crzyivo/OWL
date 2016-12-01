package Data;

import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Arrays;

public class OwlUserVO {
	private String email = null;
	private String nombre = null;
	private String apellidos = null;
	private Integer nacimiento = 9999;
	private Integer tlfn = 999999999;
	private String calle = null;
	private String numero = "";
	private String piso = "";
	private String poblacion = null;
	private String provincia = null;
	private String pass = null;

	public OwlUserVO(String email, String nombre, String apellidos, Integer tlfn, Integer nacimiento, String calle,
			String numero, String piso_puerta, String poblacion, String provincia, String pass) {

		this.email = email;

		this.nombre = nombre;

		this.apellidos = apellidos;

		this.tlfn = tlfn;

		this.calle = calle;

		this.numero = numero;

		this.piso = piso_puerta;

		this.poblacion = poblacion;

		this.provincia = provincia;

		this.pass = pass;

	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getNacimiento() {
		return this.nacimiento;
	}

	public void setNacimiento(Integer Nacimiento) {
		this.nacimiento = Nacimiento;
	}

	public Integer getTlfn() {
		return this.tlfn;
	}

	public void setTlfn(Integer tlfn) {
		this.tlfn = tlfn;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPiso() {
		return this.piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getPoblacion() {
		return this.poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.calle = poblacion;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.piso = provincia;
	}

	public String getPassword() {
		return this.pass;
	}

	public void setPassword(String pass) {
		this.pass = pass;
	}

}