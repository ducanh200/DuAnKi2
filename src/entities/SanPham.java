package entities;

public class SanPham {
    Integer id;
    String name;
    Double gia;

    public SanPham(Integer id, String name, Double gia)  {
        this.id = id;
        this.name = name;
        this.gia = gia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }
}
