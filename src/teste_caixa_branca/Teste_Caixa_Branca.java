package teste_caixa_branca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Teste_Caixa_Branca {

public Connection conectarBD() { 
 Connection conn = null; // Ponto 1: Define a conexão como nula
 try { // Ponto 2: Tenta executar o bloco de código
 Class.forName("com.mysql.Driver.Manager").newInstance(); // Ponto 3: Carrega o driver JDBC
 String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123"; // Ponto 4: Define a URL de conexão
 conn = DriverManager.getConnection(url); // Ponto 5: Estabelece a conexão
 } // Ponto 6: Fim do bloco try
 catch (Exception e) { // Ponto 7: Captura qualquer exceção e não faz nada
 }
 return conn; // Ponto 8: Retorna a conexão
}

public String nome = ""; // Variável de instância
public boolean result = false; // Variável de instância

public boolean verificarUsuario(String login, String senha) { 
 String sql = ""; // Ponto 9: Define uma string vazia para a instrução SQL
 Connection conn = conectarBD(); // Ponto 10: Conecta ao banco de dados
 sql += "select nome from usuarios"; // Ponto 11: Adiciona à instrução SQL
 sql += "where login = " + "'" + login + "'"; // Ponto 11: Adiciona à instrução SQL
 sql += " and senha = " + "'" + senha + "'"; // Ponto 11: Adiciona à instrução SQL
 try { // Ponto 12: Tenta executar o bloco de código
 Statement st = conn.createStatement(); // Ponto 13: Cria um Statement
 ResultSet rs = st.executeQuery(sql); // Ponto 14: Executa a consulta SQL
 if (rs.next()) { // Ponto 15: Verifica se a consulta retornou um resultado
 result = true; // Ponto 16: Define o resultado como verdadeiro
 nome = rs.getString("nome"); // Ponto 17: Obtém o nome do usuário
 } // Ponto 18: fim do if
 } catch (Exception e) { // Ponto 19: Captura qualquer exceção e não faz nada
 }
 return result; // Ponto 20: Retorna o resultado
}

} //fim da classe
