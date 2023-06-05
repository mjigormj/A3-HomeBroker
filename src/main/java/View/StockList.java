package View;

import Controller.CRUD;
import Model.Stock;
import Model.User;
import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class StockList extends javax.swing.JFrame {

    String stockName;
    private ArrayList<Stock> titulos;
    private static User user;

    public StockList(User user) {
        this.user = user;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        stockTable = new javax.swing.JTable();
        btnRefreshTable = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnNewStock = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jlEmail = new javax.swing.JLabel();
        lucroLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        investidoLabel = new javax.swing.JLabel();
        vlCarteiraLabel = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        btnDelete1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        stockTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo", "Preço Atual", "VL Medio Pago", "Qtd", "Valor em Posse", "Lucro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(stockTable);

        btnRefreshTable.setBackground(javax.swing.UIManager.getDefaults().getColor("window"));
        btnRefreshTable.setBorder(null);
        btnRefreshTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshTableActionPerformed(evt);
            }
        });

        btnDelete.setBackground(javax.swing.UIManager.getDefaults().getColor("window"));
        btnDelete.setBorder(null);

        btnNewStock.setBackground(new java.awt.Color(0, 140, 158));
        btnNewStock.setForeground(new java.awt.Color(255, 255, 255));
        btnNewStock.setText("Adc Novo Titulo");
        btnNewStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewStockActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 140, 158));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("refresh");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Lucro Total:");

        jlEmail.setText("Nome do Usuario:");

        lucroLabel.setText("lucro");

        jLabel2.setText("Valor na carteira");

        jLabel3.setText("investido");

        investidoLabel.setText("investido");

        vlCarteiraLabel.setText("vlCarteira");
        vlCarteiraLabel.setToolTipText("");

        userNameLabel.setText("nome");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(userNameLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(vlCarteiraLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(investidoLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(72, 72, 72)
                        .addComponent(lucroLabel)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(investidoLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(vlCarteiraLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lucroLabel)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlEmail)
                        .addComponent(userNameLabel)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        btnDelete1.setBackground(new java.awt.Color(0, 95, 107));
        btnDelete1.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete1.setText("Excluir");
        btnDelete1.setBorder(null);
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefreshTable)
                        .addGap(58, 58, 58))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNewStock)
                        .addGap(346, 346, 346)
                        .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRefreshTable, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNewStock, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(btnDelete)
                    .addComponent(btnDelete1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {
            tituloList();
        } catch (SQLException ex) {
            Logger.getLogger(StockList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StockList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formComponentShown

    private void btnNewStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewStockActionPerformed
        StockSearch ss = new StockSearch(user);
        ss.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNewStockActionPerformed

    private void btnRefreshTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshTableActionPerformed
        try {
            tituloList();
        } catch (SQLException ex) {
            Logger.getLogger(StockList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StockList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefreshTableActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            tituloList();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(StockList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        try {
            DefaultTableModel val = (DefaultTableModel) stockTable.getModel();
            int linhaSelecionada = stockTable.getSelectedRow();
            if (linhaSelecionada >= 0) {
                deletarTitulo(stockTable.getValueAt(linhaSelecionada, 0).toString());
                val.removeRow(linhaSelecionada);
                stockTable.setModel(val);
                tituloList();

            } else {
                JOptionPane.showMessageDialog(null, "Favor selecionar uma linha");
            }
        } catch (IOException | SQLException ex) {
            Logger.getLogger(StockList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDelete1ActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatOneDarkIJTheme());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockList(user).setVisible(true);
            }
        });
    }


    // Methods
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public void tituloList() throws SQLException, IOException {
        
        titulos = CRUD.returnStockFromTable(CRUD.selectIdUsuario(user.getEmail()));
        try {
            Double valorAtualCarteira = 0.0;
            Double valorInvestidoCarteira = 0.0;
            DefaultTableModel val = (DefaultTableModel) stockTable.getModel();
            val.setRowCount(0);
            for (Stock titulo : titulos) {
                String valorAtual = df.format(titulo.getMarcketValue());
                String tituloQtd = String.valueOf(titulo.getStockQtd());
                String precoMedio = df.format(titulo.getAvgCust());
                String valorTotal = df.format(titulo.getMarcketValue() * titulo.getStockQtd());
                String lucro = df.format(titulo.getMarcketValue() * titulo.getStockQtd() - titulo.getAvgCust() * titulo.getStockQtd());
                val.addRow(new String[]{titulo.getName(), valorAtual, precoMedio, tituloQtd, valorTotal, lucro });
                valorAtualCarteira += titulo.getMarcketValue() * titulo.getStockQtd();
                valorInvestidoCarteira += titulo.getAvgCust() * titulo.getStockQtd();
            }
                userNameLabel.setText(user.getUserName());
                vlCarteiraLabel.setText(df.format(valorAtualCarteira));
                investidoLabel.setText(df.format(valorInvestidoCarteira));
                lucroLabel.setText(df.format(valorAtualCarteira - valorInvestidoCarteira));
                
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida");
        }
    }
    
        public void deletarTitulo(String nmTitulo) throws SQLException {
            for (Stock titulo : titulos) {
                if (titulo.getName().equals(nmTitulo)) {
                    CRUD.deleteStockFromTable(titulo.getName(),user.getIdUsuario());
                    titulos.remove(titulo);
                    return;
                }
            }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnNewStock;
    private javax.swing.JButton btnRefreshTable;
    private javax.swing.JLabel investidoLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel lucroLabel;
    private javax.swing.JTable stockTable;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JLabel vlCarteiraLabel;
    // End of variables declaration//GEN-END:variables
}
