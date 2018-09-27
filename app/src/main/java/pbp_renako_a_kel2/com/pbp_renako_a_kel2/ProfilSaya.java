package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

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
}
