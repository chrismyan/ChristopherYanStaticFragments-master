package edu.westga.christopheryanstaticfragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements DataEntryFragment.DataEntryListener {

    @Override
    public void onDataEntry(double first, double second) {
        DataDisplayFragment displayFragment = (DataDisplayFragment)
                getSupportFragmentManager().findFragmentById(R.id.dataDisplayFragment);

        TextView firstNumber = (TextView)  findViewById(R.id.editText);
        String firstNumberStr = firstNumber.getText().toString();

        TextView secondNumber = (TextView)  findViewById(R.id.editText2);
        String secondNumberStr = secondNumber.getText().toString();

        // Validate values of first and second number
        double firstNumberDbl;
        if(firstNumberStr == null || firstNumberStr.isEmpty()) {
            firstNumberDbl = 0.0;
        } else {
            firstNumberDbl = Double.parseDouble(firstNumber.getText().toString());
        }

        double secondNumberDbl;
        if(secondNumberStr == null || secondNumberStr.isEmpty()) {
            secondNumberDbl = 0.0;
        } else {
            secondNumberDbl = Double.parseDouble(secondNumber.getText().toString());
        }
        displayFragment.setFirstNumber(firstNumberDbl);
        displayFragment.setSecondNumber(secondNumberDbl);
        displayFragment.multiply(firstNumberDbl, secondNumberDbl);
        displayFragment.displayProduct();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
