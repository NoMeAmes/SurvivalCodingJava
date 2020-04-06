package com.study.survivalcodingjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // MainActivity 클래스 이름을 String 으로 변환해줌
    private static final String TAG = MainActivity.class.getSimpleName();

    public static final int QUANTITY_MIN = 0;
    public static final int QUANTITY_MAX = 10;
    public static final int COFFEE_PRICE = 3000;

    private Button mMinusButton;
    private Button mPlusButton;
    private TextView mQuantityTextView;
    // result 를 표기할 TextView
    private TextView mResultTextView;
    private Button mOrderButton;

    // 수량
    private int mQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 초기화
        init();

        // 레이아웃 표시
        setContentView(R.layout.activity_coffee);

        // 레이아웃에서 특정 id를 인스턴스 변수와 연결
        mMinusButton = (Button) findViewById(R.id.btn_minus);
        mPlusButton = (Button) findViewById(R.id.btn_plus);
        mQuantityTextView = (TextView) findViewById(R.id.txt_quantity);
        mResultTextView = (TextView) findViewById(R.id.txt_result);
        mOrderButton = (Button) findViewById(R.id.btn_order);

        // 무명클래스
        mMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // debug
//                Log.d (TAG, "마이너스 버튼 클릭");
//                Log.v (TAG, "일반로그");
//                Log.e (TAG, "에러로그");
//                Log.i (TAG, "정보로그");
//                Log.w (TAG, "경고로그");

                // Toast 메시지
//                Toast.makeText(MainActivity.this, "메세지", Toast.LENGTH_SHORT).show();

                mQuantity--;
                // 0보다 작을경우 0으로 제한
                if (mQuantity < QUANTITY_MIN) {
                    mQuantity = QUANTITY_MIN;
                }
                displayResult();

            }
        });
        mPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQuantity++;
                // 최대 10 개로 제한
                if (mQuantity > QUANTITY_MAX) {
                    mQuantity = QUANTITY_MAX;
                }
                displayResult();
            }
        });

        mOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = mResultTextView.getText().toString();
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

    }
    // 중복된 코드를 밖으로 뺌
    private void displayResult() {
        mQuantityTextView.setText("" + mQuantity);
        // "" + mQuantity int 가 들어오더라도 강제로 string 으로 만들어줌
        String result = "가격 : " + (COFFEE_PRICE * mQuantity) + "원\n감사합니다";
        mResultTextView.setText(result);
    }
    private void init() {
        mQuantity = 0;
    }
}
