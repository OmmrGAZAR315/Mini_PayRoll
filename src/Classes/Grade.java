package Classes;

public class Grade {
    String position;

    double TAX;

    double PR;


    public Grade(String position) {
        this.position = position;
        setTAX();
        setPR();
    }

    public void setPR() {
        switch (position) {
            case "Manger" -> PR = 35;
            case "Team Leader" -> PR = 25;
            case "Team Member" -> PR = 15;
        }
    }

    public void setTAX() {
        switch (position) {
            case "Manger" -> TAX = 0.75;
            case "Team Leader" -> TAX = 0.8;
            case "Team Member" -> TAX = 0.9;
        }
    }
}
