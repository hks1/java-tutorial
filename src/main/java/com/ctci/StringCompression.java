package com.ctci;

// 1.6

public class StringCompression {
    public String stringCompression(String str){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i-1) != str.charAt(i)){
                count++;
            }else{
                sb.append(str.charAt(i-1));
                sb.append(Integer.toString(count));
                count = 1;
            }
        }
        sb.append(str.charAt(str.length()-1));
        sb.append(count);
        return (str.length() > sb.toString().length() ? sb.toString() : str);
    }
}
