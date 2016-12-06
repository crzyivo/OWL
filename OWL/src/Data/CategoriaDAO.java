package Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JDBCTemplate;

//TODO: Método a parte para aumentar el numero de libros libros a una categoria sin hacer updateCategoria
//TODO: Control de errores
public class CategoriaDAO {

	
	public void insertarCategoria (CategoriaVO categoria, JDBCTemplate jdbctemp){
		//No Connectuion, se trabajara con jdbtemplate
		try{
			 /* Create "preparedStatement". */
            String queryString = "INSERT INTO categoria " +
                "(nombre, nlibros "+
            		"VALUES (?,?)";
            
            
           jdbctemp.executeSentence(queryString, 
        		   categoria.getNombre(),
        		   categoria.getNLibros());

		}catch (Exception e){
			System.out.println("Error inserción categoria ");
		}
		
	}
	
	public void annadirLibroaCategoria (CategoriaVO categoria, LibroVO libro, JDBCTemplate jdbctemp){
		//No Connectuion, se trabajara con jdbtemplate
		try{
			 /* Create "preparedStatement". */
            String queryString = "INSERT INTO pertenece " +
                "(categoria, titulo, autor "+
            		"VALUES (?,?,?)";
            
            
           jdbctemp.executeSentence(queryString, 
        		   categoria.getNombre(),
        		   libro.getTitulo(),
        		   libro.getAutor());
           
           CategoriaVO cat2 = new CategoriaVO(categoria.getNombre(),categoria.getNLibros()+1);
           
           actualizarCategoria(cat2,jdbctemp);

		}catch (Exception e){
			System.out.println("Error inserción libro a categoria ");
		}
		
	}
	
	public void actualizarCategoria (CategoriaVO categoria, JDBCTemplate jdbctemp) {     
        try{
            /* Create "preparedStatement". */
            String queryString = "UPDATE categoria " +
                "SET nombre = ?, nlibros = ?,  WHERE  nombre = ?)";  
            jdbctemp.executeSentence(queryString, 
         		   categoria.getNombre(),
         		   categoria.getNLibros(),
         		   categoria.getNombre());
            
        } catch (Exception e) {
        	System.out.println("DAO-Error al actualizar categoria: ");
           // e.printStackTrace(System.err);
        }                
    } 
            
    public List<LibroVO> obtenerLibrosInCategoria ( String nombre,JDBCTemplate jdbctemp){     
    	LibroVO libroVO = new LibroVO ();
    	List<LibroVO> lista = new ArrayList <LibroVO>();
    	String sql="";
    	try{
    		
            /* Create "preparedStatement". */
    			sql="SELECT  l.titulo, l.autor, descripcion, ventas, id"+
                		"  FROM libro l,pertenece p WHERE "+ "p.categoria"+" = " +"'"+nombre+"'"
                		+"and p.titulo=l.titulo and p.autor=l.autor"; 

            
            /* Execute query. */   
            ArrayList<Object> resultSet=  jdbctemp.executeSentenceResult(sql);
                   
            
            /* Execute query. */ 
            int i=0;
            for(i=0;i>-1;i=i+5){
            if(!resultSet.isEmpty()){
            String titulo = (String) resultSet.get(i);
            String autort = (String) resultSet.get(i+1);
            String descripcion = (String) resultSet.get(i+2);
            int ventas = Integer.parseInt((String) resultSet.get(i+3));
            int id = Integer.parseInt((String) resultSet.get(i+4));
            	
            
           	libroVO = new LibroVO (id, titulo, autort, descripcion, ventas);
           	lista.add(libroVO);
             
            }
            else{i=-2;}
            }
                
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    	return lista;
    }
    
    public List<CategoriaVO> obtenerCategorias ( JDBCTemplate jdbctemp){     
    	CategoriaVO categoriaVO = new CategoriaVO ();
    	List<CategoriaVO> lista = new ArrayList <CategoriaVO>();
    	String sql="";
    	try{
    		
            /* Create "preparedStatement". */
    			sql="SELECT nombre,nibros FROM categoria";  

            
            /* Execute query. */   
            ArrayList<Object> resultSet=  jdbctemp.executeSentenceResult(sql);
                   
            
            /* Execute query. */ 
            int i=0;
            for(i=0;i>-1;i=i+2){
            if(!resultSet.isEmpty()){
            String nombre = (String) resultSet.get(i);
            int nlibros = Integer.parseInt((String) resultSet.get(i+1));
            
           	categoriaVO = new CategoriaVO (nombre,nlibros);
           	lista.add(categoriaVO);
             
            }
            else{i=-2;}
            }
                
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    	return lista;
    }
    
    
    
    public void borrarCategoria (String nombre, JDBCTemplate jdbctemp){
		//No Connectuion, se trabajara con jdbtemplate
		try{
			 /* Create "preparedStatement". */
            String queryString = "DELETE * FROM categoria " +
                "WHERE nombre = "+nombre;
            
            
            jdbctemp.executeQuery(queryString);

		}catch (Exception e){
			System.out.println("DAO-Error al borrar categoria: ");
			System.out.println("DAO-Error: " + e.getMessage());
		}
		
	}

}