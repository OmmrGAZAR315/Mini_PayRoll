package Pages;

import Classes.Employee;
import Classes.Engineer;
import Classes.Trainee;

import static Main.Main.*;
import static Main.Main.reExecute;
import static Pages.AdminPage.AdminSettings;

interface Functions {
    static void getUserName() throws InterruptedException {
        int leftTimes = 3;
        do {
            reExecute = false;
            System.out.print("User Name : ");
            userName = input.nextLine();
            if (userName.length() < 6) {
                if (--leftTimes > 0) {

                    reExecute = true;
                    displayError("Remaining attempts: ");
                    System.out.println(leftTimes + ". ");
                    System.out.println("User Name must be at least 6 characters");
                } else ifLeftTimes_0(false);
                System.out.println();
            }
        } while (reExecute);
    }

    static void noSize(String str) throws InterruptedException {
        System.out.println("  Error 404 : Not Found");
        System.out.println("   you don't have a " + str + " in your company");
        System.out.println("   please add at least a " + str);
        System.out.println();
        System.out.println();
        System.out.print("    Press Enter to continue");
        System.out.println();
        System.out.println();
        input.nextLine();
        AdminSettings();
    }

    static void getPassword() throws InterruptedException {
        int leftTimes = 3;
        do {
            reExecute = false;
            System.out.print("Password : ");
            password = input.nextLine();
            if (password.length() < 6) {
                if (--leftTimes > 0) {

                    reExecute = true;
                    System.out.println();
                    displayError("Remaining attempts: ");
                    System.out.println(leftTimes + ". ");
                    System.out.println("Password must be at least 6 characters");
                    System.out.println();
                } else ifLeftTimes_0(false);
                System.out.println();
            } else if (password.contains(" ")) {
                if (--leftTimes > 0) {
                    reExecute = true;
                    System.out.println();
                    displayError("Remaining attempts: ");
                    System.out.println(leftTimes + ". ");
                    System.out.println("Password can not have spaces");
                    System.out.println();
                } else ifLeftTimes_0(false);
            }
        } while (reExecute);
    }

    static void displayError(String errorMessage) {
        System.out.println();
        System.out.println();
        System.out.print("Invalid input, " + errorMessage);
    }

    static void getWH() throws InterruptedException {
        do {
            reExecute = false;
            System.out.print("Working Hours : ");
            try {
                AdminPage.WH = Double.parseDouble(input.nextLine());
                if (AdminPage.WH <= 0) {
                    if (--AdminPage.leftTimes > 0) {
                        reExecute = true;
                        displayError("Remaining attempts : ");
                        System.out.println(AdminPage.leftTimes + ". ");
                        System.out.print("Working Hours can't be less than zero, be reasonable");
                        System.out.println(" please, try again");
                        System.out.println();
                    } else ifLeftTimes_0(true);
                } else if (AdminPage.WH > 24) {
                    if (--AdminPage.leftTimes > 0) {
                        reExecute = true;
                        displayError("Remaining attempts : ");
                        System.out.println(AdminPage.leftTimes + ". ");
                        System.out.println("Working Hours can't be more than 1 Day please, try again");
                        System.out.println();
                    } else ifLeftTimes_0(true);
                }
            } catch (NumberFormatException | InterruptedException e) {
                if (--AdminPage.leftTimes > 0) {
                    displayError("Remaining attempts : ");
                    System.out.println(AdminPage.leftTimes + ". ");
                    System.out.println("Working Hours must be numbers please, try again");
                    System.out.println();
                    System.out.println();
                    reExecute = true;
                } else ifLeftTimes_0(true);
            }
        } while (reExecute);//WH

    }

    public static void ifLeftTimes_0(boolean afterLogin) throws InterruptedException {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("You have failed 3 times. Please try again");
        System.out.println();
        System.out.println();
        if (afterLogin) AdminSettings();
        else MainMenu();
    }


    static String looper(String str) throws InterruptedException {
        int leftTimes = 3;
        String var;
        do {
            System.out.print(str + " : ");
            var = input.nextLine();
            if (var.isEmpty()) {
                if (--leftTimes > 0) {
                    reExecute = true;
                    System.out.println();
                    System.out.println();
                    System.out.println("this field is required, please try again ");
                    System.out.println("Remaining attempts : " + leftTimes + ". ");
                    System.out.println();
                } else ifLeftTimes_0(true);
            }

        } while (reExecute);
        return var;
    }

    static void displayThisArray(Employee[] list) {
        for (int x = 0; x < list.length; x++) {
            System.out.print(x + 1 + " - ");
            System.out.print(list[x].getID() + " ");
            System.out.println(list[x].getName());
        }

    }

    static void semiAnimation() throws InterruptedException {
        System.out.print("Save");
        Thread.sleep(500);
        System.out.print(".");
        Thread.sleep(500);
        System.out.print(".");
        Thread.sleep(500);
        System.out.print(".");
        Thread.sleep(500);
        System.out.println("Saved successfully.");
    }

    static void displayTraineeInTable(Trainee Trainee) {
        System.out.print("    | " + Trainee.getID());
        System.out.print("  | " + Trainee.getName());
        System.out.print("    | " + Trainee.getUniversity());
        System.out.print("       | " + Trainee.getGPA());
        System.out.print("           | " + Trainee.getAcademicYear());
        System.out.println("                  | " + Trainee.getSalary() + "       |");
    }

    static void displayEngineerInTable(int x, Engineer engineer) {
        System.out.print(x + " - | " + engineer.getID());
        System.out.print("  | " + engineer.getName());
        System.out.print("    | " + engineer.getGrade());
        System.out.print("    | " + engineer.getWorkingHours());
        System.out.println("         | " + engineer.getSalary() + "       |");

    }

    static String capitalized(String str) throws InterruptedException {
        String[] words = str.split("\\s+");
        String Str = "";
        for (String word : words) {
            try {
                Str += word.substring(0, 1).toUpperCase();
                Str += word.substring(1).toLowerCase() + " ";
            } catch (StringIndexOutOfBoundsException e) {
                MainMenu();
            }
        }
        return Str.trim();
    }
}
