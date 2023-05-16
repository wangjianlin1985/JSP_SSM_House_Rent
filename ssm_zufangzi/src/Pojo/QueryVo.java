// 
// 
// 

package Pojo;

public class QueryVo
{
    private String zuname;
    private String fromdate;
    private String todate;
    private Integer userlist_id;
    
    public Integer getUserlist_id() {
        return this.userlist_id;
    }
    
    public void setUserlist_id(final Integer userlist_id) {
        this.userlist_id = userlist_id;
    }
    
    public String getZuname() {
        return this.zuname;
    }
    
    public void setZuname(final String zuname) {
        this.zuname = zuname;
    }
    
    public String getFromdate() {
        return this.fromdate;
    }
    
    public void setFromdate(final String fromdate) {
        this.fromdate = fromdate;
    }
    
    public String getTodate() {
        return this.todate;
    }
    
    public void setTodate(final String todate) {
        this.todate = todate;
    }
}
