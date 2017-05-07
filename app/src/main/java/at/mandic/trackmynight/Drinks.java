package at.mandic.trackmynight;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Drinks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        Button minusBier = (Button) findViewById(R.id.minusBier);
        Button minusWein = (Button) findViewById(R.id.minusWein);
        Button minusSchnaps = (Button) findViewById(R.id.minusSchnaps);
        Button minusVodka = (Button) findViewById(R.id.minusVodka);
        Button minusWhisky = (Button) findViewById(R.id.minusWhisky);

        Button plusBier = (Button) findViewById(R.id.plusBier);
        Button plusWein = (Button) findViewById(R.id.plusWein);
        Button plusSchnaps = (Button) findViewById(R.id.plusSchnaps);
        Button plusVodka = (Button) findViewById(R.id.plusVodka);
        Button plusWhisky = (Button) findViewById(R.id.plusWhisky);

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

        Context context = getApplicationContext();
        CharSequence text = "Cannot drink too negativ !";
        int duration = Toast.LENGTH_SHORT;
        final Toast toast = Toast.makeText(context, text, duration);


        plusBier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(String.valueOf(countBier.getText()));
                i++;
                countBier.setText(String.valueOf(i));
            }
        });

        plusWein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(String.valueOf(countWein.getText()));
                i++;
                countWein.setText(String.valueOf(i));
            }
        });

        plusSchnaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(String.valueOf(countSchnaps.getText()));
                i++;
                countSchnaps.setText(String.valueOf(i));
            }
        });

        plusVodka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(String.valueOf(countVodka.getText()));
                i++;
                countVodka.setText(String.valueOf(i));
            }
        });

        plusWhisky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(String.valueOf(countWhisky.getText()));
                i++;
                countWhisky.setText(String.valueOf(i));
            }
        });

        minusBier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(String.valueOf(countBier.getText()));
                if (i == 0) {
                    i = 0;
                    toast.show();
                } else {
                    i--;
                }
                countBier.setText(String.valueOf(i));
            }
        });

        minusWein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(String.valueOf(countWein.getText()));
                if (i == 0) {
                    i = 0;
                    toast.show();
                } else {
                    i--;
                }
                countWein.setText(String.valueOf(i));
            }
        });

        minusSchnaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(String.valueOf(countSchnaps.getText()));
                if (i == 0) {
                    i = 0;
                    toast.show();
                } else {
                    i--;
                }
                countSchnaps.setText(String.valueOf(i));
            }
        });

        minusVodka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(String.valueOf(countVodka.getText()));
                if (i == 0) {
                    i = 0;
                    toast.show();
                } else {
                    i--;
                }
                countVodka.setText(String.valueOf(i));
            }
        });

        minusWhisky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(String.valueOf(countWhisky.getText()));
                if (i == 0) {
                    i = 0;
                    toast.show();
                } else {
                    i--;
                }
                countWhisky.setText(String.valueOf(i));
            }
        });

        Button savebutton = (Button) findViewById(R.id.buttonSave);

        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedpreferences = getSharedPreferences("Getraenke", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString("Bier", countBier.getText().toString());
                editor.putString("Wein", countWein.getText().toString());
                editor.putString("Schnaps", countSchnaps.getText().toString());
                editor.putString("Vodka", countVodka.getText().toString());
                editor.putString("Whisky", countWhisky.getText().toString());
                editor.apply();

                Toast.makeText(Drinks.this, "Daten wurden gespeichert", Toast.LENGTH_LONG).show();
            }
        });




    }
}
