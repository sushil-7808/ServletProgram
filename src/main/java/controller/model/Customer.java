package controller.model;


import controller.enums.Gender;

//Creating encapsulated customer class.
public class Customer {
    private Integer id;
    private String fullName;
    private String password;
    private String address;
    private String email;
    private String mobileNumber;
    private Gender gender;

    public Customer(String fullName,String password, String address, String email, String mobileNumber, Gender gender) {
        this.fullName = fullName;
        this.password = password;
        this.address = address;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
    }

    public Customer(Integer id, String fullName, String password, String address, String email, String mobileNumber, Gender gender) {
        this.id = id;
        this.fullName = fullName;
        this.password = password;
        this.address = address;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
