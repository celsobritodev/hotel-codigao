package teste;


import java.util.ArrayList;


import dominio.Reserva;
import persistencia.ReservaBD;

public class TesteDAORESERVA {
	
  public static void main (String[] args) {
	 
	// TestInserir();
	 TestAlterar();
	 // TestListar();
	  

  }
  
  
 public static void TestListar() {
	 ArrayList<Reserva> listaReservas = ReservaBD.listar();
     for(Reserva reserva:listaReservas) {
			System.out.println(reserva.getCodigo()+" "+reserva.getDataReserva()+" "+
            reserva.getDataCadastro()+" "+reserva.getQuantidadeDiarias());
		}
 }
   
 public static void TestAlterar() {
	 
	 Reserva reserva = new Reserva();
	 reserva.setCodigo(2);
	 reserva.setQuantidadeDiarias(7);
	 
	 ReservaBD.alterar(reserva);
 }
  
  
  public static void TestInserir() {
	
	  Reserva reserva = new Reserva();
	  reserva.setCodigo(2);
	  reserva.setQuantidadeDiarias(5);
	  
	  ReservaBD.inserir(reserva); 
  }
}
