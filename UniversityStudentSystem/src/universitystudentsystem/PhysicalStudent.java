
package universitystudentsystem;

class PhysicalStudent extends UndergraduateStudent{
    private SubCombination combination;

    public PhysicalStudent(String firstName, String lastName, String indexNo, double zScore, SubCombination combination) {
        super(firstName, lastName, indexNo, zScore);
        setCombination(combination);
    }

    public SubCombination getCombination() {
        return combination;
    }

    public void setCombination(SubCombination combination) {
        this.combination = combination;
    }
    
    @Override
    public void evaluateGrade()
    {
        double gpa = this.getGpa();
        
        if( gpa>=3.5 && gpa<=4.5 )
        {
            this.setGrade("1st class");
        }
        else if( gpa>=3.0 && gpa<3.5 )
        {
            this.setGrade("2nd upper");
        }
         else if( gpa>=2.5 && gpa<3.0 )
        {
            this.setGrade("2nd lower");
        }
         else if( gpa>=2.0 && gpa<2.5 )
        {
            this.setGrade("pass");
        }
         else if( gpa>=0 && gpa<2.0 )
        {
            this.setGrade("fail");
        }
        else
         {
             this.setGrade( "invalid gpa!");
         }
           
    }
    
}
