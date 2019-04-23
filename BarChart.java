package NEWPACK;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.sql.*;
import java.util.Random;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class BarChart extends JPanel {

    String title, xtitle, ytitle;
    DefaultCategoryDataset dataset;

    public static void main(String arg[]) {
        ApplicationFrame app = new ApplicationFrame("");
        BarChart chart = new BarChart("asdsa", "Node", "Mem");
        chart.addValue(100, "M", "1");
        chart.addValue(120, "M", "2");
        chart.addValue(150, "M", "3");
        chart.createChart();
        app.setContentPane(chart);
        app.setDefaultCloseOperation(app.HIDE_ON_CLOSE);
        app.setSize(500, 400);
        app.setVisible(true);
    }

    public BarChart(String title, String xtitle, String ytitle) {
        this.title = title;
        this.xtitle = xtitle;
        this.ytitle = ytitle;
        dataset = new DefaultCategoryDataset();
    }

    void addValue(double val, String xaxis, String yaxis) {
        dataset.addValue(val, xaxis, yaxis);
    }

    public void createChart() {

        // create the chart...
        JFreeChart chart = ChartFactory.createBarChart(
                title, // chart title
                xtitle, // domain axis label
                ytitle, // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips?
                false // URLs?
                );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...

        // set the background color for the chart...
        chart.setBackgroundPaint(Color.white);

        // get a reference to the plot for further customisation...
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // disable bar outlines...
        final BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);

        // set up gradient paints for series...
        final GradientPaint gp0 = new GradientPaint(
                0.0f, 0.0f, Color.blue,
                0.0f, 0.0f, Color.lightGray);
        final GradientPaint gp1 = new GradientPaint(
                0.0f, 0.0f, Color.green,
                0.0f, 0.0f, Color.lightGray);
        final GradientPaint gp2 = new GradientPaint(
                0.0f, 0.0f, Color.red,
                0.0f, 0.0f, Color.lightGray);
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);

        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
                CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0));
        // OPTIONAL CUSTOMISATION COMPLETED.
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 400));
        add(chartPanel);
    }
    int getVal(int m,int n) {
        
        int x = 0;
        Random r = new Random();
            x = m+r.nextInt(n-m);
        return x;
    }

    double[] sorta(double xx[]) {
        for (int i = 0; i < xx.length; i++) {
            for (int j = i + 1; j < xx.length; j++) {
                if (xx[i] > xx[j]) {
                    double t = xx[i];
                    xx[i] = xx[j];
                    xx[j] = t;
                }
            }
        }
        return xx;
    }

    double[] sortd(double xx[]) {
        for (int i = 0; i < xx.length; i++) {
            for (int j = i + 1; j < xx.length; j++) {
                if (xx[i] < xx[j]) {
                    double t = xx[i];
                    xx[i] = xx[j];
                    xx[j] = t;
                }
            }
        }
        return xx;
    }
}