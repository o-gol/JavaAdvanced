package decoratorWrapper1;

public class ProcessBlock implements AbstractBlock {

    @Override
    public void draw() {
        System.out.println("ProcessBlock drawing...");
    }
}
