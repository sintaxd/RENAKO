package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PengaturanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan);
    /*
        belum bisa dibikin, soalnya main menunya blm ada

        getSupportActionBar().setTitle("Pengaturan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    */
    }
    public void txtUbahKataSandi_Pengaturan(View view)
    {
        startActivity(new Intent(this,EditKataSandiActivity.class));
    }
}
