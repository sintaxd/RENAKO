package pbp_renako_a_kel2.com.pbp_renako_a_kel2;

public class UserDAO {
    String nama;
    String email;
    String password;
    String ulangpassword;

    public UserDAO(String nama, String email, String password, String ulangpassword) {
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.ulangpassword = ulangpassword;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUlangpassword() {
        return ulangpassword;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUlangpassword(String ulangpassword) {
        this.ulangpassword = ulangpassword;
    }
}
