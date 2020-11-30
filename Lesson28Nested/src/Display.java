public class Display {
    private static final  int HIGH_DISPLAY =1200;
    private static final  int WIGHT_DISPLAY=1400;
    //Pixel pixel;
    private int x=0;

    public Display() {
    Pixel
            pixel=new Pixel(10,10,Color.GRIN);

    }

    @Override
    public String toString() {
        return "Display{" +
                "HIGH_DISPLAY=" + HIGH_DISPLAY +
                ", WIGHT_DISPLAY=" + WIGHT_DISPLAY +
                '}';
    }

    private class Pixel{
        private int x;
        private int y;
        Color color;

        private Pixel(int x, int y, Color color) {
            if (0<=x && x<= HIGH_DISPLAY&&0<=y && y<= WIGHT_DISPLAY) {
                this.x = x;
                this.y = y;
                this.color = color;
                System.out.println(this.toString());

            } else {
                throw new IllegalArgumentException(String.format("x and y should by between %s and %s",HIGH_DISPLAY,WIGHT_DISPLAY));
            }
        }

        public void testScope(int x){
            System.out.printf("x-%s\n",x);
            System.out.printf("Pixel x-%s\n",this.x);
            System.out.printf("Display x-%s\n",Display.this.x);

        }

        @Override
        public String toString() {
            return "Pixel{" +
                    "x=" + x +
                    ", y=" + y +
                    ", color=" + color +
                    '}';
        }
    }

    enum  Color{
        BLUE,RED, GRIN,BLACK
    }

}
