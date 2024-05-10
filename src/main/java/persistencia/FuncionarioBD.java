package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dominio.Funcionario;

public class FuncionarioBD {
	
	static Connection con = Conexao.getConnection();

	public static void inserir(Funcionario novoFuncionario) {

		String sql = "INSERT INTO FUNCIONARIO (codigo,login,senha) values (?,?,?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, novoFuncionario.getCodigo());
			preparador.setString(2, novoFuncionario.getLogin());
			preparador.setString(3, novoFuncionario.getSenha());
			preparador.execute();
			preparador.close();

			System.out.println("Cadastrado com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	public static void alterar(Funcionario funcionarioAlterado) {
		excluir(funcionarioAlterado.getCodigo());
		inserir(funcionarioAlterado);
		
	}
	
	
	
	
	public static void excluir(int codigo) {

		String sql = "DELETE FROM LIDER WHERE cpf=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, codigo);
			preparador.execute();
			preparador.close();

			System.out.println("Excluido com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
    public static Funcionario getByCodigo(int codigo) {
    	
    	String sql = "SELECT * FROM FUNCIONARIO WHERE CODIGO=?";
		Funcionario funcionario = null;
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, codigo);

			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {
				funcionario = new Funcionario();
				funcionario.setCodigo(resultado.getInt("codigo"));
				funcionario.setLogin(resultado.getString("login"));
				funcionario.setSenha(resultado.getString("senha"));
				
				System.out.println("Buscado UM POR Codigo com sucesso!");
			}
			preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return funcionario;

    	
    }
    
  public static Funcionario procurarPorLoginSenha(String login, String senha) {
    	
    	String sql = "SELECT * FROM FUNCIONARIO WHERE LOGIN=? AND SENHA=?";
		Funcionario funcionario = null;
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, login);
			preparador.setString(2, senha);

			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {
				funcionario = new Funcionario();
				funcionario.setCodigo(resultado.getInt("codigo"));
				funcionario.setLogin(resultado.getString("login"));
				funcionario.setSenha(resultado.getString("senha"));
				
				System.out.println("Buscado UM POR Codigo com sucesso!");
			}
			preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return funcionario;

    	
    }
	
	

    
    
	public static ArrayList<Funcionario> listar() {

		String sql = "SELECT * FROM FUNCIONARIO";

		ArrayList<Funcionario> lista = new ArrayList<>();

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {

				Funcionario novoFuncionario = new Funcionario();

				novoFuncionario.setCodigo(resultado.getInt("codigo"));
				novoFuncionario.setLogin(resultado.getString("login"));
				novoFuncionario.setSenha(resultado.getString("senha"));
				
				lista.add(novoFuncionario);
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
