public class OnlineBanking extends Payment{
    private String bankName;
    private long accountNum;

    //constructor
    public OnlineBanking(){}

    //parameterized constructor
    public OnlineBanking(double serviceCharge, double amount, double totalIncludeSC, String bankName, long accountNum){
        super(serviceCharge, amount, totalIncludeSC);
        this.bankName = bankName;
        this.accountNum = accountNum;
    }

    //getter for bank name
    public String getBankName() {
        return bankName;
    }

    //getter for account number
    public long getAccountNum() {
        return accountNum;
    }

    public void setBankName(int optionBank){
        if(optionBank == 1){
            bankName = "Public Bank";
        }
        else if(optionBank == 2){
            bankName = "Maybank";
        }
        else if(optionBank == 3){
            bankName = "CIMB Bank";
        }
        else{
            bankName = "RHB Bank";
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

}
