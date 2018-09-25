package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class homeFragment extends Fragment {

    private Button mTambahResep;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_home, container, false);
        mTambahResep=(Button)view.findViewById(R.id.btnTambah_resep_menu);
        mTambahResep.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getActivity(),TambahResep.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
