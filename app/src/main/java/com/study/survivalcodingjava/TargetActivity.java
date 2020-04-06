package com.study.survivalcodingjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TargetActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mValueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);

        mValueTextView = (TextView) findViewById(R.id.value_text);

        findViewById(R.id.result_button).setOnClickListener(this);

        if (getIntent() != null) {
            String value = getIntent().getStringExtra("value");
            mValueTextView.setText(value);
        }
    }

    @Override
    public void onClick(View v) {
        // 결과 전달
        Intent intent = new Intent();
        intent.putExtra("result", "이것은 내가 지정한 문구다");
        intent.putExtra("int", 50);
        setResult(RESULT_OK, intent);
//        setResult(RESULT_CANCELED);
        finish();
    }
}
