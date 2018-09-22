package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

private EditText mNama;
private EditText mEmail;
private EditText mPassword;
private EditText mConfirmPassword;
private Button mRegisterButton;
private Button mCancelButton;
SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Session class instance
        session = new SessionManager(getApplicationContext());

        setAtribut();
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickRegister();
            }
        });
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(i);
            }
        });


    }
    private void setAtribut(){
        mNama= findViewById(R.id.txtNama_Register);
        mEmail=findViewById(R.id.txtEmail_Register);
        mPassword=findViewById(R.id.txtPassword_Register2);
        mConfirmPassword=findViewById(R.id.txtConfirmPassword_Register);
        mRegisterButton=findViewById(R.id.btnSimpan_Register);
        mCancelButton=findViewById(R.id.btnBatal_Register);
    }

    private void startIntent(){
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
    private void onClickRegister(){
        if(mNama.getText().toString().isEmpty() ||
            mEmail.getText().toString().isEmpty()||
            mPassword.getText().toString().isEmpty() ||
            mConfirmPassword.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Kolom tidak boleh kosong !", Toast.LENGTH_SHORT).show();
        }
        else
        {
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
                Call<JsonObject> userDAOCall=apiClient.regUser(mNama.getText().toString(),
                        mEmail.getText().toString(),mPassword.getText().toString());

                userDAOCall.enqueue(new Callback<JsonObject>() {
                    @Override

                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        Toast.makeText(RegisterActivity.this,"Register Success",Toast.LENGTH_SHORT).show();
                        startIntent();
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this,"Network connection failed",Toast.LENGTH_SHORT).show();
                    }
                });
        }
    }
}
