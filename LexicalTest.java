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
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                this.text.append(tempString);
                this.text.append(" ");
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
        String filename = args[0];
        //String filename = "D:/sourceCode.txt";
        lexicalTest.readFileByLines(filename);
        System.out.println(lexicalTest.getText());
        lexicalTest.setLexicalAnalysis(lexicalTest.getText());
        System.out.println(lexicalTest.getText().length());
        ArrayList<Token> tokens = lexicalTest.lexicalAnalysis();
        //System.out.println("记忆符\t\t->\t\t单词");
        for (Token i : tokens) {
            //System.out.println(i.getMemorySymbol());
        }
    }
}
