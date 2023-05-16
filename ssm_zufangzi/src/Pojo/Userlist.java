// 
// 
// 

package Pojo;

import java.util.List;

public class Userlist
{
    private Integer id;
    private String name;
    private String idcard;
    private String phone;
    private Integer user_id;
    private List<Apply> apply;
    private List<Zulist> zulist;
    private List<Checkout> checkout;
    private List<Applyout> applyout;
    private User user;
    
    public User getUser() {
        return this.user;
    }
    
    public void setUser(final User user) {
        this.user = user;
    }
    
    public List<Applyout> getApplyout() {
        return this.applyout;
    }
    
    public void setApplyout(final List<Applyout> applyout) {
        this.applyout = applyout;
    }
    
    public List<Checkout> getCheckout() {
        return this.checkout;
    }
    
    public void setCheckout(final List<Checkout> checkout) {
        this.checkout = checkout;
    }
    
    public List<Zulist> getZulist() {
        return this.zulist;
    }
    
    public void setZulist(final List<Zulist> zulist) {
        this.zulist = zulist;
    }
    
    public List<Apply> getApply() {
        return this.apply;
    }
    
    public void setApply(final List<Apply> apply) {
        this.apply = apply;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public String getIdcard() {
        return this.idcard;
    }
    
    public void setIdcard(final String idcard) {
        this.idcard = idcard;
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(final String phone) {
        this.phone = phone;
    }
    
    public Integer getUser_id() {
        return this.user_id;
    }
    
    public void setUser_id(final Integer user_id) {
        this.user_id = user_id;
    }
}
