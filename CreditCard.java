public class CreditCard extends Payment{
    private String cardName;
    private long cardNum;
    private String cardType;
    private int cvv;

    //constructor
    public CreditCard(){}

    //parameterized constructor
    public CreditCard(double serviceCharge, double amount, double totalIncludeSC, String cardName, long cardNum, String cardType, int cvv){
        super(serviceCharge, amount, totalIncludeSC);
        this.cardName = cardName;
        this.cardNum = cardNum;
        this.cardType = cardType;
        this.cvv = cvv;
    }

    //getter for card name
    public String getCardName() {
        return cardName;
    }

    //getter for card num
    public long getCardNum() {
        return cardNum;
    }

    //getter for cvv
    public int getCvv() {
        return cvv;
    }

    //setter for card name
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    //setter for card num
    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }

    //setter for card type
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    //setter fro cvv
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    //method for validate credit card num
    public boolean validateCardNum(){
        int sumA = 0, sumB = 0;
        long temp1 = cardNum;

        //check the length of card num is 16 if not error
        if(String.valueOf(cardNum).length() != 16){
            return false;
        }

        //check the first number is 4 or 5 if not error
        if((String.valueOf(cardNum).charAt(0) != '4') && (String.valueOf(cardNum).charAt(0) != '5')){
            return false;
        }

        //check credit card number is it all digit
        for(int i = 0; i < String.valueOf(cardNum).length(); i++){
            if(!(Character.isDigit(String.valueOf(cardNum).charAt(i)))){
                return false;
            }
        }

        //check credit card num using Luhn algorithm
        //get the digit in the place 2,4,6,8,10,12,14,16
        for (int i = 0; i < 8; i++){
            sumA += temp1 % 10;
            temp1 /= 100;
        }

        //get the digit in the place 1,3,5,7,9,11,13,15
        long temp2 = cardNum / 10;
        for(int i = 0; i < 8; i++){
            //double the digit
            long digit = (temp2 % 10) * 2;

            //if double digit greater than 10 minus it with 9
            if(digit > 9){
                sumB = sumB + ((int)digit - 9);
            }
            temp2 /= 100;
        }
        
        if((sumA + sumB) % 10 != 0){
            return false;
        }

        return true;
    }

    public void creditCardType(){
        //if first digit is 4 card type equal to Visa type
        if(String.valueOf(cardNum).charAt(0) == '4'){
            cardType = "Visa";
        }
        //if fist digit is 5 card type equal to MasterCard type
        else{
            cardType = "MasterCard";
        }
    }

    public String toString(){
        return super.toString() +
                "Credit Card Holder Name: " + cardName +
                "Credit Card Number: " + cardNum + 
                "Credit Card Type (Visa / MasterCard): " + cardType +
                "CVV: " + cvv;
    }
}

