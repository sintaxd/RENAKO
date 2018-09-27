package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {
    private Context context;
    private List<resep_data> result2=new ArrayList<>();

    public RecycleAdapter(Context context,List<resep_data> result2){
        this.context=context;
        this.result2=result2;
    }

    @Override
    public RecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_recycle_adapter, viewGroup, false);

        return new RecycleAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecycleAdapter.MyViewHolder myViewHolder, int i) {
        resep_data resep= result2.get(i);
        myViewHolder.mNamaResep.setText(resep.getNamaResepMasakan());
        myViewHolder.mKategori.setText(resep.getKategoriMasakan());
        myViewHolder.mPembuat.setText(resep.getUserName());

    }

    @Override
    public int getItemCount() {
        return result2.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mNamaResep;
        private TextView mKategori;
        private TextView mPembuat;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            mNamaResep=(TextView)itemView.findViewById(R.id.txtNama_masakan_menu);
            mKategori=(TextView)itemView.findViewById(R.id.kategori_masakan_menu);
            mPembuat=(TextView)itemView.findViewById(R.id.user_resep_menu);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(context,"Anda mengklik saya",Toast.LENGTH_SHORT).show();
        }
    }


}
