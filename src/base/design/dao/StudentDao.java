package base.design.dao;

import java.util.List;

/**
 * @author ktx
 * @data 2022-06-26 10:39
 */
public interface StudentDao {
    public List<Student> getAllStudents();
    public Student getStudent(int rollNo);
    public void updateStudent(Student student);
    public void deleteStudent(Student student);
}
