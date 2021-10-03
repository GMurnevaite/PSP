package com.my.junit;

public class PhoneValidator {

    public boolean isPhoneNumberValid(String number) {

        if(null != number) if (!number.isEmpty())
            return noSpaceBars(number) && onlyNumbers(number) && lengthIsRight(number);
        return false;
    }

    private boolean lengthIsRight(String number) {
        return number.length() == 12;
    }

    private boolean noSpaceBars(String number) {

        return !number.contains(" ");
    }

    private boolean onlyNumbers(String number) {

        for(int i = 0; i < number.length(); i++)
            return number.charAt(i) >= '0' && number.charAt(i) <= '9';
        return false;
    }

    public String replacePhoneNumberPrefix(String number) {

        String newPhoneNumber;
        newPhoneNumber = number.replace("8", "+370");
        return newPhoneNumber;
    }

    public boolean isPhoneNumberValidByState(String number, String prefix, String s1, int i) {

        return true;
    }


}
