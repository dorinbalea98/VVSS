package UI;

import Exceptions.ValidatorException;
import Repository.StudentXMLRepo;
import Service.StudentXMLService;
import Validator.StudentValidator;
import com.google.common.collect.Iterables;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class uiTest {

    private ui ui;
    @Before
    public void setUp() throws Exception {
        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        ui=new ui(stsrv);
    }

    @Test
    public void addStudentSuccessTestCase() {
        try {

            String simulatedUserInput = "1" + System.getProperty("line.separator")
                    + "Andreea Acatrinei" + System.getProperty("line.separator")
                    + "931" + System.getProperty("line.separator")
                    + "andreea.acatrinei@gmail.com" + System.getProperty("line.separator")
                    + "Andreea Vescan" + System.getProperty("line.separator");

            InputStream savedStandardInputStream = System.in;
            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

            int size = Iterables.size(this.ui.stdSrv.findAll());

            ui.addStudent();

            System.setIn(savedStandardInputStream);

            assertEquals(Iterables.size(ui.stdSrv.findAll()), size + 1 );
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addStudentFailedTestCase() {
        System.setIn(new ByteArrayInputStream("".getBytes()));

        int size = Iterables.size(this.ui.stdSrv.findAll());


        try {
            String simulatedUserInput = "" + System.getProperty("line.separator")
                    + "Andreea Acatrinei" + System.getProperty("line.separator")
                    + "931" + System.getProperty("line.separator")
                    + "andreea.acatrinei@gmail.com" + System.getProperty("line.separator")
                    + "Andreea Vescan" + System.getProperty("line.separator");
            InputStream savedStandardInputStream = System.in;

            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

            ui.addStudent();

            System.setIn(savedStandardInputStream);

        } catch (ValidatorException e) {
            assertEquals(Iterables.size(ui.stdSrv.findAll()), size);
        }
    }

}