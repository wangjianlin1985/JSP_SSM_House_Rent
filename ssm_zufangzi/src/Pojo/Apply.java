// 
// 
// 

package Pojo;

public class Apply
{
    private Integer id;
    private String house_id;
    private String address;
    private double area;
    private double price;
    private Integer userlist_id;
    private String status;
    private Userlist userlist;
    
    public Userlist getUserlist() {
        return this.userlist;
    }
    
    public void setUserlist(final Userlist userlist) {
        this.userlist = userlist;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public String getHouse_id() {
        return this.house_id;
    }
    
    public void setHouse_id(final String house_id) {
        this.house_id = house_id;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(final String address) {
        this.address = address;
    }
    
    public double getArea() {
        return this.area;
    }
    
    public void setArea(final double area) {
        this.area = area;
    }
    
    public double getPrice() {
        return this.price;
    }
    
    public void setPrice(final double price) {
        this.price = price;
    }
    
    public Integer getUserlist_id() {
        return this.userlist_id;
    }
    
    public void setUserlist_id(final Integer userlist_id) {
        this.userlist_id = userlist_id;
    }
    
    @Override
    public String toString() {
        return "Apply [id=" + this.id + ", house_id=" + this.house_id + ", address=" + this.address + ", area=" + this.area + ", price=" + this.price + ", userlist_id=" + this.userlist_id + ", status=" + this.status + ", userlist=" + this.userlist + "]";
    }
}
