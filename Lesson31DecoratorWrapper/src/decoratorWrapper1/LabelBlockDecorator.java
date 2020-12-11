package decoratorWrapper1;

public class LabelBlockDecorator extends AbstractBlockDecorator {
    private AbstractBlock abstractBlock;
    public LabelBlockDecorator(AbstractBlock abstractBlock) {
        super(abstractBlock);
        this.abstractBlock=abstractBlock;

    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("And draw label");
    }
}
