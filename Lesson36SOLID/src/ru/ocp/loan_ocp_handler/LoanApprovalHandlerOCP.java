package ru.ocp.loan_ocp_handler;

import java.lang.annotation.Annotation;

public class LoanApprovalHandlerOCP {

    public static void main(String[] args) {
        LoanApprovalHandlerOCP loanApprovalHandlerOCP=new LoanApprovalHandlerOCP();
        loanApprovalHandlerOCP.approveLoan(new LoanValidatorOCP(Type.Vehicle));
    }


    public void approveLoan(Loan validatble ){
        if(validatble.isValid())
            System.out.printf("%s loan is approve...\n",validatble.type.toString());
        else
            System.out.printf("%s loan is not approve...\n",validatble.type.toString());
    }

}
class LoanValidatorOCP extends Loan{
    public LoanValidatorOCP(Type type) {
        super(type);
    }

    @Override
    public boolean isValid() {
        switch (super.type){
            case Person:
                return false;
            case Vehicle:
                return true;
        }
        return false;
    }
}

abstract class Loan implements Validatble{

    public final Type type;

    public Loan(Type type) {
        this.type = type;
    }
}

enum Type{
    Person("Person"),
    Vehicle("Vehicle");
    String type;

    Type(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return type;
    }


}





interface Validatble {

    boolean isValid();
}

