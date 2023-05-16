// 
// 
// 

package dao;

import Pojo.Hetong;

public interface HetongMapper
{
    void inserthetong(Hetong p0);
    
    Hetong findhetong(String p0);
    
    void updatehetong(Hetong p0);
    
    void deletehetong(String p0);
}
