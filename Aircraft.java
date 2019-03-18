public abstract class Aircraft{
  private String name;
  private String origin;
  private int speed;

  public Aircraft(String aName,String aOrigin,int aSpeed){
    this.setName(aName);
    this.setOrigin(aOrigin);
    this.setSpeed(aSpeed);


  }

  public Aircraft(Aircraft toCopy){
    this.setName(toCopy.getName());
    this.setOrigin(toCopy.getOrigin());
    this.setSpeed(toCopy.getSpeed());

  }

  public String getName(){
    return this.name.toLowerCase();

  }

  public void setName(String aName){
    this.name = aName;

  }

  public String getOrigin(){
    return this.origin.toUpperCase();

  }

  public void setOrigin(String aOrigin){
    this.origin = aOrigin;

  }

  public int getSpeed(){
    return this.speed;

  }

  public void setSpeed(int aSpeed){
    if(aSpeed >= 0){
      this.speed = aSpeed;
    }


  }

  protected abstract String getCategory();

  public String getAircraftCategoryBySpeed(){
    if (getSpeed() <= 550){
      return getCategory() + " " + "with A";
    }
    else if (getSpeed() <= 751 && getSpeed() >= 551){
      return getCategory() + " " + "with B";
    }
    else{
      return getCategory() + " " + "with C";
    }




  }

  public String toString(){
    return "Name: " + this.getName() + " Category: " + this.getAircraftCategoryBySpeed();


  }
}
