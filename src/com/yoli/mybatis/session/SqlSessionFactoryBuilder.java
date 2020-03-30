/**
 * 
 */
package com.yoli.mybatis.session;
import java.io.IOException;
import java.io.InputStream;
import com.yoli.mybatis.session.defaults.DefaultSqlSessionFactory;


public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(String fileName) {
        //1.加载 config.properties文件(转成输入流)
        InputStream inputStream = SqlSessionFactoryBuilder.class.getClassLoader().getResourceAsStream(fileName);
        return build(inputStream);
    }



    public SqlSessionFactory build(InputStream inputStream) {
        try {
            //2.加载输入流到configuration properties里面
            Configuration.PROPS.load(inputStream);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        String mapperLocation = Configuration.getProperty("mapper.location");
        String jdbcDriver = Configuration.getProperty("jdbc.driver");
        String jdbcUrl = Configuration.getProperty("jdbc.url");
        String jdbcUsername = Configuration.getProperty("jdbc.username");
        String jdbcPassword = Configuration.getProperty("jdbc.password");

        System.out.println("mapperLocation==="+mapperLocation);
        System.out.println("jdbcDriver==="+jdbcDriver);
        System.out.println("jdbcUrl==="+jdbcUrl);
        System.out.println("jdbcUsername==="+jdbcUsername);
        System.out.println("jdbcPassword==="+jdbcPassword);

        //3.默认sqlSession工厂中扫描mapper.xml将解析后的节点信息存到configuration中
       return new DefaultSqlSessionFactory(new Configuration());
    }
}
