public class Bouncer{
    private int height;
    private double bounciness;
    public Bouncer(double bounciness,int height){
        setBounciness(bounciness);
        setHeight(height);
    }
    public Bouncer(Bouncer toCopy){
        this.bounciness = toCopy.bounciness;
        this.height = toCopy.height;
    }
    public void setHeight(int height){
        if(height<=0){
            this.height = 1;
        }
        else{
            this.height = height;
        }
    }
    public int getHeight(){
        return this.height;
    }
    public void setBounciness(double bounciness){
        if(bounciness >= 1 || bounciness <= 0){
            this.bounciness = 0.5;
        }
        
        else{
            this.bounciness = bounciness;
        }
    }
    public double getBounciness(){
        return this.bounciness;
    }
    public int bounce(){
        this.height = (int)(this.getHeight() * this.getBounciness());
        return this.height;
    }
    public int numberOfBounces(){
        int numberOfBounces = 0;
        int temHeight = this.getHeight();
        while(temHeight > 0){
            temHeight = (int)(temHeight * this.getBounciness());
            numberOfBounces ++;
        }
        return numberOfBounces;
    }
    public boolean equals(Bouncer other){
        if ((other.getHeight()==this.height)&& (other.getBounciness()==this.bounciness)){
            return true;
        }
        else{
            return false;
        }
    }
}