package space.schnieder.fuelcalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Integer remainingFuel = 0;
    Integer rampFuel = 0;
    Integer uplift = 0;
    int calcLiter = 0;
    String eingabe = "";
    double output = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /** wird aufgerufen, sobald der Button gedrückt wird */

    public void calculateFuel(View view) {
        editText = (EditText) findViewById(R.id.remaining_fuel);
        eingabe = editText.getText().toString();
        remainingFuel = Integer.valueOf(eingabe);
        output = ( (double) remainingFuel / 10);
        editText.setText("" + output + "oo");
        remainingFuel = remainingFuel * 100;

        editText = (EditText) findViewById(R.id.ramp_fuel);
        eingabe = editText.getText().toString();
        rampFuel = Integer.valueOf(eingabe);
        output = ( (double) rampFuel / 10);
        editText.setText("" + output + "oo");
        rampFuel = Integer.valueOf(eingabe) * 100;

        uplift = rampFuel - remainingFuel;
        calcLiter = (int) ((uplift * 0.567) + 0.5);
        // calcLiter = 12344;
        TextView textUplift = (TextView) findViewById(R.id.uplift);
        output = ( (double) uplift / 1000);
        textUplift.setText("" + output + "oo");

        output = ( (double) calcLiter / 1000);
        TextView textCalcLiters = (TextView) findViewById(R.id.calc_liters);
        textCalcLiters.setText("" + output);



    }

}
