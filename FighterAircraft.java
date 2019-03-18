public class FighterAircraft extends Aircraft{
  private char bvrTechnology;

  public FighterAircraft(String aName,String aOrigin,int aSpeed,char aBvrTechnology){
    super(aName,aOrigin,aSpeed);
    this.setBVRTechnology(aBvrTechnology);

  }

  public FighterAircraft(FighterAircraft toCopy){
    super(toCopy);
    this.setBVRTechnology(toCopy.getBVRTechnology());

  }

  public char getBVRTechnology(){
    return this.bvrTechnology;

  }

  public void setBVRTechnology(char aBvrTechnology){
    if(aBvrTechnology == getBVRTechnology()){
      this.bvrTechnology = 'Y';
      this.bvrTechnology = aBvrTechnology;
    }
    else{
      this.bvrTechnology = 'N';
      this.bvrTechnology = aBvrTechnology;
    }

  }


  public String getCategory(){
    if (getBVRTechnology() == 'Y'){
      return "EXCELLENT";
    }
    else{
      return "NORMAL";
    }
  }
}
