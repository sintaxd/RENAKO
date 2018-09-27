package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class resep_data {

    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("nama_resep_masakan")
    @Expose
    private String namaResepMasakan;
    @SerializedName("alat_bahan_masakan")
    @Expose
    private String alatBahanMasakan;
    @SerializedName("cara_memasak")
    @Expose
    private String caraMemasak;
    @SerializedName("image_masakan")
    @Expose
    private Object imageMasakan;
    @SerializedName("kategori_masakan")
    @Expose
    private String kategoriMasakan;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNamaResepMasakan() {
        return namaResepMasakan;
    }

    public void setNamaResepMasakan(String namaResepMasakan) {
        this.namaResepMasakan = namaResepMasakan;
    }

    public String getAlatBahanMasakan() {
        return alatBahanMasakan;
    }

    public void setAlatBahanMasakan(String alatBahanMasakan) {
        this.alatBahanMasakan = alatBahanMasakan;
    }

    public String getCaraMemasak() {
        return caraMemasak;
    }

    public void setCaraMemasak(String caraMemasak) {
        this.caraMemasak = caraMemasak;
    }

    public Object getImageMasakan() {
        return imageMasakan;
    }

    public void setImageMasakan(Object imageMasakan) {
        this.imageMasakan = imageMasakan;
    }

    public String getKategoriMasakan() {
        return kategoriMasakan;
    }

    public void setKategoriMasakan(String kategoriMasakan) {
        this.kategoriMasakan = kategoriMasakan;
    }

}
