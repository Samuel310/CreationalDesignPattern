package com.dp.Singleton;

class ATM {
    String univ_pwd;

    public static ATM  Unique = new ATM() ;

    private ATM() {
        univ_pwd="India";
    }

    public static ATM get_instance() {
        if(Unique==null)
            Unique= new ATM();
        return Unique;
    }

    public void setPWD(String s) {
        univ_pwd = s;
    }

    public void printPWD() {
        System.out.println(univ_pwd);
    }
}

class Demo {
}

public class Main {
    public static void main(String args[]) {
        ATM obj = ATM.get_instance();
        obj.setPWD("deadlock");
        System.out.println(obj.hashCode());
        ATM obj1 = ATM.get_instance();
        obj1.printPWD();
        System.out.println(obj1.hashCode());
        Demo d1=new Demo();
        System.out.println(d1.hashCode());
        Demo d2=new Demo();
        System.out.println(d2.hashCode());
    }
}
