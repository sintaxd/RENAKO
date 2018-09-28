package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class utamaFragment extends Fragment {

    private List<resep_data> mListResep;
    private RecycleAdapter recycleAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= inflater.inflate(R.layout.fragment_utama, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        recycleAdapter=new RecycleAdapter(getActivity(),mListResep);
        mListResep = new ArrayList<>();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        showList();
        return view;
    }
    public void showList(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit.Builder builder=new Retrofit.
                Builder().baseUrl("http://renakomaster.000webhostapp.com").
                addConverterFactory(GsonConverterFactory.create(gson));
        Retrofit retrofit=builder.build();
        ApiClientResep apiClientResep=retrofit.create(ApiClientResep.class);

        Call<resep_model> ResepDAOCall=apiClientResep.getReseputama();

        ResepDAOCall.enqueue(new Callback<resep_model>() {
            @Override
            public void onResponse(Call<resep_model> call, Response<resep_model> response) {
                try {
                    recycleAdapter.notifyDataSetChanged();
                    recycleAdapter = new RecycleAdapter(getContext(), response.body().getResep());
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

    }
}
