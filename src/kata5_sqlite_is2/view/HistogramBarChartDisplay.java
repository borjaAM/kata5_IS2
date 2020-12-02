package kata5_sqlite_is2.view;

import kata5_sqlite_is2.model.Histogram;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramBarChartDisplay extends ApplicationFrame{
    Histogram<String> histogram;
    private final String title;
    private final String xAxisLabel;
    private final String yAxisLabel;
    public HistogramBarChartDisplay(Histogram histogram, String title, String xAxisLabel, String yAxisLabel) {
        super(title);
        this.title = title;
        this.xAxisLabel = xAxisLabel;
        this.yAxisLabel = yAxisLabel;
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
    }

    public void execute() {
        this.setVisible(true);
    }

    private JPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        return chartPanel;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataSet) {
        JFreeChart freeChart = ChartFactory.createBarChart(title, xAxisLabel, yAxisLabel,
                dataSet, PlotOrientation.VERTICAL,
                false, false, rootPaneCheckingEnabled);
        return freeChart;
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for(String key : histogram.keySet()){
            dataSet.addValue(histogram.get(key), "", key);
        }
        return dataSet;
    }
    
}
