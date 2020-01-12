package view;

import controller.CustomerController;
import controller.ItemController;
import controller.OrderController;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Customer;
import model.Item;
import model.ItemDetail;
import model.Order;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lochana Edirisinghe
 */
public class PlaceOrderForm extends javax.swing.JFrame {

    double totalAmount=0.00;
    /**
     * Creates new form PlaceOrderForm
     */
    public PlaceOrderForm() {
        initComponents();
        setOrderDate();
        loadAllCustomerID();
        loadAllItemCode();
        setOrderID();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        btnRemoveTable = new javax.swing.JButton();
        btnPlaceOrder = new javax.swing.JButton();
        btnNewCustomer = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbCustomerID = new javax.swing.JComboBox<>();
        cmbCode = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        lblCustomerName = new javax.swing.JLabel();
        lblUnitPrice = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblQtyOnHand = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtQty = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        lblOrderDate = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblOrderID = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnAddTable = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Descrption", "Unit Price", "OrderQty ", "Total"
            }
        ));
        jScrollPane1.setViewportView(tblOrder);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 780, 170));

        btnRemoveTable.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnRemoveTable.setText("Remove");
        btnRemoveTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveTableActionPerformed(evt);
            }
        });
        jPanel1.add(btnRemoveTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 160, 40));

        btnPlaceOrder.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnPlaceOrder.setText("Place Order");
        btnPlaceOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlaceOrderActionPerformed(evt);
            }
        });
        jPanel1.add(btnPlaceOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 460, 160, 40));

        btnNewCustomer.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnNewCustomer.setText("New");
        btnNewCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewCustomerActionPerformed(evt);
            }
        });
        jPanel1.add(btnNewCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 70, 30));

        lblTotal.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblTotal.setText("0.00");
        lblTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, 100, 30));

        lblDescription.setBackground(new java.awt.Color(255, 255, 255));
        lblDescription.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblDescription.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblDescription.setOpaque(true);
        jPanel1.add(lblDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 220, 30));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setText("Total    :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 100, 30));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel4.setText("Order ID :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 100, 30));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel5.setText("Customer ID");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 120, 30));

        cmbCustomerID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCustomerIDItemStateChanged(evt);
            }
        });
        cmbCustomerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCustomerIDActionPerformed(evt);
            }
        });
        jPanel1.add(cmbCustomerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 140, 30));

        cmbCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCodeActionPerformed(evt);
            }
        });
        jPanel1.add(cmbCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 140, 30));

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel6.setText("Code");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 100, 30));

        lblCustomerName.setBackground(new java.awt.Color(255, 255, 255));
        lblCustomerName.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblCustomerName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCustomerName.setOpaque(true);
        jPanel1.add(lblCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 250, 30));

        lblUnitPrice.setBackground(new java.awt.Color(255, 255, 255));
        lblUnitPrice.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblUnitPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblUnitPrice.setOpaque(true);
        jPanel1.add(lblUnitPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 140, 30));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Unit Price");
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 140, 30));

        lblQtyOnHand.setBackground(new java.awt.Color(255, 255, 255));
        lblQtyOnHand.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblQtyOnHand.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblQtyOnHand.setOpaque(true);
        jPanel1.add(lblQtyOnHand, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, 120, 30));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Qty.");
        jLabel11.setOpaque(true);
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 150, 110, 30));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Qty On Hand");
        jLabel12.setOpaque(true);
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 120, 30));
        jPanel1.add(txtQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 180, 110, 30));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Description");
        jLabel13.setOpaque(true);
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 220, 30));

        lblOrderDate.setBackground(new java.awt.Color(255, 255, 255));
        lblOrderDate.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblOrderDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblOrderDate.setOpaque(true);
        jPanel1.add(lblOrderDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, 250, 30));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel15.setText("Customer Name   :");
        jLabel15.setOpaque(true);
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 170, 30));

        lblOrderID.setBackground(new java.awt.Color(255, 255, 255));
        lblOrderID.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblOrderID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblOrderID.setOpaque(true);
        jPanel1.add(lblOrderID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 180, 30));

        jLabel17.setBackground(new java.awt.Color(153, 153, 153));
        jLabel17.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Place Order Form");
        jLabel17.setOpaque(true);
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 50));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel18.setText("Order Date   :");
        jLabel18.setOpaque(true);
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 130, 30));

        btnAddTable.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btnAddTable.setText("Add");
        btnAddTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTableActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 160, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCustomerIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCustomerIDItemStateChanged
        
    }//GEN-LAST:event_cmbCustomerIDItemStateChanged

    private void cmbCustomerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCustomerIDActionPerformed
        try {
            String custID = (String) cmbCustomerID.getSelectedItem();
            Customer cust = CustomerController.searchCustomer(custID);
            lblCustomerName.setText(cust.getName());
        } catch (Exception ex) {
            Logger.getLogger(PlaceOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbCustomerIDActionPerformed

    private void cmbCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCodeActionPerformed
        try {
            String code = (String) cmbCode.getSelectedItem();
            Item item = ItemController.searchItem(code);
            lblDescription.setText(item.getDescription());
            lblUnitPrice.setText(""+item.getUnitPrice());
            lblQtyOnHand.setText(""+item.getQtyOnHand());
        } catch (Exception ex) {
            Logger.getLogger(PlaceOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbCodeActionPerformed

    private void btnAddTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTableActionPerformed
        String code = (String) cmbCode.getSelectedItem();
        String description = lblDescription.getText();
        double unitPrice=Double.parseDouble(lblUnitPrice.getText());
        int qty = Integer.parseInt(txtQty.getText());
        int qtyOnHand=Integer.parseInt(lblQtyOnHand.getText());
        DefaultTableModel dtm = (DefaultTableModel) tblOrder.getModel();
        if (qty<=qtyOnHand) {
            for (int i = 0; i < dtm.getRowCount(); i++) {
                String itemCode = (String) dtm.getValueAt(i, 0);
                if (code.equals(itemCode)) {
                    int tempQty =(int) dtm.getValueAt(i, 3);
                    qty+=tempQty;
                    dtm.removeRow(i);
                    totalAmount-=tempQty*unitPrice;
                }
            }
            double amount= qty*unitPrice;
//            SET TOTAL AMOUNT
            totalAmount+=amount;
            lblTotal.setText(""+totalAmount);
            Object rowData[]={code,description,unitPrice,qty,amount};
            dtm.addRow(rowData);
        } else {
            JOptionPane.showMessageDialog(this, "Low Stocks");
        }
    }//GEN-LAST:event_btnAddTableActionPerformed

    private void btnRemoveTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveTableActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) tblOrder.getModel();
        int selectRow = tblOrder.getSelectedRow();
        double amount = (double) dtm.getValueAt(selectRow, 4);
        totalAmount-=amount;
        lblTotal.setText(""+totalAmount);
        dtm.removeRow(selectRow);
    }//GEN-LAST:event_btnRemoveTableActionPerformed

    private void btnPlaceOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlaceOrderActionPerformed
        //Order order=new Order(orderDetails);
        String customerID=(String) cmbCustomerID.getSelectedItem();
        String orderId=lblOrderID.getText();
        String orderDate=lblOrderDate.getText();
        ArrayList <ItemDetail> itemDetailList=new ArrayList<>();
        DefaultTableModel dtm=(DefaultTableModel) tblOrder.getModel();
        for (int i = 0; i < dtm.getRowCount(); i++) {
            String itemCode=(String) dtm.getValueAt(i, 0);
            int orderQty=(int) dtm.getValueAt(i, 3);
            double unitPrice=(double) dtm.getValueAt(i, 2);
            ItemDetail itemDetail=new ItemDetail(orderId, itemCode, orderQty, unitPrice);
            itemDetailList.add(itemDetail);
        }
        Order order=new Order(orderId, orderDate, customerID, itemDetailList);
        
        try {
           boolean isAdded = OrderController.addOrder(order);
            if(isAdded){
            
            }           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PlaceOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PlaceOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnPlaceOrderActionPerformed

    private void btnNewCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewCustomerActionPerformed
        new AddCustomerForm().setVisible(true);
    }//GEN-LAST:event_btnNewCustomerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlaceOrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlaceOrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlaceOrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlaceOrderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlaceOrderForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddTable;
    private javax.swing.JButton btnNewCustomer;
    private javax.swing.JButton btnPlaceOrder;
    private javax.swing.JButton btnRemoveTable;
    private javax.swing.JComboBox<String> cmbCode;
    private javax.swing.JComboBox<String> cmbCustomerID;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCustomerName;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblOrderDate;
    private javax.swing.JLabel lblOrderID;
    private javax.swing.JLabel lblQtyOnHand;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblUnitPrice;
    private javax.swing.JTable tblOrder;
    private javax.swing.JTextField txtQty;
    // End of variables declaration//GEN-END:variables

    private void setOrderDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        String formatDate = sdf.format(date);
        lblOrderDate.setText(formatDate);
    }

    private void loadAllCustomerID() {
        try {
            ArrayList<String> customerIDS = CustomerController.loadAllCustomerID();
            for (String custID : customerIDS) {
                cmbCustomerID.addItem(custID);
            }
        } catch (Exception ex) {
            Logger.getLogger(PlaceOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadAllItemCode() {
        try {
            ArrayList<String> itemCodes = ItemController.loadAllItemCode();
            for (String itemID : itemCodes) {
                cmbCode.addItem(itemID);
            }
        } catch (Exception ex) {
            Logger.getLogger(PlaceOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setOrderID() {
        try {
            String newID = IDGenerator.getNewID("Orders", "id", "D0");
            lblOrderID.setText(newID);
        } catch (Exception ex) {
            Logger.getLogger(PlaceOrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
