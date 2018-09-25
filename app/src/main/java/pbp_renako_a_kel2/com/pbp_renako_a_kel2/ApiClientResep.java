package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiClientResep {

    @GET("show_resep_process.php")
    Call<JsonObject> getResep();

    @POST("insert_resep_process.php")
    @FormUrlEncoded
    Call<JsonObject> regResep  (@Field("nama_resep_masakan") String nama_resep_masakan,
                                @Field ("alat_bahan_masakan") String alat_bahan_masakan,
                                @Field ("cara_memasak") String cara_memasak,
                                @Field ("kategori_masakan") String kategori_masakan
                               );

}