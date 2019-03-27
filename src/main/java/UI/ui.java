package UI;

import Exceptions.ValidatorException;
import Service.StudentXMLService;
import Service.TemaLabXMLService;

import java.util.Scanner;

public class ui {
    StudentXMLService stdSrv;
    TemaLabXMLService tmLbSrv;
    public ui(StudentXMLService srv1, TemaLabXMLService srv2) {
        this.stdSrv=srv1;
        this.tmLbSrv=srv2;
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

    public void addHomework() throws ValidatorException {
        Scanner scanner = new Scanner(System.in);
        String id,descr,saptLim,saptPred;
        System.out.println("Nr tema:");
        id=scanner.nextLine();
        scanner.nextLine();
        System.out.println("Descriere tema:");
        descr=scanner.nextLine();
        scanner.nextLine();
        System.out.println("Saptamana limita:");
        saptLim=scanner.nextLine();
        scanner.nextLine();
        System.out.println("Saptamana predarii:");
        saptPred=scanner.nextLine();
        scanner.nextLine();
        String[] params={id,descr,saptLim,saptPred};
        try{
            tmLbSrv.add(params);
        }catch (ValidatorException ex){
            System.out.println(ex.getMessage());
        }
    }





}
