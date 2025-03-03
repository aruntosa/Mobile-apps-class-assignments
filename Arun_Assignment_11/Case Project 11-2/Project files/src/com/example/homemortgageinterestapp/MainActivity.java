package com.example.homemortgageinterestapp;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.BaseBundle;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
	float intMonthlyPayment;
	int intNumberOfYears;
	int intPrincipalLoanAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText monthlyPayment=(EditText)findViewById(R.id.numMonthlyPayment);
        final EditText numberOfYears=(EditText)findViewById(R.id.numYears);
        final EditText principalLoanAmount=(EditText)findViewById(R.id.numInterestPaid);
        Button btCompute = (Button)findViewById(R.id.btnCompute);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        btCompute.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				intMonthlyPayment = Float.parseFloat(monthlyPayment.getText().toString());
				intNumberOfYears = Integer.parseInt(numberOfYears.getText().toString());
				intPrincipalLoanAmount = Integer.parseInt(principalLoanAmount.getText().toString());
				SharedPreferences.Editor editor = sharedPref.edit();
				editor.putFloat("key1", intMonthlyPayment);
				editor.putInt("key2", intNumberOfYears);
				editor.putInt("key3", intPrincipalLoanAmount);
				editor.commit();
				startActivity(new Intent(MainActivity.this, Years.class));
			}
		});
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
