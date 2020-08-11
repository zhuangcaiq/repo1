package com.zcq;

import com.zcq.dao.StudentDaoImpl;
import com.zcq.domain.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.apache.ibatis.io.Resources.*;

public class StudentDaoTest {
    @Test
    public void selectTest() throws IOException {
        //访问mybatis读取student数据
        //1、定义mybatis主配置文件的名称，从类路径的根开始（target/classes）
        String config = "mybatis.xml";
        //2、读取这个config表示的文件
        InputStream is = getResourceAsStream(config);
        //3、创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4、创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(is);
        //5、获取SqlSession对象，从创建SqlSessionFactory对象中获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //6、指定要执行的sql语句标识。sql映射文件的namespace+"."+标签的id值
        String sqlId = "com.zcq.dao.StudentDao"+"."+"selectStudents";
        //7、执行sql语句，通过sqlId找到语句
        List<Student> studentList = sqlSession.selectList(sqlId);
        //8、输出结果
        for (Student student : studentList) {
            System.out.println(student);
        }
        //9、关闭SqlSession对象
        sqlSession.close();
    }

    @Test
    public void insertTest() throws IOException {
        String config="mybatis.xml";
        InputStream is = getResourceAsStream(config);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(is);
        SqlSession sqlSession = build.openSession();
        String sqlId="com.zcq.dao.StudentDao"+"."+"insertStudent";
        int nums = sqlSession.insert(sqlId,new Student(1003,"王五","wangw@qq.com",20));

        //mybatis默认不是自动提交事务，所以在insert、update、delete后要手动提交事务
        sqlSession.commit();
        System.out.println("执行insert的结果："+nums);
    }


    @Test
    public void selectTest1(){
        StudentDaoImpl studentDao = new StudentDaoImpl();
        List<Student> students = studentDao.selectStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void insertTest1(){
        StudentDaoImpl studentDao = new StudentDaoImpl();
        int nums = studentDao.insertStudent(new Student(1004, "赵六", "zhaoliu@qq.com", 22));
        System.out.println("执行insert语句的结果："+nums);
    }
}
