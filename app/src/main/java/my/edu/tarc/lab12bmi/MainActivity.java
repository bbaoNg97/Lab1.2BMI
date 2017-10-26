package my.edu.tarc.lab12bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextWeight, editTextHeight;
    private TextView textViewResult;
    private ImageView imageViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Link code with variable
        editTextWeight=(EditText)findViewById(R.id.editTextWeight);
        editTextHeight=(EditText)findViewById(R.id.editTextHeight);
        textViewResult=(TextView)findViewById(R.id.textViewResult);
        imageViewResult=(ImageView)findViewById(R.id.imageViewResult);
    }

    public double calculateBMI(Double w, Double h){
        double BMIresult;

        BMIresult=w/(h*h);
        return BMIresult;
    }
    public void displayBMI(View view){
        double weight,height,result;
        weight=Double.parseDouble(editTextWeight.getText().toString());
        height=Double.parseDouble(editTextHeight.getText().toString());
        height/=100;
        result=calculateBMI(weight,height);
        //String use " "+ , then it will convert to String
        textViewResult.setText("BMI: "+String.format("%.2f",result));
        if(result<=18.5){
            imageViewResult.setImageResource(R.drawable.under);
        }
        else if(result>=25){
            imageViewResult.setImageResource(R.drawable.over);
        }
        else
            imageViewResult.setImageResource(R.drawable.normal);
    }
  public void resetScreen(View view){
      editTextHeight.setText("");
      editTextWeight.setText("");
      textViewResult.setText("");
      imageViewResult.setImageResource(R.drawable.empty);
  }

}
