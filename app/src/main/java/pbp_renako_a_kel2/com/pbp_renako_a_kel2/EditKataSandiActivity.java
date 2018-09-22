package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditKataSandiActivity extends AppCompatActivity {

    private EditText eKataSandi;
    private Button mbtnSimpan_EKS, mBtnBatal_EKS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_kata_sandi);

        getSupportActionBar().setTitle("Ubah Kata Sandi");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setAtribut();
        mbtnSimpan_EKS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick(mbtnSimpan_EKS);
            }
        });
        mBtnBatal_EKS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EditKataSandiActivity.this, PengaturanActivity.class);
                startActivity(i);
            }
        });


    }
    private void setAtribut(){
        eKataSandi = findViewById(R.id.editText6);
        mbtnSimpan_EKS = findViewById(R.id.btnSimpan_EKS);
        mBtnBatal_EKS = findViewById(R.id.btnBatal_EKS);
    }
}










