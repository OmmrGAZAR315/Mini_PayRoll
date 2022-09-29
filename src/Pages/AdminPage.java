package Pages;

import Classes.Engineer;
import Classes.Trainee;
import Main.Main;

import java.util.Arrays;
import java.util.Collections;

import static Main.Main.*;
import static Pages.Functions.*;

public abstract class AdminPage implements Functions {
    static int age = 0;
    static String university;
    static int academicYear;
    static double GPA;
    static String grade;
    static int leftTimes = 3;
    static int choosen = 0;
    static int salary;
    static double WH = 0;
    static Engineer[] engineerArray;
    static Trainee[] traineeArray;

    public static void Login() throws InterruptedException {
        Thread.sleep(350);
        getUserName();
        getPassword();
        if (AdminUserName.equals(userName) && AdminPassword.equals(password)) {
            System.out.println();
            AdminSettings();
        } else {
            System.out.println("Wrong user name and password");
            Login();
        }
    }


    public static void AdminSettings() throws InterruptedException {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Welcome Mr." + capitalized(AdminUserName));
        Collections.sort(engineerList);
        engineerArray = Arrays.copyOf(engineerList.toArray(), engineerList.size(), Engineer[].class);
        traineeArray = Arrays.copyOf(traineeList.toArray(), traineeList.size(), Trainee[].class);
        System.out.println("Choose your action (with n̲u̲m̲b̲e̲r̲ or w̲o̲r̲d̲ as you like ");
        System.out.println("1 - Add an engineer");
        System.out.println("2 - Edit an engineer");
        System.out.println("3 - Delete an engineer");
        System.out.println("4 - View an engineer");
        System.out.println("------------------------");
        System.out.println("5 - Add an Trainee");
        System.out.println("6 - Edit an Trainee");
        System.out.println("7 - Delete an Trainee");
        System.out.println("8 - View an Trainee");
        System.out.println("------------------------");
        System.out.println("9 - Change admin user name and password");
        System.out.println("------------------------");
        switch (input.nextLine().toLowerCase()) {
            case "add" -> {
                System.out.println("Please, sir be specific");
                System.out.println("1 - Engineer");
                System.out.println("2 - Trainee");
                System.out.println();
                switch (input.nextLine().toLowerCase()) {
                    case "1", "engineer" -> Add_Engineer();
                    case "2", "trainee" -> Add_Trainee();
                }
            }
            case "edit" -> {
                System.out.println("Please, sir be specific");
                System.out.println("1 - Engineer");
                System.out.println("2 - Trainee");
                System.out.println();
                switch (input.nextLine().toLowerCase()) {
                    case "1", "engineer" -> Edit_Engineer();
                    case "2", "trainee" -> Edit_Trainee();
                }
            }
            case "delete" -> {
                System.out.println("Please, sir be specific");
                System.out.println("1 - Engineer");
                System.out.println("2 - Trainee");
                System.out.println();
                switch (input.nextLine().toLowerCase()) {
                    case "1", "engineer" -> Delete_Engineer();
                    case "2", "trainee" -> Delete_Trainee();
                }
            }
            case "view" -> {
                System.out.println("Please, sir be specific");
                System.out.println("1 - Engineer");
                System.out.println("2 - Trainee");
                System.out.println();
                switch (input.nextLine().toLowerCase()) {
                    case "1", "engineer" -> ViewAllEngineer();
                    case "2", "trainee" -> ViewAllTrainee();
                }
            }
            case "1", "add engineer" -> Add_Engineer();
            case "2", "edit engineer" -> Edit_Engineer();
            case "3", "delete engineer" -> Delete_Engineer();
            case "4", "view engineer" -> ViewAllEngineer();
            case "5", "add trainee" -> Add_Trainee();
            case "6", "edit trainee" -> Edit_Trainee();
            case "7", "delete trainee" -> Delete_Trainee();
            case "8", "view trainee" -> ViewAllTrainee();
            case "9", "change admin" -> changeAdmin();
            default -> {
                displayError("please try again");
                System.out.println();
                AdminSettings();
            }
        }
    }


