package com.kd.SystemDesign.LLD.Adaptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class XmlPrinter {
    public void printXml(String data) {
        System.out.println("<xml>" + data + "</xml>");
    }
}

interface JsonPrinter {
    void printJson(String data);
}

class XmlToJsonAdapter implements JsonPrinter {
    private XmlPrinter xmlPrinter;

    public XmlToJsonAdapter(XmlPrinter xmlPrinter) {
        this.xmlPrinter = xmlPrinter;
    }

    @Override
    public void printJson(String data) {
        String xmlData = data.replace("{", "<").replace("}", ">"); // simplification
        xmlPrinter.printXml(xmlData);
    }
}

public class Main {
    public static void main(String[] args) {
        JsonPrinter printer = new XmlToJsonAdapter(new XmlPrinter());
        printer.printJson("{message:Hello}");
        List<String> list = new ArrayList<>();
        list.forEach(System.out::println);
    }
}
