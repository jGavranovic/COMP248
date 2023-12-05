//----------------------------------------------------------------------
// Assignment 4
// Written by: Jovan Gavranovic 40282175 12/1/2023
// For COMP 248 H 2232
//----------------------------------------------------------------------
//This class is responsible for handling everything to do with sales (money and categories)
public class Sales {
    //Create the variables for each category
    private int juniorNum,teenNum,mediumNum,bigNum,familyNum;
    //Create final constants for the price of each meal
    private final int juniorPrice = 5,teenPrice = 10,mediumPrice = 12,bigPrice = 15,familyPrice = 20;

    //Default constructor
    public Sales(){

    }
    //Constructor with 5 parameters
    public Sales(int junior, int teen,int medium,int big, int family){
        juniorNum = junior;
        teenNum = teen;
        mediumNum = medium;
        bigNum = big;
        familyNum = family;
    }
    //Copy constructor
    public Sales(Sales copy){
       juniorNum = copy.juniorNum;
       teenNum = copy.teenNum;
       mediumNum = copy.mediumNum;
       bigNum = copy.bigNum;
       familyNum = copy.familyNum;
    }
    // Accessor methods for all attributes
    public int getJunior() {return juniorNum;}
    public int getTeen() {return teenNum;}
    public int getMedium() {return mediumNum;}
    public int getBig() {return bigNum;}
    public int getFamily() {return familyNum;}
    public int getJuniorPrice() {return juniorPrice;}
    public int getTeenPrice() {return teenPrice;}
    public int getMediumPrice() {return mediumPrice;}
    public int getBigPrice() {return bigPrice;}
    public int getFamilyPrice() {return familyPrice;}
   
    //Mutator methods for all attributes
    public void setJunior(int junior) {juniorNum=junior;}
    public void setTeen(int teen) {teenNum=teen;}
    public void setMedium(int medium) {mediumNum=medium;}
    public void setBig(int big) {bigNum=big;}
    public void setFamily(int family) {familyNum=family;}

    //addSales method
    public void addSales(int junior, int teen,int medium,int big, int family){
        juniorNum+=junior;
        teenNum+=teen;
        mediumNum+=medium;
        bigNum+=big;
        familyNum+=family;
    }
    //SalesTotal method
    public int salesTotal(){
        return(juniorNum*juniorPrice+teenNum*teenPrice+mediumNum*mediumPrice+bigNum*bigPrice+familyNum*familyPrice);
    }
    //Custom toString method
    public String toString(){
        return(juniorNum+" x $"+juniorPrice+" + "+teenNum+" x $"+teenPrice+" + "+mediumNum+" x $"+mediumPrice+" + "+bigNum+" x $"+bigPrice+" + "+familyNum+" x $"+familyPrice);
    }
    //Custom equals method
    public boolean equals(Sales sales1){
        return((juniorNum==sales1.juniorNum)&&(teenNum==sales1.teenNum)&&(mediumNum==sales1.mediumNum)&&(bigNum==sales1.bigNum)&&(familyNum==sales1.familyNum));
    }
}
