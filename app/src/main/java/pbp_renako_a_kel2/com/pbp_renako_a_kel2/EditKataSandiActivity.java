package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EditKataSandiActivity extends AppCompatActivity {

    SessionManager session;
    private EditText ksLama,ksBaru,ksConf;
    private String tempPass,tempEmail;
    private Button mbtnSimpan_EKS, mBtnBatal_EKS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_kata_sandi);

        getSupportActionBar().setTitle("Ubah Kata Sandi");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        session = new SessionManager(getApplicationContext());

        setAtribut();
        mbtnSimpan_EKS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickUpdate();
            }
        });
        mBtnBatal_EKS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EditKataSandiActivity.this, PengaturanActivity.class);
                startActivity(i);
            }
        });


    }
    private void setAtribut(){
        ksLama = findViewById(R.id.editPasswordLama);
        ksBaru=findViewById(R.id.ksBaru);
        ksConf=findViewById(R.id.ksConf);
        tempPass=session.pref.getString("pass", "");
        tempEmail=session.pref.getString("email", "");
        mbtnSimpan_EKS = findViewById(R.id.btnSimpan_EKS);
        mBtnBatal_EKS = findViewById(R.id.btnBatal_EKS);
    }

    private void startIntent(){
        Intent intent=new Intent(getApplicationContext(),PengaturanActivity.class);
        startActivity(intent);
    }

    private void onClickUpdate(){
        if(ksLama.getText().toString().isEmpty() || ksBaru.getText().toString().isEmpty() || ksConf.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Kolom tidak boleh kosong !", Toast.LENGTH_SHORT).show();
        }

        else if(ksLama.getText().toString().equalsIgnoreCase(tempPass))
        {
            if(ksBaru.getText().toString().equalsIgnoreCase(ksConf.getText().toString()))
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
                Call<JsonObject> userDAOCall=apiClient.editPass(ksBaru.getText().toString(),tempEmail);

                userDAOCall.enqueue(new Callback<JsonObject>() {
                    @Override

                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        Toast.makeText(EditKataSandiActivity.this,"Edit Kata Sandi Berhasil",Toast.LENGTH_SHORT).show();
                        startIntent();
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Toast.makeText(EditKataSandiActivity.this,"Network connection failed",Toast.LENGTH_SHORT).show();
                    }
                });
            }
            else
            {
                Toast.makeText(EditKataSandiActivity.this,"Kata sandi baru tidak sesuai",Toast.LENGTH_SHORT).show();
            }


        }
        else
        {
            Toast.makeText(EditKataSandiActivity.this,"Kata sandi lama tidak sesuai",Toast.LENGTH_SHORT).show();
        }
    }
}










