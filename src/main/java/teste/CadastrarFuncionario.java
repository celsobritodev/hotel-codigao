package teste;

import dominio.Funcionario;
import persistencia.FuncionarioBD;

public class CadastrarFuncionario {

	public static void main(String[] args) {
		 Funcionario funcionario = new Funcionario();
		 funcionario.setLogin("leandro");
		 funcionario.setSenha("leandro");
		 funcionario.setCodigo(1);
		 FuncionarioBD.inserir(funcionario);

	}

}
