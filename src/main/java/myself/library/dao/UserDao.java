package myself.library.dao;

import myself.library.model.entities.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @program: library
 * @description: 用户接口
 * @author: ChaiRJ
 * @create: 2020-08-27 20:44
 **/
@Mapper
@Repository
public interface UserDao {

    @Insert("insert into user " +
            "values(#{userId},#{userName},#{userEmail},#{userPassword})")
    int insertUser(User user);

    @Select("select * from user where userId = #{userId}")
    User selectById(int userId);

    @Select("select * from user where userName = #{userName}")
    User selectByName(String userName);

    @Update("update user set " +
            "userName = #{userName},userPassword = #{userPassword} " +
            "where userId = #{userId}")
    int updateUserInfo(User user);

}
