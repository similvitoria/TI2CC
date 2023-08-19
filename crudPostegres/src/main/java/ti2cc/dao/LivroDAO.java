package ti2cc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ti2cc.model.Livro;

public class LivroDAO extends DAO {
    public LivroDAO() {
        super();
        conectar();
    }

    public void finalize() {
        close();
    }

    //insert book into table 'livros'
    public boolean insert(Livro livro) {
        //data
        boolean status = false;

        try {
            Statement st = conexao.createStatement();
            String sql = "INSERT INTO livros (codigo, nome, autor, genero) " + "VALUES ("+livro.getCodigo()+ ", '" + livro.getNome() + "', '"  + livro.getAutor() + "', '" + livro.getGenero() + "');";
            System.out.println(sql);
            st.executeUpdate(sql);
            st.close();
            status = true;
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }

        return status;
    }

    //get book from table 'livros'
    public Livro get(int codigo) {
        //data
        Livro livro = null;

        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM livros WHERE codigo=" + codigo;
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            if ( rs.next() ) {
                livro = new Livro(rs.getInt("codigo"), rs.getString("nome"),rs.getString("autor"), rs.getString("genero"));
            }
            
            //close statement
            st.close();
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }

        return livro;
    }

    public List<Livro> get() {
        return get("");
    }

    public List<Livro> getOrderByCodigo() {
        return get("codigo");
    }

    public List<Livro> getOrderByNome() {
        return get("nome");
    }

    public List<Livro> getOrderByAutor() {
        return get("autor");
    }

    public List<Livro> getOrderByGenero() {
        return get("genero");
    }

    public List<Livro> get(String orderBy) {
        //data
        List<Livro> livros = new ArrayList<>();

        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM livros" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                Livro livro = new Livro(rs.getInt("codigo"), rs.getString("nome"),rs.getString("autor"), rs.getString("genero"));
                livros.add(livro);
            }
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }

        return livros;
    }

    public boolean uptade(Livro livro) {
        //data
        boolean status = false;

        try {
            Statement st = conexao.createStatement();
			String sql = "UPDATE livros SET nome = '" + livro.getNome() + "', autor = '"  
				       + livro.getAutor() + "', genero = '" + livro.getGenero() + "'"
					   + " WHERE codigo = " + livro.getCodigo();
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }

        return status;
    }

    public boolean delete(int codigo) {
        //data
        boolean status = false;

        try {
            Statement st = conexao.createStatement();
            String sql = "DELETE FROM livros WHERE codigo = " + codigo;
            System.out.println(sql);
            st.executeUpdate(sql);
            st.close();
            status = true;
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }

        return status;
    }

    public boolean autenticar(String nome, String autor, String genero) {
        //data  
		boolean resp = false;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM livros WHERE nome LIKE '" + nome + "' AND autor LIKE '" + autor + "' AND genero LIKE '" + genero  + "'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			resp = rs.next();
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return resp;
	}
}
