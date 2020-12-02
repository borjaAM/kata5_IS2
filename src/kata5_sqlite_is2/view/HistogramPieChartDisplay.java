package kata5_sqlite_is2.view;

import javax.swing.JPanel;
import kata5_sqlite_is2.model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramPieChartDisplay extends ApplicationFrame {
    Histogram<String> histogram;
    private final String title;
    
    public HistogramPieChartDisplay(Histogram histogram, String title) {
        super(title);
        this.title = title;
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
    }

    public void execute() {
        this.setVisible(true);
    }

    private JPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createPieChart3D(createPieDataset()));
        return chartPanel;
    }

    private JFreeChart createPieChart3D(PieDataset dataSet){
        JFreeChart pieChart = ChartFactory.createPieChart3D(title, dataSet, true, true, false);
        return pieChart;
    }
    
    private PieDataset createPieDataset(){
        DefaultPieDataset pds = new DefaultPieDataset();
        for (String key : histogram.keySet()) {
            pds.setValue(key, histogram.get(key));
        }
        return pds;
    }
}
