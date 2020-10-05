

import java.util.HashMap;
import java.util.HashSet;

public class LexicalHandler {
    public char getChar(String text, int index) {
        if (index < text.length()) {
            return text.charAt(index);
        }
        return ' ';
    }

    /**
     * 将字符拼接到字符串之后
     * @param token
     * @param character
     */
    public void catToken(StringBuilder token, char character) {
        token.append(character);
    }

    /**
     * 清空字符串
     * @param token
     */
    public void clearToken(StringBuilder token) {
        token.delete(0, token.length());
    }

    /**
     * 判断一个字符是不是空字符
     * @param character
     * @return
     */
    public boolean isBlank(char character) {
        if (character == ' ' || character == '\n' || character == '\t') {
            return true;
        }
        return false;
    }

    /**
     * 读取一个空字符串并跳过
     * @param character
     * @param index
     * @return
     */
    public int getBlankChar(char character, int index) {
        if (isBlank(character)) {
            index ++;
        }
        return index;
    }

    /**
     * 字符指针增加
     * @param index
     * @return
     */
    public int addIndex(int index) {
        index ++;
        return index;
    }

    /**
     * 字符指针减少
     * @param index
     * @return
     */
    public int reduceIndex(int index) {
        index --;
        return index;
    }

    /**
     * 判断一个字符是不是数字
     * @param character
     * @return
     */
    public boolean isDigit(char character) {
        if (Character.isDigit(character)) {
            return true;
        }
        return false;
    }

    /**
     * 判断一个字符是不是字母
     * @param character
     * @return
     */
    public boolean isLetter(char character) {
        if (Character.isLetter(character)) {
            return true;
        }
        return false;
    }

    /**
     * 判断一个单词是不是关键字
     * @param reservers
     * @param token
     * @return
     */
    public boolean isReserver(HashSet<String> reservers, StringBuilder token) {
        if (reservers.contains(token.toString())) {
            return true;
        }
        return false;
    }

    /**
     * 将字符串转化为数字
     * @param token
     * @return
     */
    public int atoi(StringBuilder token) {
        return Integer.parseInt(token.toString());
    }

    /**
     * 抛出异常
     * @return
     */
    public LexicalException throwError() {
        return new LexicalException("Something went wrong...");
    }

    /**
     * 判断字符是否为界符
     * @param delimiters
     * @param character
     * @return
     */
    public boolean isDelimiter(HashMap<String, String> delimiters, char character) {
        //System.out.println(delimiters);
        if (delimiters.containsKey(Character.toString(character))) {
            return true;
        }
        return false;
    }

    public boolean isSevenWords(HashMap<String, String> sevenWords, StringBuilder token) {
        if (sevenWords.containsKey(token.toString())) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        StringBuffer sb = new StringBuffer();
//        char a = 'a';
//        sb.append(a);
//        System.out.println(sb.toString());
    }
} 
