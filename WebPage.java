public class WebPage extends Document{
  private int visits = 1;
  public WebPage(int aSize, String aLanguage, String aAuthor, String aUri, int aVisit, double aRank){
    super(aSize, aLanguage, aAuthor, aUri, aRank);
    this.setSize(aSize);
    this.setLanguage(aLanguage);
    this.setAuthors(aAuthor);
    this.setUri(aUri);
    this.setVisits(aVisit);
    this.setRank(aRank);
  }
  public WebPage(WebPage toCopy){
    super();
    this.setSize(toCopy.getSize());
    this.setLanguage(toCopy.getLanguage());
    this.setAuthors(toCopy.getAuthors());
    this.setUri(toCopy.getUri());
    this.setVisits(toCopy.getVisits());
    this.setRank(toCopy.getRank());
  }
  public int getVisits(){
    return this.visits;
  }
  public double getRank(){
    if(this.visits == 100){
      return 0.99;
    }
    double newRank = 1 - (1/visits);
    return newRank;
  }
  public void setVisits(int aVisit){
    if(aVisit >= this.visits){
      if(aVisit >= 1){
        this.visits = aVisit;
      }
    }
  }

}
