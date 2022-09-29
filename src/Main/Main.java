package Main;

import Classes.Engineer;
import Classes.Trainee;

import java.util.ArrayList;
import java.util.Scanner;

import static Pages.AdminPage.*;

public class Main implements StaticData {
    public static ArrayList<Engineer> engineerList = StaticData.EngineersInfo();
    public static ArrayList<Trainee> traineeList = StaticData.TrainsInfo();
    public static String AdminUserName = "omar ahmed";
    public static String AdminPassword = "omarahmed9090";
    public static String userName;
    public static String password;
    public static boolean reExecute = false;
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        MainMenu();
    }


    public static void MainMenu() throws InterruptedException {
        System.out.println();
        System.out.println("-----------Welcome Administrator-----------");
        System.out.println();
        Thread.sleep(450);
        System.out.println("Enter your username and password kindly");
        System.out.println();
        System.out.println();
        Login();

    }


}
