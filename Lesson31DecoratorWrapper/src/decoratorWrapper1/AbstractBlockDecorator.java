package decoratorWrapper1;

public abstract class AbstractBlockDecorator implements AbstractBlock   {
    AbstractBlock abstractBlock;

    public AbstractBlockDecorator(AbstractBlock abstractBlock) {
        this.abstractBlock = abstractBlock;
    }

    @Override
    public void draw() {
        abstractBlock.draw();
    }
}
