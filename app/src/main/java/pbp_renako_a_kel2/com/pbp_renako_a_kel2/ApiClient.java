package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiClient {
    @GET("View.php")
    Call<Value> getStudents();

    @POST("Insert.php")
    @FormUrlEncoded
    Call<String> regStudent (@Field("nama") String npm,
                             @Field ("email") String email,
                             @Field ("password") String password,
                             @Field ("ulangpassword") String ulangpassword);
}
