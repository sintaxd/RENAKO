package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
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
    private List<ResepDAO> result2;

    public RecycleAdapter(Context context,List<ResepDAO> result2){
        this.context=context;
        this.result2=result2;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        ResepDAO resep= result2.get(i);
        myViewHolder.mNamaResep.setText(resep.getNama_resep_makanan());
        myViewHolder.mKategori.setText(resep.getKategori_masakan());

    }

    @Override
    public int getItemCount() {
        return result2.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
       private TextView mNamaResep;
       private TextView mKategori;


       public MyViewHolder(@NonNull View itemView){
           super(itemView);

           mNamaResep=(TextView)itemView.findViewById(R.id.user_resep_menu);
           mKategori=(TextView)itemView.findViewById(R.id.kategori_masakan_menu);
       }

       @Override
       public void onClick(View view) {
           Toast.makeText(context,"Anda mengklik saya",Toast.LENGTH_SHORT).show();
       }
   }


}
