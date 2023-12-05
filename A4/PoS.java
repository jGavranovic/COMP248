//----------------------------------------------------------------------
// Assignment 4
// Written by: Jovan Gavranovic 40282175 12/1/2023
// For COMP 248 H 2232
//----------------------------------------------------------------------
//This class combines the the Sales and PrePaiCards classes and interfaces with the driver method.
public class PoS {
  private Sales sales = new Sales();
  private PrePaiCard[] cards = new PrePaiCard[0];
//Default constructor
  public PoS(){
  }

//Two parameter constructor
  public PoS(Sales saleIn, PrePaiCard[] cardIn){
    sales = saleIn;
    cards = cardIn;
  }
  //Method to check if money equal in two PoS
  public boolean moneyEquals(PoS pos){
    if (sales.salesTotal()==pos.sales.salesTotal()) return true;
    return false; 
  }
//Method to check if two PoS have same category breakdown
  public boolean categoryEquals(PoS pos){
    if (sales.equals(pos.sales))return true;
    return false;
  }
//Method to return the sales total $ of a PoS
  public int getSalesTotal(){
    return sales.salesTotal();
  }
//Method to return the number of PrePaiCards at a given PoS
  public int prePaidCardCount(){
    return cards.length;
  }
//Method to add prepaicard to a PoS
  public void addCard(PrePaiCard cardIn){
    //Create temporary array
    PrePaiCard[] temp = cards;
    cards = new PrePaiCard[cards.length+1];
    //Set each index to be equal the original value
    for (int i=0;i<temp.length;i++ ){
        cards[i]=temp[i];
    }
    //Add the new card
    cards[cards.length-1]=cardIn;
  }
  //Method to remove a prepaid card
  public void removeCard(int num){
    PrePaiCard[] temp = cards;
    cards = new PrePaiCard[cards.length-1];
    for (int i=0;i<num;i++){
        cards[i]=temp[i];
    }
    //Skips the card which is to be removed
    for(int i=num;i<cards.length;i++){
        cards[i]=temp[i+1];
    }
  }
//Method to update a card in the PoS
  public void updateCard(int cardNum, int dayIn, int monthIn){
    cards[cardNum].setDay(dayIn);
    cards[cardNum].setMonth(monthIn);
  }
//Method to add sales to a PoS and return the sales total
  public int plusSales(int jr, int teen, int med, int big, int fam){
    sales.addSales(jr, teen, med, big, fam);
    return sales.salesTotal();
  }
//Custom equals method which return true when sales amount and categories are equal
  public boolean equals(PoS pos){
    return (moneyEquals(pos)&&cards.length==pos.cards.length);
  }
//Custom toString method which prints  all prepaid cards in the PoS nicely formatted
  public String toString(){
    String cardsPrint = "";
    //In case no prepaicards
    if (cards.length==0) 
      cardsPrint= "No PrePaiCards\n";
    
    for (int i=0;i<cards.length;i++){
        cardsPrint += (cards[i].toString()+"\n");
    }
    return (sales.toString()+"\n"+cardsPrint+"\n");
    
  }
//Return formatted string of sales distribution.
  public String salesString(){
    return sales.toString();
  }

}
