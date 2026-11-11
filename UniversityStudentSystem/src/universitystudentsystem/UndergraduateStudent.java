
package universitystudentsystem;

abstract class UndergraduateStudent extends UniversityStudent{
    private double zScore;

    public UndergraduateStudent(String firstName, String lastName, String indexNo, double zScore) {
        super(firstName, lastName, indexNo);
        setzScore(zScore);
    }

    public void setzScore(double zScore) {
        this.zScore = zScore;
    }

    public double getzScore() {
        return zScore;
    }
    
    
}
