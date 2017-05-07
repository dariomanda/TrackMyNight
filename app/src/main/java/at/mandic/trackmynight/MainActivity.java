package at.mandic.trackmynight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //UserProfilButton
        ImageButton imgbtn = (ImageButton) findViewById(R.id.imageButton);

        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, UserProfilActivity.class));
            }
        });

        //Getraenke
        ImageButton imgbtn2 = (ImageButton) findViewById(R.id.imageButton2);

        imgbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Drinks.class));
            }
        });



    }
}
