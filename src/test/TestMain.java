/**
 * 
 */
package test;


import com.yoli.mybatis.session.SqlSession;
import com.yoli.mybatis.session.SqlSessionFactory;
import com.yoli.mybatis.session.SqlSessionFactoryBuilder;
import test.bean.User;
import test.dao.UserMapper;


public class TestMain {

    public static void main(String[] args) {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build("conf.properties");
        System.out.println("factory==="+factory);

        SqlSession session = factory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.getUser("1");
//        System.out.println("******* " + user);
//        System.out.println("*******all " + userMapper.getAll());
//
//
//        userMapper.updateUser("1");
//        System.out.println("*******all " +
//                userMapper.getAll());
    }

}
