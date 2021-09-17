package BusReservationSystem;

public class OnlineBanking extends Payment{
    private String bankName;
    private long accountNum;
    private int payCode;
    private static int countBank = 0;

    //constructor
    public OnlineBanking(){
        countBank++;
    }

    //parameterized constructor
    public OnlineBanking(int receiptNo, double serviceCharge, double amount, double totalIncludeSC, String bankName, long accountNum){
        super(receiptNo, serviceCharge, amount, totalIncludeSC);
        this.bankName = bankName;
        this.accountNum = accountNum;
        countBank++;
    }

    //getter for bank name
    public String getBankName() {
        return bankName;
    }

    //getter for account number
    public long getAccountNum() {
        return accountNum;
    }

    public static int getCountBank() {
        return countBank;
    }

    //getter for payCode
    public int getPayCode() {
        return payCode;
    }

        //setter for payCode
    public void setPayCode(int payCode) {
        this.payCode = payCode;
    }

    //setter for account number
    public void setAccountNum(long accountNum) {
        this.accountNum = accountNum;
    }

    public void setBankName(int optionBank){
        if(optionBank == 1){
            this.bankName = "Public Bank";
        }
        else if(optionBank == 2){
            this.bankName = "Maybank";
        }
        else if(optionBank == 3){
            this.bankName = "CIMB Bank";
        }
        else{
            this.bankName = "RHB Bank";
        }
    }

    public boolean validateAccountNum(int optionBank){
        if(optionBank == 1){
            
            //check is it have 10 digits for public bank account 
            if(String.valueOf(accountNum).length() != 10){
                return false;
            }
        }
        else if(optionBank == 2){

            //check is it have 12 digits for maybank account 
            if(String.valueOf(accountNum).length() != 12){
                return false;
            }
        }
        else if(optionBank == 3){
           
            //check is it have 10 or 14 digits for cimb bank account 
            if(String.valueOf(accountNum).length() != 10 || String.valueOf(accountNum).length() != 14){
                return false;
            }
        }
        else{
            
           //check is it have 14 digits for cimb bank account 
           if(String.valueOf(accountNum).length() != 14){
            return false;
            }
        }
        return true;
    }

    //check code from user after they made payment
    @Override
    public boolean validatePayCode(){
        if(String.valueOf(payCode).charAt(1) != '2'){
            return false;
        }
        return true;
    }

    //toString

}
