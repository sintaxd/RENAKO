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

public class EditDataPengguna extends AppCompatActivity {

    SessionManager session;
    private EditText eNama;
    private EditText eEmail;
    private String tempEmail;
    private String tempPassword;
    private Button eSimpan;
    private Button eBatal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data_pengguna);

        getSupportActionBar().setTitle("Ubah Data Pengguna");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        session = new SessionManager(getApplicationContext());

        setAtribut();
        eSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickRegister();
            }
        });
        eBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(EditDataPengguna.this,PengaturanActivity.class);
                startActivity(i);
            }
        });
    }
    private void setAtribut(){
        // Session class instance
        eNama= findViewById(R.id.editNamaPengguna);
        eEmail=findViewById(R.id.editEmailPengguna);
        eSimpan=findViewById(R.id.btnSimpan_EDP);
        eBatal=findViewById(R.id.btnBatal_EDP);
        tempEmail=session.pref.getString("email", "");
        tempPassword=session.pref.getString("pass", "");

    }

    private void onClickRegister(){
        if(eNama.getText().toString().isEmpty() || eEmail.getText().toString().isEmpty())
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
            Call<JsonObject> userDAOCall=apiClient.editUser(eNama.getText().toString(),
                    eEmail.getText().toString(),tempEmail,tempPassword);

            userDAOCall.enqueue(new Callback<JsonObject>() {
                @Override

                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    Toast.makeText(EditDataPengguna.this,"Edit Success",Toast.LENGTH_SHORT).show();
                    startIntent();
                }

                @Override
                public void onFailure(Call<JsonObject> call, Throwable t) {
                    Toast.makeText(EditDataPengguna.this,"Network connection failed",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    private void startIntent(){
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
