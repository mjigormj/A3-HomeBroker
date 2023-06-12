package Controller;

import Model.Stock;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.jsoup.nodes.Document;

import org.mockito.Mock;

class CRUDTest {

    @Autowired
    private CRUD crud;
    
    @Mock
    private Document doc;
    
    @Test
    public void testInsertInTableUsuario() throws SQLException {
        assertTrue(crud.insertInTableUsuario("TesteSucesso", "johndoe@TesteSucesso.com", "password123"));
    }

    @Test
    public void testInsertInTableUsuario_EmailAlreadyExists() throws SQLException {
        Connection mockConnection = Mockito.mock(Connection.class);
        assertFalse(crud.insertInTableUsuario("John Doe", "johndoe@example.com", "password123"));
        Mockito.verify(mockConnection, Mockito.never()).prepareStatement(Mockito.anyString());
        Mockito.verifyNoMoreInteractions(mockConnection);
    }
    
    @Test
    public void testInsertInTableCarteira() throws SQLException {
        boolean executou = CRUD.insertInTableCarteira("Stock Name", 10, 100.0, "johndoe@example.com");
        assertTrue(executou);
    }
    
    @Test
    public void testUpdateInTableCarteira() throws SQLException {
        boolean executou = CRUD.updateInTableCarteira("Stock Name", 10, 100.0, "johndoe@example.com");
        assertTrue(executou);
    }
    
    @Test
    public void testReturnStockFromTable() throws SQLException, IOException{
        //TODO: WHEN não está funcionando
        ArrayList<Stock> result = CRUD.returnStockFromTable(2);
        assertTrue(!result.isEmpty());
        Stock stock = result.get(0);
        assertEquals("PETR4", stock.getName());
        assertEquals(5, stock.getStockQtd());
        assertEquals(30.28, stock.getAvgCust(), 0.01);
    }
    
    @Test
    public void testSelectIdUsuario() throws SQLException {
        int result = CRUD.selectIdUsuario("johndoe@example.com");
        assertEquals(35, result);
    }
    
    @Test
    public void testVerifyIfExistsInTable() throws SQLException {
        boolean result = CRUD.verifyIfExistsInTable("usuario", "email", "johndoe@TesteSucesso.com");
        assertTrue(result);
    }
    
    @Test
    public void testDeleteStockFromTable() throws SQLException {
        assertTrue(CRUD.deleteStockFromTable("Stock Name", 35));
    }
    

}
