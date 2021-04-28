public class Product1 {

    private String name1;
    private String number1;
    private String score;
    private String boundaries;
    private String balls;
    private String venue;

    public Product1(String name1, String number1, String score, String boundaries, String balls, String venue) {
        this.name1 = name1;
        this.number1 = number1;
        this.score = score;
        this.boundaries = boundaries;
        this.balls = balls;
        this.venue = venue;
    }

    public Product1(){

        this.name1 = "";
        this.number1 = "";
        this.score = "";
        this.boundaries = "";
        this.balls = "";
        this.venue = "";

    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getNumber1() {
        return number1;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getBoundaries() {
        return boundaries;
    }

    public void setBoundaries(String boundaries) {
        this.boundaries = boundaries;
    }

    public String getBalls() {
        return balls;
    }

    public void setBalls(String balls) {
        this.balls = balls;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
}