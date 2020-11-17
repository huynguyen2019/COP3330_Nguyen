import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class TaskItem {
    private String title;
    private String description;
    private String dueDate;
    private boolean comStatus;

    public TaskItem(String title, String description, String dueDate, boolean comStatus){
        if(isTitleValid(title)){
            this.title = title;
        } else {
            System.out.println("WARNING: title must be at least 1 character long; task not created");
        }
        if(isDescValid(description)){
            this.description = description;
        }
        if(isDateValid(dueDate)){
            this.dueDate = dueDate;
        } else {
            System.out.println("WARNING: invalid due date; task not created");
        }

        this.comStatus = comStatus;
    }
    public void setTitle(String t){
        if(isTitleValid(t)){
            this.title = t;
        } else {
            System.out.println("WARNING: title must be at least 1 character long; task not set");
        }
    }
    public void setDescription(String d){
        if(isDescValid(d)){
            this.description = d;
        }
    }
    public void setDueDate(String dd){
        if(isDateValid(dd)){
            this.dueDate = dd;
        } else {
            System.out.println("WARNING: invalid due date; task not set");
        }
    }
    public void setComStatus(boolean cs){
        this.comStatus = cs;
    }

    private boolean isTitleValid(String titl) {
        return titl.length() > 0;
    }

    private boolean isDescValid(String desc) {
        return desc.length() > 0;
    }

    private boolean isDateValid(String date){
        if (!date.trim().equals("")) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            format.setLenient(false);
            try {
                Date javaDate = format.parse(date);
            } catch (ParseException e) {
                return false;
            }
        }
        return true;
    }

    public String getTitle(){
        return this.title;
    }
    public String getDescription(){
        return this.description;
    }
    public String getDueDate(){
        return this.dueDate;
    }
    public boolean getComStatus(){ return this.comStatus; }

    public boolean equals(Object o){
        TaskItem other = (TaskItem)o;
        return other.getTitle().equals(getTitle()) & other.getDueDate().equals(getDueDate())
                & other.getDescription().equals(getDescription()) & other.getComStatus() == getComStatus();
    }
    public String toString() {
        String completedStr = this.comStatus? "true": "false";
        return String.format("Task{.title = \"%s\", .desc = \"%s\", .dueDate = \"%s\", .completed = \"%s\"}",
                this.getTitle(), this.getDescription(), this.getDueDate(), completedStr);
    }
}
