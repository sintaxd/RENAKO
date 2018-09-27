package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiClient {
    @GET("show_user_process.php")
    Call<JsonObject> getUser(@Field("user_name") String user_name);


    @POST("user_process.php")
    @FormUrlEncoded
    Call<JsonObject>regUser(@Field("user_name") String user_name,
                            @Field ("user_email") String user_email,
                            @Field ("user_password") String user_password);

    @POST("login.php")
    @FormUrlEncoded
    Call<Login_response>logUser(@Field ("user_email") String user_email,
                            @Field ("user_password") String user_password);

    @POST("edit_user_process.php")
    @FormUrlEncoded
    Call<JsonObject>editUser(@Field("user_name") String user_name,
                            @Field ("user_email") String user_email,
                            @Field("tempEmail") String tempEmail);

    @POST("edit_password_process.php")
    @FormUrlEncoded
    Call<JsonObject>editPass(@Field ("ksBaru") String ksBaru,
                             @Field("tempEmail") String tempEmail);
}
