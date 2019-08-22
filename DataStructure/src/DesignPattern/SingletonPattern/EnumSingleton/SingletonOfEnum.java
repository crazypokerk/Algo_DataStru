package DesignPattern.SingletonPattern.EnumSingleton;

public enum SingletonOfEnum {
	DATASOURCE;
	private MYSQLConnection connection = null;
	
	private SingletonOfEnum() {
		connection = new MYSQLConnection();
	}
	
	public MYSQLConnection getConnection() {
		return connection;
	}
	
}

class MYSQLConnection {
}
