package persistencia;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import dominio.Lider;

public class LiderBD  {

	
	static Connection con = Conexao.getConnection();

	public static void inserir(Lider novoLider) {

		String sql = "INSERT INTO LIDER (cpf,nome,telefone,dataNascimento,cidade,estado) values (?,?,?,?,?,?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, novoLider.getCpf());
			preparador.setString(2, novoLider.getNome());
			preparador.setString(3, novoLider.getTelefone());
			preparador.setDate(4, novoLider.getDataNascimento());
			preparador.setString(5,novoLider.getCidade());
			preparador.setString(6,novoLider.getEstado());
			preparador.execute();
			preparador.close();

			System.out.println("Cadastrado com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	public static void alterar(Lider liderAlterado) {
		excluir(liderAlterado.getCpf());
		inserir(liderAlterado);
		
	}
	
	
	
	
	public static void excluir(String cpf) {

		String sql = "DELETE FROM LIDER WHERE cpf=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, cpf);
			preparador.execute();
			preparador.close();

			System.out.println("Excluido com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
    public static Lider getByCpf(String cpf) {
    	
    	String sql = "SELECT * FROM LIDER WHERE CPF=?";
		Lider lider = null;
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, cpf);

			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {
				lider = new Lider();
				lider.setCpf(resultado.getString("cpf"));
				lider.setNome(resultado.getString("nome"));
				lider.setTelefone(resultado.getString("telefone"));
				lider.setDataNascimento(resultado.getDate("dataNascimento"));
				lider.setCidade(resultado.getString("cidade"));
				lider.setEstado(resultado.getString("estado"));
				System.out.println("Buscado UM POR CPF com sucesso!");
			}
			preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lider;

    	
    }
	

    
    
	public static ArrayList<Lider> listar() {

		String sql = "SELECT * FROM LIDER";

		ArrayList<Lider> lista = new ArrayList<>();

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {

				Lider novoLider = new Lider();

				novoLider.setCpf(resultado.getString("cpf"));
				novoLider.setNome(resultado.getString("nome"));
				novoLider.setTelefone(resultado.getString("telefone"));
				novoLider.setDataNascimento(resultado.getDate("dataNascimento"));
				novoLider.setCidade(resultado.getString("cidade"));
				novoLider.setEstado(resultado.getString("estado"));

				lista.add(novoLider);
			}

			preparador.close();

			System.out.println("Listado todos com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
   
	}

}
