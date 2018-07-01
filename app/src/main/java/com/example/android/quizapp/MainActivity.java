package com.example.android.quizapp;

import android.content.Context;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int grade = 0;
    int lengthBox = 4;
    int lenghtCount = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        }


/* method defines action to take place when submit Button is clicked
@ CheckBox counts number of time a checkbox can be selected
Also all the correct answers are declared here
 */
    public void submitButton(View view) {
        final CheckBox[] checkbox = new CheckBox[lengthBox];
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (((RadioButton) findViewById(R.id.q1r2)).isChecked()) {
                    grade++;
                }
                if (((RadioButton) findViewById(R.id.q2r1)).isChecked()) {
                    grade++;
                }
                if (((RadioButton) findViewById(R.id.q6r1)).isChecked()) {
                    grade++;
                }
                if (((RadioButton) findViewById(R.id.q7r1)).isChecked()) {
                    grade++;
                }
                // checking that the wrong number of checkboxes are not selected
                if (((CheckBox) findViewById(R.id.q4c2)).isChecked() && ((CheckBox) findViewById(R.id.q4c3)).isChecked()) {

                    if (checkbox[0].isChecked() || checkbox[1].isChecked() ||
                            checkbox[2].isChecked() || checkbox[3].isChecked()) {
                        if (lenghtCount < 2) {
                            lenghtCount++;
                        } else
                            Toast.makeText(MainActivity.this, "Limit reached!!!", Toast.LENGTH_SHORT).show();

                        {

                            grade++;
                        }
                    }
                }

                    if (((EditText) findViewById(R.id.q3e1)).getText().toString().equalsIgnoreCase("Android Debug Bridge")) {
                        grade++;
                    }
                    if (((EditText) findViewById(R.id.q5e1)).getText().toString().equalsIgnoreCase("bin/")) {
                        grade++;
                    }
                    if (((EditText) findViewById(R.id.q8e1)).getText().toString().equalsIgnoreCase("android asset packaging tool")) {
                        grade++;
                    }

                    String displayMessage = (displayResult());

                }


        });

    }

    /* This is where the toast is defined
     This method handles score display
     */


    private String displayResult() {
        String message = "You scored " + grade;
        message += " out of 8";
        message += "\nNice attempt!";
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        finish();
        startActivity(getIntent());
        return message;
    }

    private void shareResult(View view) {
        String result = displayResult();
        Intent mIntent = new Intent(Intent.ACTION_SENDTO);
        mIntent.setData(Uri.parse("mailto:"));
        mIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{""});
        mIntent.putExtra(Intent.EXTRA_SUBJECT, "@string/your result");
        mIntent.putExtra(Intent.EXTRA_TEXT, result);

        if (mIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(mIntent, "Send Email Using..."));
        }


    }
}









