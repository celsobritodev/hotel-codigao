package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import dominio.Reserva;

public class ReservaBD {


	static Connection con = Conexao.getConnection();

	public static void inserir(Reserva novaReserva) {

		String sql = "INSERT INTO RESERVA (codigo,dataReserva,dataCadastro,quantidadeDiarias) values (?,?,?,?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, novaReserva.getCodigo());
			preparador.setDate(2, novaReserva.getDataReserva());
			preparador.setDate(3, novaReserva.getDataCadastro());
			preparador.setInt(4, novaReserva.getQuantidadeDiarias());
			preparador.execute();
			preparador.close();

			System.out.println("Cadastrado com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	public static void alterar(Reserva reservaAlterada) {
		excluir(reservaAlterada.getCodigo());
		inserir(reservaAlterada);
		
	}
	
	
	
	
	public static void excluir(int codigo) {

		String sql = "DELETE FROM RESERVA WHERE codigo=?";

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
	
	
	
	
	
	public static ArrayList<Reserva> listar() {

		String sql = "SELECT * FROM RESERVA";

		ArrayList<Reserva> lista = new ArrayList<>();

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {

				Reserva novaReserva = new Reserva();

				novaReserva.setCodigo(resultado.getInt("codigo"));
				novaReserva.setDataReserva(resultado.getDate("dataReserva"));
				novaReserva.setDataCadastro(resultado.getDate("dataCadastro"));
				novaReserva.setQuantidadeDiarias(resultado.getInt("quantidadeDiarias"));
				
				lista.add(novaReserva);
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
