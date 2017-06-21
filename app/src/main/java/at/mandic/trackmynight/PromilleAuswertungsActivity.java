package at.mandic.trackmynight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PromilleAuswertungsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promille_auswertungs);

        BarChart barChart = (BarChart) findViewById(R.id.chart);

        Berechnung test = new Berechnung(this);

        ArrayList<BarEntry> barEntries = new ArrayList<>();

        double a = test.promille(0);
        double b = test.promille(1);
        double c = test.promille(2);
        double d = test.promille(3);
        double e = test.promille(4);


        barEntries.add(new BarEntry(0, (float) a));
        barEntries.add(new BarEntry(1, (float) b));
        barEntries.add(new BarEntry(2, (float) c));
        barEntries.add(new BarEntry(3, (float) d));
        barEntries.add(new BarEntry(4, (float) e));

        BarDataSet barDataSetBier = new BarDataSet(barEntries.subList(0, 1), "Bier");
        barDataSetBier.setColors(ColorTemplate.VORDIPLOM_COLORS[2]);
        BarDataSet barDataSetWein = new BarDataSet(barEntries.subList(1, 2), "Wein");
        barDataSetWein.setColors(ColorTemplate.VORDIPLOM_COLORS[1]);
        BarDataSet barDataSetSchnaps = new BarDataSet(barEntries.subList(2, 3), "Schnaps");
        barDataSetSchnaps.setColor(ColorTemplate.VORDIPLOM_COLORS[4]);
        BarDataSet barDataSetVodka = new BarDataSet(barEntries.subList(3, 4), "Vodka");
        barDataSetVodka.setColor(ColorTemplate.VORDIPLOM_COLORS[3]);
        BarDataSet barDataSetWhisky = new BarDataSet(barEntries.subList(4, 5), "Whisky");
        barDataSetWhisky.setColor(ColorTemplate.VORDIPLOM_COLORS[0]);

        ArrayList<IBarDataSet> alkoholsorten = new ArrayList<IBarDataSet>();
        alkoholsorten.add(barDataSetBier);
        alkoholsorten.add(barDataSetWein);
        alkoholsorten.add(barDataSetSchnaps);
        alkoholsorten.add(barDataSetVodka);
        alkoholsorten.add(barDataSetWhisky);

        BarData data = new BarData(alkoholsorten);
        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);
        barChart.setDescription(null);
        barChart.setMotionEventSplittingEnabled(true);
        barChart.animateX(3000);
        barChart.setData(data);

        double f = test.promille(5);

        TextView textView = (TextView) findViewById(R.id.textView10);
        textView.setText("Absoluter Promillewert : " + Double.toString(f));
    }
}
