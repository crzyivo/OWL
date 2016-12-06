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
            String queryString = "INSERT INTO libroF " +
                "(id, libro, editorial, estado, precio, vendedor, comprador, ISBN, anno)"+
            		"VALUES (?,?,?,?,?,?,?,?,?)";
            
            
           jdbctemp.executeSentence(queryString, 
        		   ejemplar.getId(),
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
            String queryString = "UPDATE libroF " +
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
            
    public EjemplarVO obtenerEjemplar (String id, JDBCTemplate jdbctemp){     
    	EjemplarVO ejemplarVO = new EjemplarVO();
    	try{
            /* Create "preparedStatement". */
    		String sql="SELECT  libro, editorial, estado, precio, vendedor, comprador,"+
            		" ISBN, anno, id FROM libroF WHERE  id = '"+id+"'";                    
            
            /* Execute query. */   
            ArrayList<Object> resultSet=  jdbctemp.executeSentenceResult(sql);
                   
            
            /* Execute query. */  
            if(!resultSet.isEmpty()){
            int libro = (int) resultSet.get(0);
            String editorial = (String) resultSet.get(1);
            String estado = (String) resultSet.get(2);
            float precio = (float) resultSet.get(3);
            String vendedor = (String) resultSet.get(4);
            String comprador = (String) resultSet.get(5);
            String ISBN = (String) resultSet.get(6);
            int anno = (int) resultSet.get(7);
            int ids = (int) resultSet.get(8);
 
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
            		" ISBN, anno, id FROM libroF WHERE "+ parametro+" = " +"'"+valueifint+"'";  
    		}
    		else if(parametro.equals("editorial")||parametro.equals("comprador")||parametro.equals("vendedor")){
    			/* Create "preparedStatement". */
    			sql="SELECT  libro, editorial, estado, precio, vendedor, comprador,"+
            		" ISBN, anno, id FROM libroF WHERE "+ parametro+" = " +"'"+valueifstring+"'"; 
    			
    		}
            
            /* Execute query. */   
            ArrayList<Object> resultSet=  jdbctemp.executeSentenceResult(sql);
                   
            
            /* Execute query. */ 
            int i=0;
            for(i=0;i>-1;i=i+9){
            if(!resultSet.isEmpty()){
            int libro = (int) resultSet.get(i);
            String editorial = (String) resultSet.get(i+1);
            String estado = (String) resultSet.get(i+2);
            float precio = (float) resultSet.get(i+3);
            String vendedor = (String) resultSet.get(i+4);
            String comprador = (String) resultSet.get(i+5);
            String ISBN = (String) resultSet.get(i+6);
            int anno = (int) resultSet.get(i+7);
            int ids = (int) resultSet.get(i+8);
            	
            
             ejemplarVO = new EjemplarVO (ids, libro, editorial, estado, precio,
            							vendedor, comprador, ISBN,anno);
             lista.add(ejemplarVO);
             
            }
            else{i=-2;}
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
            String queryString = "DELETE * FROM libroF " +
                "WHERE id = "+id;
            
            
            jdbctemp.executeQuery(queryString);

		}catch (Exception e){
			System.out.println("DAO-Error al borrar ejemplar: ");
			System.out.println("DAO-Error: " + e.getMessage());
		}
		
	}

}
