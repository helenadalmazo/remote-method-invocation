import java.net.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.List;
import java.util.Scanner;

public class Cliente {
	
	static Servico stubServer;
	
	public static void main(String args[]) {
		try {
			getAvailableServer();
			
			Scanner scan = new Scanner(System.in);
			Scanner scan1 = new Scanner(System.in);
			String mensagem = "";
			int opcao;
			
			boolean retry = false;
			
			while(true) {
				if (retry) {
					String retorno = stubServer.echo("cliente1", mensagem);
					System.out.println(retorno);
					retry = false;
					continue;
				}
				
				System.out.println("####################################");
				System.out.println("Bem vindo(a), selecione uma opcao:");
				System.out.println("1. Ecoar mensagem.");
				System.out.println("2. Visualizar mensagens.");
				System.out.println("####################################");
				
				opcao = scan.nextInt();
				
				try {
					if(opcao == 1) {
						System.out.print("Digite a mensagem: ");
						mensagem = scan1.nextLine();
						String retorno = stubServer.echo("cliente1", mensagem);
						System.out.println(retorno);
					}
					else if (opcao == 2) {
						List<String> retorno =stubServer.getListOfMsg("cliente1");
						System.out.println(retorno);
					}
					else {
						System.out.println("Ops, tente uma nova opcao.");
					}
				} catch (Exception e) {
					if (getAvailableServer() == null) {
						System.out.println("Nenhum servidor encontra-se disponível, tente novamente mais tarde.");
					} else {
						retry = true;
					}
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	public static ServicoModel getAvailableServer() {
		try {
			Registry registryMasterServer = LocateRegistry.getRegistry("127.0.0.1", 9999);
			ServicoMestre stubMasterServer = (ServicoMestre) registryMasterServer.lookup("MasterServer");
			
			for (ServicoModel sm : stubMasterServer.getServers()) {
				try {
					Registry registryServer= LocateRegistry.getRegistry(sm.getHost(), sm.getPort());
					stubServer = (Servico) registryServer.lookup(sm.getServerName());
					return sm;
				} catch (Exception e) {
					System.out.println(sm + " not available");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
}