package at.mandic.trackmynight;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class UserProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profil);

        ///////////////////////////////////////////////////////////////////////////////////////////
        //Checkbox fuer Geschlechtsauswahl, es darf immer nur ein Geschlecht ausgewaehlt werden!!!
        final CheckBox maennlich = (CheckBox) findViewById(R.id.checkBox);
        final CheckBox weiblich =  (CheckBox) findViewById(R.id.checkBox2);

        maennlich.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    weiblich.setChecked(false);
                }
            }
        });
        weiblich.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    maennlich.setChecked(false);
                }
            }
        });
        ///////////////////////////////////////////////////////////////////////////////////////////


    }
}
