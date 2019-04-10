package UI;

import Exceptions.ValidatorException;
import Repository.StudentXMLRepo;
import Repository.TemaLabXMLRepo;
import Service.StudentXMLService;
import Service.TemaLabXMLService;
import Validator.StudentValidator;
import Validator.TemaLabValidator;
import com.google.common.collect.Iterables;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import static org.junit.Assert.*;

public class uiTest {

    private ui ui;
    @Before
    public void setUp() throws Exception {
        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        TemaLabValidator vl = new TemaLabValidator();
        TemaLabXMLRepo tlRepo = new TemaLabXMLRepo(vl, "TemaLabXML.xml");
        TemaLabXMLService tmlsrv = new TemaLabXMLService(tlRepo);
        ui=new ui(stsrv, tmlsrv, null);
    }


    @Test
    public void addHomeworkSuccessTestCase() {
        try {

            String simulatedUserInput = "1" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "Tema" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "2" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "2" + System.getProperty("line.separator") + System.getProperty("line.separator");

            InputStream savedStandardInputStream = System.in;
            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

            int size = Iterables.size(this.ui.tmLbSrv.findAll());

            ui.addHomework();

            System.setIn(savedStandardInputStream);

            assertEquals(Iterables.size(ui.tmLbSrv.findAll()), size + 1 );
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addHomeworkFailedTestCase() {

        int size = Iterables.size(this.ui.tmLbSrv.findAll());

        try {

            String simulatedUserInput = "Ana" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "Tema laborator saptamana 2" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "2" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "2" + System.getProperty("line.separator") + System.getProperty("line.separator");

            InputStream savedStandardInputStream = System.in;
            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));


            ui.addHomework();

            System.setIn(savedStandardInputStream);

        } catch (Exception e) {
            assertEquals(Iterables.size(ui.tmLbSrv.findAll()), size);
        }
    }

    @Test
    public void addHomeworkFailedTestCaseIntegerParseIntId() {

        int size = Iterables.size(this.ui.tmLbSrv.findAll());

        try {

            String simulatedUserInput = "Ana" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "Tema laborator saptamana 2" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "2" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "2" + System.getProperty("line.separator") + System.getProperty("line.separator");

            InputStream savedStandardInputStream = System.in;
            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));


            ui.addHomework();

            System.setIn(savedStandardInputStream);

        } catch (NumberFormatException e) {
            assertEquals(Iterables.size(ui.tmLbSrv.findAll()), size);
        } catch (ValidatorException e) {
            assert false;
        }
    }

    @Test
    public void addHomeworkFailedTestCaseIntegerParseIntWeek() {

        int size = Iterables.size(this.ui.tmLbSrv.findAll());

        try {

            String simulatedUserInput = "10" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "Tema laborator saptamana 2" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "Ana" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "2" + System.getProperty("line.separator") + System.getProperty("line.separator");

            InputStream savedStandardInputStream = System.in;
            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));


            ui.addHomework();

            System.setIn(savedStandardInputStream);

        } catch (NumberFormatException e) {
            assertEquals(Iterables.size(ui.tmLbSrv.findAll()), size);
        } catch (ValidatorException e) {
            assert false;
        }
    }


    @Test
    public void addHomeworkWriteToFileTestCase() {

        try {

            // delete the TemaLabXML file so we can test that the writeToFile method creates it.
            File file = new File("TemaLabXML.xml");
                boolean result = Files.deleteIfExists(file.toPath());

            String simulatedUserInput = "1" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "Tema laborator saptamana 2" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "2" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "4" + System.getProperty("line.separator") + System.getProperty("line.separator");

            InputStream savedStandardInputStream = System.in;
            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));


            ui.addHomework();

            File f = new File("TemaLabXML.xml");

            assertTrue(f.exists() && !f.isDirectory());

            System.setIn(savedStandardInputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addHomeworkWriteToFileTestCaseFail() {

        try {

            // delete the TemaLabXML file so we can test that the writeToFile method creates it.
            File file = new File("TemaLabXML.xml");
            boolean result = Files.deleteIfExists(file.toPath());

            // input error here so it doesn't get to the writeToFile method
            String simulatedUserInput = "Aana" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "Tema laborator saptamana 2" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "2" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "4" + System.getProperty("line.separator") + System.getProperty("line.separator");

            InputStream savedStandardInputStream = System.in;
            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));


            ui.addHomework();

            File f = new File("TemaLabXML.xml");

            assertFalse(f.exists());

            System.setIn(savedStandardInputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void addHomeworkFailedTestCaseForNameValidation() {

        int size = Iterables.size(this.ui.tmLbSrv.findAll());

        try {

            String simulatedUserInput = "4" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "2" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "2" + System.getProperty("line.separator") + System.getProperty("line.separator");

            InputStream savedStandardInputStream = System.in;
            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));


            ui.addHomework();

            System.setIn(savedStandardInputStream);

        } catch (ValidatorException e) {
            assertEquals(Iterables.size(ui.tmLbSrv.findAll()), size);
        }
    }

    @Test
    public void addHomeworkFailedTestCaseForWeekValidation() {

        int size = Iterables.size(this.ui.tmLbSrv.findAll());

        try {

            String simulatedUserInput = "4" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "Tema" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "-1" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "2" + System.getProperty("line.separator") + System.getProperty("line.separator");

            InputStream savedStandardInputStream = System.in;
            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));


            ui.addHomework();

            System.setIn(savedStandardInputStream);

        } catch (ValidatorException e) {
            assertEquals(Iterables.size(ui.tmLbSrv.findAll()), size);
        }
    }

    @Test
    public void addHomeworkFailedTestCaseForDeadlineValidation() {

        int size = Iterables.size(this.ui.tmLbSrv.findAll());

        try {

            String simulatedUserInput = "4" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "Tema" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "2" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "15" + System.getProperty("line.separator") + System.getProperty("line.separator");

            InputStream savedStandardInputStream = System.in;
            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));


            ui.addHomework();

            System.setIn(savedStandardInputStream);

        } catch (ValidatorException e) {
            assertEquals(Iterables.size(ui.tmLbSrv.findAll()), size);
        }
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