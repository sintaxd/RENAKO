package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TampilResep extends AppCompatActivity {
    public String namaPembuat,namaResep,caraMasak,alatBahan,kategori;
    public TextView viewResep,viewPembuat,viewCaraMasak,viewAlat,viewKategori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_resep);

        getSupportActionBar().setTitle("Tampil Resep");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i= getIntent();

        namaPembuat=i.getStringExtra("pembuat");
        namaResep=i.getStringExtra("resep");
        caraMasak=i.getStringExtra("cara");
        alatBahan=i.getStringExtra("alat");
        kategori=i.getStringExtra("kategori");

        viewResep=(TextView) findViewById(R.id.namaResep);
        viewResep.setText(namaResep);
        viewPembuat=(TextView) findViewById(R.id.user_resep);
        viewPembuat.setText(namaPembuat);
        viewAlat=(TextView) findViewById(R.id.alat_Bahan);
        viewAlat.setText(alatBahan);
        viewCaraMasak=(TextView) findViewById(R.id.cara_memasak);
        viewCaraMasak.setText(caraMasak);
        viewKategori=(TextView) findViewById(R.id.kategori_makanan);
        viewKategori.setText(kategori);
    }
}
