package pbp_renako_a_kel2.com.pbp_renako_a_kel2;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Login_response {

    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("user_email")
    @Expose
    private String userEmail;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

}