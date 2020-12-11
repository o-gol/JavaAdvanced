package decoratorWrapper1;

public class TerminatorBlock implements AbstractBlock {

    @Override
    public void draw() {
        System.out.println("TerminatorBlock drawing...");
    }
}
