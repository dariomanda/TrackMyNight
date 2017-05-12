package at.mandic.trackmynight;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class UserProfilActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profil);

        final EditText name = (EditText) findViewById(R.id.editText);
        final EditText height = (EditText) findViewById(R.id.editText2);
        final EditText birthdate = (EditText) findViewById(R.id.editText3);
        final EditText weight = (EditText) findViewById(R.id.editText4);

        final CheckBox maennlich = (CheckBox) findViewById(R.id.checkBox);
        final CheckBox weiblich =  (CheckBox) findViewById(R.id.checkBox2);

        SharedPreferences sharedpreferences = getSharedPreferences("UserSettings", Context.MODE_PRIVATE);
        String Name = sharedpreferences.getString("Name","");
        String Alter = sharedpreferences.getString("Date","");
        String Gewicht = sharedpreferences.getString("Weight","");
        String Groesse = sharedpreferences.getString("Height", "");
        Boolean GenderMale = sharedpreferences.getBoolean("Male", false);
        Boolean GenderFemale = sharedpreferences.getBoolean("Female", false);

        name.setText(Name);
        birthdate.setText(Alter);
        weight.setText(Gewicht);
        height.setText(Groesse);
        maennlich.setChecked(GenderMale);
        weiblich.setChecked(GenderFemale);


        //Checkbox fuer Geschlechtsauswahl, es darf immer nur ein Geschlecht ausgewaehlt werden!!!
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

    }

    @Override
    protected void onStop() {
        super.onStop();

        final EditText name = (EditText) findViewById(R.id.editText);
        final EditText height = (EditText) findViewById(R.id.editText2);
        final EditText birthdate = (EditText) findViewById(R.id.editText3);
        final EditText weight = (EditText) findViewById(R.id.editText4);

        final CheckBox maennlich = (CheckBox) findViewById(R.id.checkBox);
        final CheckBox weiblich = (CheckBox) findViewById(R.id.checkBox2);

        SharedPreferences sharedpreferences = getSharedPreferences("UserSettings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putString("Name", name.getText().toString());
        editor.putString("Date", birthdate.getText().toString());
        editor.putString("Weight", weight.getText().toString());
        editor.putString("Height", height.getText().toString());
        editor.putBoolean("Male", maennlich.isChecked());
        editor.putBoolean("Female", weiblich.isChecked());
        editor.apply();
    }
}
