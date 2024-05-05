package teste;

import dominio.Lider;
import persistencia.LiderBD;

public class TesteSalvar {
  public static void main (String[] args) {
	 
	  Lider lider = new Lider();
	  lider.setNome("vai corintia");
	  lider.setCpf("123");
	  LiderBD.inserir(lider);
	  
	  System.out.println("Cadastrado com sucesso");	
  }
}
