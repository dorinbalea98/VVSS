package Integration;

import Exceptions.ValidatorException;
import Repository.NotaXMLRepo;
import Repository.StudentXMLRepo;
import Repository.TemaLabXMLRepo;
import Service.NotaXMLService;
import Service.StudentXMLService;
import Service.TemaLabXMLService;
import UI.ui;
import Validator.NotaValidator;
import Validator.StudentValidator;
import Validator.TemaLabValidator;
import com.google.common.collect.Iterables;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class IncrementalTests {

    private UI.ui ui;
    @Before
    public void setUp() throws Exception {
        StudentValidator vs=new StudentValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        TemaLabValidator vl = new TemaLabValidator();
        TemaLabXMLRepo tlRepo = new TemaLabXMLRepo(vl, "TemaLabXML.xml");
        TemaLabXMLService tmlsrv = new TemaLabXMLService(tlRepo);
        NotaValidator nv = new NotaValidator();
        NotaXMLRepo nrepo = new NotaXMLRepo(nv,"NotaXML.xml");
        ui=new ui(stsrv, tmlsrv, new NotaXMLService(nrepo));
    }

    @Test
    public void addStudentTestCase() {
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
    public void addAssignmentTestCase() {
        addStudentTestCase();
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
    public void addGradeTestCase() {
        addAssignmentTestCase();
        try {
            
            String simulatedUserInput = "1" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "1" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "1" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "10" + System.getProperty("line.separator") + System.getProperty("line.separator")
                    + "2019-10-04T12:30:00" + System.getProperty("line.separator") + System.getProperty("line.separator");

            InputStream savedStandardInputStream = System.in;
            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

            int size = Iterables.size(this.ui.notaSrv.findAll());

            ui.addNota();

            System.setIn(savedStandardInputStream);

            assertEquals(Iterables.size(ui.notaSrv.findAll()), size + 1 );
        } catch (ValidatorException e) {
            e.printStackTrace();
        }


    }




}
