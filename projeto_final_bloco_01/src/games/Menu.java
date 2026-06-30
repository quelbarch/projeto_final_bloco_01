package games;

import java.util.InputMismatchException;
import java.util.Scanner;

import games.controller.Controller;
import games.model.Jogo;
import games.util.Cores;

public class Menu {
	
	private static final Scanner leia = new Scanner (System.in);
	
	private static final Controller controller = new Controller();

	public static void main(String[] args) {
		
		int opcao;
		
		criarProdutosTeste();
		
		
		while (true) {
			
			System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND 
					+ "\n*************************************************************");
			System.out.println("                                                             ");
			System.out.println("                  BEM-VINDO À RB GAME STORE 🎮               ");
			System.out.println("                                                             ");
			System.out.println("*************************************************************" + Cores.TEXT_RESET);
			System.out.println(Cores.TEXT_YELLOW+ Cores.ANSI_BLACK_BACKGROUND 
					+ "                                                             ");
			System.out.println("                 1- Cadastrar Jogo                           ");
			System.out.println("                 2- Listar todos os Jogos                    ");
			System.out.println("                 3- Buscar Jogo por ID                       ");
			System.out.println("                 4- Atualizar Jogo                           ");
			System.out.println("                 5- Deletar Jogo                             ");
			System.out.println("                 0- Sair                                     ");
			System.out.println("                                                             ");
			System.out.println(Cores.TEXT_GREEN + "*************************************************************");
			System.out.println("Entre com a opção desejada:                                  ");
			System.out.println("                                                             " + Cores.TEXT_RESET);
			
			try {
			    opcao = leia.nextInt();
			    leia.nextLine();
			}catch(InputMismatchException e) {
				opcao = -1;
				System.out.println("Digite um número inteiro entre 0 e 5");
				leia.nextLine();
			}
			
			if (opcao == 0) {
				System.out.println(Cores.TEXT_YELLOW + "\n\nRB GAME STORE 🎮\n");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {

			case 1:
				System.out.println(Cores.TEXT_YELLOW + "\nCadastrar Jogo\n\n");
				cadastrarJogo();
				keyPress();
				break;

			case 2:
				System.out.println(Cores.TEXT_YELLOW + "\nListar todos os Jogos\n\n");
				listarJogos();
				keyPress();
				break;

			case 3:
				System.out.println(Cores.TEXT_YELLOW + "\nBuscar Jogo por ID\n\n");
				buscarJogo();
				keyPress();
				break;

			case 4:
				System.out.println(Cores.TEXT_YELLOW + "\nAtualizar Jogo\n\n");
				atualizarJogo();
				keyPress();
				break;

			case 5:
				System.out.println(Cores.TEXT_YELLOW + "\nDeletar Jogo \n\n");
				deletarJogo();
				keyPress();
				break;

			default:
				System.out.println(Cores.TEXT_RED + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();
				break;
			}
		}
	}
	
	public static void sobre() {
		System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND
				+ "*************************************************************");
		System.out.println(Cores.TEXT_YELLOW + "Projeto Desenvolvido por Raquel                              ");
		System.out.println("Generation Brasil - raqueln@genstudents.org                  ");
		System.out.println("Github: https://github.com/quelbarch                         ");
		System.out.println("*************************************************************" + Cores.TEXT_RESET);
	}

	public static void keyPress() {
		System.out.println(Cores.TEXT_YELLOW + "\n\nPressione Enter para continuar...");
		leia.nextLine();
	}
	

	private static void criarProdutosTeste() {
		controller.cadastrar(new Jogo(0, "GTA V", 1 , 100, "PC, PlayStation, Xbox", true)
				);
	}

