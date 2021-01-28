package com.example.halloffame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvHeader;
    TextView tvNamePlayer1;
    TextView tvBirthPlayer1;
    TextView tvInfoPlayer1;
    TextView tvNamePlayer2;
    TextView tvBirthPlayer2;
    TextView tvInfoPlayer2;
    TextView tvNamePlayer3;
    TextView tvBirthPlayer3;
    TextView tvInfoPlayer3;

    EditText etEnterNewDescriptionHint;

    Button btnInspiration;
    Button btnEditDescription;

    RadioButton rbPlayer1;
    RadioButton rbPlayer2;
    RadioButton rbPlayer3;

    ImageView ivPlayer1;
    ImageView ivPlayer2;
    ImageView ivPlayer3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeUI();
    }

    private void initializeUI(){
        this.ivPlayer2 = (ImageView) findViewById(R.id.ivPlayer2);
        this.btnInspiration = (Button) findViewById(R.id.btnInspiration);
        this.rbPlayer1 = (RadioButton) findViewById(R.id.rbPlayer1);
        this.rbPlayer2 = (RadioButton) findViewById(R.id.rbPlayer2);
        this.rbPlayer3 = (RadioButton) findViewById(R.id.rbPlayer3);
        this.etEnterNewDescriptionHint = (EditText) findViewById(R.id.etEnterNewDescriptionHint);
        this.tvInfoPlayer1 = (TextView) findViewById(R.id.tvInfoPlayer1);
        this.tvInfoPlayer2 = (TextView) findViewById(R.id.tvInfoPlayer2);
        this.tvInfoPlayer3 = (TextView) findViewById(R.id.tvInfoPlayer3);
    }

    public void onClick(View view){
        this.ivPlayer2.setVisibility(View.INVISIBLE);
    }

    public void onClickFact(View view){
        String message = "Best player in the world!";
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void onClickInfo(View view){
        String info = "CR7";
        Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
    }

    public void onClickInspiration(View view){
        String inspiration = getRandomFact();
        Toast.makeText(this, inspiration, Toast.LENGTH_SHORT).show();
    }

    private String getRandomFact(){
        int number = (int)(Math.random()*((3-1)+1))+1;
        String randomFact = "inspiration";
        if(number == 1){
            randomFact = "There are ups and downs, but whatever happens, you have to trust and believe in yourself. - L. Modrić";
        }
        if(number == 2){
            randomFact="I can’t help but laugh at how perfect I am. – Peak Zlatan";
        }
        if(number == 3){
            randomFact = "I don't mind people hating me, because it pushes me. - C. Ronaldo";
        }
        return randomFact;
    }

    public void changeRadioButton(View view){
        switch (view.getId()) {
            case R.id.rbPlayer1:
                if (rbPlayer1.isChecked()) {
                    rbPlayer2.setChecked(false);
                    rbPlayer3.setChecked(false);
                }
                break;
            case R.id.rbPlayer2:
                if (rbPlayer2.isChecked()) {
                    rbPlayer1.setChecked(false);
                    rbPlayer3.setChecked(false);
                }
                break;
            case R.id.rbPlayer3:
                if (rbPlayer3.isChecked()) {
                    rbPlayer1.setChecked(false);
                    rbPlayer2.setChecked(false);
                }
                break;
        }
    }

    public void changeInfo(View view){
        String newInfo = String.valueOf(etEnterNewDescriptionHint.getText());
        if(rbPlayer1.isChecked()){
            tvInfoPlayer1.setText(newInfo);
        }
        if(rbPlayer3.isChecked()){
            tvInfoPlayer3.setText(newInfo);
        }
        if(rbPlayer2.isChecked()){
            tvInfoPlayer2.setText(newInfo);
        }
    }
}
