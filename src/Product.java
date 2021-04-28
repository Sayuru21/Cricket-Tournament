public class Product {

    private String name;
    private String number;
    private String team;
    private String playerAge;
    private String playerRole;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPlayerAge() {
        return playerAge;
    }

    public void setPlayerAge(String playerAge) {
        this.playerAge = playerAge;
    }

    public String getPlayerRole() {
        return playerRole;
    }

    public void setPlayerRole(String playerRole) {
        this.playerRole = playerRole;
    }



    public Product(){
        this.name = "";
        this.number = "";
        this.team = "";
        this.playerAge = "";
        this.playerRole = "";
    }

    public Product(String name, String number, String team, String playerAge, String playerRole) {
        this.name = name;
        this.number = number;
        this.team = team;
        this.playerAge = playerAge;
        this.playerRole = playerRole;
    }
}