	public static void cadastrarJogo() {

		System.out.println("Nome do jogo: " + Cores.TEXT_RESET);
		String nome = leia.nextLine();

		System.out.println(Cores.TEXT_YELLOW + "Categoria do jogo:" + Cores.TEXT_RESET);
		System.out.println("1 - Ação");
		System.out.println("2 - RPG");
		System.out.println("3 - Terror");
		System.out.println("4 - Esporte");
		System.out.println("5 - Aventura");

		int categoria = leia.nextInt();
		leia.nextLine();

		System.out.println(Cores.TEXT_YELLOW + "Preço: \n"+ Cores.TEXT_RESET );
		float preco = leia.nextFloat();
		leia.nextLine();

		System.out.println(Cores.TEXT_YELLOW + "Plataformas disponíveis:");
		System.out.println("1 - PC");
		System.out.println("2 - PS4");
		System.out.println("3 - Xbox");
		System.out.println("4 - Nintendo Switch");

		System.out.println("Digite as opções separadas por vírgula (ex: 1,3,4): " + Cores.TEXT_RESET);
		String entrada = leia.nextLine();

		String plataformas = "";

		String[] escolhas = entrada.split(",");

		for (String e : escolhas) {
		    switch (e.trim()) {
		        case "1" -> plataformas += "PC ";
		        case "2" -> plataformas += "PS4 ";
		        case "3" -> plataformas += "Xbox ";
		        case "4" -> plataformas += "Nintendo Switch ";
		        default -> plataformas += "Desconhecido ";
		    }
		}

		System.out.println(Cores.TEXT_YELLOW + "Multijogador? (S/N): "+ Cores.TEXT_RESET);
		String resposta = leia.nextLine().trim().toLowerCase();

		boolean multijogador;

		if (resposta.startsWith("s")) {
		    multijogador = true;
		} else if (resposta.startsWith("n")) {
		    multijogador = false;
		} else {
		    System.out.println(Cores.TEXT_RED + "Opção inválida! Será definido como NÃO." + Cores.TEXT_RESET);
		    multijogador = false;
		}

		controller.cadastrar(new Jogo(0, nome, categoria, preco, plataformas, multijogador)
		);

		System.out.println(Cores.TEXT_BLUE + "\nJogo cadastrado!"+ Cores.TEXT_RESET);
	}

	public static void listarJogos() {
		controller.listarTodos();
	}

	public static void buscarJogo() {
		try {
	        System.out.println(Cores.TEXT_YELLOW + "Digite o ID: "+ Cores.TEXT_RESET);
	        int id = leia.nextInt();
	        leia.nextLine();

	        controller.buscarPorId(id);

	    } catch (InputMismatchException e) {
	        System.out.println(Cores.TEXT_YELLOW + "Digite apenas números inteiros!"+ Cores.TEXT_RESET);
	        leia.nextLine();
	    }
	}

	public static void atualizarJogo() {

	    System.out.println(Cores.TEXT_YELLOW + "Digite o ID: "+ Cores.TEXT_RESET);
	    int id = leia.nextInt();
	    leia.nextLine();

	    Jogo jogo = (Jogo) controller.buscarNaCollection(id);

	    if (jogo != null) {
	    	
	    	System.out.printf(Cores.TEXT_YELLOW + "Nome atual: %s%nDigite o novo nome (ENTER para manter): " + Cores.TEXT_RESET, jogo.getNome());
	        String entrada = leia.nextLine();
	        String nome = entrada.isEmpty() ? jogo.getNome() : entrada;

	        System.out.printf(Cores.TEXT_YELLOW + "Categoria atual: %d%nDigite a nova categoria (ENTER para manter): "+ Cores.TEXT_RESET, jogo.getCategoria());
	        entrada = leia.nextLine();
	        int categoria = entrada.isEmpty() ? jogo.getCategoria() : Integer.parseInt(entrada);

	        System.out.printf(Cores.TEXT_YELLOW + "Preço atual: %.2f%nDigite o novo preço (ENTER para manter): "+ Cores.TEXT_RESET, jogo.getPreco());
	        entrada = leia.nextLine();
	        float preco = entrada.isEmpty() ? jogo.getPreco() : Float.parseFloat(entrada.replace(",", "."));

	        System.out.printf(Cores.TEXT_YELLOW + "Plataformas atuais: %s%nDigite novas plataformas (ENTER para manter): "+ Cores.TEXT_RESET, jogo.getPlataformas());
	        entrada = leia.nextLine();
	        String plataformas = entrada.isEmpty() ? jogo.getPlataformas() : entrada;


	        System.out.printf(Cores.TEXT_YELLOW + "Multijogador atual: %s%n(S/N, ENTER mantém): "+ Cores.TEXT_RESET, jogo.getMultijogador() ? "Sim" : "Não");
	        entrada = leia.nextLine().trim().toLowerCase();

	        boolean multijogador;
	        if (entrada.isEmpty()) {
	            multijogador = jogo.getMultijogador();
	        } else if (entrada.startsWith("s")) {
	            multijogador = true;
	        } else if (entrada.startsWith("n")) {
	            multijogador = false;
	        } else {
	            System.out.println(Cores.TEXT_RED + "Entrada inválida! Mantendo valor atual."+ Cores.TEXT_RESET);
	            multijogador = jogo.getMultijogador();
	        }

	        controller.atualizar(
	            new Jogo(id, nome, categoria, preco, plataformas, multijogador)
	        );

	    } else {
	        System.out.println(Cores.TEXT_RED +"Jogo não encontrado!"+ Cores.TEXT_RESET);
	    }
	}

	public static void deletarJogo() {

		System.out.println(Cores.TEXT_YELLOW +"Digite o ID: "+ Cores.TEXT_RESET);
		int id = leia.nextInt();
		leia.nextLine();

		controller.deletar(id);
	}
}