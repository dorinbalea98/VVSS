package UI;

import Exceptions.ValidatorException;
import Repository.NotaXMLRepo;
import Service.NotaXMLService;
import Service.StudentXMLService;
import Service.TemaLabXMLService;

import java.io.IOException;
import java.util.Scanner;

public class ui {
    public StudentXMLService stdSrv;
    public TemaLabXMLService tmLbSrv;
    public NotaXMLService notaSrv;
    public ui(StudentXMLService srv1, TemaLabXMLService srv2, NotaXMLService srv3) {
        this.stdSrv=srv1;
        this.tmLbSrv=srv2;
        this.notaSrv=srv3;
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

    public void addNota() throws ValidatorException {
        Scanner scanner = new Scanner(System.in);
        String id,ids,idt,val,data;
        System.out.println("Id nota:");
        id=scanner.nextLine();
        scanner.nextLine();
        System.out.println("Id student:");
        ids=scanner.nextLine();
        scanner.nextLine();
        System.out.println("Id tema:");
        idt=scanner.nextLine();
        scanner.nextLine();
        System.out.println("Valoare:");
        val=scanner.nextLine();
        System.out.println(val);
        scanner.nextLine();
        System.out.println("Data:");
        data=scanner.nextLine();
        scanner.nextLine();
        String val1=notaSrv.depunctare(tmLbSrv,idt,val);
        String[] params={id,ids,idt,val1,data};
        try{
            notaSrv.add(params);
            notaSrv.printAllNotes(tmLbSrv);
        }catch (ValidatorException ex){
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }






}
