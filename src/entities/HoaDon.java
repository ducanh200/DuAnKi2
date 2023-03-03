package entities;

public class HoaDon {
    Integer id;
    String namekh;
    String sdt;
    String namesp;
    Double gia;
    String sp_id;

    public HoaDon(Integer id, String namekh, String sdt, String namesp, Double gia, String sp_id) {
        this.id = id;
        this.namekh = namekh;
        this.sdt = sdt;
        this.namesp = namesp;
        this.gia = gia;
        this.sp_id = sp_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamekh() {
        return namekh;
    }

    public void setNamekh(String namekh) {
        this.namekh = namekh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNamesp() {
        return namesp;
    }

    public void setNamesp(String namesp) {
        this.namesp = namesp;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public String getSp_id() {
        return sp_id;
    }

    public void setSp_id(String sp_id) {
        this.sp_id = sp_id;
    }
}
