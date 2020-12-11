package decoratorWrapper1;

public class StarLableBlockDecarator extends AbstractBlockDecorator {
    public StarLableBlockDecarator(AbstractBlock abstractBlock) {
        super(abstractBlock);
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("And star draw");
    }
}
