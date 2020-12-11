package decoratorWrapper1;

public class Program {
    public static void main(String[] args) {
        AbstractBlockDecorator abstractBlockDecorator=new LabelBlockDecorator(new ProcessBlock());
        AbstractBlockDecorator abstractBlockDecorator2=new LabelBlockDecorator(new BorderBlockDecorator(new TerminatorBlock()));
        abstractBlockDecorator.draw();
        abstractBlockDecorator2.draw();
        AbstractBlockDecorator abstractBlockDecorator1=new StarLableBlockDecarator(new LabelBlockDecorator(new BorderBlockDecorator(new TerminatorBlock())));
        abstractBlockDecorator1.draw();
    }
}
