package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiClient {
    @GET("")
    Call<Value> getUser();

    @POST("user_process.php")
    @FormUrlEncoded
    Call<JsonObject>regUser(@Field("user_name") String user_name,
                            @Field ("user_email") String user_email,
                            @Field ("user_password") String user_password);
}
