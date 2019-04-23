/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEWPACK;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Java
 */
public class SHUFFLING extends javax.swing.JFrame {

    /**
     * Creates new form SHUFFLING
     */
    public static double[] Data = null;
    public static double[] prediction = null;

    public SHUFFLING() {
        initComponents();
        try {
            List<String[]> all = new ArrayList<String[]>();
            Vector row = new Vector();
            ArrayList<String> datestring = new ArrayList<String>();
            for (int i = 0; i < PARTITION_DATASET.q1.size(); i++) {
                int index = PARTITION_DATASET.q1.get(i);
                String[] details = RUN_MAIN.all.get(index);
                all.add(details);
                datestring.add(details[1]);
            }
            for (int i = 0; i < PARTITION_DATASET.q2.size(); i++) {
                int index = PARTITION_DATASET.q2.get(i);
                String[] details = RUN_MAIN.all.get(index);
                all.add(details);
                datestring.add(details[1]);
            }
            for (int i = 0; i < PARTITION_DATASET.q3.size(); i++) {
                int index = PARTITION_DATASET.q3.get(i);
                String[] details = RUN_MAIN.all.get(index);
                all.add(details);
                datestring.add(details[1]);
            }
            for (int i = 0; i < PARTITION_DATASET.q4.size(); i++) {
                int index = PARTITION_DATASET.q4.get(i);
                String[] details = RUN_MAIN.all.get(index);
                all.add(details);
                datestring.add(details[1]);
            }

            for (int i = 0; i < PARTITION_DATASET.q5.size(); i++) {
                int index = PARTITION_DATASET.q5.get(i);
                String[] details = RUN_MAIN.all.get(index);
                all.add(details);
                datestring.add(details[1]);
            }
            for (int i = 0; i < PARTITION_DATASET.q6.size(); i++) {
                int index = PARTITION_DATASET.q6.get(i);
                String[] details = RUN_MAIN.all.get(index);
                all.add(details);
                datestring.add(details[1]);
            }
            for (int i = 0; i < PARTITION_DATASET.q7.size(); i++) {
                int index = PARTITION_DATASET.q7.get(i);
                String[] details = RUN_MAIN.all.get(index);
                all.add(details);
                datestring.add(details[1]);
            }
            for (int i = 0; i < PARTITION_DATASET.q8.size(); i++) {
                int index = PARTITION_DATASET.q8.get(i);
                String[] details = RUN_MAIN.all.get(index);
                all.add(details);
                datestring.add(details[1]);
            }
            for (int i = 0; i < PARTITION_DATASET.q9.size(); i++) {
                int index = PARTITION_DATASET.q9.get(i);
                String[] details = RUN_MAIN.all.get(index);
                all.add(details);
                datestring.add(details[1]);
            }
            for (int i = 0; i < PARTITION_DATASET.q10.size(); i++) {
                int index = PARTITION_DATASET.q10.get(i);
                String[] details = RUN_MAIN.all.get(index);
                all.add(details);
                datestring.add(details[1]);
            }
            for (int i = 0; i < PARTITION_DATASET.q11.size(); i++) {
                int index = PARTITION_DATASET.q11.get(i);
                String[] details = RUN_MAIN.all.get(index);
                all.add(details);
                datestring.add(details[1]);
            }
            for (int i = 0; i < PARTITION_DATASET.q12.size(); i++) {
                int index = PARTITION_DATASET.q12.get(i);
                String[] details = RUN_MAIN.all.get(index);
                all.add(details);
                datestring.add(details[1]);
            }

            Collections.sort(datestring, new Comparator<String>() {
                DateFormat f = new SimpleDateFormat("dd/MM/yyyy");

                @Override
                public int compare(String o1, String o2) {
                    try {
                        return f.parse(o1).compareTo(f.parse(o2));
                    } catch (Exception e) {
                        throw new IllegalArgumentException(e);
                    }
                }
            });
            String[] startarr = datestring.get(0).split("/");
            String[] endtarr = datestring.get(datestring.size() - 1).split("/");

            int starty = Integer.parseInt(startarr[2]);
            int endy = Integer.parseInt(endtarr[2]);

            Data = new double[((endy - starty) + 1) * 12];
            int ind = 0;
            for (int i = starty; i <= endy; i++) {
                double d1 = 0.0, d2 = 0.0, d3 = 0.0, d4 = 0.0, d5 = 0.0, d6 = 0.0, d7 = 0.0, d8 = 0.0, d9 = 0.0, d10 = 0.0, d11 = 0.0, d12 = 0.0;
                for (int j = 0; j < RUN_MAIN.all.size(); j++) {
                    String[] details = RUN_MAIN.all.get(j);
                    String[] temparr = details[1].split("/");
                    int year = Integer.parseInt(temparr[2]);
                    int month = Integer.parseInt(temparr[1]);
                    if (year == i && month == 1) {
                        d1 += Double.parseDouble(details[28]);
                    } else if (year == i && month == 2) {
                        d2 += Double.parseDouble(details[28]);
                    } else if (year == i && month == 3) {
                        d3 += Double.parseDouble(details[28]);
                    } else if (year == i && month == 4) {
                        d4 += Double.parseDouble(details[28]);
                    } else if (year == i && month == 5) {
                        d5 += Double.parseDouble(details[28]);
                    } else if (year == i && month == 6) {
                        d6 += Double.parseDouble(details[28]);
                    } else if (year == i && month == 7) {
                        d7 += Double.parseDouble(details[28]);
                    } else if (year == i && month == 8) {
                        d8 += Double.parseDouble(details[28]);
                    } else if (year == i && month == 9) {
                        d9 += Double.parseDouble(details[28]);
                    } else if (year == i && month == 10) {
                        d10 += Double.parseDouble(details[28]);
                    } else if (year == i && month == 11) {
                        d11 += Double.parseDouble(details[28]);
                    } else if (year == i && month == 12) {
                        d12 += Double.parseDouble(details[28]);
                    }

                }

                System.out.println("Year : " + i);
                System.out.println("Quad1 : " + d1);
                System.out.println("Quad2  : " + d2);
                System.out.println("Quad3 : " + d3);
                Data[ind] = d1;
                ind++;
                Data[ind] = d2;
                ind++;
                Data[ind] = d3;
                ind++;
                Data[ind] = d4;
                ind++;
                Data[ind] = d5;
                ind++;
                Data[ind] = d6;
                ind++;
                Data[ind] = d7;
                ind++;
                Data[ind] = d8;
                ind++;
                Data[ind] = d9;
                ind++;
                Data[ind] = d10;
                ind++;
                Data[ind] = d11;
                ind++;
                Data[ind] = d12;
                ind++;
            }

            Object body[][] = all.toArray(new Object[][]{});
            jTable1.setModel(new DefaultTableModel(body, RUN_MAIN.headarr));
            jTable1.setRowHeight(30);

        } catch (Exception e) {
            e.printStackTrace();
        }
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
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Vrinda", 1, 14), java.awt.Color.black)); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("MAP REDUCE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(395, 395, 395)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       new HDProcess().setVisible(true);
    //	new VIEW_RESULT().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(SHUFFLING.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SHUFFLING.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SHUFFLING.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SHUFFLING.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SHUFFLING().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