    private static void Add_Engineer() throws InterruptedException {
        System.out.println();
        System.out.println();
        System.out.println("Enter the following fields ");
        String id = looper("ID");
        String name = capitalized(looper("Name").toLowerCase());
        leftTimes = 3;
        do {
            reExecute = false;
            System.out.print("Age : ");
            try {
                age = Integer.parseInt(input.nextLine());
                if (age < 21) {
                    if (--leftTimes > 0) {
                        reExecute = true;
                        displayError("Remaining attempts : ");
                        System.out.println(leftTimes + ". ");
                        System.out.println("age can't be less than legal age 21, be reasonable");
                        System.out.println("please, try again");
                        System.out.println();
                    } else ifLeftTimes_0(true);
                } else if (age > 60) {
                    if (--leftTimes > 0) {
                        reExecute = true;
                        displayError("Remaining attempts : ");
                        System.out.println(leftTimes + ". ");
                        displayError("age can't be more than 60 years");
                        System.out.println(" please, try again");
                        System.out.println();
                    } else ifLeftTimes_0(true);
                }

            } catch (NumberFormatException e) {
                if (--leftTimes > 0) {
                    displayError("Remaining attempts : ");
                    System.out.println(leftTimes + ". ");
                    displayError("Age must be numbers");
                    System.out.println(" please, try again");
                    System.out.println();
                    System.out.println();
                    reExecute = true;
                } else ifLeftTimes_0(true);
            }
        } while (reExecute);//Age
        leftTimes = 3;
        do {
            reExecute = false;
            grade = capitalized(looper("Grade (Manger, Team Leader, Team Member)").toLowerCase());
            if (!((grade.equals("Manger")) || (grade.equals("Team Leader")) || (grade.equals("Team Member")))) {
                displayError("please try again");
                System.out.println();
                reExecute = true;
            }
        } while (reExecute);
        getWH();
        do {
            reExecute = false;

            System.out.println();
            System.out.println("Are you sure ? Y/N");
            switch (input.nextLine().toLowerCase()) {
                case "y", "yes" -> {
                    semiAnimation();
                    engineerList.add(new Engineer(id, name, age, grade, WH));
                    Thread.sleep(600);
                    AdminSettings();
                }
                case "n", "no" -> {
                    System.out.println("Return to Admin settings Y");
                    System.out.println("Retry the operation again N");
                    switch (input.nextLine().toLowerCase()) {
                        case "y", "yes" -> AdminSettings();
                        case "n", "no" -> Add_Engineer();
                    }
                }
                default -> {
                    displayError("please try again");
                    System.out.println();
                    reExecute = true;
                }
            }
        } while (reExecute);
        System.out.println();
    }

    private static void Edit_Engineer() throws InterruptedException {
        if (engineerList.size() > 0) {
            do {
                reExecute = false;

                System.out.println();
                System.out.println("Choose which engineer you want to update his info                       ( this list sorted by Grade and by salary when two object have the53 same grade ) ");
                displayThisArray(engineerArray);
                try {
                    choosen = Integer.parseInt(input.nextLine()) - 1;
                    if (choosen >= engineerList.size()) {
                        displayError("Out of range input");
                        System.out.println();
                        reExecute = true;
                    }
                } catch (NumberFormatException e) {
                    reExecute = true;
                    displayError("numbers only");
                }
            } while (reExecute);
            System.out.println();
            System.out.println("1 - Grade");
            System.out.println("2 - Working Hours");
            System.out.println();
            switch (input.nextLine().toLowerCase()) {
                case "grade", "1" -> {
                    System.out.println("Grade was : " + engineerList.get(choosen).getGrade());
                    String grade = capitalized(looper("New Grade").toLowerCase());
                    do {
                        reExecute = false;
                        System.out.println();
                        System.out.println("Are you sure ? Y/N");
                        switch (input.nextLine().toLowerCase()) {
                            case "y", "yes" -> {
                                semiAnimation();
                                engineerList.get(choosen).setGrade(grade);
                                Thread.sleep(600);
                                AdminSettings();
                            }
                            case "n", "no" -> {
                                System.out.println("Return to Admin settings Y");
                                System.out.println("Retry the operation again N");
                                switch (input.nextLine().toLowerCase()) {
                                    case "y", "yes" -> AdminSettings();
                                    case "n", "no" -> Edit_Engineer();
                                }
                            }
                            default -> {
                                displayError("please try again");
                                System.out.println();
                                reExecute = true;
                            }
                        }
                    } while (reExecute);
                }
                case "wh", "working hours", "2" -> {
                    System.out.println("Working Hours was : " + engineerList.get(choosen).getWorkingHours() + "H");
                    getWH();
                    do {
                        reExecute = false;

                        System.out.println();
                        System.out.println("Are you sure ? Y/N");
                        switch (input.nextLine().toLowerCase()) {
                            case "y", "yes" -> {
                                semiAnimation();
                                engineerList.get(choosen).setWorkingHours(WH);
                                Thread.sleep(600);
                                AdminSettings();
                            }
                            case "n", "no" -> {
                                System.out.println("Return to Admin settings Y");
                                System.out.println("Retry the operation again N");
                                switch (input.nextLine().toLowerCase()) {
                                    case "y", "yes" -> AdminSettings();
                                    case "n", "no" -> Edit_Engineer();
                                }
                            }
                            default -> {
                                displayError("please try again");
                                System.out.println();
                                reExecute = true;
                            }
                        }
                    } while (reExecute);
                }
            }
        } else noSize("engineer");
    }

