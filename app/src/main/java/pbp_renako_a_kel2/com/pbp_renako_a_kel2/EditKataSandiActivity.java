package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class EditKataSandiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_kata_sandi);

        getSupportActionBar().setTitle("Ubah Kata Sandi");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
