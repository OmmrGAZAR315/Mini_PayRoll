package Main;

import Classes.Engineer;
import Classes.Trainee;

import java.util.ArrayList;


public interface StaticData {
  public static ArrayList<Engineer> EngineersInfo() {
        ArrayList<Engineer> engineerList = new ArrayList<>();
        String uniqueID = String.valueOf((int) (Math.random() * (254645467 - 655464654 + 1) + 655464654));
        engineerList.add(new Engineer(uniqueID, "Nouran", 21, "Manger", 24));
        engineerList.add(new Engineer(uniqueID, "Youssef", 22, "Team Leader", 20));
        engineerList.add(new Engineer(uniqueID, "Abanoub", 23, "Team Member", 21));
        engineerList.add(new Engineer(uniqueID, "Farouk", 24, "Manger", 16));
        engineerList.add(new Engineer(uniqueID, "Magdy", 34, "Team Member", 19));
        engineerList.add(new Engineer(uniqueID, "Yousra", 53, "Team Leader", 15));
        return engineerList;
    }
    static ArrayList<Trainee> TrainsInfo() {
        ArrayList<Trainee> traineeList = new ArrayList<>();
        String uniqueID = String.valueOf((int) (Math.random() * (254645467 - 655464654 + 1) + 655464654));
        traineeList.add(new Trainee(uniqueID, "Nouran", 33, 700, "sadat",2,2));
        traineeList.add(new Trainee(uniqueID, "Youssef", 33, 700, "3in",1,1));
        traineeList.add(new Trainee(uniqueID, "Abanoub", 33, 700, "shames",3,4));
        traineeList.add(new Trainee(uniqueID, "Farouk", 33, 700, "helwan",4,3));
        traineeList.add(new Trainee(uniqueID, "Magdy", 33, 700, "cairo",3.5,2));
        traineeList.add(new Trainee(uniqueID, "Yousra", 33, 700, "nooba",3.8,1));
        return traineeList;
    }
}