    private static void Delete_Engineer() throws InterruptedException {
        if (engineerList.size() > 0) {
            System.out.println();
            do {
                reExecute = false;
                System.out.println();
                System.out.println("Choose which engineer you want to remove ");
                displayThisArray(engineerArray);
                try {
                    choosen = Integer.parseInt(input.nextLine()) - 1;
                    if (choosen >= engineerList.size()) {
                        displayError("out of range");
                        System.out.println();
                        reExecute = true;
                    }
                } catch (NumberFormatException e) {
                    reExecute = true;
                    displayError("numbers only");
                }
            } while (reExecute);
            System.out.println();
            System.out.println("    |‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|");
            System.out.println("    | ID        |    Name  |  | Grade  |    Working Hours   |      Salary     |");
            System.out.println("    |‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾| ");
            Engineer engineer = engineerList.get(choosen);
            displayEngineerInTable(choosen + 1, engineer);
            System.out.println("    |‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾ ");
            System.out.println("Are you sure ? Y/N");
            switch (input.nextLine().toLowerCase()) {
                case "y", "yes" -> {
                    semiAnimation();
                    engineerList.remove(choosen);
                    Thread.sleep(600);
                    AdminSettings();
                }
                case "n", "no" -> {
                    System.out.println("Return to Admin settings Y");
                    System.out.println("Retry the operation again N");
                    switch (input.nextLine().toLowerCase()) {
                        case "y", "yes" -> AdminSettings();
                        case "n", "no" -> Delete_Engineer();
                    }
                }
                default -> {
                    displayError("please try again");
                    System.out.println();
                    reExecute = true;
                }
            }
        } else noSize("engineer");
    }

    private static void ViewAllEngineer() throws InterruptedException {
        if (engineerList.size() > 0) {
            reExecute = true;
            System.out.println();
            int x = 1;
            System.out.println();
            System.out.println();
            for (; x <= engineerList.size(); x++) {
                if (reExecute) {
                    reExecute = false;
                    System.out.println("    |‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|");
                    System.out.println("    | ID        |    Name  |  | Grade  |    Working Hours   |      Salary     |");
                    System.out.println("    |‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾| ");
                }
                Engineer engineer = engineerList.get(x - 1);
                displayEngineerInTable(x, engineer);
                System.out.println("    |‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾ ");
                if (x % 3 == 0 && x != engineerList.size()) {
                    reExecute = true;
                    System.out.println();
                    System.out.println();
                    System.out.print("check for more engineer!");
                    System.out.println();
                    System.out.println();
                    input.nextLine();
                }
            }
            if (engineerList.size() == 0) {
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("Error 404 : Not Found");
                System.out.println("you don't have any Engineer");
            }
            System.out.println();
            System.out.println();
            System.out.print("Press Enter to continue");
            System.out.println();
            System.out.println();
            input.nextLine();
            AdminSettings();
        } else noSize("engineer");
    }

