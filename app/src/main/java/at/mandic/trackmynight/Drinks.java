package at.mandic.trackmynight;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Drinks extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
        TextView startTime = (TextView) findViewById(R.id.startTime);
        TextView stop = (TextView) findViewById(R.id.endTime);
        SharedPreferences sharedpreferenc = getSharedPreferences("Zeit", Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = sharedpreferences.edit();
        long start = sharedpreferenc.getLong("StartTime", 0);
        if (Global.valueEndTime==null){
            stop.setText("Endzeit: ");
        }
        else {
            stop.setText("Endzeit: " + Global.valueEndTime);
        }
        startTime.setText("Startzeit: " + Global.convertDateSMS(start));


        final TextView countBier = (TextView) findViewById(R.id.cntBier);
        final TextView countWein = (TextView) findViewById(R.id.cntWein);
        final TextView countSchnaps = (TextView) findViewById(R.id.cntSchnaps);
        final TextView countVodka = (TextView) findViewById(R.id.cntVodka);
        final TextView countWhisky = (TextView) findViewById(R.id.cntWhisky);

        SharedPreferences sharedpreferences = getSharedPreferences("Getraenke", Context.MODE_PRIVATE);
        String Bier = sharedpreferences.getString("Bier", "0");
        String Wein = sharedpreferences.getString("Wein", "0");
        String Schnaps = sharedpreferences.getString("Schnaps", "0");
        String Vodka = sharedpreferences.getString("Vodka", "0");
        String Whisky = sharedpreferences.getString("Whisky", "0");

        countBier.setText(Bier);
        countWein.setText(Wein);
        countSchnaps.setText(Schnaps);
        countVodka.setText(Vodka);
        countWhisky.setText(Whisky);
    }

    public int plus(int count) {
        int i = count;
        i++;
        return i;
    }

    public int minus(int count) {
        Context context = getApplicationContext();
        CharSequence text = "Cannot drink too negativ !";
        int duration = Toast.LENGTH_SHORT;
        final Toast toast = Toast.makeText(context, text, duration);

        if (count == 0) {
            count = 0;
            toast.show();
            return count;
        } else {
            int i = count;
            i--;
            return i;
        }
    }

    public void plusWein(View view) {
        TextView countWein = (TextView) findViewById(R.id.cntWein);
        int i = Integer.parseInt(String.valueOf(countWein.getText()));
        i = plus(i);
        countWein.setText(String.valueOf(i));
    }

    public void plusBier(View view) {
        TextView countBier = (TextView) findViewById(R.id.cntBier);
        int i = Integer.parseInt(String.valueOf(countBier.getText()));
        i = plus(i);
        countBier.setText(String.valueOf(i));
    }

    public void plusSchnaps(View view) {
        TextView countSchnaps = (TextView) findViewById(R.id.cntSchnaps);
        int i = Integer.parseInt(String.valueOf(countSchnaps.getText()));
        i = plus(i);
        countSchnaps.setText(String.valueOf(i));
    }

    public void plusVodka(View view) {
        TextView countVodka = (TextView) findViewById(R.id.cntVodka);
        int i = Integer.parseInt(String.valueOf(countVodka.getText()));
        i = plus(i);
        countVodka.setText(String.valueOf(i));
    }

    public void plusWhisky(View view) {
        TextView countWhisky = (TextView) findViewById(R.id.cntWhisky);
        int i = Integer.parseInt(String.valueOf(countWhisky.getText()));
        i = plus(i);
        countWhisky.setText(String.valueOf(i));
    }

    public void minusBier(View view) {
        TextView countBier = (TextView) findViewById(R.id.cntBier);
        int i = Integer.parseInt(String.valueOf(countBier.getText()));
        i = minus(i);
        countBier.setText(String.valueOf(i));
    }

    public void minusWein(View view) {
        TextView countWein = (TextView) findViewById(R.id.cntWein);
        int i = Integer.parseInt(String.valueOf(countWein.getText()));
        i = minus(i);
        countWein.setText(String.valueOf(i));
    }

    public void minusSchnaps(View view) {
        TextView countSchnaps = (TextView) findViewById(R.id.cntSchnaps);
        int i = Integer.parseInt(String.valueOf(countSchnaps.getText()));
        i = minus(i);
        countSchnaps.setText(String.valueOf(i));
    }

    public void minusVodka(View view) {
        TextView countVodka = (TextView) findViewById(R.id.cntVodka);
        int i = Integer.parseInt(String.valueOf(countVodka.getText()));
        i = minus(i);
        countVodka.setText(String.valueOf(i));
    }

    public void minusWhisky(View view) {
        TextView countWhisky = (TextView) findViewById(R.id.cntWhisky);
        int i = Integer.parseInt(String.valueOf(countWhisky.getText()));
        i = minus(i);
        countWhisky.setText(String.valueOf(i));
    }

    @Override
    protected void onStop() {
        super.onStop();
        TextView countBier = (TextView) findViewById(R.id.cntBier);
        TextView countWein = (TextView) findViewById(R.id.cntWein);
        TextView countSchnaps = (TextView) findViewById(R.id.cntSchnaps);
        TextView countVodka = (TextView) findViewById(R.id.cntVodka);
        TextView countWhisky = (TextView) findViewById(R.id.cntWhisky);
        TextView startTime = (TextView) findViewById(R.id.startTime);
        TextView endTime = (TextView) findViewById(R.id.endTime);


        SharedPreferences sharedpreferences = getSharedPreferences("Getraenke", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putString("Bier", countBier.getText().toString());
        editor.putString("Wein", countWein.getText().toString());
        editor.putString("Schnaps", countSchnaps.getText().toString());
        editor.putString("Vodka", countVodka.getText().toString());
        editor.putString("Whisky", countWhisky.getText().toString());
        editor.apply();

    }

    public void stopTracking(View view){
        TextView stop = (TextView) findViewById(R.id.endTime);
        if(Global.valueEndTime==null) {
            stop.setText("Endzeit: " + Global.convertDate(Global.getTime()));
            Global.valueEndTime = Global.convertDate(Global.getTime());
            Global.endzeit = Global.getTime();
        }
        Intent reports = new Intent(this, Reports.class);
        startActivity(reports);
    }

}
