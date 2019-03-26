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

    @Test
    public void addStudentTestCase3() {
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

    @Test
    public void addStudentTestCase4() {

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

    @Test
    public void addStudentTestCase5() {
        System.setIn(new ByteArrayInputStream("".getBytes()));

        int size = Iterables.size(this.ui.stdSrv.findAll());


        try {
            String simulatedUserInput = "0" + System.getProperty("line.separator")
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

    @Test
    public void addStudentTestCase7() {
        System.setIn(new ByteArrayInputStream("".getBytes()));

        int size = Iterables.size(this.ui.stdSrv.findAll());


        try {
            String simulatedUserInput = "Text" + System.getProperty("line.separator")
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


    @Test
    public void addStudentTestCase8() {
        System.setIn(new ByteArrayInputStream("".getBytes()));

        int size = Iterables.size(this.ui.stdSrv.findAll());


        try {
            String simulatedUserInput = "-1" + System.getProperty("line.separator")
                    + "Andreea Acatrinei" + System.getProperty("line.separator")
                    + "111" + System.getProperty("line.separator")
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


    @Test
    public void addStudentTestCase9() {
        System.setIn(new ByteArrayInputStream("".getBytes()));

        int size = Iterables.size(this.ui.stdSrv.findAll());


        try {
            String simulatedUserInput = "-1" + System.getProperty("line.separator")
                    + "Andreea Acatrinei" + System.getProperty("line.separator")
                    + "911" + System.getProperty("line.separator")
                    + "andreea.acatrinei@gmail.com" + System.getProperty("line.separator")
                    + "Andreea Vescan" + System.getProperty("line.separator");
            InputStream savedStandardInputStream = System.in;

            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

            ui.addStudent();

            assertEquals(Iterables.size(ui.stdSrv.findAll()), size + 1);

            System.setIn(savedStandardInputStream);

        } catch (ValidatorException e) {

        }
    }



    @Test
    public void addStudentTestCase10() {
        System.setIn(new ByteArrayInputStream("".getBytes()));

        int size = Iterables.size(this.ui.stdSrv.findAll());


        try {
            String simulatedUserInput = "-1" + System.getProperty("line.separator")
                    + "Andreea Acatrinei" + System.getProperty("line.separator")
                    + "131" + System.getProperty("line.separator")
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



    @Test
    public void addStudentTestCase11() {
        System.setIn(new ByteArrayInputStream("".getBytes()));

        int size = Iterables.size(this.ui.stdSrv.findAll());


        try {
            String simulatedUserInput = "-1" + System.getProperty("line.separator")
                    + "Andreea Acatrinei" + System.getProperty("line.separator")
                    + "117" + System.getProperty("line.separator")
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



    @Test
    public void addStudentTestCase12() {
        System.setIn(new ByteArrayInputStream("".getBytes()));

        int size = Iterables.size(this.ui.stdSrv.findAll());


        try {
            String simulatedUserInput = "-1" + System.getProperty("line.separator")
                    + "Andreea Acatrinei" + System.getProperty("line.separator")
                    + "1234" + System.getProperty("line.separator")
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


    @Test
    public void addStudentTestCase13() {
        System.setIn(new ByteArrayInputStream("".getBytes()));

        int size = Iterables.size(this.ui.stdSrv.findAll());


        try {
            String simulatedUserInput = "-1" + System.getProperty("line.separator")
                    + "Andreea Acatrinei" + System.getProperty("line.separator")
                    + "12" + System.getProperty("line.separator")
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


    @Test
    public void addStudentTestCase15() {
        System.setIn(new ByteArrayInputStream("".getBytes()));

        int size = Iterables.size(this.ui.stdSrv.findAll());


        try {
            String simulatedUserInput = "-1" + System.getProperty("line.separator")
                    + "Andreea Acatrinei" + System.getProperty("line.separator")
                    + "931" + System.getProperty("line.separator")
                    + "email@yahoo.com" + System.getProperty("line.separator")
                    + "Andreea Vescan" + System.getProperty("line.separator");
            InputStream savedStandardInputStream = System.in;

            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

            ui.addStudent();
            assertEquals(Iterables.size(ui.stdSrv.findAll()), size + 1);

            System.setIn(savedStandardInputStream);

        } catch (ValidatorException e) {
        }
    }

    @Test
    public void addStudentTestCase16() {
        System.setIn(new ByteArrayInputStream("".getBytes()));

        int size = Iterables.size(this.ui.stdSrv.findAll());


        try {
            String simulatedUserInput = "-1" + System.getProperty("line.separator")
                    + "Andreea Acatrinei" + System.getProperty("line.separator")
                    + "931" + System.getProperty("line.separator")
                    + "email+yahoo.com" + System.getProperty("line.separator")
                    + "Andreea Vescan" + System.getProperty("line.separator");
            InputStream savedStandardInputStream = System.in;

            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

            ui.addStudent();

            System.setIn(savedStandardInputStream);

        } catch (ValidatorException e) {
            assertEquals(Iterables.size(ui.stdSrv.findAll()), size);
        }
    }
    @Test
    public void addStudentTestCase17() {
        System.setIn(new ByteArrayInputStream("".getBytes()));

        int size = Iterables.size(this.ui.stdSrv.findAll());


        try {
            String simulatedUserInput = "-1" + System.getProperty("line.separator")
                    + "Andreea Acatrinei" + System.getProperty("line.separator")
                    + "931" + System.getProperty("line.separator")
                    + "email@yahoo!com" + System.getProperty("line.separator")
                    + "Andreea Vescan" + System.getProperty("line.separator");
            InputStream savedStandardInputStream = System.in;

            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

            ui.addStudent();

            System.setIn(savedStandardInputStream);

        } catch (ValidatorException e) {
            assertEquals(Iterables.size(ui.stdSrv.findAll()), size);
        }
    }
    @Test
    public void addStudentTestCase18() {
        System.setIn(new ByteArrayInputStream("".getBytes()));

        int size = Iterables.size(this.ui.stdSrv.findAll());


        try {
            String simulatedUserInput = "-1" + System.getProperty("line.separator")
                    + "Andreea Acatrinei" + System.getProperty("line.separator")
                    + "931" + System.getProperty("line.separator")
                    + "email*yahoo*com" + System.getProperty("line.separator")
                    + "Andreea Vescan" + System.getProperty("line.separator");
            InputStream savedStandardInputStream = System.in;

            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

            ui.addStudent();

            System.setIn(savedStandardInputStream);

        } catch (ValidatorException e) {
            assertEquals(Iterables.size(ui.stdSrv.findAll()), size);
        }
    }
    @Test
    public void addStudentTestCase19() {
        System.setIn(new ByteArrayInputStream("".getBytes()));

        int size = Iterables.size(this.ui.stdSrv.findAll());


        try {
            String simulatedUserInput = "-1" + System.getProperty("line.separator")
                    + "Alex Barboy" + System.getProperty("line.separator")
                    + "931" + System.getProperty("line.separator")
                    + "andreea.acatrinei@gmail.com" + System.getProperty("line.separator")
                    + "Andreea Vescan" + System.getProperty("line.separator");
            InputStream savedStandardInputStream = System.in;

            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

            ui.addStudent();

            assertEquals(Iterables.size(ui.stdSrv.findAll()), size + 1);

            System.setIn(savedStandardInputStream);

        } catch (ValidatorException e) {
        }
    }
    @Test
    public void addStudentTestCase20() {
        System.setIn(new ByteArrayInputStream("".getBytes()));

        int size = Iterables.size(this.ui.stdSrv.findAll());


        try {
            String simulatedUserInput = "-1" + System.getProperty("line.separator")
                    + "Alex Barboy!" + System.getProperty("line.separator")
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
    @Test
    public void addStudentTestCase21() {
        System.setIn(new ByteArrayInputStream("".getBytes()));

        int size = Iterables.size(this.ui.stdSrv.findAll());


        try {
            String simulatedUserInput = "-1" + System.getProperty("line.separator")
                    + "" + System.getProperty("line.separator")
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
    @Test
    public void addStudentTestCase22() {
        System.setIn(new ByteArrayInputStream("".getBytes()));

        int size = Iterables.size(this.ui.stdSrv.findAll());


        try {
            String simulatedUserInput = "-1" + System.getProperty("line.separator")
                    + "Andreea Acatrinei" + System.getProperty("line.separator")
                    + "931" + System.getProperty("line.separator")
                    + "andreea.acatrinei@gmail.com" + System.getProperty("line.separator")
                    + "Alex Barboy" + System.getProperty("line.separator");
            InputStream savedStandardInputStream = System.in;

            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

            ui.addStudent();

            assertEquals(Iterables.size(ui.stdSrv.findAll()), size + 1);

            System.setIn(savedStandardInputStream);

        } catch (ValidatorException e) {
        }
    }
    @Test
    public void addStudentTestCase23() {
        System.setIn(new ByteArrayInputStream("".getBytes()));

        int size = Iterables.size(this.ui.stdSrv.findAll());


        try {
            String simulatedUserInput = "-1" + System.getProperty("line.separator")
                    + "Andreea Acatrinei" + System.getProperty("line.separator")
                    + "931" + System.getProperty("line.separator")
                    + "andreea.acatrinei@gmail.com" + System.getProperty("line.separator")
                    + "Alex Barboy !" + System.getProperty("line.separator");
            InputStream savedStandardInputStream = System.in;

            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

            ui.addStudent();

            System.setIn(savedStandardInputStream);

        } catch (ValidatorException e) {
            assertEquals(Iterables.size(ui.stdSrv.findAll()), size);
        }
    }
    @Test
    public void addStudentTestCase24() {
        System.setIn(new ByteArrayInputStream("".getBytes()));

        int size = Iterables.size(this.ui.stdSrv.findAll());


        try {
            String simulatedUserInput = "-1" + System.getProperty("line.separator")
                    + "Andreea Acatrinei" + System.getProperty("line.separator")
                    + "931" + System.getProperty("line.separator")
                    + "andreea.acatrinei@gmail.com" + System.getProperty("line.separator")
                    + "" + System.getProperty("line.separator");
            InputStream savedStandardInputStream = System.in;

            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

            ui.addStudent();

            System.setIn(savedStandardInputStream);

        } catch (ValidatorException e) {
            assertEquals(Iterables.size(ui.stdSrv.findAll()), size);
        }
    }
    public void addStudentTestCase6() {
        System.setIn(new ByteArrayInputStream("".getBytes()));

        int size = Iterables.size(this.ui.stdSrv.findAll());


        try {
            String simulatedUserInput = "-1" + System.getProperty("line.separator")
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