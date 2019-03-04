public class Document{
  private int size = 0;
  private String language = "English";
  private String authors = "";
  private String uri = "";
  private double rank;

  public Document(){
  }

  public Document(int aSize,String aAuthor,String aUri){
    this.setSize(aSize);
    this.setAuthors(aAuthor);
    this.setUri(aUri);
  }
  public Document(int aSize,String aLanguage, String aAuthor, String aUri, double aRank){
    this.setSize(aSize);
    this.setLanguage(aLanguage);
    this.setAuthors(aAuthor);
    this.setUri(aUri);
    this.setRank(aRank);
  }
  public int getSize(){
    return this.size;
  }
  public String getLanguage(){
    return this.language;
  }
  public String getAuthors(){
    return this.authors;
  }
  public String getUri(){
    return this.uri;
  }
  public double getRank(){
    return this.rank;
  }
  public void setSize(int aSize){
    if(aSize >= 0 ){
      this.size = aSize;
    }
  }
  public void setLanguage(String aLanguage){
    this.language = aLanguage;
  }
  public void setAuthors(String aAuthor){
    this.authors = aAuthor;
  }
  public void setUri(String aUri){
    this.uri = aUri;
  }
  public void setRank(double aRank){
    if(aRank >=0 && aRank <=1){
      this.rank = aRank;
    }
    else if(aRank > 1){
      this.rank = 1;
    }
  }
}
