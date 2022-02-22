package day05;

import org.junit.Test;

public class C01_Juint {
    //main method olmadan selenium da da methodlar cagirlmadan calismaz
    public void ilkTestMethodu(){
        System.out.println("ilk test methodumuz");
    }
    @Test
    //test notasyonu sayesinde main method mecburiyeti ortadan kalkar
    public  void notasyonluMethodumuz(){
        System.out.println("notasyonlu ilk test methodumuz");
    }
}
