package com.onurtogan.demo.simpleweb.model;

import javax.validation.constraints.*;

public class SpecialAgent {

    @NotBlank(message="First name cannot be missing or empty")
    @Size(min=2, message="First name must not be less than 2 characters")
    private String firstName;

    @NotBlank(message="Last name cannot be missing or empty")
    @Size(min=2, message="Last name must not be less than 2 characters")
    private String lastName;

    @Size(min = 1, max = 5)
    private String motto;

    @Pattern(regexp = "[0-9]{1,3}")
    private String code;

    @NotNull
    @Email
    private String email;

    @NotEmpty
    private String status;

    @Min(value = 18, message = "Age must be greater than or equal to 18")
    private int age;

    @Max(5)
    private int numberOfCurrentMissions;

    public SpecialAgent() {
    }

    public SpecialAgent(@NotBlank String firstName, @NotBlank String lastName, @NotEmpty String motto, @Pattern(regexp = "[0-9]{1,3}") String code, @NotNull @Email String email, @Size(min = 1, max = 3) String status, @Min(value = 18, message = "Age must be greater than or equal to 18") int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.motto = motto;
        this.code = code;
        this.email = email;
        this.status = status;
        this.age = age;
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

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumberOfCurrentMissions() {
        return numberOfCurrentMissions;
    }

    public void setNumberOfCurrentMissions(int numberOfCurrentMissions) {
        this.numberOfCurrentMissions = numberOfCurrentMissions;
    }
}
