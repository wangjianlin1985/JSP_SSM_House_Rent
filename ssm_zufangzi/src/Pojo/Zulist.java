// 
// 
// 

package Pojo;

public class Zulist
{
    private Integer zid;
    private String house_id;
    private Double price;
    private String address;
    private Integer userlist_id;
    private Integer contract_id;
    private Userlist userlist;
    
    public Userlist getUserlist() {
        return this.userlist;
    }
    
    public void setUserlist(final Userlist userlist) {
        this.userlist = userlist;
    }
    
    public Integer getZid() {
        return this.zid;
    }
    
    public void setZid(final Integer zid) {
        this.zid = zid;
    }
    
    public String getHouse_id() {
        return this.house_id;
    }
    
    public void setHouse_id(final String house_id) {
        this.house_id = house_id;
    }
    
    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(final Double price) {
        this.price = price;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(final String address) {
        this.address = address;
    }
    
    public Integer getUserlist_id() {
        return this.userlist_id;
    }
    
    public void setUserlist_id(final Integer userlist_id) {
        this.userlist_id = userlist_id;
    }
    
    public Integer getContract_id() {
        return this.contract_id;
    }
    
    public void setContract_id(final Integer contract_id) {
        this.contract_id = contract_id;
    }
}
