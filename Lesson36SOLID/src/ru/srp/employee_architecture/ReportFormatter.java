package ru.srp.employee_architecture;

import java.text.Format;

public class ReportFormatter {
    String format;

    public ReportFormatter(Object object, FormatType formatType){
        switch (formatType){
            case CSV:
                format=convertObjectToCSV(object);
                break;
            case XML:
                format=convertObjectToXML(object);
                break;
        }
    }

    private String convertObjectToXML(Object object){
        return String.format("convert to XML %s",object.toString());
    }
    private String convertObjectToCSV(Object object){
        return String.format("convert to CSV %s",object.toString());
    }


}
