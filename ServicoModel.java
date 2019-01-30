import java.io.Serializable;

public class ServicoModel implements Serializable {
	
	private String host;
	private String serverName;
	private Integer port;
	
	public ServicoModel(String host, String serverName, Integer port) {
		this.host = host;
		this.serverName = serverName;
		this.port = port;
	}
	
	public String getHost() {
		return host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public String getServerName() {
		return serverName;
	}
	
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	
	public Integer getPort() {
		return port;
	}
	
	public void setPort(Integer port) {
		this.port = port;
	}
	
	public String toString() {
		return "[ " + host + " : " + port + " : " + serverName + " ]";
	}
}
