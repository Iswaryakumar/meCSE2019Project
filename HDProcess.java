package NEWPACK;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import csvreader.CSVParser;
import csvreader.CSVReader;
import csvreader.CSVWriter;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.awt.Cursor;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jfree.ui.ApplicationFrame;

//import org.jfree.ui.ApplicationFrame;
import java.awt.GridBagLayout;

public class HDProcess extends JFrame {

    private JPanel contentPane;
    private JPanel panel_1;
    private JPanel panel_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HDProcess frame = new HDProcess();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public HDProcess() {
        setTitle("Hadoop Process");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1150, 609);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblMapReduce = new JLabel("Map Reduce");
        lblMapReduce.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblMapReduce.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                File f1 = new File("input");
                File f2 = new File("output");
                if (!f1.exists()) {
                    f1.mkdirs();
                }
                if (!f2.exists()) {
                    f2.mkdirs();
                }
                panel_1.setLayout(new GridLayout(RUN_MAIN.entry.length, 1, 5, 5));
                panel_2.setLayout(new GridLayout(RUN_MAIN.entry.length, 1, 5, 5));
                long st1 = System.currentTimeMillis();
                long ptime = 0;
                long stime = 0;
                ApplicationFrame app = new ApplicationFrame("");
                BarChart chart = new BarChart("Performance Chart", "", "Exeuction Time(nano sec)");
                List<Long> numbers = new ArrayList<Long>();
                List<Long> numbers1 = new ArrayList<Long>();
             
                for (int i = 0; i < RUN_MAIN.entry.length; i++) {
                    try {
                        long st = System.currentTimeMillis();
                        csvreader.CSVWriter writer = new CSVWriter(new FileWriter(new File(f1, "part.csv")));
                        writer.writeAll(RUN_MAIN.entry[i]);
                        writer.close();
                        MapReduce m = new MapReduce(f1.getAbsolutePath(), f2.getAbsolutePath());
                        m.doMapReduce();

                        File fin = new File(f2, "part-r-00000");
                        File fout = new File("result");
                        if (!fout.exists()) {
                            fout.mkdirs();
                        }
                        fout = new File(fout, i + ".csv");
                        copyFileUsingStream(fin, fout);
                        System.out.println("Reducer " + i + " map reduced");
                        CSVReader reader = new CSVReader(new FileReader(fout));
                        RUN_MAIN.entry1[i] = reader.readAll();

                        JScrollPane scrollPane = new JScrollPane();
                        JTable table = new JTable();
                        table.setModel(new DefaultTableModel(RUN_MAIN.entry1[i].toArray(new String[][]{}), RUN_MAIN.headarr));
                        scrollPane.setViewportView(table);
                        panel_2.add(scrollPane);

                        JScrollPane scrollPane1 = new JScrollPane();
                        JTextArea textArea = new JTextArea();
                        textArea.setText("Reducer " + i + " is Map/Reduce\n\n");
                        textArea.append(m.getLogDetails());
                        long en = System.currentTimeMillis();
                        ptime = (en-st);
                        System.out.println("Parellel Timing : " +( en-st) +" Nano Seconds");
                        textArea.append("Execution Time : " +( en-st) +" Nano Seconds" );
                        scrollPane1.setViewportView(textArea);
                        panel_1.add(scrollPane1);
                        panel_1.updateUI();
                        panel_2.updateUI();
                        setExtendedState(JFrame.MAXIMIZED_BOTH);
                        chart.addValue(ptime, " Pro R"+(i+1), "");
                        numbers.add(ptime);
                        numbers1.add(ptime);
                       
                    } catch (Exception ex) {
                        System.err.println(ex.getMessage());
                    }                   
                }
                
                Collections.sort(numbers);
                String mess = ""; 
                int c=1;
                for(int j=0;j<numbers.size();j++)
                {
                	int ind = numbers.indexOf(numbers1.get(j))+1;
                  mess += c + " Higher end Node is " +	ind +"\n";
                  c++;
                }
                JOptionPane.showMessageDialog(new JFrame("Find Higher End Node"), mess);
                
                 
                
                 long en1 = System.currentTimeMillis();           
                 stime = (en1-st1);
                 System.out.println("Single Timing : " +( en1-st1) +" Nano Seconds");
                 chart.addValue(stime, "Existing", "");
                
                 chart.createChart();
                 app.setContentPane(chart);
                 app.setDefaultCloseOperation(app.HIDE_ON_CLOSE);
                 app.setSize(800, 450);
                 app.setVisible(true);
            }
        });
        lblMapReduce.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblMapReduce.setBounds(162, 21, 97, 14);
        panel.add(lblMapReduce);

        JScrollPane scrollPane = new JScrollPane();

        panel_1 = new JPanel();
        scrollPane.setViewportView(panel_1);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{0};
        gbl_panel_1.rowHeights = new int[]{0};
        gbl_panel_1.columnWeights = new double[]{Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{Double.MIN_VALUE};
        panel_1.setLayout(gbl_panel_1);

        JScrollPane scrollPane_1 = new JScrollPane();

        panel_2 = new JPanel();
        scrollPane_1.setViewportView(panel_2);
        GridBagLayout gbl_panel_2 = new GridBagLayout();
        gbl_panel_2.columnWidths = new int[]{0};
        gbl_panel_2.rowHeights = new int[]{0};
        gbl_panel_2.columnWeights = new double[]{Double.MIN_VALUE};
        gbl_panel_2.rowWeights = new double[]{Double.MIN_VALUE};
        panel_2.setLayout(gbl_panel_2);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                        .addGap(5)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addComponent(panel, GroupLayout.DEFAULT_SIZE, 1127, Short.MAX_VALUE)
                                .addGroup(gl_contentPane.createSequentialGroup()
                                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED)
                                        .addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE))))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                        .addComponent(panel, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addGroup(gl_contentPane.createSequentialGroup()
                                        .addGap(11)
                                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
                                .addGroup(gl_contentPane.createSequentialGroup()
                                        .addGap(12)
                                        .addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))))
        );
        
        JLabel lblApplyPrediction = new JLabel("Sales Predict");
        lblApplyPrediction.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblApplyPrediction.setBounds(532, 21, 125, 14);
        panel.add(lblApplyPrediction);
        contentPane.setLayout(gl_contentPane);
        lblApplyPrediction.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblApplyPrediction.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	//new VIEW_RESULT().setVisible(true);
            	  try {
                      int period = 12;
                      int m = 1;

                      double alpha = 0.3;
                      double beta = 0.4;
                      double gamma = 0.5;

                      SHUFFLING.prediction = HoltWinters.forecast(SHUFFLING.Data, alpha, beta, gamma,
                              period, m, true);

                      new PredicationChart().showChart();
                     
                      
                      
                             
                      

                  } catch (Exception e1) {

                  }

            }
        });
        
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
}
