import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.rmi.registry.*;
import java.net.*;

public class ServicoImpl implements Servico {
	
	public ServicoImpl() throws RemoteException {
		super();
	}
	
	@Override
	public String echo(String nomeCliente, String mensagem) throws RemoteException {
		saveHistoryOnOthersServers(nomeCliente, mensagem);
		return "> " + mensagem;
	}
	
	@Override
	public List<String> getListOfMsg(String nomeCliente) throws RemoteException {
		return mapaMensagens.get(nomeCliente);
	}
	
	public void addNewMessage(String nomeCliente, String mensagem) throws RemoteException {
		List<String> historicoMensagems = mapaMensagens.get(nomeCliente);
		if(historicoMensagems == null) {
			historicoMensagems = new ArrayList<String>();
		}
		historicoMensagems.add(mensagem);
		mapaMensagens.put(nomeCliente, historicoMensagems);		
	}
	
	public void saveHistoryOnOthersServers(String nomeCliente, String mensagem) {
		try {
			Registry registryMasterServer = LocateRegistry.getRegistry("127.0.0.1", 9999);
			ServicoMestre stubMasterServer = (ServicoMestre) registryMasterServer.lookup("MasterServer");
			System.out.println("server availables: " + stubMasterServer.getServers());
			
			for (ServicoModel sm : stubMasterServer.getServers()) {
				try {
					System.out.println("tentando conexao com o servidor: " + sm);
					Registry registryServer= LocateRegistry.getRegistry(sm.getHost(), sm.getPort());
					Servico stubServer = (Servico) registryServer.lookup(sm.getServerName());
					stubServer.addNewMessage(nomeCliente, mensagem);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			System.out.println("MasterServer not available");
		}		
	}
}