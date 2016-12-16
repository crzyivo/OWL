package Data;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.es.SpanishAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import jdbc.JDBCTemplate;

//TODO Método para incrementar ventas en N.

public class LibroDAO {

	public void insertarLibro(LibroVO libro, JDBCTemplate jdbctemp) {
		// No Connectuion, se trabajara con jdbtemplate
		try {
			/* Create "preparedStatement". */
			String queryString = "INSERT INTO libro " + "(id, titulo, autor, descripcion, ventas,"
					+ "VALUES (?,?,?,?,?)";

			jdbctemp.executeSentence(queryString, libro.getId(), libro.getTitulo(), libro.getAutor(),
					libro.getDescripcion(), libro.getVentas());

		} catch (Exception e) {
			System.out.println("Error inserción libro ");
		}

	}

	public void actualizarLibro(LibroVO libro, JDBCTemplate jdbctemp) {
		try {
			/* Create "preparedStatement". */
			String queryString = "UPDATE libro " + "SET titulo = ?, autor = ?, descripcion = ?, "
					+ " ventas = ? WHERE  id = ?)";
			jdbctemp.executeSentence(queryString, libro.getTitulo(), libro.getAutor(), libro.getDescripcion(),
					libro.getVentas(), libro.getId());

		} catch (Exception e) {
			System.out.println("DAO-Error al actualizar libro: ");
			// e.printStackTrace(System.err);
		}
	}

	public LibroVO obtenerlibro(int id, JDBCTemplate jdbctemp) {
		LibroVO libroVO = new LibroVO();
		try {
			/* Create "preparedStatement". */
			String sql = "SELECT  titulo, autor, descripcion, ventas, id" + "  FROM libro WHERE  id = '" + id + "'";

			/* Execute query. */
			ArrayList<Object> resultSet = jdbctemp.executeSentenceResult(sql);

			/* Execute query. */
			if (!resultSet.isEmpty()) {
				String titulo = (String) resultSet.get(0);
				String autor = (String) resultSet.get(1);
				String descripcion = (String) resultSet.get(2);
				Integer ventas = Integer.parseInt((String) resultSet.get(3));
				int ids = Integer.parseInt((String) resultSet.get(4));

				libroVO = new LibroVO(ids, titulo, autor, descripcion, ventas);
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return libroVO;
	}

	public List<LibroVO> obtenerLibrosByAutor(String autor, JDBCTemplate jdbctemp) {
		LibroVO libroVO = new LibroVO();
		List<LibroVO> lista = new ArrayList<LibroVO>();
		String sql = "";
		try {

			/* Create "preparedStatement". */
			sql = "SELECT  titulo, autor, descripcion, ventas, id" + "  FROM libro WHERE " + "autor" + " = " + "'"
					+ autor + "'";

			/* Execute query. */
			ArrayList<Object> resultSet = jdbctemp.executeSentenceResult(sql);

			/* Execute query. */
			while (!resultSet.isEmpty()) {
				String titulo = (String) resultSet.get(0);
				resultSet.remove(0);
				String autort = (String) resultSet.get(0);
				resultSet.remove(0);
				String descripcion = (String) resultSet.get(0);
				resultSet.remove(0);
				int ventas = Integer.parseInt((String) resultSet.get(0));
				resultSet.remove(0);
				int id = Integer.parseInt((String) resultSet.get(0));
				resultSet.remove(0);

				libroVO = new LibroVO(id, titulo, autort, descripcion, ventas);
				lista.add(libroVO);
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return lista;
	}

	public List<LibroVO> obtenerLibrosByVenta(JDBCTemplate jdbctemp) {
		LibroVO libroVO = new LibroVO();
		List<LibroVO> lista = new ArrayList<LibroVO>();
		String sql = "";
		try {

			/* Create "preparedStatement". */
			sql = "SELECT  titulo, autor, descripcion, ventas, id" + "  FROM libro ORDER BY ventas desc LIMIT 5";

			/* Execute query. */
			ArrayList<Object> resultSet = jdbctemp.executeSentenceResult(sql);

			/* Execute query. */
			while (!resultSet.isEmpty()) {
				String titulo = (String) resultSet.get(0);
				resultSet.remove(0);
				String autort = (String) resultSet.get(0);
				resultSet.remove(0);
				String descripcion = (String) resultSet.get(0);
				resultSet.remove(0);
				int ventas = Integer.parseInt((String) resultSet.get(0));
				resultSet.remove(0);
				int id = Integer.parseInt((String) resultSet.get(0));
				resultSet.remove(0);

				libroVO = new LibroVO(id, titulo, autort, descripcion, ventas);
				lista.add(libroVO);
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return lista;
	}

	public void borrarLibro(int id, JDBCTemplate jdbctemp) {
		// No Connectuion, se trabajara con jdbtemplate
		try {
			/* Create "preparedStatement". */
			String queryString = "DELETE * FROM libro " + "WHERE id = " + id;

			jdbctemp.executeQuery(queryString);

		} catch (Exception e) {
			System.out.println("DAO-Error al borrar libro: ");
			System.out.println("DAO-Error: " + e.getMessage());
		}

	}public List<LibroVO> busquedaLibros(String searchString, JDBCTemplate jdbctemp) {
		LibroVO libroVO = new LibroVO();
		List<LibroVO> lista = new ArrayList<LibroVO>();
		String sql = "";
		try {
			//mysql.indexaLibroSQL();
			File FILE_INDEX_DIRECTORY = new File("../Database/Index");
			Directory INDEX_DIRECTORY_ = FSDirectory.open(FILE_INDEX_DIRECTORY);
			DirectoryReader directoryReader = DirectoryReader.open(INDEX_DIRECTORY_);
			IndexSearcher buscador = new IndexSearcher(directoryReader);
			Analyzer analizador = new SpanishAnalyzer(Version.LUCENE_40);
			
			//QueryParser queryParser = new QueryParser(Version.LUCENE_40, "titulo", analizador);
			MultiFieldQueryParser queryParser = new MultiFieldQueryParser(Version.LUCENE_40,new String[]{"titulo","autor"}, analizador);
			Query query =queryParser.parse(searchString);
			TopDocs resultado = buscador.search(query, 10);
			ScoreDoc[] hits = resultado.scoreDocs;
			  
			System.out.println("Found " + hits.length + " hits.");
			for(int i=0;i<hits.length;++i) {
				int docId = hits[i].doc;
				Document doc = buscador.doc(docId);
				System.out.println((i + 1) + ". " + doc.get("id") +doc.get("autor")+ "\t" + hits[i].score);
				String titulo = (String) doc.get("titulo");
				String autor = (String) doc.get("autor");
				String descripcion = (String) doc.get("descripcion");
				Integer ventas = Integer.parseInt((String) doc.get("ventas"));
				int ids = Integer.parseInt((String) doc.get("id"));
				libroVO = new LibroVO(ids, titulo, autor, descripcion, ventas);
				lista.add(libroVO);
			}
			return lista;

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return lista;
	}
	
	

}