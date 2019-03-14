package UI;

import Exceptions.ValidatorException;
import Service.StudentXMLService;

import java.util.Scanner;

public class ui {
    StudentXMLService stdSrv;
    public ui(StudentXMLService srv1){
        this.stdSrv=srv1;
    }

    public void addStudent() throws ValidatorException {
        Scanner scanner = new Scanner(System.in);
        String id,nume,grupa,email,prof;
        System.out.println("Id student:");
        id=scanner.nextLine();
        //scanner.nextLine();
        System.out.println("Nume student:");
        nume=scanner.nextLine();
        //scanner.nextLine();
        System.out.println("Grupa:");
        grupa=scanner.nextLine();
        //scanner.nextLine();
        System.out.println("Email:");
        email=scanner.nextLine();
        //scanner.nextLine();
        System.out.println("Profesor indrumator:");
        prof=scanner.nextLine();
        //scanner.nextLine();
        String[] params={id,nume,grupa,email,prof};
        try{
            stdSrv.add(params);
        }catch (ValidatorException ex){
            System.out.println(ex.getMessage());
        }

    }
}
