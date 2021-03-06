/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrs;

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 *
 * @author Im_jay
 */
public class Search extends javax.swing.JFrame {

    /**
     * Creates new form Search
     */
    FileWriter w;
    int d;
    String rad="";
    public Search() {
        initComponents();
        this.setLocationRelativeTo(null);
        jDateChooser1.getJCalendar().setMinSelectableDate(new Date());
        jDateChooser2.getJCalendar().setMinSelectableDate(new Date());
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel2.setText("Hotel Reservation System");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 50, 340, 32);

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel3.setText("Check-In Date");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 120, 110, 19);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel4.setText("Check-Out Date");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 160, 110, 19);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel5.setText("Number of Guest");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 200, 130, 19);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(190, 200, 100, 20);

        jButton1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(140, 300, 120, 27);

        jButton2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jButton2.setText("Profile");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(290, 10, 97, 27);

        jDateChooser1.setDateFormatString("MM/dd/yyyy");
        jPanel1.add(jDateChooser1);
        jDateChooser1.setBounds(190, 120, 160, 20);

        jDateChooser2.setDateFormatString("MM/dd/yyyy");
        jPanel1.add(jDateChooser2);
        jDateChooser2.setBounds(190, 160, 160, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon("G:\\HRS\\backgroud image.jpg")); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 400, 450);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //jButton1 = search button
        Date date1 = jDateChooser1.getDate();
        String datestring1 = String.format("%1$tm/%1$td/%1$tY", date1);
        Date date2 = jDateChooser2.getDate();
        String datestring2 = String.format("%1$tm/%1$td/%1$tY", date2);
        if(jDateChooser1.getDate() == null){
            JOptionPane.showMessageDialog(null,"You must enter a check-in date.", "HRS",JOptionPane.PLAIN_MESSAGE);
        }
        else if(jDateChooser2.getDate() == null){
            JOptionPane.showMessageDialog(null,"You must enter a check-out date.", "HRS",JOptionPane.PLAIN_MESSAGE);
        }
        else if (jDateChooser2.getDate().compareTo(jDateChooser1.getDate())==-1 || datestring1.equals(datestring2)){
            JOptionPane.showMessageDialog(null,"Invalid check-out date.", "HRS",JOptionPane.PLAIN_MESSAGE);
        }
        else{
        try{
            w = new FileWriter("temp.txt",false);
            Date d1 = jDateChooser1.getDate();
            String datestr1 = String.format("%1$tm/%1$td/%1$tY", d1);
            w.write("Check-In date: "+datestr1);
            w.write("\r\n");
            Date d2 = jDateChooser2.getDate();
            String datestr2 = String.format("%1$tm/%1$td/%1$tY", d2);
            w.write("Check-Out date: "+datestr2);
            w.write("\r\n");
            long diff = d2.getTime()-d1.getTime();
            long diffDays = diff / (24*60*60*1000)+1;
            d = (int) diffDays;
            
            if(d ==0){
                JOptionPane.showMessageDialog(null,"Invalid check-out date.", "HRS",JOptionPane.PLAIN_MESSAGE);
            }
            w.write("Days: "+d);
            w.write("\r\n");
            String box1 = jComboBox1.getSelectedItem().toString();
            w.write("Number of Guest: "+ box1);
            w.write("\r\n");
            w.close();
            FileWriter day = new FileWriter("day.txt",false);
            day.write(""+d);
            day.close();
            Random rd = new Random();
            for(int i=0; i<8; i++){
                int n = rd.nextInt(9);
                rad = rad + n;
            }
            FileWriter conf = new FileWriter("confirmation.txt",false);
            conf.write("Confirmation Number: "+rad);
            conf.close();
            FileWriter confnum = new FileWriter("confirmationNum.txt",false);
            confnum.write(rad);
            confnum.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
        dispose();
        Hotel h = new Hotel();
        h.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
        Profile p = new Profile();
        p.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Search().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
