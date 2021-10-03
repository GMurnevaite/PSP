package com.my.junit;

public class EmailValidator {

    public boolean isEmailValid(String email) {

        if(null != email) if(!email.isEmpty())
            return emailDomainValid(email) && isEmailNameInvalid(email);
        return false;
    }

    private boolean haveEta(String email) {
        return email.contains("@");
    }

    private boolean emailDomainValid(String email) {

        String tld;
        String name;
        char [] symbols = new char[] {',', '(', ')', '~', '[', ']', '\"', '"',',',':',';', '>', '<', '@','-', '!', '#', '$', '%', '&', '\'', '*', '+', '/', '=', '?', '^', '_', '`', '{', '|', '}'};

        if (haveEta(email) && email.substring(email.indexOf("@")).contains(".")) {
            tld = email.substring(email.lastIndexOf('.')+1);
            name = email.substring(email.indexOf('@')+1, email.lastIndexOf('.'));
            return name.length() > 253 || name.length() == 0 || containsInvalidSymbol(name, symbols) || !isStringLowerCase(tld) || containsInvalidSymbol(tld, symbols);
        }
        else return true;
    }

    private boolean isStringLowerCase(String tld){

        char[] array = tld.toCharArray();

        for (char c : array) if (Character.isLowerCase(c)) return true;
        return false;
    }


    private boolean symbolsInStartAndEnd(String name, char[] legalSymbols){
        for (char c : legalSymbols)
            if ( name.charAt(name.length() - 1) == c || name.charAt(0) == c) return true;
        return false;
    }

    private boolean symbolsRepeatsInRow(String name, char[] legalSymbols){
        int numberOfSymbols;
        for (char c : legalSymbols) {
            numberOfSymbols = 0;
            for (int i = 0; i < name.length(); i++) {
                if (name.charAt(i) == c) numberOfSymbols++;
                else if (numberOfSymbols > 0) break;
            }
            if (numberOfSymbols > 1) return true;
        }
        return false;
    }

    private boolean containsInvalidSymbol (String email, char[] symbols){
        for (char c : symbols)
            if (email.indexOf(c) >= 0)
                return true;
        return false;
    }

    private boolean isEmailNameInvalid(String email) {
        String name;
        char[] legalSymbols = new char[]{'.', '!', '#', '$', '%', '&', '\'', '*', '+', '-', '/', '=', '?', '^', '_', '`', '{', '|', '}'};
        char[] symbols = new char[]{'(', ')', '~', '[', ']', '\"', '"', ',', ':', ';', '>', '<', '@'};

        if (haveEta(email)) {
            name = email.substring(0, email.indexOf('@'));
            return containsInvalidSymbol(email, symbols) || name.length() > 64 || name.length() == 0 || symbolsInStartAndEnd(name, legalSymbols) || symbolsRepeatsInRow(name, legalSymbols);
        } else return true;
    }
}
