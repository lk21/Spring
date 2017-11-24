package com.lk.JDBCpractice;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class StudentJDBCTemplate implements StudentdDAO{
    
//    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
//    private PlatformTransactionManager transactionManager;
    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
//    public void setTransactionManager(PlatformTransactionManager transactionManager) {
//        this.transactionManager = transactionManager;
//    }
    
    public void create(String name, Integer age, Integer marks, Integer year) {
        
//        TransactionDefinition def = new DefaultTransactionDefinition();
//        TransactionStatus status = transactionManager.getTransaction(def);
        
        try {
            String SQL1 = "insert into Student (name, age) values (?, ?)";
            jdbcTemplate.update(SQL1, name, age);
         // Get the latest student id to be used in Marks table
            String SQL2 = "select max(id) from Student";
            int sid = jdbcTemplate.queryForObject(SQL2, Integer.class);
            String SQL3 = "insert into Marks(sid, marks, year) values (?, ?, ?)";
            jdbcTemplate.update(SQL3, sid, marks, year);
            System.out.println("Created Name = " + name + ", Age = " + age);
//            transactionManager.commit(status);
        } catch(DataAccessException e) {
            System.out.println("Error in creating record, rolling back");
//            transactionManager.rollback(status); 
            throw e;
        }
        
        
        return;
    }
    
    public Student getStudent(Integer id) {
        String sql = "select * from Student where id = ?";
        Student student = jdbcTemplate.queryForObject(sql, new Object[]{id}, new StudentMapper());
        return student;
    }

    @Override
    public List<StudentMarks> listStudents() {
        String SQL = "select * from Student, Marks where Student.id=Marks.sid";
        List<StudentMarks> studentMarks = jdbcTemplate.query(SQL, new StudentMarksMapper());
        return studentMarks;
    }

    @Override
    public void delete(Integer id) {
        String SQL = "delete from Student where id = ?";
        jdbcTemplate.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id);
        return;
    }

    @Override
    public void update(Integer id, Integer age) {
        String SQL = "update Student set age = ? where id = ?";
        jdbcTemplate.update(SQL, age, id);
        System.out.println("Updated Record with ID = " + id);
        return;
    }

    
    

}
