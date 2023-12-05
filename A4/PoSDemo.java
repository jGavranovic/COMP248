import java.util.Scanner;
//----------------------------------------------------------------------
// Assignment 4
// Written by: Jovan Gavranovic 40282175 12/1/2023
// For COMP 248 H 2232
//----------------------------------------------------------------------
//This program simulates a point of sales (PoS) control application
public class PoSDemo {
/*Algorithm of Driver
1. Hardcode demo PoSs with the initial conditions
2. Display welcome message
3. Create static method to display the menu
4. Create static methods for each of the different menu options
5. Create a switch statement inside a loop which checks the users input and executes the appropriate method
6. If user enters 0, exit the loop, display goodbye message and exit the program

*/
    //Hardcode initial PoS
    private static PoS[] poss = {new PoS(new Sales(2,1,0,4,1),new PrePaiCard[] {new PrePaiCard("Vegetarian",40825164,25,12),new PrePaiCard("Carnivore",21703195,3,12)}),
        new PoS(new Sales(2,1,0,4,1),new PrePaiCard[] {new PrePaiCard("Vigan",40825164,7,12), new PrePaiCard("Vegetarian",21596387,24,8)}),
        new PoS(new Sales(0,1,5,2,0),new PrePaiCard[] {new PrePaiCard("Pescatarian",95432806,1,6),new PrePaiCard("Halal",42087913,18,12),new PrePaiCard("Kosher",40735421,5,4)}),
        new PoS(new Sales(3,2,4,1,2),new PrePaiCard[] {}),
        new PoS(new Sales(3,2,4,1,2),new PrePaiCard[] {})};
    //For empty PoS
    //private static PoS[] poss = new PoS[0];
    //Create new scanner to read user input
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        //Welcome message
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("|   Welcome to Concordia CostLessBites Catering Sales Counter Application       |");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        //Main loop, always will be true
        while (true){
            //Print menu using static method
            printMenu();
            //Read user input and execute appropriate method
            int choice = input.nextInt();
            switch (choice){
                case 1: printPoSs();break;
                case 2: printOnePoS();break;
                case 3: possMoneyEquals();break;
                case 4: possCatEquals();break;
                case 5: possCatMonEquals();break;
                case 6: addCard();break;
                case 7: removeCard(); break;
                case 8: updateCard(); break;
                case 9: addSales(); break;
                //If user enters 0, display goodbye message and close program
                case 0: 
                    System.out.println("Thank you for using Concordia CostLessBites Catering Sales Counter Application!");
                    System.exit(0);
                // If user did not enter valid choice, tell them and display the options again for them to choose
                default: 
                    System.out.println("Sorry that is not a valid choice. Try again.");
            }
        }
    }
    //Print menu, might not be alligned for all, depends on font and other things
    private static void printMenu(){
        System.out.println("|  What would you like to do?                                                   |");
        System.out.println("| 1   >>  See the content of all PoSs                                           |");
        System.out.println("| 2   >>  See the content of one PoS                                            |");
        System.out.println("| 3   >>  List PoSs with same $ amount of sales                                 |");
        System.out.println("| 4   >>  List PoSs with same number of Sales categories                        |");
        System.out.println("| 5   >>  List PoSs with same $ amount of Sales and same number of prepaid cards|");
        System.out.println("| 6   >>  Add a PrePaiCard to an existing PoS                                   |");
        System.out.println("| 7   >>  Remove an existing prepaid card from a PoS                            |");
        System.out.println("| 8   >>  Update the expiry date of an existing Prepaid card                    |");
        System.out.println("| 9   >>  Add Sales to a PoS                                                    |");
        System.out.println("| 0   >>  To quit                                                               |");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        System.out.print("Please enter your choice and press <Enter>: ");
    }
