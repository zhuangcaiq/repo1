package com.zcq;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import com.zcq.dao.StudentDao;
import com.zcq.domain.MyStudent;
import com.zcq.domain.Student;
import com.zcq.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestMybatis {

    @Test
    public void selectMultiParam(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectMultiParam("张三", 20);
        for (Student student : students) {
            System.out.println("学生信息为:"+student);
        }
        sqlSession.close();
    }

    @Test
    public void selectStudentCount(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        int count = dao.selectStudentCount();
        System.out.println(count);
    }

    @Test
    public void selectMyStudent(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> myStudents = dao.selectMyStudent(20);
        for (MyStudent myStudent : myStudents) {
            System.out.println(myStudent);
        }
        sqlSession.close();
    }

    @Test
    public void selectOneStudent(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Map<Object, Object> map = dao.selectOneStudent(1002);
        System.out.println(map);
    }

    @Test
    public void insertStudent(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        int num = dao.insertStudent(new Student(1005, "李华", "lihua@qq.com", 21));
        System.out.println(num);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectLikeStudent(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        String name = "%李%";
        List<Student> students = dao.selectLikeStudent(name);
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void selectStudentWhere(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectStudentWhere("李华", 20);
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void selectStudentForeach(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Integer> list = new ArrayList();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        List<Student> students = dao.selectStudentForeach(list);
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void selectAllStudents(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        PageHelper.startPage(2, 3);
        List<Student> students = dao.selectAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}
