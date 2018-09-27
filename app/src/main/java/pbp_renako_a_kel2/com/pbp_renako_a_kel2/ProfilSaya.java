package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class ProfilSaya extends AppCompatActivity {
    SessionManager session;
    private TextView setEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        getSupportActionBar().setTitle("Profil Pengguna");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        session = new SessionManager(getApplicationContext());
        setEmail =(TextView)findViewById(R.id.email_profil);
        setEmail.setText(session.pref.getString("email", ""));
    }

    public void showMenu(){

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
                    recycleAdapter = new RecycleAdapter(getContext(), response.body().getResep());

                } catch (Exception e) {
                    Toast.makeText(getContext(), "Belum ada resep!", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<resep_model> call, Throwable t) {
                Toast.makeText(getContext(),"Network connection failed",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
