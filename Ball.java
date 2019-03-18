public class Ball extends Bouncer{

    private int bounciness;

    public Ball(int bounciness, double height){
        super(height);
        setBounciness(bounciness);
    }

    public Ball(Ball toCopy){
        super(toCopy.getHeight());
        this.bounciness = toCopy.bounciness;
    }

    public void setBounciness(int bounciness){
        if(bounciness < 100 && bounciness > 0){
            this.bounciness = bounciness;
        }
        else{
            this.bounciness = 50;
        }
    }

    public int getBounciness(){
        return this.bounciness;
    }

    @Override
    public double heightAfterBounces(int numOfBounces) {
        double bouncinessPercent = (double)bounciness/100.0;

        double newHeight1 = this.getHeight();

        if(newHeight1 <= 1){
            newHeight1 = 0;
            return newHeight1;
        }

        for(int i = 0; i < numOfBounces; i++) {
            newHeight1 = newHeight1 * bouncinessPercent;
        }
        return newHeight1;
    }

    @Override
    public String toString() {
        return "[Ball] " + super.toString() + " Bounciness: " + getBounciness() + "%";
    }
}
