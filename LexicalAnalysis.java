

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static java.lang.System.exit;

public class LexicalAnalysis {
    private char character;
    private StringBuilder token;
    private HashSet<String> reservers;
    private HashMap<String, String> delimiters;
    private HashMap<String, String> sevenWords;
    private LexicalHandler lexicalHandler;
    private String text;
    private int index;
    private int flag;
    private ArrayList<Token> tokens;
    public LexicalAnalysis(String text) {
        this.flag ^= this.flag;
        this.text = text;
        this.index ^= this.index;
        this.reservers = new HashSet<String>();
        this.delimiters = new HashMap<String, String>();
        this.sevenWords = new HashMap<String, String>();
        this.token = new StringBuilder();
        this.lexicalHandler = new LexicalHandler();
        this.tokens = new ArrayList<Token>();
        this.token.delete(0, this.token.length());
        String reservers[] = {"auto", "case", "char", "const", "continue", "default", "do", "double" , "else", "enum",
        "extern", "float", "for", "goto", "if", "int", "long", "register", "return", "short", "signed", "sizeof", "static",
        "struct", "switch", "typedef", "unsigned", "union", "void", "volatile", "while", "BEGIN", "END", "FOR",
        "DO", "IF", "THEN", "ELSE"};
        for (String s : reservers) {
            this.reservers.add(s);
        }
        this.delimiters.put(":", "Colon");
        this.delimiters.put("+", "Plus");
        this.delimiters.put("*", "Star");
        this.delimiters.put(",", "Comma");
        this.delimiters.put("(", "LParenthesis");
        this.delimiters.put(")", "RParenthesis");
        this.delimiters.put(":=", "Assign");

        this.sevenWords.put("BEGIN", "Begin");
        this.sevenWords.put("END", "End");
        this.sevenWords.put("FOR", "For");
        //this.sevenWords.put("DO", "DOSY");
        this.sevenWords.put("IF", "If");
        this.sevenWords.put("THEN", "Then");
        this.sevenWords.put("ELSE", "Else");

    }

    public LexicalAnalysis() {

    }

    public void addIndex() {
        this.index ++;
    }

    public void reduceIndex() {
        this.index --;
    }
    public ArrayList<Token> lexicalAnalysis() throws LexicalException {
        while (index < text.length()) {
            while (lexicalHandler.isBlank((character = lexicalHandler.getChar(text, index)))) {
                addIndex();
                if (index >= text.length()) {
                    this.flag += 1;
                    break;
                }
            }
            if (this.flag != 0) {
                break;
            }
            if (lexicalHandler.isLetter(character)) {
                lexicalHandler.catToken(token, character);
                addIndex();
                character = lexicalHandler.getChar(text, index);
                while (lexicalHandler.isLetter(character) || lexicalHandler.isDigit(character)) {
                    lexicalHandler.catToken(token, character);
                    addIndex();
                    character = lexicalHandler.getChar(text, index);
                }
                //reduceIndex();

                if (lexicalHandler.isReserver(reservers, token)) {
                    if (lexicalHandler.isSevenWords(sevenWords, token)) {
                        tokens.add(new Token(sevenWords.get(token.toString()), token.toString()));
                        //add output
                        System.out.println(sevenWords.get(token.toString()));
                    }
                    else {
                        tokens.add(new Token("Ident(" + token.toString() + ")", token.toString()));
                        //add output
                        System.out.println("Ident(" + token.toString() + ")");
                    }
                } else {
                    tokens.add(new Token("Ident(" + token.toString() + ")", token.toString()));
                    //add output
                    System.out.println("Ident(" + token.toString() + ")");
                }
                lexicalHandler.clearToken(token);
            } else if (lexicalHandler.isDigit(character)) {
                lexicalHandler.catToken(token, character);
                addIndex();
                character = lexicalHandler.getChar(text, index);
                while (lexicalHandler.isDigit(character)) {
                    lexicalHandler.catToken(token, character);
                    addIndex();
                    character = lexicalHandler.getChar(text, index);
                }
                //reduceIndex();
                tokens.add(new Token("Int(" + String.valueOf(lexicalHandler.atoi(token)) + ")", String.valueOf(lexicalHandler.atoi(token))));
                //add output
                System.out.println("Int(" + String.valueOf(lexicalHandler.atoi(token)) + ")");
                lexicalHandler.clearToken(token);
            } else if (lexicalHandler.isDelimiter(delimiters, character)){
                lexicalHandler.catToken(token, character);
                if (character == ':') {
                    addIndex();
                    character = lexicalHandler.getChar(text, index);
                    if (character == '=') {
                        tokens.add(new Token(delimiters.get(":="), ":="));
                        //add output
                        System.out.println(delimiters.get(":="));
                    } else {
                        tokens.add(new Token(delimiters.get(":"), ":"));
                        //add output
                        System.out.println(delimiters.get(":"));
                        reduceIndex();
                    }
                } else {
                    //System.out.println(delimiters.get(Character.toString(character)) + " and " + character);
                    tokens.add(new Token(delimiters.get(Character.toString(character)), Character.toString(character)));
                    //add output
                    System.out.println(delimiters.get(Character.toString(character)));
                }
                addIndex();
                lexicalHandler.clearToken(token);
            } else {
                System.out.println("Unknown");
                exit(0);
                //throw new LexicalException();
            }
        }
        return tokens;
    }
}
