package Lexical;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LexicalTest {
    private LexicalAnalysis lexicalAnalysis;
    private StringBuilder text;

    public LexicalTest() {
        text = new StringBuilder();
        //lexicalAnalysis = new LexicalAnalysis();
    }

    public LexicalTest(String text) {
        lexicalAnalysis = new LexicalAnalysis(text);
    }

    public void setLexicalAnalysis(String text) {
        this.lexicalAnalysis = new LexicalAnalysis(text);
    }
    public void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
            while ((tempString = reader.readLine()) != null) {
                this.text.append(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getText () {
        return this.text.toString();
    }

    public ArrayList<Token> lexicalAnalysis() throws LexicalException {
        return this.lexicalAnalysis.lexicalAnalysis();
    }
    public static void main(String[] args) throws LexicalException {
        LexicalTest lexicalTest = new LexicalTest();
        String filename = "D:/hello.txt";
        lexicalTest.readFileByLines(filename);
        lexicalTest.setLexicalAnalysis(lexicalTest.getText());
        ArrayList<Token> tokens = lexicalTest.lexicalAnalysis();
        //System.out.println("�����\t\t->\t\t����");
        for (Token i : tokens) {
            //System.out.println(i.getMemorySymbol());
        }
    }
}
