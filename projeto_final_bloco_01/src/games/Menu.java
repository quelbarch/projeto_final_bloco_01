package games;

import java.util.InputMismatchException;
import java.util.Scanner;
import games.util.Cores;

public class Menu {
	
	private static final Scanner leia = new Scanner (System.in);

	public static void main(String[] args) {
		
		int opcao;
		
		
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
                keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_YELLOW + "\nListar todos os Jogos\n\n");
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_YELLOW + "\nBuscar Jogo por ID\n\n");
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_YELLOW + "\nAtualizar Jogo\n\n");
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_YELLOW + "\nDeletar Jogo \n\n");
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
		            System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND + "*************************************************************");
		            System.out.println(Cores.TEXT_YELLOW + "Projeto Desenvolvido por Raquel                              ");
		            System.out.println("Generation Brasil - raqueln@genstudents.org                  ");
		            System.out.println("Github: https://github.com/quelbarch                         ");
		            System.out.println("                                                             ");
		            System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND + 
		            		"*************************************************************" + Cores.TEXT_RESET);
	}
			   public static void keyPress() {
	    			System.out.println(Cores.TEXT_YELLOW + "\n\nPressione Enter para continuar...");
	    			leia.nextLine();
			   }
}
