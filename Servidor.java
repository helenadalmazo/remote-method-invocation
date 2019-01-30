import java.net.*;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class Servidor {
	public static void main(String args[]) {
		String serverName = "Server";
		String port = "1099";
		String host = "127.0.0.1";
		
		if (args.length > 0) {
			serverName = args[0];
		}
		
		if (args.length > 1) {
			port = args[1];
		}
		
		if (args.length > 2) {
			host = args[2];
		}
		
		try {
			ServicoImpl server = new ServicoImpl();
			Servico stub = (Servico) UnicastRemoteObject.exportObject(server, 0);
			Registry registry = LocateRegistry.createRegistry(Integer.valueOf(port));
			registry.rebind(serverName, stub);
			
			System.out.println(serverName+ " running on port " + port);
			
			Registry registryMasterServer = LocateRegistry.getRegistry("127.0.0.1", 9999);
			ServicoMestre stubMasterServer = (ServicoMestre) registryMasterServer.lookup("MasterServer");
			stubMasterServer.registerServer(host, serverName, Integer.valueOf(port));

			System.out.println("Servers available: " + stubMasterServer.getServers());
        } catch(Exception e) {
			e.printStackTrace();
			System.out.println("HelloServer erro"+ e.getMessage());
		}
	}
}