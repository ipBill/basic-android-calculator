package up1.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText firstNumber = (EditText) findViewById(R.id.firstNumber);
        final EditText secondNumber = (EditText) findViewById(R.id.secondNumber);
        final TextView resultTextView = (TextView) findViewById(R.id.result);
        final RadioGroup operatorType = (RadioGroup) findViewById(R.id.operatorType);

        Button calculateButton = (Button) findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(firstNumber.getText() == null || firstNumber.getText().toString().isEmpty()) {
                    firstNumber.setError("Please input data");
                    return;
                }

                if(secondNumber.getText() == null || secondNumber.getText().toString().isEmpty()) {
                    secondNumber.setError("Please input data");
                    return;
                }

                int first = Integer.parseInt(firstNumber.getText().toString());
                int second = Integer.parseInt(secondNumber.getText().toString());
                int result = 0;
                switch (operatorType.getCheckedRadioButtonId()) {
                    case R.id.plus :
                        result = first + second;
                        break;
                    case R.id.minus :
                        result = first - second;
                        break;
                    case R.id.multiply :
                        result = first * second;
                    case R.id.divide :
                        result = first / second;
                        break;
                }
                resultTextView.setText(String.valueOf(result));
            }
        });

    }
}
