import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class PrecisionLossPlot extends JFrame {

    public PrecisionLossPlot(String title) {
        super(title);

        // Create dataset for small values (denormalized)
        XYSeries smallSeries = new XYSeries("Denormalized Precision Loss");
        for (double v = Math.pow(10, -38); v < Math.pow(10, -1); v *= 1.1) {
            float convertedValue = (float) v;
            smallSeries.add(v, convertedValue);
        }

        // Create dataset for large values (normalized)
        XYSeries largeSeries = new XYSeries("Normalized Precision Loss");
        for (double v = Math.pow(10, 1); v < Math.pow(10, 38); v *= 1.1) {
            float convertedValue = (float) v;
            largeSeries.add(v, convertedValue);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(smallSeries);
        dataset.addSeries(largeSeries);

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Precision Loss in Floating Point Numbers",
                "Original Value (Log Scale)",
                "Converted Value (Log Scale)",
                dataset
        );

        // Customize the plot
        XYPlot plot = chart.getXYPlot();
        plot.getDomainAxis().setStandardTickUnits(org.jfree.chart.axis.NumberTickUnitSource.createIntegerTickUnits());
        plot.getRangeAxis().setStandardTickUnits(org.jfree.chart.axis.NumberTickUnitSource.createIntegerTickUnits());
        plot.setDomainPannable(true);
        plot.setRangePannable(true);

        // Create and set up the chart panel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PrecisionLossPlot example = new PrecisionLossPlot("Precision Loss Visualization");
            example.setSize(800, 600);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
