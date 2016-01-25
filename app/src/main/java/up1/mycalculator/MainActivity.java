package up1.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText firstNumber = (EditText) findViewById(R.id.firstNumber);
        final EditText secondNumber = (EditText) findViewById(R.id.secondNumber);
        final TextView resultTextView = (TextView)findViewById(R.id.result);

        Button calculateButton = (Button) findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int first = Integer.parseInt(firstNumber.getText().toString());
                int second = Integer.parseInt(secondNumber.getText().toString());
                int result = first + second;
                resultTextView.setText(String.valueOf(result));
            }
        });

    }
}
