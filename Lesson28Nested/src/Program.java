public class Program {
    public static void main(String[] args) {
        //-----Static
//        Display.Pixel pixel=new Display.Pixel(100,100, Display.Color.RED);


        //-----NO STATIC
        Phone phone1=new Phone("s-111","Sosang");
        phone1.turnOn();
        Display display1=phone1.getDisplay();
        phone1.call("1234567890");
        //phone1.getButton();
        phone1.setButton(() -> {
            System.out.printf("click on butten in Program");
                });
        phone1.getButton().click();
//        Display.Pixel pixel1=display1.new Pixel(123,3, Display.Color.BLACK);
//        pixel1.testScope(11);
//        Display display2=new Display();
//        Display.Pixel pixel2=display2.new Pixel(23654,123, Display.Color.BLUE);
        //-------



    }
}
