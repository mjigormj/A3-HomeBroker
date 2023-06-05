package Controller;

import Model.Stock;
import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CRUD {

    public static void insertInTableUsuario(String userName, String email, String passwd) throws SQLException {
        if (!verifyIfExistsInTable("usuario", "email", email)) {
            Connection con;
            con = Conector.conect();
            String sql = "insert into usuario(user_name, email, passwd) values ('" + userName + "' , '" + email + "', '" + passwd + "');";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Já existe uma conta com o email: " + email, "Usuario já cadastrado", JOptionPane.ERROR_MESSAGE);
        }

    }

    //insere valores na tabela Carteira
    public static void insertInTableCarteira(String stockName, int qtdStock, Double valorPago, String email) throws SQLException {
        Connection con;
        con = Conector.conect();
        int idUsuario = selectIdUsuario(email);
        String sql = "insert into carteira(nmTitulo, qtdTitulo, valorPago, fk_IDusuario) values ('" + stockName + "' , " + qtdStock + ", " + valorPago + ", '" +idUsuario+"');";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.executeUpdate();

        stmt.close();
        con.close();
    }


    public static Integer selectIdUsuario(String email) throws SQLException {
        int idUsuario = 666;
        Connection con;
        con = Conector.conect();
        String sql = "select IDusuario from usuario where email = '" + email + "' ;";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            idUsuario = rs.getInt(1);
        }
        stmt.close();
        con.close();
        return idUsuario;
    }

    //verifica se existe o valor passado na tabela
    public static boolean verifyIfExistsInTable(String tableName, String columnName, String tableValue) throws SQLException {
        boolean thereValue;
        Connection con;
        con = Conector.conect();
        PreparedStatement stmt = con.prepareStatement("select * from " + tableName + " where " + columnName + " = '" + tableValue + "';");
        ResultSet rs = stmt.executeQuery();
        thereValue = rs.next();
        stmt.close();
        con.close();
        return thereValue;
    }

    public static boolean verifyIfExistsInTable(String tableName, String columnName, String tableValue, String columnName2, String tableValue2) throws SQLException {
        boolean thereValue;
        Connection con;
        con = Conector.conect();
        PreparedStatement stmt = con.prepareStatement("select * from " + tableName + " where " + columnName + " = '" + tableValue + "' AND " + columnName2 + " = '" + tableValue2 + "';");
        ResultSet rs = stmt.executeQuery();
        thereValue = rs.next();
        stmt.close();
        con.close();
        return thereValue;
    }

}
