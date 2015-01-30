package com.example.bmicalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	
	
	
	double bmi = 0.0;
	double weight = 0.0;
	double height = 0.0;
	
	private TextView displayTextView;
	private Button bmiBtn;
	public TextView textView1;
	public TextView resultMessage;
	private RadioGroup rdGroup;
	
	EditText inputWeight;
	EditText inputHeight;
	
	private RadioButton engButton;
	private RadioButton metricButton;
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        inputWeight = (EditText) findViewById(R.id.weightEditText);
        
        inputHeight = (EditText) findViewById(R.id.heightEditText);
        
        textView1 = (TextView) findViewById(R.id.textView1);
        resultMessage = (TextView) findViewById(R.id.textView3);
        
        
       rdGroup = (RadioGroup) findViewById(R.id.radioGroup1);
       engButton = (RadioButton)findViewById(R.id.engRadioBtn);
       metricButton = (RadioButton)findViewById(R.id.MetricRadioBtn);
       
       engButton.setOnClickListener(this);
       metricButton.setOnClickListener(this);
       
       
    
       
        
        
        final Button button = (Button) findViewById(R.id.bmiCalcBtn);
        
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	
            	 
            	int ckint = rdGroup.getCheckedRadioButtonId();
        		
        		switch (ckint) {
        		case R.id.engRadioBtn:
        			if(engButton.isChecked())
        			{
        				
        				
        				engbmi();
        				bmivalues();
        				
        			}
        			
        			break;
        		
        		case R.id.MetricRadioBtn:
        			if(metricButton.isChecked())
        			{
        				
        				
        				metricbmi();
        				bmivalues();
        			
        			}
        			
        			break;
        			
        		default:
        			Toast.makeText(MainActivity.this, 
        				    "default", Toast.LENGTH_LONG).show();
        			break;
        		}
            	
            	
            }
        });
        
     
    
        
      }
        
       
          
    private void engbmi() 
    {
    	
    	String w = null;
		String h = null;
		//engbmi();
		w = inputWeight.getText().toString();
		weight = Double.parseDouble(w);
		
		h = inputHeight.getText().toString();
		height = Double.parseDouble(h);
		
		bmi = ((weight * 703)/(height * height));
		
		textView1.setText(String.valueOf(bmi));
    	
    	
    }
    
    private void metricbmi() 
    {
    	String w = null;
		String h = null;
		w = inputWeight.getText().toString();
		weight = Double.parseDouble(w);
		
		h = inputHeight.getText().toString();
		height = Double.parseDouble(h);
		
		bmi = (weight/(height * height));
		
		textView1.setText(String.valueOf(bmi));
    	
    	
    }
        
    private void bmivalues()
    {
    	String result = null;
    	
    	if(bmi<18.5)
    		result = "Underweight";
    	else if(bmi>18.5 && bmi<24.9)
    		result = "Normal";
    	else if(bmi>25 && bmi<29.9)
    		result = "Overweight";
    	else if(bmi>=30)
    		result = "Obese";
    	
    	resultMessage.setText(result);
    	
    		
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








	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int ckint = rdGroup.getCheckedRadioButtonId();
		
		switch (ckint) {
		case R.id.engRadioBtn:
			if(engButton.isChecked()){}
			
			break;
		
		case R.id.MetricRadioBtn:
			if(metricButton.isChecked()){}
			
			break;
			
		default:
			break;
		}
		
		
	}
}
