package com.zcq.dao;

import com.zcq.domain.MyStudent;
import com.zcq.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    List<Student> selectMultiParam(@Param("myname") String name,@Param("age") Integer age);

    int selectStudentCount();

    int insertStudent(Student student);

    List<MyStudent> selectMyStudent(@Param("stuage") Integer age);

    Map<Object,Object> selectOneStudent(@Param("id") Integer id);

    List<Student> selectLikeStudent(@Param("name") String name);

    List<Student> selectStudentWhere(@Param("name") String name,@Param("age") Integer age);

    List<Student> selectStudentForeach(@Param("list") List<Integer> list);

    List<Student> selectAllStudents();
}
