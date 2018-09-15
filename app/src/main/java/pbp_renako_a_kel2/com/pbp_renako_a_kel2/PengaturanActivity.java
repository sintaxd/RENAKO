package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PengaturanActivity extends AppCompatActivity {

    private TextView txtUbahKataSandi,txtUbahProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan);

        getSupportActionBar().setTitle("Pengaturan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtUbahKataSandi = (TextView)  findViewById(R.id.txtUbahKataSandi_Pengaturan);
        txtUbahProfile = (TextView) findViewById(R.id.txtUbahProfile_Pengaturan);

        txtUbahKataSandi.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PengaturanActivity.this,EditKataSandiActivity.class);
                startActivity(intent);
            }
        });
        txtUbahProfile.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PengaturanActivity.this,EditDataPengguna.class);
                startActivity(intent);
            }
        });



    }
}
