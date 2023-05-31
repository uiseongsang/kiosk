package Assignment;

import javax.xml.namespace.QName;
import java.util.Scanner;

// 이름, 설명 필드
public class Menu {
    private String name;
    private String desc;
    public Menu(){

    }
    public Menu(String name, String desc){
        this.name = name;
        this.desc = desc;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDesc(){
        return desc;
    }
    @Override
    public String toString() {
        return this.name + "   - " + this.desc;
    }
}
