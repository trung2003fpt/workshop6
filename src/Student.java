public class Student {
    String code = "";
    String name = "";
    int mark = 0;
    public Student(){
    }
    public Student(String code, String name, int mark){
        this.code = code.toUpperCase();
        this.name = name.toUpperCase();
        this.mark = (mark >=0 && mark <= 10) ? mark:0;
    }
    @Override
    public String toString(){
        return code + ", " + name + ", " + mark;
    }
    public String getCode(){
        return this.code;
    }
    public int getMark(){
        return this.mark;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        name = name.toUpperCase().trim();
        if(name.length() > 0) this.name = name;
    }
    public void setMark(int mark){
        if(mark >=0 && mark <= 10) this.mark = mark;
    }
}