package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {
    private Context context;
    private List<resep_data> result= new ArrayList<>();

    public RecycleAdapter(Context context,List<resep_data> result){
        this.context=context;
        this.result=result;
    }

    @Override
    public RecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_recycle_adapter, viewGroup, false);
        return new RecycleAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RecycleAdapter.MyViewHolder myViewHolder, int i) {
        final resep_data resep= result.get(i);
        myViewHolder.mNamaResep.setText(resep.getNamaResepMasakan());
        myViewHolder.mKategori.setText(resep.getKategoriMasakan());
        myViewHolder.mPembuat.setText(resep.getUserName());
        myViewHolder.kotak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TampilResep.class);
                intent.putExtra("pembuat", resep.getUserName());
                intent.putExtra("kategori", resep.getKategoriMasakan());
                intent.putExtra("cara", resep.getCaraMemasak());
                intent.putExtra("resep", resep.getNamaResepMasakan());
                intent.putExtra("alat", resep.getAlatBahanMasakan());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView mNamaResep;
        public TextView mKategori;
        public TextView mPembuat;
        public TextView mCaraMasak;
        public Context mContext;
        public ConstraintLayout kotak;
        public MyViewHolder(View itemView){
            super(itemView);
            kotak = itemView.findViewById(R.id.kotak);
            mNamaResep=(TextView)itemView.findViewById(R.id.txtNama_masakan_menu);
            mKategori=(TextView)itemView.findViewById(R.id.kategori_masakan_menu);
            mPembuat=(TextView)itemView.findViewById(R.id.user_resep_menu);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(context,"Anda mengklik saya",Toast.LENGTH_SHORT).show();
        }
    }


}
