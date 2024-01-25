package principal;

import java.util.Scanner;

import controllers.PessoaController;

public class Main {

	public static void main(String[] args) {

		System.out.println("\nSISTEMA PARA CONTROLE DE PESSOAS\n");
		Scanner scanner = new Scanner(System.in);

		try {
			
			System.out.println("(1) CADASTRAR PESSOA");
			System.out.println("(2) ATUALIZAR PESSOA");
			System.out.println("(3) EXCLUIR PESSOA");
			System.out.println("(4) CONSULTAR PESSOAS");
			
			System.out.print("\nINFORME A OPÇÃO DESEJADA: ");
			Integer opcao = Integer.parseInt(scanner.nextLine());
			
			PessoaController pessoaController = new PessoaController();
			
			switch(opcao) {
			case 1:
				pessoaController.cadastrarPessoa();
				break;
			case 2:
				pessoaController.atualizarPessoa();
				break;
			case 3:
				pessoaController.excluirPessoa();
				break;
			case 4:
				pessoaController.consultarPessoas();
				break;
			default:
				System.out.println("\nOPÇÃO INVÁLIDA!");
				break;
			}
		}
		catch(Exception e) {
			System.out.println("\nOCORREU UM ERRO: " + e.getMessage());
		}
		finally {
			scanner.close();
		}
	}
}
