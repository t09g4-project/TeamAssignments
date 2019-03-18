public class BomberAircraft extends Aircraft{
  private int payload;

  public BomberAircraft(String aName,String aOrigin,int aSpeed,int aPayload){
    super(aName,aOrigin,aSpeed);
    this.setPayload(aPayload);

  }

  public BomberAircraft(BomberAircraft toCopy){
    super(toCopy);
    this.setPayload(toCopy.getPayload());

  }

  public int getPayload(){
    return this.payload;

  }

  public void setPayload(int aPayload){
    this.payload = aPayload;

  }

  public String getCategory(){
    if (getPayload() <= 1){
      return "LIGHTER";
    }
    else if (getPayload() <= 2 && getPayload() > 1){
      return "MEDIUM";
    }
    else{
      return "HEAVIER";
    }

  }
}
