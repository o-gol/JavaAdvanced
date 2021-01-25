import java.util.List;

public interface BoxList<E,V> extends List<E> {
    E sum(E one,V two);
}