//Method to print every PoS nicely
    private static void printPoSs(){
            String temp = "Content of each PoS:\n----------------------\n";
    //Loop through and print every PoS using a predefined custom toString() method
            for (int i=0;i<poss.length;i++){
                temp += "PoS #"+i+":\n"+poss[i].toString();
            }

            System.out.println(temp);
        }
    //Ask user which specific PoS they want to print then print it.
    private static void printOnePoS(){
        if (poss.length == 0)
            System.out.println("There are no PoSs");
        else {System.out.print("Which PoS do you want to see the content of? (Enter number 0 to "+(poss.length-1)+")");
        int num = input.nextInt();
        while (!(0<=num&&num<=poss.length-1)) {
            System.out.println("Sorry but there is no "+"PoS"+" number "+num);
            System.out.print(" --> Try again: (Enter number "+0+" to "+(poss.length-1)+"):");
            num = input.nextInt();
        }
        System.out.println(poss[num].toString());}
    }
    //Method to display which PoS have same sale total amount
    private static void possMoneyEquals(){
        String temp ="List of PoSs with same total $ Sales:\n\n";
        //Check if money is equals using nested loop swhich wont overlap and  repeat one
        for (int i=0;i<poss.length-1;i++){
            for (int j=i+1;j<poss.length;j++){
                if (poss[i].moneyEquals(poss[j]))
                    temp+= "\tPoSs "+i+" and "+j+" both have "+ poss[i].getSalesTotal()+"\n";
            }
        }
        //Print result
        System.out.println(temp);
    }
//Method to display which PoS have the same vategory breakdown
    private static void possCatEquals(){
        String temp = "List of PoSs with same Sales categories:\n\n";
        //Check if categories are equal using predefined equals method and nested for loops which wont repeat same answer
        for (int i=0;i<poss.length-1;i++){
            for (int j=i+1;j<poss.length;j++){
                if (poss[i].categoryEquals(poss[j]))
                    temp+="\tPoSs "+i+" and "+j+" both have "+poss[i].salesString()+"\n";
            }
        }
        System.out.println(temp);
    }
//Method to show which PoS have the same sales total and category breakdown
    private static void possCatMonEquals(){
        String temp = "List of PoSs with same $ amount of sales and same number of PrePaiCards :\n\n";
        //Check if categories  and money are equal using predefined equals method and nested for loops which wont repeat same answer
        for (int i=0;i<poss.length-1;i++){
            for (int j=i+1;j<poss.length;j++){
                if (poss[i].equals(poss[j]))
                    temp+="\tPoSs "+i+" and "+j+"\n";
            }
        }
        System.out.println(temp);
    }
//Method to get user to add card to a PoS
    private static void addCard(){
        //In case of empty PoS to avoid errors
        if (poss.length==0)
            System.out.println("There are no PoSs");
        else {
        //Ask user which PoS they want to add a card to
        System.out.print("Which PoS to you want to add an PrePaiCard to? (Enter number 0 to "+(poss.length-1)+"): ");
        int num = input.nextInt();
        //Check validity of input
        while (!(0<=num&&num<=poss.length-1)) {
            System.out.println("Sorry but there is no "+"PoS"+" number "+num);
            System.out.print(" --> Try again: (Enter number "+0+" to "+(poss.length-1)+"):");
            num = input.nextInt();
        }
        System.out.println("Please enter the following information so that we may complete the PrePaiCard-\n"+
        " --> Type of PrePaiCard (Carnivore, Halal, Kosher, Pescatarian, Vegetarian, Vigan):");
        String type=input.next();
        System.out.print(" --> Id of the prepaid card owner: ");
        int id = input.nextInt();
        System.out.print("Expiry day number and month (seperate by a space): ");
        int day = input.nextInt(), month = input.nextInt();
        //Add a card to the desired PoS with the given type id day and month
        poss[num].addCard(new PrePaiCard(type,id,day,month));

        System.out.println("You now have "+poss[num].prePaidCardCount()+" PrePaiCard");}

    }
    //Method to remove card with the help of user input
    private static void removeCard(){
        if (poss.length==0)
            System.out.println("There are no PoSs");
        else {
        System.out.print("Which PoS to you want to remove an PrePaiCard to? (Enter number 0 to "+(poss.length-1)+"): ");
        int num = input.nextInt();
        //Check input validity
        while (!(0<=num&&num<=poss.length-1)) {
            System.out.println("Sorry but there is no "+"PoS"+" number "+num);
            System.out.print(" --> Try again: (Enter number "+0+" to "+(poss.length-1)+"):");
            num = input.nextInt();
        }
        if (poss[num].prePaidCardCount()==0)
            System.out.println("Sorry that PoS has no PrePaiCards");
        else {
            System.out.println("(Enter number 0 to "+(poss[num].prePaidCardCount()-1)+"):");
            int cardNb = input.nextInt();
            while (!(0<=cardNb&&cardNb<=poss[num].prePaidCardCount()-1)) {
            System.out.println("Sorry but there is no "+"PrePaiCard"+" number "+cardNb);
            System.out.print(" --> Try again: (Enter number "+0+" to "+(poss[num].prePaidCardCount()-1)+"):");
            cardNb = input.nextInt();
        }
            //Remove desired card from desired PoS
            poss[num].removeCard(cardNb);
            System.out.println("PrePaiCard was removed succesfully");
        }}
    }
