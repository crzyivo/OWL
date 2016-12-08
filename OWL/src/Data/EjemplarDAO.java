package Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import jdbc.JDBCTemplate;


public class EjemplarDAO {

	public void insertarEjemplar (EjemplarVO ejemplar, JDBCTemplate jdbctemp){
		//No Connectuion, se trabajara con jdbtemplate
		try{
			 /* Create "preparedStatement". */
            String queryString = "INSERT INTO ejemplar " +
                "(libro, editorial, estado, precio, vendedor, comprador, ISBN, anno)"+
            		"VALUES (?,?,?,?,?,?,?,?)";
            
            
           jdbctemp.executeSentence(queryString, 
        		   ejemplar.getLibro(),
        		   ejemplar.getEditorial(),
        		   ejemplar.getEstado(),
        		   ejemplar.getPrecio(),
        		   ejemplar.getVendedor(),
        		   ejemplar.getComprador(),
        		   ejemplar.getISBN(),
        		   ejemplar.getAnno());

		}catch (Exception e){
			System.out.println("Error inserción ejemplar ");
		}
		
	}
	
	public void actualizarEjemplar (EjemplarVO ejemplar, JDBCTemplate jdbctemp) {     
        try{
            /* Create "preparedStatement". */
            String queryString = "UPDATE ejemplar " +
                "SET libro = ?, editorial = ?, estado = ?, " +
            	" precio = ?, vendedor = ?, comprador = ?, ISBN = ?, anno = ? WHERE  id = ?)";  
            jdbctemp.executeSentence(queryString, 
         		   ejemplar.getLibro(),
         		   ejemplar.getEditorial(),
         		   ejemplar.getEstado(),
         		   ejemplar.getPrecio(),
         		   ejemplar.getVendedor(),
         		   ejemplar.getComprador(),
         		   ejemplar.getISBN(),
         		   ejemplar.getAnno(),
         		   ejemplar.getId());
            
        } catch (Exception e) {
        	System.out.println("DAO-Error al actualizar ejemplar: ");
           // e.printStackTrace(System.err);
        }                
    } 
            
    public EjemplarVO obtenerEjemplar (int id, JDBCTemplate jdbctemp){     
    	EjemplarVO ejemplarVO = new EjemplarVO();
    	try{
            /* Create "preparedStatement". */
    		String sql="SELECT  libro, editorial, estado, precio, vendedor, comprador,"+
            		" ISBN, anno, id FROM ejemplar WHERE  id = '"+id+"'";                    
            
            /* Execute query. */   
            ArrayList<Object> resultSet=  jdbctemp.executeSentenceResult(sql);
                   
            
            /* Execute query. */  
            if(!resultSet.isEmpty()){
            int libro = Integer.parseInt((String) resultSet.get(0));
            String editorial = (String) resultSet.get(1);
            String estado = (String) resultSet.get(2);
            float precio = Float.parseFloat((String) resultSet.get(3));
            String vendedor = (String) resultSet.get(4);
            String comprador = (String) resultSet.get(5);
            String ISBN = (String) resultSet.get(6);
            int anno = Integer.parseInt((String) resultSet.get(7));
            int ids = Integer.parseInt((String) resultSet.get(8));
 
            ejemplarVO = new EjemplarVO (ids, libro, editorial, estado, precio,
            							vendedor, comprador, ISBN,anno);
            }
           
                
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    	return ejemplarVO;
    }
    
    public List<EjemplarVO> obtenerEjemplaresBy (String parametro, String valueifstring, int valueifint, JDBCTemplate jdbctemp){     
    	EjemplarVO ejemplarVO = new EjemplarVO ();
    	List<EjemplarVO> lista = new ArrayList <EjemplarVO>();
    	String sql="";
    	try{
    		if(parametro.equals("libro")||parametro.equals("anno")){
            /* Create "preparedStatement". */
    			sql="SELECT  libro, editorial, estado, precio, vendedor, comprador,"+
            		" ISBN, anno, id FROM ejemplar WHERE "+ parametro+" = " +"'"+valueifint+"'"+" ORDER BY precio asc";  
    		}
    		else if(parametro.equals("editorial")||parametro.equals("comprador")||parametro.equals("vendedor")){
    			/* Create "preparedStatement". */
    			sql="SELECT  libro, editorial, estado, precio, vendedor, comprador,"+
            		" ISBN, anno, id FROM ejemplar WHERE "+ parametro+" = " +"'"+valueifstring+"'"+" ORDER BY precio asc"; 
    			
    		}
            
            /* Execute query. */   
            ArrayList<Object> resultSet=  jdbctemp.executeSentenceResult(sql);
                   
            
            /* Execute query. */ 
            while(!resultSet.isEmpty()){
            int libro = Integer.parseInt((String) resultSet.get(0));
		    resultSet.remove(0);
            String editorial = (String) resultSet.get(0);
		    resultSet.remove(0);
            String estado = (String) resultSet.get(0);
		    resultSet.remove(0);
            float precio = Float.parseFloat((String) resultSet.get(0));
		    resultSet.remove(0);
            String vendedor = (String) resultSet.get(0);
		    resultSet.remove(0);
            String comprador = (String) resultSet.get(0);
		    resultSet.remove(0);
            String ISBN = (String) resultSet.get(0);
		    resultSet.remove(0);
            int anno = Integer.parseInt((String) resultSet.get(0));
		    resultSet.remove(0);
            int ids = Integer.parseInt((String) resultSet.get(0));
		    resultSet.remove(0);
            	
            
             ejemplarVO = new EjemplarVO (ids, libro, editorial, estado, precio,
            							vendedor, comprador, ISBN,anno);
             lista.add(ejemplarVO);
             
            }
                
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    	return lista;
    }
    
    
    
    public void borrarEjemplar (int id, JDBCTemplate jdbctemp){
		//No Connectuion, se trabajara con jdbtemplate
		try{
			 /* Create "preparedStatement". */
            String queryString = "DELETE * FROM ejemplar " +
                "WHERE id = "+id;
            
            
            jdbctemp.executeQuery(queryString);

		}catch (Exception e){
			System.out.println("DAO-Error al borrar ejemplar: ");
			System.out.println("DAO-Error: " + e.getMessage());
		}
		
	}

}
