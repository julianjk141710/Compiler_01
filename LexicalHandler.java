package Lexical;

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
     * ���ַ�ƴ�ӵ��ַ���֮��
     * @param token
     * @param character
     */
    public void catToken(StringBuilder token, char character) {
        token.append(character);
    }

    /**
     * ����ַ���
     * @param token
     */
    public void clearToken(StringBuilder token) {
        token.delete(0, token.length());
    }

    /**
     * �ж�һ���ַ��ǲ��ǿ��ַ�
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
     * ��ȡһ�����ַ���������
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
     * �ַ�ָ������
     * @param index
     * @return
     */
    public int addIndex(int index) {
        index ++;
        return index;
    }

    /**
     * �ַ�ָ�����
     * @param index
     * @return
     */
    public int reduceIndex(int index) {
        index --;
        return index;
    }

    /**
     * �ж�һ���ַ��ǲ�������
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
     * �ж�һ���ַ��ǲ�����ĸ
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
     * �ж�һ�������ǲ��ǹؼ���
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
     * ���ַ���ת��Ϊ����
     * @param token
     * @return
     */
    public int atoi(StringBuilder token) {
        return Integer.parseInt(token.toString());
    }

    /**
     * �׳��쳣
     * @return
     */
    public LexicalException throwError() {
        return new LexicalException("Something went wrong...");
    }

    /**
     * �ж��ַ��Ƿ�Ϊ���
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
