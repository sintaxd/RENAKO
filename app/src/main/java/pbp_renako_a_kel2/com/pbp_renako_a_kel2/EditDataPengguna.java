package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EditDataPengguna extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data_pengguna);

        getSupportActionBar().setTitle("Ubah Data Pengguna");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
