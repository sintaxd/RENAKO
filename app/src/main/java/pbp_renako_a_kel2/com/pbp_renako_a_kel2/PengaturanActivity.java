package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PengaturanActivity extends AppCompatActivity {

    private TextView txtUbahKataSandi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan);

        txtUbahKataSandi = (TextView)  findViewById(R.id.txtUbahKataSandi_Pengaturan);
        txtUbahKataSandi.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                openEditKataSandiClass();
            }
        });

        getSupportActionBar().setTitle("Pengaturan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    public void openEditKataSandiClass()
    {
        startActivity(new Intent(this,EditKataSandiActivity.class));
    }
}
