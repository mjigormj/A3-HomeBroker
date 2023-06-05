package View;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class LoginTest {

    @Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockStatement;

    @Mock
    private ResultSet mockResultSet;

    @Mock
    private JTextField mockEmailTextField;

    @Mock
    private JTextField mockPasswordTextField;

    @Mock
    private JButton mockLoginButton;

    @Mock
    private JButton mockCreateAccountButton;

    @Mock
    private JOptionPane mockOptionPane;

    private LoginScreen loginScreen;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        loginScreen = new LoginScreen();
        loginScreen.setEmailTextField(mockEmailTextField);
        loginScreen.setPasswordTextField(mockPasswordTextField);
        loginScreen.setLoginButton(mockLoginButton);
        loginScreen.setCreateAccountButton(mockCreateAccountButton);
        loginScreen.setOptionPane(mockOptionPane);
    }

    @Test
    public void testLoginActionPerformed_SuccessfulLogin() throws SQLException {
        // Arrange
        when(mockEmailTextField.getText()).thenReturn("test@example.com");
        when(mockPasswordTextField.getPassword()).thenReturn("password".toCharArray());

        // Act
        loginScreen.loginActionPerformed(mock(ActionEvent.class));

        // Assert
        verify(mockConnection).prepareStatement("select * from usuario where email=? and passwd=?");
        verify(mockStatement).setString(1, "test@example.com");
        verify(mockStatement).setString(2, "password");
        verify(mockStatement).executeQuery();
        verify(mockResultSet).next();
        verify(mockResultSet).getString("user_name");
        verify(mockResultSet).getString("email");
        verify(mockResultSet).getString("passwd");
        verify(mockCreateAccountButton, never()).doClick();
        verify(mockLoginButton, never()).setEnabled(false);
        verify(mockEmailTextField).setEnabled(false);
        verify(mockPasswordTextField).setEnabled(false);
        verify(mockOptionPane, never()).showMessageDialog(null, "Login Invalido \n Verificar email e senha");
        verify(loginScreen).dispose();
        verify(mockResultSet).close();
        verify(mockStatement).close();
        verify(mockConnection).close();
    }

    @Test
    public void testLoginActionPerformed_InvalidLogin() throws SQLException {
        // Arrange
        when(mockEmailTextField.getText()).thenReturn("test@example.com");
        when(mockPasswordTextField.getPassword()).thenReturn("password".toCharArray());
        when(mockResultSet.next()).thenReturn(false);

        // Act
        loginScreen.loginActionPerformed(mock(ActionEvent.class));

        // Assert
        verify(mockConnection).prepareStatement("select * from usuario where email=? and passwd=?");
        verify(mockStatement).setString(1, "test@example.com");
        verify(mockStatement).setString(2, "password");
        verify(mockStatement).executeQuery();
        verify(mockResultSet).next();
        verify(mockCreateAccountButton, never()).doClick();
        verify(mockLoginButton).setEnabled(false);
        verify(mockEmailTextField).setEnabled(false);
        verify(mockPasswordTextField).setEnabled(false);
        verify(mockOptionPane).showMessageDialog(null, "Login Invalido \n Verificar email e senha");
        verify(loginScreen, never()).dispose();
        verify(mockResultSet).close();
        verify(mockStatement).close();
        verify(mockConnection).close();
    }
    

}