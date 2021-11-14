import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;


public class ManipulaCaminhada {
	conexaosql con=new conexaosql();
	public void inserir(String data,String resposta)
	{
		String comandoSQL="insert into caminhar(data,resposta)values(?,?)";
		PreparedStatement prepara=null;
		try
		{
			prepara=con.getConexao().prepareStatement(comandoSQL);
			prepara.setString(1, data);
			prepara.setString(2,resposta);
			
			prepara.execute();
			JOptionPane.showMessageDialog(null, "Dados Salvos com sucesso");
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	public ResultSet listagem()
	{
		ResultSet resultado=null;
		String comandoSQL="select * from caminhar";
		PreparedStatement prepara=null;
		try
		{
			prepara=con.getConexao().prepareStatement(comandoSQL);
			resultado=prepara.executeQuery();
			
		}catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}	
		
		return resultado;		
	}
	public void excluir(String data)
	{
		String comandoSQL="delete from caminhar where data=?";
		PreparedStatement prepara=null;
		try
		{
			prepara=con.getConexao().prepareStatement(comandoSQL);
			prepara.setString(1,data);
			prepara.execute();
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
}
