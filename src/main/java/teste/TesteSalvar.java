package teste;

import dominio.Lider;
import persistencia.LiderBD;

public class TesteSalvar {
  public static void main (String[] args) {
	 

	  Lider lider = new Lider();
	  lider.setNome("outro lider");
	  lider.setCpf("123456");
	
	  LiderBD.inserir(lider);
	  
	  System.out.println("Cadastrado com sucesso");	
  }
}
