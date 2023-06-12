package View;

import Controller.CRUD;
import Controller.Conector;
import Model.Stock;
import Model.User;
import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class StockSearch extends javax.swing.JFrame {

    String stockName;
    private static User user;
    
    public StockSearch(User user) {
        this.user = user;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        stockInput = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        stockTable = new javax.swing.JTable();
        btnAddStock = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Procurar titulo:");

        btnSearch.setBackground(new java.awt.Color(0, 140, 158));
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Pesquisar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        stockInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockInputActionPerformed(evt);
            }
        });
        stockInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                stockInputKeyPressed(evt);
            }
        });

        stockTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo", "Preço (R$)", "Variação (%)", "Baixa/Alta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(stockTable);

        btnAddStock.setBackground(new java.awt.Color(0, 140, 158));
        btnAddStock.setForeground(new java.awt.Color(255, 255, 255));
        btnAddStock.setText("+");
        btnAddStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStockActionPerformed(evt);
            }
        });

        btnVoltar.setBackground(new java.awt.Color(0, 95, 107));
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddStock, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(stockInput, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(btnSearch))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVoltar)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVoltar)
                .addGap(2, 2, 2)
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockInput, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAddStock)
                        .addGap(46, 46, 46))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stockInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockInputActionPerformed
        //stockName = stockInput.getText().trim();
    }//GEN-LAST:event_stockInputActionPerformed

    private void stockInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stockInputKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            this.showStock();
    }//GEN-LAST:event_stockInputKeyPressed

    private void btnAddStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStockActionPerformed
        try {
            DefaultTableModel val = (DefaultTableModel) stockTable.getModel();
            String stockNome = val.getValueAt(0, 0).toString();
            String qtdStock = JOptionPane.showInputDialog(stockName + "\n Quantidade a ser comprada", 1);
            int qtdStockInteger = Integer.parseInt(qtdStock);
            String id = CRUD.selectIdUsuario(user.getEmail()).toString();
            
            String valorPago = JOptionPane.showInputDialog("\n Valor a ser pago R$:", val.getValueAt(0, 1).toString());
            Double valorPagoDouble = Double.parseDouble(valorPago);
            
            if(CRUD.verifyIfExistsInTable("carteira", "nmTitulo", stockNome, "fk_IDusuario", id)){
                CRUD.updateInTableCarteira(stockNome, qtdStockInteger, valorPagoDouble * qtdStockInteger, user.getEmail());
            } else {
                CRUD.insertInTableCarteira(stockNome, qtdStockInteger, valorPagoDouble * qtdStockInteger, user.getEmail());
            }
            
            StockList sl = new StockList(user);
            sl.setVisible(true);
            this.dispose();
            

        } catch (SQLException ex) {            
            Logger.getLogger(StockSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch ( Exception e) {
            JOptionPane.showMessageDialog(null, "DIGITE APENAS NÚEMEROS", "ERRO", JOptionPane.ERROR_MESSAGE);

        }


    }//GEN-LAST:event_btnAddStockActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        this.showStock();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        StockList sl = new StockList(user);
        sl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatOneDarkIJTheme());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockSearch(user).setVisible(true);
            }
        });
    }

    // Methods
    public void showStock() {
        try {
            if (!stockInput.getText().isEmpty()) {
                try {
                    Stock stock = new Stock();
                    stock.criarStock(stockInput.getText().trim());
                    DefaultTableModel val = (DefaultTableModel) stockTable.getModel();

                    int i = val.getRowCount();
                    if (i > 0) {
                        val.removeRow(0);
                    }
                    val.addRow(new String[]{stock.getName(), stock.getMarcketValue().toString(), stock.percentVariance(), stock.dayRange()});
                } catch (NumberFormatException e) {
                    
                    JOptionPane.showMessageDialog(null,
                            stockInput.getText()+" não encontrado \n Tente novamente",
                            "Erro titulo", JOptionPane.ERROR_MESSAGE);
                    
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(StockSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddStock;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField stockInput;
    private javax.swing.JTable stockTable;
    // End of variables declaration//GEN-END:variables
}
