package teste;


import java.util.ArrayList;


import dominio.Lider;
import persistencia.LiderBD;

public class TesteDAOLIDER {
	
  public static void main (String[] args) {
	 
	// TestInserir();
	 //TestAlterar();
	  TestListar();
	  

  }
  
  
 public static void TestListar() {
	 ArrayList<Lider> listaLideres = LiderBD.listar();
     for(Lider lider:listaLideres) {
			System.out.println(lider.getCpf()+" "+lider.getNome()+" "+
            lider.getTelefone()+" "+lider.getDataNascimento());
		}
 }
   
 public static void TestAlterar() {
	 
	 Lider lider = new Lider();
	 lider.setCpf("123456");
	 lider.setNome("Paçoquinha");
	 
	 LiderBD.alterar(lider);
 }
  
  
  public static void TestInserir() {
	
	  Lider lider = new Lider();
	  lider.setNome("outro lider");
	  lider.setCpf("2233456");
	  
	  LiderBD.inserir(lider); 
  }
}
