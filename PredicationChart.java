package NEWPACK;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.*;

public class PredicationChart {

    public void showChart() {
        XYSeriesCollection xyDataset = new XYSeriesCollection();

        XYSeries series1 = new XYSeries("Actual Data");
        XYSeries series2 = new XYSeries("Predicted Data");
        for (int i = 0; i < SHUFFLING.Data.length-12; i++) {
            series1.add(i + 1, SHUFFLING.Data[i]);
        }
        for (int i = 0; i < SHUFFLING.prediction.length; i++) {
            series2.add(i + 1, Math.abs(SHUFFLING.prediction[i]));
        }

        xyDataset.addSeries(series1);
        xyDataset.addSeries(series2);
        
        String mess="Next year Sales Prediction\n\n";
        int c = 1;
        for (int i = SHUFFLING.Data.length-13; i < SHUFFLING.prediction.length; i++) {
        	mess += "M" + c + " : " + Math.abs(SHUFFLING.prediction[i]) + "\n";
            c++;
        }
        JOptionPane.showMessageDialog(new JFrame(), mess);
        
        

        JFreeChart chart = ChartFactory.createScatterPlot("Sales Prediction", "Monthly", "Predicted Value", xyDataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, true);
        plot.setRenderer(renderer);
        ChartFrame frame1 = new ChartFrame("Sales Prediction", chart);
        frame1.setVisible(true);
        frame1.setSize(800, 400);

    }

}
