package sg.edu.nus.iss.vttp5a_ssf_day13l.model;

import java.util.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class Person {

    private String id;

    // NotNull is for integer, NotEmpty for
    @NotEmpty(message = "First name is mandatory")
    @Size(min = 5, max = 60, message = "First name must be between 5 and 60 characters")
    private String firstName;

    @NotEmpty(message = "Last name is mandatory")
    @Size(min = 2, max = 60, message = "Last name must be between 2 and 60 characters")
    private String lastName;

    @Min(value = 1500, message = "Minimum salary starts from 1500")
    @Max(value = 50000, message = "Maximum salary ceiling is 50000")
    @NotNull(message = "Salary is mandatory")
    private Integer salary;

    @Email(message = "Email input does not conform to email format")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Past(message = "Birth date must be a past date")
    @NotNull(message = "Birth date is mandatory") 
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @Pattern(regexp = "(8|9)[0-9]{7}", message = "Phone number must start with 8 or 9 follow by 7 digits")
    private String telephone;

    @Digits(fraction = 0, integer = 6, message = "Postal code must be 6 digits")
    @Min(value = 111111, message = "Postal code starts from 111111")
    @Max(value = 999999, message = "Postal code cannot exceed 999999")
    private Integer postalCode;

    public Person() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
                + ", email=" + email + ", dateOfBirth=" + dateOfBirth + "]";
    }

    

}
