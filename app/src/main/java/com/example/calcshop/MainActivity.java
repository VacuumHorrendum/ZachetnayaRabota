package com.example.calcshop;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    int k;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radioButton1:
                       k = 1;
                       break;
                    case R.id.radioButton2:
                        k =2;
                        break;
                    case R.id.radioButton3:
                        k = 3;
                        break;
                }
            }
        });
    }
    public void calc(View view) {
        EditText width = (EditText) findViewById(R.id.editText3);
        EditText height = (EditText) findViewById(R.id.editText2);
        EditText consumption = (EditText) findViewById(R.id.editText4);
        EditText layers = (EditText) findViewById(R.id.editText5);
        EditText volume = (EditText) findViewById(R.id.editText6);
        TextView result = (TextView) findViewById(R.id.textView9);

        double widthC = Double.parseDouble(width.getText().toString());
        double heightC = Double.parseDouble(height.getText().toString());
        double consumptionC = Double.parseDouble(consumption.getText().toString());
        double layersC = Double.parseDouble(layers.getText().toString());
        double volumeC = Double.parseDouble(volume.getText().toString());
        double square = widthC * heightC;
        double x = square * consumptionC * layersC;
        double y = x / volumeC;
        double okr = Math.ceil(y);
        int res;
       if (k == 1){
          double okr2 = okr*10/100;
          okr = okr+okr2;
        okr = Math.ceil(okr);
        res = (int) okr;
          result.setText("Банок понадобится: "+Integer.toString(res));
      }
       else if (k == 2) {
          double okr2 = okr*15/100;
         okr = okr+okr2;
         okr = Math.ceil(okr);
        res = (int) okr;
         result.setText("Банок понадобится: "+Integer.toString(res));
       }
        else if (k == 3){
           res = (int) okr;
           result.setText("Банок понадобится: "+Integer.toString(res));
       }
    }
    public void que(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Уточняйте у производителя!", Toast.LENGTH_SHORT);
        toast.show();
    }
    public void que2(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Позаботьтесь о том, чтобы краски хватило!", Toast.LENGTH_SHORT);
        toast.show();
    }
}

