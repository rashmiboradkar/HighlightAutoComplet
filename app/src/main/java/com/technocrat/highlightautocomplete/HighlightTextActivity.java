package com.technocrat.highlightautocomplete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HighlightTextActivity extends AppCompatActivity {

    //initialise variable
    private EditText etText;
    private TextView tvText;
    private Button btnHighlight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highlight_text);

        initialise();
        btnHighlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get text from edittext
                String textToHighlight = etText.getText().toString();

                //create formatted text
                String replacewith = "<span style='backgroung-color:yellow'>"+textToHighlight+"</span>";

                //get text from textview
                String originalText = tvText.getText().toString();

                //replace edittext text with formatted text
                String modifiedText = originalText.replaceAll(textToHighlight,replacewith);

                //now update the textview
                tvText.setText(Html.fromHtml(modifiedText));
            }
        });
    }

    private void initialise() {
        etText = findViewById(R.id.et_search);
        tvText = findViewById(R.id.tv_highlight);
        btnHighlight = findViewById(R.id.btn_highlight);
    }

}