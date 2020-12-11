package decoratorWrapper1;

public class BorderBlockDecorator extends AbstractBlockDecorator {
    private AbstractBlock abstractBlock;
    public BorderBlockDecorator(AbstractBlock abstractBlock) {
        super(abstractBlock);
        this.abstractBlock=abstractBlock;

    }



    @Override
    public void draw() {
        super.draw();
        System.out.println("And draw border");
    }
}
