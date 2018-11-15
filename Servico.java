import java.net.*;
import java.rmi.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Servico extends Remote {
	
	Map<String, List<String>> mapaMensagens = new HashMap<String, List<String>>();
			
	String echo(String nomeCliente, String mensagem) throws RemoteException;
    
    List<String> getListOfMsg(String nomeCliente) throws RemoteException;
    
    void addNewMessage(String nomeCliente, String mensagem) throws RemoteException; 
}