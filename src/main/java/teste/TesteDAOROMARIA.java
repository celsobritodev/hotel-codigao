package teste;


import java.util.ArrayList;


import dominio.Reserva;
import dominio.Romaria;
import persistencia.ReservaBD;
import persistencia.RomariaBD;

public class TesteDAOROMARIA {
	
  public static void main (String[] args) {
	 
// TestInserir();
	 TestAlterar();
	// TestListar();
	  

  }
  
  
 public static void TestListar() {
	 ArrayList<Romaria> listaRomarias = RomariaBD.listar();
     for(Romaria romaria:listaRomarias) {
			System.out.println(romaria.getCodigo()+" "+romaria.getQuantidadeCasais()+" "+
            romaria.getQuantidadeSolteiros()+" "+romaria.getQuantidadeCriancas());
		}
 }
   
 public static void TestAlterar() {
	 
	 Romaria romaria = new Romaria();
	 romaria.setCodigo(2);
	 romaria.setQuantidadeCasais(17);
	 romaria.setQuantidadeSolteiros(29);
	 romaria.setQuantidadeCriancas(35);
	 
	 RomariaBD.alterar(romaria);
 }
  
  
  public static void TestInserir() {
	
	  Romaria romaria = new Romaria();
	  romaria.setCodigo(2);
	  romaria.setQuantidadeCasais(45);
	  romaria.setQuantidadeSolteiros(62);
	  romaria.setQuantidadeCriancas(139);
	  
	  RomariaBD.inserir(romaria); 
  }
}
