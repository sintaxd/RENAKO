package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfilSaya extends AppCompatActivity {
    SessionManager session;
    private TextView setEmail;
    private TextView setNama;
    private String tempNama,tempEmail;
    private List<resep_data> mListResep;
    private RecycleAdapter recycleAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        getSupportActionBar().setTitle("Profil Pengguna");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        session = new SessionManager(getApplicationContext());
        setEmail =(TextView)findViewById(R.id.email_profil);
        tempEmail=session.pref.getString("email", "");
        setEmail.setText(session.pref.getString("email", ""));
        setNama = (TextView)findViewById(R.id.nama_profil);

        //showUser();
        showMenu();
    }

    public void showUser(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit.Builder builder=new Retrofit.
                Builder().baseUrl("http://renakomaster.000webhostapp.com").
                addConverterFactory(GsonConverterFactory.create(gson));
        Retrofit retrofit=builder.build();
        ApiClient apiClient=retrofit.create(ApiClient.class);
        Call<String> userDAOCall=apiClient.getUser(setEmail.getText().toString());

        userDAOCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(ProfilSaya.this,"Network connection failed",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showMenu(){
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recycleAdapter=new RecycleAdapter(this,mListResep);
        mListResep = new ArrayList<>();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit.Builder builder=new Retrofit.
                Builder().baseUrl("http://renakomaster.000webhostapp.com").
                addConverterFactory(GsonConverterFactory.create(gson));
        Retrofit retrofit=builder.build();
        ApiClientResep apiClientResep=retrofit.create(ApiClientResep.class);
        Call<resep_model> ResepDAOCall=apiClientResep.getResepUser();
        ResepDAOCall.enqueue(new Callback<resep_model>() {
            @Override
            public void onResponse(Call<resep_model> call, Response<resep_model> response) {
                try {
                    recycleAdapter.notifyDataSetChanged();
                    recycleAdapter = new RecycleAdapter(ProfilSaya.this, response.body().getResep());
                    recyclerView.setAdapter(recycleAdapter);
                } catch (Exception e) {
                    Toast.makeText(ProfilSaya.this, "Belum ada resep!", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<resep_model> call, Throwable t) {
                Toast.makeText(ProfilSaya.this,"Network connection failed",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
