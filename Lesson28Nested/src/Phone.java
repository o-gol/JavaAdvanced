public class Phone {

     Display display;
     String model;
     String make;
     private RadioModul radioModul;
     private AbstractPhoneButton button;


     public interface AbstractPhoneButton{
         void click();
     }

    public void setButton(AbstractPhoneButton button) {
        this.button = button;
    }

    public AbstractPhoneButton getButton() {
        return button;
    }

    private void initButton() {
        this.button = new AbstractPhoneButton() {
            @Override
            public void click() {
                System.out.println("click on button");
            }
        };
    }

    public Phone(String model, String make) {
        this.model = model;
        this.make = make;
    }


    public void turnOn(){
        initDisplay();
        radioModul=new RadioModul();
        initButton();
    }

    public void call(String number){
        radioModul.call(number);
        this.button.click();
    }

    private void initDisplay(){
        display=new Display();
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }
}
