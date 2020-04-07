package com.kongming.mybatis.demo.dao;

import com.kongming.mybatis.demo.domain.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * mybatis动态代理：
 * 使用mapper接口不用写接口实现类即可完成数据库操作
 * 使用非常简单，也是官方推荐的使用方法
 * 1）Mapper的namespace必须和mapper接口的全路径一致
 * 2）Mapper接口的方法名必须和sql定义的id一致
 * 3）Mapper接口的方法的输入参数类型必须和sql定义的parameterType一致（不一定）
 * 4）Mapper接口中方法的输出参数类型必须和sql定义的resultType一致
 */
public interface UserMapper {
    /**
     * 登录（直接使用注解指定传入参数名称）
     * @param userName
     * @param password
     * @return
     */
    public User login(@Param("userName") String userName, @Param("password") String password);

    /**
     * 根据表名查询用户信息（直接使用注解指定传入参数名称）
     * @param tableName
     * @return
     */
    public List<User> queryUserByTableName(@Param("tableName") String tableName);

    /**
     * 根据Id查询用户信息
     * @param id
     * @return
     */
    public User queryUserById(Long id);

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> queryUserAll();

    /**
     * 新增用户信息
     * @param user
     */
    public void insertUser(User user);

    /**
     * 根据id更新用户信息
     * @param user
     */
    public void updateUser(User user);

    /**
     * 根据id删除用户信息
     * @param id
     */
    public void deleteUserById(Long id);

    /**
     * 根据用户姓名模糊查询
     * @param name
     * @return
     */
    public List<User> queryUserList(@Param("name") String name);

    /**
     * 查询男性用户，如果输入了姓名则按照姓名模糊查找，否则如果输入了年龄则按照年龄查找，否则查找姓名为“鹏程”的用户。
     * @param name
     * @param age
     * @return
     */
    List<User> queryUserListByNameOrAge(@Param("name") String name,@Param("age") Integer age);

    /**
     * 查询所有用户，如果输入了姓名按照姓名进行模糊查询，如果输入年龄，按照年龄进行查询，如果两者都输入，两个条件都要成立
     * @param name
     * @param age
     * @return
     */
    List<User> queryUserListByNameAndAge(@Param("name") String name,@Param("age") Integer age);

    /**
     * 按多个Id查询
     * @param ids
     * @return
     */
    List<User> queryUserListByIds(@Param("ids") String[] ids);

    List<User> queryUserListByTime();
}