    private static void Add_Trainee() throws InterruptedException {
        System.out.println();
        System.out.println();
        System.out.println("Enter the following fields ");
        String id = looper("ID");
        String name = capitalized(looper("Name").toLowerCase());
        leftTimes = 3;
        do {
            reExecute = false;
            System.out.print("Age : ");
            try {
                age = Integer.parseInt(input.nextLine());
                if (age < 16) {
                    if (--leftTimes > 0) {
                        reExecute = true;
                        displayError("Remaining attempts : ");
                        System.out.println(leftTimes + ". ");
                        System.out.println("age can't be less than legal age, be reasonable");
                        System.out.println("please, try again");
                        System.out.println();
                    } else ifLeftTimes_0(true);
                } else if (age > 25) {
                    if (--leftTimes > 0) {
                        reExecute = true;
                        displayError("Remaining attempts : ");
                        System.out.println(leftTimes + ". ");
                        displayError("age can't be more than 60 years");
                        System.out.println(" please, try again");
                        System.out.println();
                    } else ifLeftTimes_0(true);
                }
            } catch (NumberFormatException e) {
                if (--leftTimes > 0) {
                    displayError("Remaining attempts : ");
                    System.out.println(leftTimes + ". ");
                    displayError("Age must be numbers");
                    System.out.println(" please, try again");
                    System.out.println();
                    System.out.println();
                    reExecute = true;
                } else ifLeftTimes_0(true);
            }
        } while (reExecute);//Age
        leftTimes = 3;
        do {
            reExecute = false;
            System.out.print("Salary : ");
            try {
                salary = Integer.parseInt(input.nextLine());
                if (salary < 0) {
                    if (--leftTimes > 0) {
                        reExecute = true;
                        displayError("Remaining attempts : ");
                        System.out.println(leftTimes + ". ");
                        System.out.println("salary can't be less than 0");
                        System.out.println("please, try again");
                        System.out.println();
                    } else ifLeftTimes_0(true);
                }
            } catch (NumberFormatException e) {
                if (--leftTimes > 0) {
                    displayError("Remaining attempts : ");
                    System.out.println(leftTimes + ". ");
                    displayError("Salary must be numbers");
                    System.out.println(" please, try again");
                    System.out.println();
                    System.out.println();
                    reExecute = true;
                } else ifLeftTimes_0(true);
            }
        } while (reExecute);//Salary
        university = capitalized(looper("University").toLowerCase());
        leftTimes = 3;
        do {
            reExecute = false;
            System.out.print("GPA : ");
            try {
                GPA = Double.parseDouble(input.nextLine());
                if (GPA < 2) {
                    if (--leftTimes > 0) {
                        reExecute = true;
                        displayError("Remaining attempts : ");
                        System.out.println(leftTimes + ". ");
                        System.out.println("GPA can't be less than 2");
                        System.out.println("please, try again");
                        System.out.println();
                    } else ifLeftTimes_0(true);
                }
            } catch (NumberFormatException e) {
                if (--leftTimes > 0) {
                    displayError("Remaining attempts : ");
                    System.out.println(leftTimes + ". ");
                    displayError("GPA must be numbers");
                    System.out.println(" please, try again");
                    System.out.println();
                    System.out.println();
                    reExecute = true;
                } else ifLeftTimes_0(true);
            }
        } while (reExecute);//GPA
        leftTimes = 3;
        do {
            reExecute = false;
            System.out.print("Academic Year : ");
            try {
                academicYear = Integer.parseInt(input.nextLine());
                if (academicYear < 0) {
                    if (--leftTimes > 0) {
                        reExecute = true;
                        displayError("Remaining attempts : ");
                        System.out.println(leftTimes + ". ");
                        System.out.println("Academic Year can't be less than 0");
                        System.out.println("please, try again");
                        System.out.println();
                    } else ifLeftTimes_0(true);
                }
            } catch (NumberFormatException e) {
                if (--leftTimes > 0) {
                    displayError("Remaining attempts : ");
                    System.out.println(leftTimes + ". ");
                    displayError("Academic Year must be numbers");
                    System.out.println(" please, try again");
                    System.out.println();
                    System.out.println();
                    reExecute = true;
                } else ifLeftTimes_0(true);
            }
        } while (reExecute);//Year
        do {
            reExecute = false;
            System.out.println();
            System.out.println("Are you sure ? Y/N");
            switch (input.nextLine().toLowerCase()) {
                case "y", "yes" -> {
                    semiAnimation();
                    traineeList.add(new Trainee(id, name, age, 700, university, GPA, academicYear));
                    Thread.sleep(600);
                    AdminSettings();
                }
                case "n", "no" -> {
                    System.out.println("Return to Admin settings Y");
                    System.out.println("Retry the operation again N");
                    switch (input.nextLine().toLowerCase()) {
                        case "y", "yes" -> AdminSettings();
                        case "n", "no" -> Add_Trainee();
                    }
                }
                default -> {
                    displayError("please try again");
                    System.out.println();
                    reExecute = true;
                }
            }
        } while (reExecute);
        System.out.println();
    }

