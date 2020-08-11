package com.zcq.dao;

import com.zcq.domain.Student;
import com.zcq.utils.MybatisUilt;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> selectStudents() {
        SqlSession sqlSession = MybatisUilt.getSqlSession();
        String sqlId = "com.zcq.dao.StudentDao.selectStudents";
        List<Student> students = sqlSession.selectList(sqlId);
        return students;
    }

    @Override
    public int insertStudent(Student student) {
        SqlSession sqlSession = MybatisUilt.getSqlSession();
        String sqlId = "com.zcq.dao.StudentDao.insertStudent";
        int nums = sqlSession.insert(sqlId,student);
        return nums;
    }
}
