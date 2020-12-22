package codeForStackoverflow;



public class Program {
    private static final String FILE_NAME = "File for write insert";
    private static final String FILE_NAME2 = "File for write insert2";

    public static void main(String[] args){

        Writer writer=new Writer();

        writer.writeTextToFile(FILE_NAME);
        writer.insertTextToFile(FILE_NAME2);
    }
}
