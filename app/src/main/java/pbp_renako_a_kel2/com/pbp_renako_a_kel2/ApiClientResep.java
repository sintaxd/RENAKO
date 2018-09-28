package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiClientResep {

    @GET("show_resep_process.php")
    Call<JsonArray> getResep();

    @GET("list_resep_all.php")
    Call<resep_model> getResepall();

    @GET("list_resep_ringan.php")
    Call<resep_model> getResepringan();

    @GET("list_resep_utama.php")
    Call<resep_model> getReseputama();

    @GET("list_resep_penutup.php")
    Call<resep_model> getReseppenutup();

    @GET("list_resep_user.php?temp_email=tempEmail")
    Call<resep_model> getResepUser();

    @POST("insert_resep_process.php")
    @FormUrlEncoded
    Call<JsonObject> regResep  (@Field("nama_resep_masakan") String nama_resep_masakan,
                                @Field ("alat_bahan_masakan") String alat_bahan_masakan,
                                @Field ("cara_memasak") String cara_memasak,
                                @Field ("kategori_masakan") String kategori_masakan,
                                @Field ("temp_email") String temp_email);

}