package controllers;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import entities.Pessoa;
import repositories.PessoaRepository;

public class PessoaController {

	public void cadastrarPessoa() throws Exception {
		
		System.out.println("\nCADASTRO DE PESSOA:\n");
		Scanner scanner = new Scanner(System.in);
		
		Pessoa pessoa = new Pessoa();
		pessoa.setId(UUID.randomUUID());
		
		System.out.print("INFORME O NOME......: ");
		pessoa.setNome(scanner.nextLine());
		
		System.out.print("INFORME O EMAIL.....: ");
		pessoa.setEmail(scanner.nextLine());
		
		System.out.print("INFORME O CPF.......: ");
		pessoa.setCpf(scanner.nextLine());
		
		PessoaRepository pessoaRepository = new PessoaRepository();
		pessoaRepository.create(pessoa);
		
		System.out.println("\nPESSOA CADASTRADO COM SUCESSO!");
		
		scanner.close();
	}

	public void atualizarPessoa() throws Exception {

		System.out.println("\nEDIÇÃO DE PESSOA:\n");
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("INFORME O ID........: ");
		UUID id = UUID.fromString(scanner.nextLine());
		
		PessoaRepository pessoaRepository = new PessoaRepository();
		Pessoa pessoa = pessoaRepository.findById(id);
		
		//verificar se a pessoa foi encontrada
		if(pessoa != null) {
			
			System.out.print("INFORME O NOME......: ");
			pessoa.setNome(scanner.nextLine());
			
			System.out.print("INFORME O EMAIL.....: ");
			pessoa.setEmail(scanner.nextLine());
			
			System.out.print("INFORME O CPF.......: ");
			pessoa.setCpf(scanner.nextLine());
			
			//atualizando o registro de pessoa no banco de dados
			pessoaRepository.update(pessoa);
			
			System.out.println("\nPESSOA ATUALIZADA COM SUCESSO!");
		}
		else {
			System.out.println("\nPESSOA NÃO ENCONTRADA. VERIFIQUE O ID.");
		}
		
		scanner.close();
	}

	public void excluirPessoa() throws Exception {
		
		System.out.println("\nEXCLUSÃO DE PESSOA:\n");
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("INFORME O ID........: ");
		UUID id = UUID.fromString(scanner.nextLine());
		
		PessoaRepository pessoaRepository = new PessoaRepository();
		Pessoa pessoa = pessoaRepository.findById(id);
		
		//verificando se pessoa foi encontrado
		if(pessoa != null) {
			
			//excluindo o registro no banco de dados
			pessoaRepository.delete(pessoa);
			
			System.out.println("\nPESSOA EXCLUÍDA COM SUCESSO!");
		}
		else {
			System.out.println("\nPESSOA NÃO ENCONTRADA. VERIFIQUE O ID.");
		}
		
		scanner.close();
	}

	public void consultarPessoas() throws Exception {

		System.out.println("\nCONSULTA DE PESSOAS:\n");
		
		//consultar todas as pessoas cadastradas
		PessoaRepository pessoaRepository = new PessoaRepository();
		List<Pessoa> lista = pessoaRepository.findAll();
		
		for(Pessoa pessoa : lista) {
			
			System.out.println("ID DA PESSOA...: " + pessoa.getId());
			System.out.println("NOME...........: " + pessoa.getNome());
			System.out.println("EMAIL..........: " + pessoa.getEmail());
			System.out.println("CPF............: " + pessoa.getCpf());
			System.out.println("...");
		}		
	}
}






