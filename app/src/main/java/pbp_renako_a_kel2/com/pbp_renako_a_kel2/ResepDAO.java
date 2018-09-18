package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

public class ResepDAO {
    String  nama_resep_makanan,alat_bahan_makanan,cara_memasak,kategori_masakan;

    public ResepDAO(String nama_resep_makanan, String alat_bahan_makanan, String cara_memasak, String kategori_masakan) {
        this.nama_resep_makanan = nama_resep_makanan;
        this.alat_bahan_makanan = alat_bahan_makanan;
        this.cara_memasak = cara_memasak;
        this.kategori_masakan = kategori_masakan;
    }

    public String getNama_resep_makanan() {
        return nama_resep_makanan;
    }

    public void setNama_resep_makanan(String nama_resep_makanan) {
        this.nama_resep_makanan = nama_resep_makanan;
    }

    public String getAlat_bahan_makanan() {
        return alat_bahan_makanan;
    }

    public void setAlat_bahan_makanan(String alat_bahan_makanan) {
        this.alat_bahan_makanan = alat_bahan_makanan;
    }

    public String getCara_memasak() {
        return cara_memasak;
    }

    public void setCara_memasak(String cara_memasak) {
        this.cara_memasak = cara_memasak;
    }

    public String getKategori_masakan() {
        return kategori_masakan;
    }

    public void setKategori_masakan(String kategori_masakan) {
        this.kategori_masakan = kategori_masakan;
    }
}
