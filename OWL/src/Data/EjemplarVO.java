
package Data;

public class EjemplarVO{
	
	private int id;
	private int libro;
	private String editorial;
	private String estado; //excelente, bueno o deteriorado
	private float precio;
	private String vendedor;
	private String comprador;
	private String ISBN;
	private int anno;
	
	public EjemplarVO() {
		this.id=-1;
		this.libro=-1;
		this.editorial="--";
		this.estado = "No inicializado";
		this.precio = -1;
		this.vendedor=null;
		this.comprador = null;
		this.ISBN = null;
		this.anno=0000;

		
	}
	
	public EjemplarVO( int id, int libro, String editorial, String estado, 
		float precio, String vendedor, String comprador, String ISBN, int anno){
		this.id=id;
		this.libro=libro;
		this.editorial=editorial;
		this.estado = estado;
		this.precio = precio;
		this.vendedor=vendedor;
		this.comprador = comprador;
		this.ISBN = ISBN;
		this.anno=anno;		
	}
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLibro() {
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

	public float getPrecio() {
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

	public int getAnno() {
		return this.anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}
	
	
};