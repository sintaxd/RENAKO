package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TambahResep extends AppCompatActivity {
    SessionManager session;
    private EditText alatbahan,caramasak,namaMasakan;
    private String kategori;
    private Spinner spinner;
    private Button cancel,save;
    private String tempEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_resep);

        getSupportActionBar().setTitle("Tambah Resep");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        session = new SessionManager(getApplicationContext());

        setAtribut();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSave();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(TambahResep.this,main_menu.class);
                startActivity(i);
//                Toast.makeText(TambahResep.this, "Hasil Spinner : " + spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void startIntent(){
        Intent intent=new Intent(getApplicationContext(),main_menu.class);
        startActivity(intent);
    }

    private void setAtribut(){
        namaMasakan=findViewById(R.id.txtNama_Masakan);
        alatbahan= findViewById(R.id.txtAlatBahan_TambahResep);
        caramasak=findViewById(R.id.txtCaraMemasak_TambahResep);
        spinner=(Spinner) findViewById(R.id.spinner1);
        cancel=findViewById(R.id.btnCancel);
        save=findViewById(R.id.btnSave);
        tempEmail=session.pref.getString("email", "");
    }

    private void onClickSave(){
        if(namaMasakan.getText().toString().isEmpty() ||
                alatbahan.getText().toString().isEmpty()||
                caramasak.getText().toString().isEmpty())
        {
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
            ApiClientResep apiClientResep=retrofit.create(ApiClientResep.class);

            //Call api yang dibuat di php
            Call<JsonObject> ResepDAOCall=apiClientResep.regResep(namaMasakan.getText().toString(),
                    alatbahan.getText().toString(),caramasak.getText().toString(),spinner.getSelectedItem().toString(),tempEmail);

            ResepDAOCall.enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    Toast.makeText(TambahResep.this,"Tambah Resep Success",Toast.LENGTH_SHORT).show();
                    startIntent();
                }

                @Override
                public void onFailure(Call<JsonObject> call, Throwable t) {
                    Toast.makeText(TambahResep.this,"Network connection failed",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
