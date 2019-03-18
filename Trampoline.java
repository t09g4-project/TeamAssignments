public class Trampoline extends  Bouncer{

    private int weightOfJumper;


    public Trampoline(int weightOfJumper, double height){
        super(height);
        setWeightOfJumper(weightOfJumper);
    }


    public Trampoline(Trampoline toCopy){
        super(toCopy);
        this.weightOfJumper = toCopy.getWeightOfJumper();
    }

    public void setWeightOfJumper(int weightOfJumper) {
        if(weightOfJumper >= 50 && weightOfJumper <= 300){
            this.weightOfJumper = weightOfJumper;
        }
        else{
            this.weightOfJumper = 140;
        }
    }

    public int getWeightOfJumper(){
        return this.weightOfJumper;
    }

    @Override
    public double heightAfterBounces(int numOfBounces) {
        double bouncePercentage = ((this.weightOfJumper + this.getHeight()) / (3.5 * this.getHeight()) / 100);


        double newHeight1 = this.getHeight();

        if(newHeight1 <= 1){
            newHeight1 = 0;
            return newHeight1;
        }

        for(int i = 0; i < numOfBounces; i++) {
            newHeight1 = newHeight1 * bouncePercentage;
        }
        return newHeight1;

    }

    @Override
    public String toString() {
        return "[Trampoline] " + super.toString();
    }
}
