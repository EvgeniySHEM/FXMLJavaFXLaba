package com.example.fxmljavafxlaba;

import java.util.Objects;

public class PersonDTO {
    private final Integer id;
    private final String jobTitle;
    private final String firstNameLastName;
    private final String phone;
    private final String email;
    private final Integer countDomains;

    public PersonDTO(Integer id, String jobTitle, String firstNameLastName, String phone, String email, Integer countDomains) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.firstNameLastName = firstNameLastName;
        this.phone = phone;
        this.email = email;
        this.countDomains = countDomains;
    }

    public Integer getId() {
        return id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getFirstNameLastName() {
        return firstNameLastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Integer getCountDomains() {
        return countDomains;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return Objects.equals(id, personDTO.id) && Objects.equals(jobTitle, personDTO.jobTitle) && Objects.equals(firstNameLastName, personDTO.firstNameLastName) && Objects.equals(phone, personDTO.phone) && Objects.equals(email, personDTO.email) && Objects.equals(countDomains, personDTO.countDomains);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, jobTitle, firstNameLastName, phone, email, countDomains);
    }
}
