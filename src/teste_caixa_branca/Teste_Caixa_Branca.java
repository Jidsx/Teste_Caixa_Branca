package teste_caixa_branca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Teste_Caixa_Branca {

    /**
     *
     * @author Jean Israel
     * @version 1.1
     * @since Release 1.1 da aplicação
     */
    
    /**
     * Método para fazer a conexão com o banco de dados
     *
     * @return conn, resultado de retorno da conexão
     */
    public Connection conectarBD() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.Driver.Manager").newInstance();
            // URL de conexão com o banco de dados
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            // Estabelece a conexão com o banco de dados
            conn = DriverManager.getConnection(url);
            // Se ocorrer um erro, não faz nada
        } catch (Exception e) {
        }
        return conn;
    }

    public String nome = "";
    public boolean result = false;

    /**
     * Verificando a existência de um usuário com o login e senha fornecidos.
     *
     * @param login, o login do usuário
     * @param senha, a senha do usuário
     * @return true se o usuário foi encontrado, false caso contrário
     */
    public boolean verificarUsuario(String login, String senha) {
        String sql = "";
        // Conecta ao banco de dados
        Connection conn = conectarBD();
        // Consulta SQL para verificar o usuário
        sql += "select nome from usuarios";
        sql += "where login = " + "'" + login + "'";
        sql += " and senha = " + "'" + senha + "'";
        try {
            // Cria uma declaração SQL
            Statement st = conn.createStatement();
            // Verifica se há um resultado
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                // Se houver, define o resultado como verdadeiro
                result = true;
                // Obtém o nome do usuário do resultado da consulta
                nome = rs.getString("nome");
            }
            // Se ocorrer um erro, não faz nada
        } catch (Exception e) {
        }
        return result;
    }

} //fim da classe
