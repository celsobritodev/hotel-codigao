package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dominio.Romaria;

public class RomariaBD {
	static Connection con = Conexao.getConnection();

	public static void inserir(Romaria novaRomaria) {

		String sql = "INSERT INTO ROMARIA (codigo,quantidadeCasais,quantidadeSolteiros,quantidadeCriancas) values (?,?,?,?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, novaRomaria.getCodigo());
			preparador.setInt(2, novaRomaria.getQuantidadeCasais());
			preparador.setInt(3, novaRomaria.getQuantidadeSolteiros());
			preparador.setInt(4, novaRomaria.getQuantidadeCriancas());
			preparador.execute();
			preparador.close();

			System.out.println("Cadastrada com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	public static void alterar(Romaria romariaAlterada) {
		excluir(romariaAlterada.getCodigo());
		inserir(romariaAlterada);
		
	}
	
	
	
	
	public static void excluir(int codigo) {

		String sql = "DELETE FROM ROMARIA WHERE codigo=?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, codigo);
			preparador.execute();
			preparador.close();

			System.out.println("Excluida com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	
	
	public static ArrayList<Romaria> listar() {

		String sql = "SELECT * FROM ROMARIA";

		ArrayList<Romaria> lista = new ArrayList<>();

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {

				Romaria novaRomaria = new Romaria();

				novaRomaria.setCodigo(resultado.getInt("codigo"));
				novaRomaria.setQuantidadeCasais(resultado.getInt("quantidadeCasais"));
				novaRomaria.setQuantidadeSolteiros(resultado.getInt("quantidadeSolteiros"));
				novaRomaria.setQuantidadeCriancas(resultado.getInt("quantidadeCriancas"));				
				
				lista.add(novaRomaria);
			}

			preparador.close();

			System.out.println("Listadas com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
   
	}
	

}
