package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiClientResep {

    @GET("")
    Call<Value> getResep();

    @POST("insert_resep_process.php")
    @FormUrlEncoded
    Call<String> regResep  (@Field("nama_resep_makanan") String nama_resep_makanan,
                            @Field ("alat_bahan_makanan") String alat_bahan_makanan,
                            @Field ("cara_memasak") String cara_memasak,
                            @Field ("kategori_masakan") String kategori_masakan);
}