    private static void Edit_Trainee() throws InterruptedException {
        leftTimes = 3;
        if (traineeList.size() > 0) {
            do {
                reExecute = false;

                System.out.println();
                System.out.println("Choose which Trainee you want to update his info ");
                displayThisArray(traineeArray);
                try {
                    choosen = Integer.parseInt(input.nextLine()) - 1;
                    if (choosen >= traineeList.size()) {
                        displayError("Out of range input");
                        System.out.println();
                        reExecute = true;
                    }
                } catch (NumberFormatException e) {
                    reExecute = true;
                    displayError("numbers only");
                }
            } while (reExecute);
            System.out.println();
            System.out.println("1 - Salary");
            System.out.println("2 - University");
            System.out.println("3 - GPA");
            System.out.println("4 - Academic Year ");
            System.out.println();
            switch (input.nextLine().toLowerCase()) {
                case "salary", "1" -> {
                    System.out.println("Salary was : " + traineeList.get(choosen).getSalary());
                    do {
                        reExecute = false;
                        System.out.print("New Salary : ");
                        try {
                            salary = Integer.parseInt(input.nextLine());
                            if (salary < 0) {
                                if (--leftTimes > 0) {
                                    reExecute = true;
                                    displayError("Remaining attempts : ");
                                    System.out.println(leftTimes + ". ");
                                    System.out.println("salary can't be less than 0");
                                    System.out.println("please, try again");
                                    System.out.println();
                                } else ifLeftTimes_0(true);
                            }
                        } catch (NumberFormatException e) {
                            if (--leftTimes > 0) {
                                displayError("Remaining attempts : ");
                                System.out.println(leftTimes + ". ");
                                displayError("Salary must be numbers");
                                System.out.println(" please, try again");
                                System.out.println();
                                System.out.println();
                                reExecute = true;
                            } else ifLeftTimes_0(true);
                        }
                    } while (reExecute);//Salary
                    do {
                        reExecute = false;

                        System.out.println();
                        System.out.println("Are you sure ? Y/N");
                        switch (input.nextLine().toLowerCase()) {
                            case "y", "yes" -> {
                                semiAnimation();
                                traineeList.get(choosen).setSalary(salary);
                                Thread.sleep(600);
                                AdminSettings();
                            }
                            case "n", "no" -> {
                                System.out.println("Return to Admin settings Y");
                                System.out.println("Retry the operation again N");
                                switch (input.nextLine().toLowerCase()) {
                                    case "y", "yes" -> AdminSettings();
                                    case "n", "no" -> Edit_Trainee();
                                }
                            }
                            default -> {
                                displayError("please try again");
                                System.out.println();
                                reExecute = true;
                            }
                        }
                    } while (reExecute);
                }
                case "university", "2" -> {
                    System.out.println("University was : " + traineeList.get(choosen).getUniversity());
                    university = capitalized(looper("University").toLowerCase());
                    do {
                        reExecute = false;

                        System.out.println();
                        System.out.println("Are you sure ? Y/N");
                        switch (input.nextLine().toLowerCase()) {
                            case "y", "yes" -> {
                                semiAnimation();
                                traineeList.get(choosen).setUniversity(university);
                                Thread.sleep(600);
                                AdminSettings();
                            }
                            case "n", "no" -> {
                                System.out.println("Return to Admin settings Y");
                                System.out.println("Retry the operation again N");
                                switch (input.nextLine().toLowerCase()) {
                                    case "y", "yes" -> AdminSettings();
                                    case "n", "no" -> Edit_Trainee();
                                }
                            }
                            default -> {
                                displayError("please try again");
                                System.out.println();
                                reExecute = true;
                            }
                        }
                    } while (reExecute);
                }
                case "gpa", "3" -> {
                    System.out.println("GPA was : " + traineeList.get(choosen).getGPA());
                    do {
                        reExecute = false;
                        System.out.print("New GPA : ");
                        try {
                            GPA = Double.parseDouble(input.nextLine());
                            if (GPA < 2) {
                                if (--leftTimes > 0) {
                                    reExecute = true;
                                    displayError("Remaining attempts : ");
                                    System.out.println(leftTimes + ". ");
                                    System.out.println("GPA can't be less than 2");
                                    System.out.println("please, try again");
                                    System.out.println();
                                } else ifLeftTimes_0(true);
                            }
                        } catch (NumberFormatException e) {
                            if (--leftTimes > 0) {
                                displayError("Remaining attempts : ");
                                System.out.println(leftTimes + ". ");
                                displayError("GPA must be numbers");
                                System.out.println(" please, try again");
                                System.out.println();
                                System.out.println();
                                reExecute = true;
                            } else ifLeftTimes_0(true);
                        }
                    } while (reExecute);//GPA
                    do {
                        reExecute = false;
                        System.out.println();
                        System.out.println("Are you sure ? Y/N");
                        switch (input.nextLine().toLowerCase()) {
                            case "y", "yes" -> {
                                semiAnimation();
                                traineeList.get(choosen).setGPA(GPA);
                                Thread.sleep(600);
                                AdminSettings();
                            }
                            case "n", "no" -> {
                                System.out.println("Return to Admin settings Y");
                                System.out.println("Retry the operation again N");
                                switch (input.nextLine().toLowerCase()) {
                                    case "y", "yes" -> AdminSettings();
                                    case "n", "no" -> Edit_Trainee();
                                }
                            }
                            default -> {
                                displayError("please try again");
                                System.out.println();
                                reExecute = true;
                            }
                        }
                    } while (reExecute);
                }
                case "year", "academic year", "4" -> {
                    System.out.println("Academic Year was : " + traineeList.get(choosen).getUniversity());
                    do {
                        reExecute = false;
                        System.out.print("New Academic Year : ");
                        try {
                            academicYear = Integer.parseInt(input.nextLine());
                            if (academicYear < 0) {
                                if (--leftTimes > 0) {
                                    reExecute = true;
                                    displayError("Remaining attempts : ");
                                    System.out.println(leftTimes + ". ");
                                    System.out.println("Academic Year can't be less than 0");
                                    System.out.println("please, try again");
                                    System.out.println();
                                } else ifLeftTimes_0(true);
                            }
                        } catch (NumberFormatException e) {
                            if (--leftTimes > 0) {
                                displayError("Remaining attempts : ");
                                System.out.println(leftTimes + ". ");
                                displayError("Academic Year must be numbers");
                                System.out.println(" please, try again");
                                System.out.println();
                                System.out.println();
                                reExecute = true;
                            } else ifLeftTimes_0(true);
                        }
                    } while (reExecute);//Year
                    do {
                        reExecute = false;
                        System.out.println();
                        System.out.println("Are you sure ? Y/N");
                        switch (input.nextLine().toLowerCase()) {
                            case "y", "yes" -> {
                                semiAnimation();
                                traineeList.get(choosen).setAcademicYear(academicYear);
                                Thread.sleep(600);
                                AdminSettings();
                            }
                            case "n", "no" -> {
                                System.out.println("Return to Admin settings Y");
                                System.out.println("Retry the operation again N");
                                switch (input.nextLine().toLowerCase()) {
                                    case "y", "yes" -> AdminSettings();
                                    case "n", "no" -> Edit_Trainee();
                                }
                            }
                            default -> {
                                displayError("please try again");
                                System.out.println();
                                reExecute = true;
                            }
                        }
                    } while (reExecute);
                }
            }
        } else noSize("trainee");
    }

