package Test;

import com.icey.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class UserTest {
    @Test
    public void userFindByIdTest(){
        //1.获取mybatis核心配置文件
        String resources = "mybatis-config.xml";
        //创建流
        Reader reader = null;
        try{
            //读取mybatis-config.xml核心配置文件内容到reader对象中
            reader = Resources.getResourceAsReader(resources);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2.创建SqlSessionFactory工厂对象
        //初始化MyBatis数据库，创建SqlSessionFactory类的实例
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        //3.创建SqlSession实例
        SqlSession session = sqlMapper.openSession();
        //4.执行sql语句，sql语句的唯一标识：namespace.id
        //传入参数查询，返回结果
        User user = session.selectOne("findById",1);
        //输出结果
        System.out.println(user.getUname());
        //5.释放资源
        //关闭session
        session.close();
    }

}
