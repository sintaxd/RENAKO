package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class main_menu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer=findViewById(R.id.drawer_layout);

        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawer,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if(savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new homeFragment()).commit();
            navigationView.setCheckedItem(R.id.home_kat);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.home_kat:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new homeFragment()).commit();
                break;
            case R.id.makanan_ringan:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ringanFragment()).commit();
                break;
            case R.id.makanan_utama:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new utamaFragment()).commit();
                break;
            case R.id.makanan_penutup:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new penutupFragment()).commit();
                break;
            case R.id.setting:
                startActivity(new Intent(this,PengaturanActivity.class));
                break;
            case R.id.logout:
                startActivity(new Intent(this,MainActivity.class));
                finish();
                break;
        }
        return true;
    }


    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


}