    private static void Delete_Trainee() throws InterruptedException {
        if (traineeList.size() > 0) {
            System.out.println();
            do {
                reExecute = false;
                System.out.println();
                System.out.println("Choose which Trainee you want to remove ");
                displayThisArray(traineeArray);
                try {
                    choosen = Integer.parseInt(input.nextLine()) - 1;
                    if (choosen >= traineeList.size()) reExecute = true;
                } catch (NumberFormatException e) {
                    reExecute = true;
                    displayError("numbers only");
                }
            } while (reExecute);
            System.out.println();
            System.out.println("    |‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|");
            System.out.println("    | ID        |    Name  |  | University  |     GPA   ||     Academic Year   |      Salary     |");
            System.out.println("    |‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾| ");
            Trainee Trainee = traineeList.get(choosen);
            displayTraineeInTable(Trainee);
            System.out.println("    |‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾ ");

            System.out.println("Are you sure ? Y/N");
            switch (input.nextLine().toLowerCase()) {
                case "y", "yes" -> {
                    semiAnimation();
                    traineeList.remove(choosen);
                    Thread.sleep(600);
                    AdminSettings();
                }
                case "n", "no" -> {
                    System.out.println("Return to Admin settings Y");
                    System.out.println("Retry the operation again N");
                    switch (input.nextLine().toLowerCase()) {
                        case "y", "yes" -> AdminSettings();
                        case "n", "no" -> Delete_Trainee();
                    }
                }
                default -> {
                    displayError("please try again");
                    System.out.println();
                    reExecute = true;
                }
            }
        } else noSize("trainee");
    }

