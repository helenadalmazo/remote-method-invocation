import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServicoMestreImpl implements ServicoMestre {
	
	public ServicoMestreImpl() throws RemoteException {
		super();
	}
	
	@Override
	public void registerServer(String host, String serverName, Integer port) throws RemoteException {
		ServicoModel sm = new ServicoModel(host, serverName, port);
		servers.add(sm);
	}
	
	@Override
	public List<ServicoModel> getServers() throws RemoteException {
		return servers;
	}
}