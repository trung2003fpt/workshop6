import java.util.ArrayList;
public class StudentList extends ArrayList<Student>{
    public StudentList(){
        super();
    }
    public Student search(String code){
        code = code.trim().toUpperCase();
        for(int i=0; i < this.size(); i++){
            if(this.get(i).getCode().equals(code)){
                return this.get(i);
            }
        }
        return null;
    }
    private boolean isCodeDupplicated(String code){
        code = code.trim().toUpperCase();
        return search(code) != null;
    }
    public void AddStudent(){
        String newCode, newName;
        int newMark;
        boolean codeDupplicated = false;
        do {
            newCode = Inputter.inputPattern("St. code S000: ", "[sS][\\d]{3}");
            newCode = newCode.trim().toUpperCase();
            codeDupplicated = isCodeDupplicated(newCode);
            if(codeDupplicated) System.out.println("Code is dupplicated!");
        } while (codeDupplicated == true);
        newName = Inputter.inputNonBlankStr("Name of new student: ");
        newName = newName.toUpperCase();
        newMark = Inputter.inputInt("Mark: ", 0, 10);
        Student st = new Student(newCode, newName, newMark);
        this.add(st);
        System.out.println("Student " + newCode + " has been added." );
    }
    public void searchStudent(){
        if(this.isEmpty()){
            System.out.println("Empty list. No search can be performed!");
        }
        else{
            String sCode = Inputter.inputStr("Input student code for search:");
            Student st = this.search(sCode);
            if(st == null){
                System.out.println("Student " + sCode + " doesn't existed!");
            }
            else System.out.println("Found: " + st);
        }
    }
    public void UpdateStudent(){
        if(this.isEmpty()) System.out.println("Empty list. No update can be performed!");
        else{
            String ucode = Inputter.inputStr("Input code of updated studet:");
            Student st = this.search(ucode);
            if(st ==null) System.out.println("Student " + ucode +" doesn't existed!");
            else{
                String oldName = st.getName();
                String msg = "Old name " + oldName + ", new name:";
                String newName = Inputter.inputNonBlankStr(msg);    
                st.setName(newName);
                int oldMark = st.getMark();
                msg = "Old mark " + oldMark + ", new mark 0..10:";
                int newMark = Inputter.inputInt(msg, 1, 10);
                st.setMark(newMark);
                System.out.println("Student " + ucode + " has been updated.");
            }
        }
    }
    public void removeStudent(){
        if(this.isEmpty()) System.out.println("Empty list. No remove can be performed!");
        else{
            String rcode = Inputter.inputStr("Input code of removed studet:");
            Student st = this.search(rcode);
            if(st ==null) System.out.println("Student " + rcode +" doesn't existed!");
            else{
                this.remove(st);
                System.out.println("Student " + rcode + " has been removed.");
            }
        }
    }
    public void printAll(){
        if(this.isEmpty()) System.out.println("Empty list!");
        else{
            System.out.println("Student list:");
            for(Student st: this){
                System.out.println(st);
            }
            System.out.println("Total: " + this.size() + " student(s).");
        }
    }

}