public class Trampoline extends Bouncer{
    private int weightOfJumper;
    public Trampoline(int weightOfJumper, double bounciness, double height){
        super(bounciness,(int)(height));
        this.setWeightOfJumper(weightOfJumper);
        this.setBounciness(bounciness);
        this.setHeight((int)(height));
    }
    public Trampoline(Trampoline toCopy){
        super(toCopy);
        this.setWeightOfJumper(toCopy.getWeightOfJumper());
        this.setBounciness(toCopy.getBounciness());
        this.setHeight(toCopy.getHeight());
    }
    public void setWeightOfJumper(int weight){
        if(weight>= 50&& weight <= 300){
            this.weightOfJumper = weight;
        }
        else{
            this.weightOfJumper = 140;
        }
    }
    public int getWeightOfJumper(){
        return this.weightOfJumper;
    }
    public double getBounciness(){
        if(this.getWeightOfJumper() < 100){
            double x = super.getBounciness() * 0.75;
            if(x < 1){
                return x;
            }
            else{
                return 0.99;
            }
        }
        else if(this.getWeightOfJumper() > 150 && this.getWeightOfJumper() <= 200){
            double x = super.getBounciness() * 1.10;
            if(x < 1){
                return x;
            }
            else{
                return 0.99;
            }
        }
        else if (this.getWeightOfJumper() > 200){
            double x = super.getBounciness() * 1.2;
            if(x < 1){
                return x;
            }
            else{
                return 0.99;
            }
        }
        else{
            return super.getBounciness();
        }
    }
}