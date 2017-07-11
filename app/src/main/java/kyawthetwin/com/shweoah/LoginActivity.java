package kyawthetwin.com.shweoah;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class LoginActivity extends AppCompatActivity {

    EditText edt_username,edt_password;
    ImageView imgView_correct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById();
        intentToHomePage();
    }

    void findViewById(){

        edt_username = (EditText) findViewById(R.id.edt_username);
        edt_password = (EditText) findViewById(R.id.edt_password);
        imgView_correct = (ImageView) findViewById(R.id.correct_img_view);
    }

    void intentToHomePage(){

        imgView_correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(i);
            }
        });
    }
}
