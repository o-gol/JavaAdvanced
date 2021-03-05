package ru.ocp.loan_ocp_handler;

public class LoanApprovalHandler {
    public void approvePersonLoan(PersonalLoanValidator personalLoanValidator){
        if(personalLoanValidator.isValid())
            System.out.println("Person loan is approve...");
    }
    public void approveVehicleLoan(PersonalLoanValidator personalLoanValidator){
        if(personalLoanValidator.isValid())
            System.out.println("Vehicle loan is approve...");
    }
}

class PersonalLoanValidator{
    public boolean isValid(){
        return true;
    }
}

class VehicleLoanValidator{
    public boolean isValid(){
        return false;
    }
}
