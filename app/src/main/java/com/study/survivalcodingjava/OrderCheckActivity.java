package com.study.survivalcodingjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class OrderCheckActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = OrderCheckActivity.class.getSimpleName();

    private TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_check);

        mResultTextView = (TextView) findViewById(R.id.result_text);

        findViewById(R.id.cancel_button).setOnClickListener(this);
        findViewById(R.id.ok_button).setOnClickListener(this);

        if (getIntent() != null) {
            String result = getIntent().getStringExtra("result");
            String comment = getIntent().getStringExtra("comment");

            Log.d(TAG, "onCreate: " + result + ", " + comment);
            mResultTextView.setText(result + "\n\n 코멘트 : " + comment);
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.cancel_button:
                // 현재 액티비티 종료
                finish();
                break;
            case R.id.ok_button:
                // 이메일로 쏘기
                String[] addresses = { "wahwah00@gmail.com" };
                composeEmail(addresses,
                        "주문 요청",
                        mResultTextView.getText().toString());
                break;
        }
    }

    private void composeEmail(String[] addresses, String subject, String text) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));  // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
