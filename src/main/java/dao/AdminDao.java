package dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Mapper
public interface AdminDao {


    public int getMatchCount(@Param("admin_id") final long admin_id,@Param("password") final String password);

    public int resetPassword(@Param("admin_id")final long admin_id, @Param("password")final String password);

    public String getPassword(@Param("admin_id")final long admin_id) ;

    public String getUsername(@Param("admin_id")final long admin_id) ;

}
