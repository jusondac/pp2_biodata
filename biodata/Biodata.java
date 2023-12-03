package biodata;


public class Biodata {
    private String id;
    private String nama;
    private String alamat;
    private String no_telp;
    private String jenis_kelamin;

    public void setId(String id) {
        this.id = id;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }
    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }


    public String getId() {
        return id;
    }
    public String getNama() {
        return nama;
    }
    public String getAlamat() {
        return alamat;
    }
    public String getNo_telp() {
        return no_telp;
    }
    public String getJenis_kelamin() {
        return jenis_kelamin;
    }
}
