import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ServicoMestre extends Remote {

	List<ServicoModel> servers = new ArrayList<ServicoModel>();

	void registerServer(String host, String serverName, Integer port) throws RemoteException;

	List<ServicoModel> getServers() throws RemoteException;

}