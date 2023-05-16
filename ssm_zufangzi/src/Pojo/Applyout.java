// 
// 
// 

package Pojo;

import java.util.List;

public class Applyout
{
    private Integer id;
    private String house_id;
    private String address;
    private String status;
    private Integer userlist_id;
    private List<Userlist> userlist;
    
    public List<Userlist> getUserlist() {
        return this.userlist;
    }
    
    public void setUserlist(final List<Userlist> userlist) {
        this.userlist = userlist;
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
    
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
    
    public Integer getUserlist_id() {
        return this.userlist_id;
    }
    
    public void setUserlist_id(final Integer userlist_id) {
        this.userlist_id = userlist_id;
    }
}