//Method to update the expiry date of a given card
    private static void updateCard(){
        if (poss.length==0)
            System.out.println("There are no PoSs");
        else {
        //Ask user which PoS they want to update
        System.out.print("Which PoS do you want to update an PrePaiCard from? (Enter number from 0 to "+(poss.length-1)+")");
        int num = input.nextInt();
        while (!(0<=num&&num<=poss.length-1)) {
            System.out.println("Sorry but there is no "+"PoS"+" number "+num);
            System.out.print(" --> Try again: (Enter number "+0+" to "+(poss.length-1)+"):");
            num = input.nextInt();
        }
        System.out.println("Which PrePaiCard do you want to update? (Enter number 0 to "+(poss[num].prePaidCardCount()-1)+"):");
        int cardNb = input.nextInt();
        while (!(0<=cardNb&&cardNb<=(poss[num].prePaidCardCount()-1))) {
            System.out.println("Sorry but there is no PrePaidCard number "+cardNb);
            System.out.print(" --> Try again: (Enter number 0 to "+(poss[num].prePaidCardCount()-1)+"):");
            cardNb = input.nextInt();
        }
        System.out.print(" --> Enter new expiry date and day number and month (seperate by a space): ");
        int day = input.nextInt();
        int month = input.nextInt();
        //Update the desired expiry date
        poss[num].updateCard(cardNb, day, month);
        System.out.println("Expiry Date updated.");
        }
    }
//Method to add sales to a PoS
    private static void addSales(){
        if (poss.length==0)
            System.out.println("There are no PoSs");
        else {
        System.out.print("Which PoS do you want to add Sales to? (Enter number from 0 to "+(poss.length-1)+")");
        int num = input.nextInt();
        while (!(0<=num&&num<=poss.length-1)) {
            System.out.println("Sorry but there is no "+"PoS"+" number "+num);
            System.out.print(" --> Try again: (Enter number "+0+" to "+(poss.length-1)+"):");
            num = input.nextInt();
        }
        System.out.println("How many junior, teen, medium, big, and family meal menu do you want to add?");
        System.out.print("Enter 5 numbers seperated by a space): ");
        int jrNum = input.nextInt(),teenNum=input.nextInt(),medNum=input.nextInt(),bigNum=input.nextInt(),famNum=input.nextInt();
        //Print new money ammount while simultaneously updating each category
        System.out.printf("You now have $%.1f%n%n", (float)poss[num].plusSales(jrNum,teenNum,medNum,bigNum,famNum));
        }
    }

}
