package com.example.marti.palindromchecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String input;
    String output;

    Button checkWordButton;

    TextView inputText;
    TextView outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(+R.id.txtInput);
        outputText = findViewById(+R.id.txtOutput);

        checkWordButton = findViewById(+R.id.btnCheck);

        checkWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = inputText.getText().toString();
                if(input.length() == 0) {
                    output = getString(R.string.noTextFound);
                } else if (input.length() < 6) {
                    output = getString(R.string.wordToShortText);
                } else if (isPalindrome(input)) {
                    output = getString(R.string.succsessText);
                } else {
                    output = getString(R.string.noSuccsessText);
                }
                outputText.setText(output);
            }
        });
    }

    public static boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
