// 
// 
// 

package Pojo;

public class User
{
    private Integer id;
    private String username;
    private String password;
    private String type;
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(final String username) {
        this.username = ((username == null) ? null : username.trim());
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(final String password) {
        this.password = ((password == null) ? null : password.trim());
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(final String type) {
        this.type = ((type == null) ? null : type.trim());
    }
    
    @Override
    public String toString() {
        return "User [id=" + this.id + ", username=" + this.username + ", password=" + this.password + ", type=" + this.type + "]";
    }
}
