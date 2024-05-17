public class RouletteSpace {
  private int number;
  private String color;
  
  /**
   * A simple wrapper class for an int and String
   */
  public RouletteSpace(int number, String color){
    this.number = number;
    this.color = color;
  }

  public int getNumber(){
    return number;
  }

  public String getColor(){
    return color;
  }
}