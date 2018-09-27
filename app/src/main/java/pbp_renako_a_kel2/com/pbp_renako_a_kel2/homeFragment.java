package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class homeFragment extends Fragment {
    private List<ResepDAO> mListResep = new ArrayList<>();
    private RecycleAdapter recycleAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    private Button mTambahResep;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        recyclerView = (RecyclerView)container.findViewById(R.id.recycler_view);

        Retrofit.Builder builder=new Retrofit.
                Builder().baseUrl("http://renakomaster.000webhostapp.com").
                addConverterFactory(GsonConverterFactory.create(gson));
        Retrofit retrofit=builder.build();
        ApiClientResep apiClientResep=retrofit.create(ApiClientResep.class);

        Call<resep_model> ResepDAOCall=apiClientResep.getResepall();

        ResepDAOCall.enqueue(new Callback<resep_model>() {
            @Override
            public void onResponse(Call<resep_model> call, Response<resep_model> response) {
                try {
                    recycleAdapter = new RecycleAdapter(getContext(), response.body().getResep());
                    recycleAdapter.notifyDataSetChanged();
                    layoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(recycleAdapter);
                } catch (Exception e) {
                    Toast.makeText(getContext(), "Belum ada resep!", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<resep_model> call, Throwable t) {
                Toast.makeText(getContext(),"Network connection failed",Toast.LENGTH_SHORT).show();
            }
        });

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
