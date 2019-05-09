package onlinebank.base.config;


import java.util.UUID;

public class UUId {

    public static String UUid(){

        String s = UUID.randomUUID().toString();

        System.out.println(s);

        String str = "";

        System.out.println(s.length());

        for(int i = 0; i < s.length(); i++){

            if(s.charAt(i) != '-'){
                str += s.charAt(i);
            }
        }
        return str;
    }
}
