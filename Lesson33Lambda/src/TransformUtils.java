public class TransformUtils<T> {
    public T transform(T element,Transformeble<T> tTransformeble){
        return tTransformeble.transform(element);
    }

    public static String returnString(String string){
        return string.toUpperCase()+"!!!!!!!!!!!!!";
    }


}