    private static void ViewAllTrainee() throws InterruptedException {
        if (traineeList.size() > 0) {
            reExecute = true;
            System.out.println();
            int x = 1;
            System.out.println();
            System.out.println();
            for (; x <= traineeList.size(); x++) {
                if (reExecute) {
                    reExecute = false;
                    System.out.println("    |‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|");
                    System.out.println("    | ID        |    Name  |  | University  |     GPA   ||     Academic Year   |      Salary     |");
                    System.out.println("    |‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾| ");
                }
                Trainee Trainee = traineeList.get(x - 1);
                displayTraineeInTable(Trainee);
                System.out.println("    |‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
                if (x % 3 == 0 && x != traineeList.size()) {
                    reExecute = true;
                    System.out.println();
                    System.out.println();
                    System.out.print("check for more trainee!");
                    System.out.println();
                    System.out.println();
                    input.nextLine();
                }
            }
            if (traineeList.size() == 0) {
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("Error 404 : Not Found");
                System.out.println("you don't have any Trainee");
            }
            System.out.println();
            System.out.println();
            System.out.print("Press Enter to continue");
            System.out.println();
            System.out.println();
            input.nextLine();
            AdminSettings();
        } else noSize("trainee");

    }


    private static void changeAdmin() throws InterruptedException {
        System.out.println();
        System.out.println("Administrator UserName and Password will change forever (ِشغال program طالما ال)");
        System.out.println("Continue Y/N");
        switch (input.nextLine().toLowerCase()) {
            case "yes", "y" -> {
                do {
                    reExecute = false;

                    System.out.println("Please, enter the following carefully ");
                    do {
                        reExecute = false;
                        getUserName();
                        String confirmName = looper("confirm Name").toLowerCase();
                        if (!(userName.equals(confirmName))) {
                            System.out.println("userName isn't match, please try again");
                            reExecute = true;
                        }
                    } while (reExecute);
                    do {
                        reExecute = false;

                        getPassword();
                        String confirmPass = looper("Confirm Password").toLowerCase();
                        if (!(password.equals(confirmPass))) {
                            System.out.println("Password isn't match, please try again");
                            reExecute = true;
                        }
                    } while (reExecute);
                    System.out.println("Are you sure Y/N");
                    switch (input.nextLine().toLowerCase()) {
                        case "yes", "y" -> {
                            System.out.println("GoodBye...Mr." + AdminUserName);
                            AdminUserName = userName;
                            AdminPassword = password;
                            Thread.sleep(400);
                            MainMenu();
                        }
                        case "no", "n" -> reExecute = true;
                        default -> {
                            displayError("please try again");
                            System.out.println();
                            reExecute = true;
                        }
                    }
                } while (reExecute);
            }
            case "no", "n" -> AdminSettings();
        }
    }


}
