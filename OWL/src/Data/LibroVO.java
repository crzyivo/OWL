
package Data;

public class LibroVO {

	private int id;
	private String titulo;
	private String autor;
	private String descripcion;
	private Integer ventas;

	public LibroVO() {
		this.id = -1;
		this.titulo = "Libro Vac�o";
		this.autor = "OWL Database";
		this.descripcion = "Creado por el constructor vac�o";
		this.ventas = 0;

	}

	public LibroVO(int id, String titulo, String autor, String descripcion, Integer ventas) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.descripcion = descripcion;
		this.ventas = ventas;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getVentas() {
		return this.ventas;
	}

	public void setVentas(Integer ventas) {
		this.ventas = ventas;
	}

};