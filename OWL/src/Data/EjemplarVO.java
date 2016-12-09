package Data;

public class EjemplarVO {

	private Integer id;
	private Integer libro;
	private String editorial;
	private String estado; // excelente, bueno o deteriorado
	private Float precio;
	private String vendedor;
	private String comprador;
	private String ISBN;
	private String fventa;
	private String fcompra;
	private Integer anno;

	public EjemplarVO() {
		this.id = -1;
		this.libro = -1;
		this.editorial = "--";
		this.estado = "No inicializado";
		this.precio = (float) -1;
		this.vendedor = null;
		this.comprador = null;
		this.ISBN = null;
		this.fventa = null;
		this.fcompra = null;
		this.anno = 0000;
	}

	public EjemplarVO(Integer id, Integer libro, String editorial, String estado, float precio, String vendedor,
			String comprador, String ISBN, Integer anno, String fventa, String fcompra) {
		this.id = id;
		this.libro = libro;
		this.editorial = editorial;
		this.estado = estado;
		this.precio = precio;
		this.vendedor = vendedor;
		this.comprador = comprador;
		this.ISBN = ISBN;
		this.fventa = fventa;
		this.fcompra = fcompra;
		this.anno = anno;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getLibro() {
		return this.libro;
	}

	public void setLibro(int libro) {
		this.libro = libro;
	}

	public String getEditorial() {
		return this.editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Float getPrecio() {
		return this.precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getVendedor() {
		return this.vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getComprador() {
		return this.comprador;
	}

	public void setComprador(String comprador) {
		this.comprador = comprador;
	}

	public String getISBN() {
		return this.ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public String getfcompra() {
		return this.fcompra;
	}

	public void setfcompra(String fcompra) {
		this.fcompra = fcompra;
	}

	public String getfventa() {
		return this.fventa;
	}

	public void setfventa(String fventa) {
		this.fventa = fventa;
	}

	public Integer getAnno() {
		return this.anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

};
