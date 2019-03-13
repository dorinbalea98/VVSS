import java.util.ArrayList;
import java.util.List;

public class ClassToTest {
    public List<String> students;

    public ClassToTest() {
        this.students = new ArrayList<String>();
    }

    public void AddStudent(String student) throws Exception{

        if(student.equals(""))
            throw new Exception("Student is in the void");
        if(!students.contains(student))
            students.add(student);

    }


}
