package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    EditText email,pass;
    Button login;
    TextView reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        email=(EditText) findViewById(R.id.txtEmail_Login);
        pass=(EditText) findViewById(R.id.txtKataSandi_Login);
        login=(Button) findViewById(R.id.btnLogin_Login);
        reg=(TextView) findViewById(R.id.txtRegister_Login);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,main_menu.class);
                startActivity(i);
                finish();
            }
        });

    }


}
