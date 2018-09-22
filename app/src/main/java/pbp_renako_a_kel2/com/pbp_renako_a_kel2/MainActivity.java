package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText email,pass;
    Button login;
    TextView reg;
    SessionManager session;
    String tempEmail, tempPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Session Manager
        session = new SessionManager(getApplicationContext());

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
                onClickLogin();
            }
        });

    }

    private void onClickLogin(){
        if(email.getText().toString().isEmpty()||
                pass.getText().toString().isEmpty()){
            Toast.makeText(this, "Field can't be empty", Toast.LENGTH_SHORT).show();
        }else{
            //Post data into API
            //Build Retroifit
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            Retrofit.Builder builder=new Retrofit.
                    Builder().baseUrl("http://renakomaster.000webhostapp.com").
                    addConverterFactory(GsonConverterFactory.create(gson));
            Retrofit retrofit=builder.build();
            ApiClient apiClient=retrofit.create(ApiClient.class);

            //Call api yang dibuat di php
            tempEmail=email.getText().toString();
            tempPass=pass.getText().toString();
            Call<Login_response> userDAOCall=apiClient.logUser(tempEmail,tempPass);
            session.createLoginSession(tempEmail,tempPass);
            userDAOCall.enqueue(new Callback<Login_response>() {

                @Override
                public void onResponse(Call<Login_response> call, Response<Login_response> response) {
                    if(response.body().getResponse().equals("OK"))
                    {
                        Toast.makeText(MainActivity.this,"Berhasil",Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(getApplicationContext(),main_menu.class);
                        startActivity(i);
                        finish();
                    }else
                        Toast.makeText(MainActivity.this,"Email atau Password salah",Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<Login_response> call, Throwable t) {
                    Log.d("TAG", t.toString());
                    Toast.makeText(MainActivity.this,"Jaringan bermasalah",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


}
