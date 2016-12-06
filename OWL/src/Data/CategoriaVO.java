package Data;

public class CategoriaVO{
	
	private int nlibros;
	private String nombre;


	
	public CategoriaVO() {
		this.nlibros = -1;
		this.nombre = "Catgoria Vacía";
		
	}
	
	public CategoriaVO(String nombre, int nlibros){
		this.nombre = nombre;
		this.nlibros = nlibros;	
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNLibros() {
		return this.nlibros;
	}

	public void setNLibros(int nlibros) {
		this.nlibros = nlibros;
	}
	
};