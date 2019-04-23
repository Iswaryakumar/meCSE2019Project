/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEWPACK;

import static NEWPACK.SPLIT_DATASET.colNames;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Java
 */
public class PARTITION_DATASET extends javax.swing.JFrame {

    /**
     * Creates new form SPLIT_DATASET
     */
    public static Vector<Integer> q1 = null;
    public static Vector<Integer> q2 = null;
    public static Vector<Integer> q3 = null;
    public static Vector<Integer> q4 = null;
    public static Vector<Integer> q5 = null;
    public static Vector<Integer> q6 = null;
    public static Vector<Integer> q7 = null;
    public static Vector<Integer> q8 = null;
    public static Vector<Integer> q9 = null;
    public static Vector<Integer> q10 = null;
    public static Vector<Integer> q11 = null;
    public static Vector<Integer> q12 = null;
    public static Vector<Integer> all = null;

    public PARTITION_DATASET() {
        initComponents();
        try {

         //   scnt.setText("TOTAL NUMBER OF SPLIT : " + SPLIT_DATASET.unique.size());
            jPanel2.setLayout(new GridLayout(SPLIT_DATASET.unique.size(), 1, 5, 5));
            q1 = new Vector<Integer>();
            q2 = new Vector<Integer>();
            q3 = new Vector<Integer>();
            q4 = new Vector<Integer>();
            q5 = new Vector<Integer>();
            q6 = new Vector<Integer>();
            q7 = new Vector<Integer>();
            q8 = new Vector<Integer>();
            q9 = new Vector<Integer>();
            q10 = new Vector<Integer>();
            q11 = new Vector<Integer>();
            q12 = new Vector<Integer>();
            jList1.setListData(SPLIT_DATASET.city);
            for (int i = 0; i < SPLIT_DATASET.unique.size(); i++) {
                CsvReader products = new CsvReader(RUN_MAIN.fpath);
                products.readHeaders();
                String city = SPLIT_DATASET.unique.get(i).toString();
                Vector row = new Vector();
                int n = 0;
                while (products.readRecord()) {
                    String check = "";
                    Vector arow = new Vector();
                    String date = products.get(products.getHeader(1));
                    String[] datearr = date.split("/");
                    String color = "";
                    int month = Integer.parseInt(datearr[1].trim());
                    if (month >= 1 && month <= 4) {
                        color = "black";
                    } else if (month >= 5 && month <= 8) {
                        color = "black";
                    } else {
                        color = "black";
                    }

                    for (int a = 0; a < products.getHeaderCount(); a++) {
                        String details = products.get(products.getHeader(a));
                        arow.add("<html><b><font color='" + color + "'>" + details + "</html>");
                        if (a == 2) {
                            check = details;
                        }
                    }
                    if (city.equals(check)) {
                        row.add(arow);
                    }
                    if (month == 1) {
                        q1.add(n);
                    } else if (month == 2) {
                        q2.add(n);
                    } else if (month == 3) {
                        q3.add(n);
                    } else if (month == 4) {
                        q4.add(n);
                    } else if (month == 5) {
                        q5.add(n);
                    } else if (month == 6) {
                        q6.add(n);
                    } else if (month == 7) {
                        q7.add(n);
                    } else if (month == 8) {
                        q8.add(n);
                    } else if (month == 9) {
                        q9.add(n);
                    } else if (month == 10) {
                        q10.add(n);
                    } else if (month == 11) {
                        q11.add(n);
                    } else if (month == 12) {
                        q12.add(n);
                    } else {
                        q12.add(n);
                    }
                    n++;

                }

                /*    JScrollPane scrollPane = new JScrollPane();
                 JTable table = new JTable();
                 table.setModel(new DefaultTableModel(row, SPLIT_DATASET.colNames));
                 table.setRowHeight(30);
                 scrollPane.setViewportView(table);
                 jPanel2.add(scrollPane);*/
                //   row.clear();
            }
            jPanel2.updateUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static ArrayList<String> removeDuplicates(ArrayList<String> list) {

        ArrayList<String> result = new ArrayList<>();

        HashSet<String> set = new HashSet<>();

        for (String item : list) {

            if (!set.contains(item)) {
                result.add(item);
                set.add(item);
            }
        }
        return result;
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
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Vrinda", 1, 14), java.awt.Color.black)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 908, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 373, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        jButton1.setText("SHUFFLING  PARTITION ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jList1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel1.setText("PARTITION RECORD");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 927, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new SHUFFLING().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        try {
            CsvReader products = new CsvReader(RUN_MAIN.fpath);
            products.readHeaders();
            String city = jList1.getSelectedValue().toString();
            int month1 = Integer.parseInt(jComboBox1.getSelectedItem().toString().trim());
            Vector row = new Vector();
            int n = 0;
            while (products.readRecord()) {
                String check = "";
                Vector arow = new Vector();
                String date = products.get(products.getHeader(1));
                String[] datearr = date.split("/");
                String color = "";
                int month = Integer.parseInt(datearr[1].trim());
                if (month >= 1 && month <= 4) {
                    color = "black";
                } else if (month >= 5 && month <= 8) {
                    color = "black";
                } else {
                    color = "black";
                }

                for (int a = 0; a < products.getHeaderCount(); a++) {
                    String details = products.get(products.getHeader(a));
                    arow.add("<html><b><font color='" + color + "'>" + details + "</html>");
                    if (a == 2) {
                        check = details;
                    }
                }
                if (city.equals(check)) {
                    if (month == month1) {
                        row.add(arow);
                    }
                }

            }

            jPanel2.removeAll();
            JScrollPane scrollPane = new JScrollPane();
            JTable table = new JTable();
            table.setModel(new DefaultTableModel(row, colNames));
            table.setRowHeight(30);
            scrollPane.setViewportView(table);
            jPanel2.add(scrollPane);
            jPanel2.updateUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

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
            java.util.logging.Logger.getLogger(PARTITION_DATASET.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PARTITION_DATASET.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PARTITION_DATASET.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PARTITION_DATASET.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PARTITION_DATASET().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
