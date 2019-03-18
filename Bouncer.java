public abstract class Bouncer {

    private double height;


    public Bouncer(double height) {
        setHeight(height);
    }

    public Bouncer(Bouncer toCopy){
        this.height = toCopy.height;
    }

    protected void setHeight(double height){
        if(height > 0.0){
            this.height = height;
        } else if(height <= 0){
            this.height = 1.0;
        }
    }



    protected double getHeight(){
        return this.height;
    }


    public void bounce(){
        this.height = heightAfterBounces(1);
    }

    public int numberOfBounces() {
        double newHeight = this.height;

        //if height is less than one, it should return 0 as no bounce
        if(newHeight < 1){
            return 0;
        }

        int i = 1;

        while(newHeight >= 1){
            newHeight = heightAfterBounces(i);
            if(newHeight < 1){
                return i;
            }
            i++;
        }

        return i;
    }


    public abstract double heightAfterBounces(int numOfBounces);


    public String toString(){
        return "Height: " + getHeight() + " Number of bounces: " + numberOfBounces();
    }
}
