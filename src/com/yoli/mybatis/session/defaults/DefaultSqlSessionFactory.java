/**
 * 
 */
package com.yoli.mybatis.session.defaults;


import java.io.File;
import java.net.URL;

import com.yoli.mybatis.constants.Constant;
import com.yoli.mybatis.session.Configuration;
import com.yoli.mybatis.session.SqlSession;
import com.yoli.mybatis.session.SqlSessionFactory;
import com.yoli.mybatis.utils.CommonUtis;
import com.yoli.mybatis.utils.XmlUtil;


/**
 * 默认SQL会话工厂实现类
 * 
 * @author PLF
 * @date 2019年3月7日
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory
{

    /** the configuration */
    private final Configuration configuration;

    /**
     * @param configuration
     */
    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
        //加载mapper info
        loadMappersInfo(Configuration.getProperty(Constant.MAPPER_LOCATION).replaceAll("\\.", "/"));
    }

    /**
     * 开启会话
     *
     * @return
     */
    @Override
    public SqlSession openSession() {

        SqlSession session = new DefaultSqlSession(this.configuration);
        return session;
    }

    /**
     * loadMappersInfo
     * 
     * @param dirName
     * @see
     */
    private void loadMappersInfo(String dirName) {

        //加载file:/F:/Yoli/project/yoli/yoli_mybatis/bin/test/dao下的所有文件
        System.out.println("");
        System.out.println("");
        System.out.println("====开始加载Mapper包下所有文件=====");
        URL resources = DefaultSqlSessionFactory.class.getClassLoader().getResource(dirName);
        File mappersDir = new File(resources.getFile());
        if (mappersDir.isDirectory()) {

            // 显示包下所有文件
            File[] mappers = mappersDir.listFiles();
            for(File file:mappers){
                System.out.println("Mapper包下所有文件=="+file);
            }

            if (CommonUtis.isNotEmpty(mappers)) {
                for (File file : mappers) {

                    // 对文件夹继续递归
                    if (file.isDirectory()) {
                        loadMappersInfo(dirName + "/" + file.getName());
                    } else if (file.getName().endsWith(Constant.MAPPER_FILE_SUFFIX)) {
                        // 只对XML文件解析
                        XmlUtil.readMapperXml(file, this.configuration);
                    }

                }

            }
        }

    }

}
