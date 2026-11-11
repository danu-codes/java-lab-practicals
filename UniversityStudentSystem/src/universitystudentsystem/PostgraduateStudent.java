
package universitystudentsystem;

public class PostgraduateStudent extends UniversityStudent{
    private String supervisor;
    private PostCategory category;
    private double researchGrade;
    private double entranceMarks;

    public PostgraduateStudent(String firstName, String lastName, String indexNo, String supervisor, double entranceMarks, PostCategory category) {
        super(firstName, lastName, indexNo);
        setSupervisor(supervisor);
        setCategory(category);
        setEntranceMarks(entranceMarks);
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public PostCategory getCategory() {
        return category;
    }

    public void setCategory(PostCategory category) {
        this.category = category;
    }

    public double getResearchGrade() {
        return researchGrade;
    }

    public void setResearchGrade(double researchGrade) {
        this.researchGrade = researchGrade;
    }

    public double getEntranceMarks() {
        return entranceMarks;
    }

    public void setEntranceMarks(double entranceMarks) {
        this.entranceMarks = entranceMarks;
    }
    
    @Override
    public void evaluateGrade()
    {
        double gpa = this.getGpa();
        
        if( gpa>=3.5 && gpa<=4.5 )
        {
            if( researchGrade>=3.5 && researchGrade<=4.5 )
                this.setGrade("1st class");
            else if (researchGrade>=2 && researchGrade<3.5)
                this.setGrade("2nd upper");
            else
                this.setGrade("2nd lower");
        }
        else if( gpa>=3.0 && gpa<3.5 )
        {
            if( researchGrade>=3.5 && researchGrade<=4.5 )
                this.setGrade("2nd upper");
            else 
                this.setGrade("2nd lower");
        }
        else if ( gpa>=2.5 && gpa<3.0 )
        {
            this.setGrade("2nd lower");
        }
        else if ( gpa>=2.0 && gpa<2.5 )
        {
            this.setGrade("pass");
        }
        else
        {
            this.setGrade("fail");
        }
    }
    
}
