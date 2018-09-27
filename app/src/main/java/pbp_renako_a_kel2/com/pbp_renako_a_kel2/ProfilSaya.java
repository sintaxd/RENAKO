package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfilSaya extends AppCompatActivity {
    SessionManager session;
    private TextView setEmail;
    private TextView setNama;
    private String tempNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        getSupportActionBar().setTitle("Profil Pengguna");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        session = new SessionManager(getApplicationContext());
        setEmail =(TextView)findViewById(R.id.email_profil);
        setEmail.setText(session.pref.getString("email", ""));
        setNama = (TextView)findViewById(R.id.nama_profil);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit.Builder builder=new Retrofit.
                Builder().baseUrl("http://renakomaster.000webhostapp.com").
                addConverterFactory(GsonConverterFactory.create(gson));
        Retrofit retrofit=builder.build();
        ApiClient apiClient=retrofit.create(ApiClient.class);
        Call<JsonObject> userDAOCall=apiClient.getUser(tempNama);
        setNama.setText(tempNama);
    }
}
