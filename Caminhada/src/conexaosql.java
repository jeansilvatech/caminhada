import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conexaosql {
	public Connection getConexao() throws SQLException
	{
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/caminhada","jean","jeanjean");
	}

}