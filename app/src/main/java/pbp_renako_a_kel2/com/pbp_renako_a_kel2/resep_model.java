package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class resep_model {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("resep")
    @Expose
    private List<resep_data> resep = new ArrayList<>();

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<resep_data> getResep() {
        return resep;
    }

    public void setResep(List<resep_data> resep) {
        this.resep = resep;
    }

}
