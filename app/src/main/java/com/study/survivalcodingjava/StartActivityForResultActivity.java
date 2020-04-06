package com.study.survivalcodingjava;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class StartActivityForResultActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_CODE_EXAMPLE = 1000;
    public static final int REQUEST_CODE_MEMO = 2000;
    public static final int REQUEST_CODE_UPDATE_MEMO = 3000;

    private EditText mValueEditText;
    private static final String TAG = StartActivityForResultActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_for_result);

        mValueEditText = (EditText) findViewById(R.id.value_edt);

        findViewById(R.id.submit_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, TargetActivity.class);
        intent.putExtra("value", mValueEditText.getText().toString());
        // 일방통행
//        startActivity(intent);
        // 주거니 받거니
        startActivityForResult(intent, REQUEST_CODE_EXAMPLE);
        // requestCode 에 1000 을 넣는 이유
        // 하나의 인텐트가 아닌 여러 개의 인텐트에서 또는 버튼에서 데이터값이 넘어 올 경우
        // 구분이 되지 않기 때문에 코드의 번호를 지정한다ㅣ.
        // 너무 많아져 관리하기 어려워지면 1000 도 상수를 사용
    }

    // 받을 때 호출되는 콜백 메서드

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_EXAMPLE && resultCode == RESULT_OK && data != null) {
            Log.d(TAG, "onActivityResult: " + requestCode);
            Log.d(TAG, "onActivityResult: " + resultCode);
            Log.d(TAG, "onActivityResult: " + data);
            String result = data.getStringExtra("result");
            int value = data.getIntExtra("int", -1);
            Toast.makeText(this, result + ", int: " + value, Toast.LENGTH_SHORT).show();
        } else if (requestCode == REQUEST_CODE_MEMO) {

        } else if (requestCode == REQUEST_CODE_UPDATE_MEMO) {

        }

    }
}
