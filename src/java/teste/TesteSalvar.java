package teste;

import dominio.Lider;
import persistencia.LiderBD;

/**
 *
 * @author Celso
 */
public class TesteSalvar {
    public static void main(String[] args) throws Exception {
        
       Lider lider1 = new Lider();
       lider1.setNome("Waldomiro");
       lider1.setCpf("171");
       LiderBD.inserir(lider1);
      /* 
       Lider lider2 = new Lider();
       lider2.setNome("Joao de Deus");
       lider2.setCpf("666");
       LiderBD.inserir(lider2);
       
       
       Lider lider3 = new Lider();
       lider3.setNome("Malafaia");
       lider3.setCpf("769");
       LiderBD.inserir(lider3);
       */
       
      // System.out.println("Cadastrado com sucesso");
    }
}
