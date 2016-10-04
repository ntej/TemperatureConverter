package tempconverter.ntej.com.temperatureconverter;


import android.annotation.TargetApi;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.util.*;

@TargetApi(Build.VERSION_CODES.N)  //
public class MainActivity extends AppCompatActivity {

    private EditText cel;
    private EditText farh;
    private Button con_button;
    private Button clear_button;

    DecimalFormat round = new DecimalFormat("0.0");
    //private static final String TAG = "Converted value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cel = (EditText)findViewById(R.id.cel_editText);
        farh = (EditText)findViewById(R.id.farh_editText);
        con_button = (Button)findViewById(R.id.buttonid);
        clear_button = (Button)findViewById(R.id.clearbuttonid);

        con_button.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {

                String cel_field = cel.getText().toString();
                String farh_field = farh.getText().toString();


                if(cel_field.length()==0 && farh_field.length()>0)
                {
                    //farh to celcius


                    float f = Float.parseFloat(farh_field);

                    float c = (f-32f)*(5f/9f);

                    String celcius = round.format(c);

                    cel.setText(celcius+"C", TextView.BufferType.EDITABLE);

                    Toast.makeText(getApplicationContext(), "Converted from Fahrenheit to Celsius", Toast.LENGTH_SHORT).show();




                   //Log.v(TAG,"Temp:"+c);


                }
                else if (farh_field.length()==0 && cel_field.length()>0)
                {
                    //celcius to farh

                    float c = Float.parseFloat(cel_field);

                    float f = (c*(9f/5f))+32f;

                    String fahrenheit = round.format(f);

                    farh.setText(fahrenheit+"F",TextView.BufferType.EDITABLE);

                    Toast.makeText(getApplicationContext(), "Converted from Celsius to Fahrenheit", Toast.LENGTH_SHORT).show();


                }
                else if (cel_field.length()==0&&farh_field.length()==0)
                {
                    //show message "Enter Temp Value"
                    Toast.makeText(getApplicationContext(), "Enter Any One Temperature Value to Convert", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //show message "Enter only one value"
                    Toast.makeText(getApplicationContext(), "Enter only One Temperature Value", Toast.LENGTH_SHORT).show();
                }
            }
        });

        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cel.setText("");
                farh.setText("");
            }
        });

    }
}
