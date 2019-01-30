import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServidorMestre {
	public static void main(String args[]) {
		try {
			ServicoMestreImpl server = new ServicoMestreImpl();
			ServicoMestre stub = (ServicoMestre) UnicastRemoteObject.exportObject(server, 0);
			Registry registry = LocateRegistry.createRegistry(9999);
			registry.rebind("MasterServer", stub);
			
			System.out.println("MasterServer running on port 9999");
	    } catch(Exception e) {
			e.printStackTrace();
	    }
	}
}
