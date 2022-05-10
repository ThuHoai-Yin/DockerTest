package model;

public class Product {
    private int id;
    private String name;
    private String unit;
    private String catelogyName;
    private int price;

    public Product() {
    }

    public Product(int id, String name, String unit, String catelogyName, int price) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.catelogyName = catelogyName;
        this.price = price;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCatelogyName() {
        return catelogyName;
    }

    public void setCatelogyName(String catelogyName) {
        this.catelogyName = catelogyName;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", unit=" + unit + ", price=" + price + ", catelogyName=" + catelogyName + '}';
    }
    
}
