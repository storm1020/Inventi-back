package br.com.fiap.inventi.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class ConnectionFactory {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement stmt = null; // Responsavel pelas sqlsInjection
		ResultSet rs = null;
		
		try {
			
			int numeroCliente = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do cliente:"));
			String login = (JOptionPane.showInputDialog("Digite o nome do usu�rio:"));
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM78861", "050795");
			
			stmt = con.prepareStatement
					("SELECT * FROM TB_CLIENTE WHERE ID_CLIENTE=? AND NOME=?"); //Prepara a tabela para ser populada.

			// Posi��o interroga��o 1, valor que vai no interroga��o.
			stmt.setInt(1, numeroCliente);
			stmt.setString(2, login);
			
			// Executar a query.
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("Bem vindo! Sr." + login);
				System.out.println("Nome: " + rs.getString("NOME")); // printa capturando o tipo de dado e a coluna.
				System.out.println("Valor Ultima Compra: " + rs.getInt("VALOR_ULTIMA_COMPRA"));
				System.out.println("CPF: " + rs.getString("CPF"));
			} else {
				System.out.println("Login inv�lido!");
			}
			
			//while(rs.next()) { //Sai do titulo e vai para o dado.
			//System.out.println("Nome: " + rs.getString("NOME")); // printa capturando o tipo de dado e a coluna.
			//System.out.println("Valor Ultima Compra: " + rs.getInt("VALOR_ULTIMA_COMPRA"));
			//System.out.println("CPF: " + rs.getString("CPF"));
		//}
			
		} catch (Exception e) {
			// 1� Momento: o sistema est� em teste/produ��o
		e.printStackTrace();
		// 2� Momento: o sistema foi homologado
		System.out.println(e);
		} finally {
			try {
				con.close();
			} catch(Exception e){
				e.printStackTrace();
				System.out.println(e);
			}
		}		
	}
}
