package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import android.content.Intent;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

private EditText mNama;
private EditText mEmail;
private EditText mPassword;
private Button mRegisterButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setAtribut();
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickRegister();
            }
        });



    }
    private void setAtribut(){
        mNama= findViewById(R.id.txtNama_Register);
        mEmail=findViewById(R.id.txtEmail_Register);
        mPassword=findViewById(R.id.txtPassword_Register2);
        mRegisterButton=findViewById(R.id.btnSimpan_Register);
    }
    private void startIntent(){
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
    private void onClickRegister(){
        if(mNama.getText().toString().isEmpty() ||
                mEmail.getText().toString().isEmpty()||
                mPassword.getText().toString().isEmpty()){
            Toast.makeText(this, "Field can't be empty", Toast.LENGTH_SHORT).show();
        }else{
            //Post data into API
            //Build Retroifit
            Retrofit.Builder builder=new Retrofit.
                    Builder().baseUrl("http://10.0.2.2/PHP_RENAKO/register.php").
                    addConverterFactory(GsonConverterFactory.create());
            Retrofit retrofit=builder.build();
            ApiClient apiClient=retrofit.create(ApiClient.class);
            //Call api yang dibuat di php
            Call<String> userDAOCall=apiClient.regUser(mNama.getText().toString(),
                    mEmail.getText().toString(),mPassword.getText().toString());

            userDAOCall.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    Toast.makeText(RegisterActivity.this,"Success",Toast.LENGTH_SHORT).show();
                    startIntent();
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Toast.makeText(RegisterActivity.this,"Network connection failed",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
