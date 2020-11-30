public class RadioModul {
    public RadioModul() {
        System.out.println("Radimodyl init");
    }

    public void call(String number){
        int lenght=10;
        class GSMModul{
            private String phoneNumber;
            private int validNumber;

            public GSMModul(String phoneNumber) {
                this.phoneNumber=phoneNumber;
            }
            public boolean isValid(){
                if(phoneNumber.length()!=lenght){
                    return false;
                }else{
                    try {
                        validNumber=Integer.parseInt(phoneNumber);
                        return true;
                    }catch (NumberFormatException e){
                        return false;
                    }
                }
            }

            public void dailIn(){
                if (isValid()){
                    System.out.printf("coll on-%s\n",validNumber);
                }else
                    System.out.printf("nambor is not valid\n");
            }
        }

        GSMModul gsmModul=new GSMModul(number);
        gsmModul.dailIn();
    }





}
