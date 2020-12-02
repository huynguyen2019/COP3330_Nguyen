public class ContactItem {
    private String firstName;
    private String lastName;
    private String phoneNum;
    private String email;

    public ContactItem(String firstName, String lastName, String phoneNum, String email) throws IllegalArgumentException{
        if(firstName == "" && lastName == "" && phoneNum == "" && email == ""){
            throw new IllegalArgumentException("You cannot leave everything blank");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        if(isPhoneValid(phoneNum)){
            this.phoneNum = phoneNum;
        }
        if(isEmailValid(email)){
            this.email = email;
        }
    }
    public void setFirstName(String fn){
        this.firstName = fn;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getPhoneNum(){
        return this.phoneNum;
    }
    public String getEmail(){
        return this.email;
    }

    private boolean isPhoneValid(String phoneNum){
        for(int i = 0; i < phoneNum.length(); i++){
            return Character.isDigit(phoneNum.charAt(i));
        }
        return phoneNum.matches("\\d{10}");
    }
    private boolean isEmailValid(String email) {
        String regex = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public String toString(){
        return "First Name: " + this.firstName + "\n Last Name: " + this.lastName
                + "\n Phone number (xxx-xxx-xxxx): " + this.phoneNum
                + "\n Email address (x@y.z): " + this.email;
    }
}
