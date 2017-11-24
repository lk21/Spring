package com.lk.JDBCpractice;

import java.util.List;
import javax.sql.DataSource;
public interface StudentdDAO {
    /*
     * 设置数据源
     */
    public void setDataSource(DataSource ds);
    
    public void create(String name, Integer age, Integer marks, Integer year);
    
    public Student getStudent(Integer id);
    
    public List<StudentMarks> listStudents();
    
    public void delete(Integer id);
    
    public void update(Integer id, Integer age);

}
