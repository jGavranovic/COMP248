//----------------------------------------------------------------------
// Assignment 4
// Written by: Jovan Gavranovic 40282175 12/1/2023
// For COMP 248 H 2232
//----------------------------------------------------------------------
//This class is responsible for everything to do with the pre paid cards
public class PrePaiCard {
    private String type;
    private int id,day,month;
    //Default constructor
    public PrePaiCard(){
    }
    //4 parameter cosntructor
    public PrePaiCard(String typeIn, int idIn, int dayIn, int monthIn){
        type = typeIn;
        id = idIn;
        day = (1<=dayIn&&dayIn<=31?dayIn:0);
        month = (1<=monthIn&&monthIn<=12?monthIn:0);
    }
    //Copy constructor
    public PrePaiCard(PrePaiCard copy){
        type = copy.type;
        id = copy.id;
        day = copy.day;
        month = copy.month;
    }

    //Accessor methods
    public String getType(){return type;}
    public int getId(){return id;}
    public int getDay(){return day;}
    public int getmonth(){return month;}

    //Mutator methods
    public void setDay(int dayIn){day=(1<=dayIn&&dayIn<=31?dayIn:0);}
    public void setMonth(int monthIn){month = (1<=monthIn&&monthIn<=12?monthIn:0);}
    //Custom toString method
    public String toString(){
        return (type+" - "+id+" - "+String.format("%02d", day)+"/"+String.format("%02d",month));
    }
    //Custom equals method
    public boolean equals(PrePaiCard card){
        return(type.equals(card.type)&&(id==card.id)&&(day==card.day)&&(month==card.month));
    }
}
