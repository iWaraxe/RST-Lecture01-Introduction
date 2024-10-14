// File: Ex02UserDTO.java
package com.coherentsolutions.restful.section01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Example 02: User Data Transfer Object (DTO)
 *
 * This class represents the User model which maps to the JSON structure
 * of the user data in the API.
 */
public class Ex02UserDTO {

    // Fields corresponding to the JSON keys
    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("age")
    private int age;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("zipCode")
    private String zipCode;

    /**
     * Default constructor.
     */
    public Ex02UserDTO() {
        // Default constructor needed for deserialization
    }

    // Getters and Setters

    /**
     * Gets the user ID.
     *
     * @return User ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the user ID.
     *
     * @param id User ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the user name.
     *
     * @return User name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the user name.
     *
     * @param name User name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the user age.
     *
     * @return User age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the user age.
     *
     * @param age User age.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the user gender.
     *
     * @return User gender.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the user gender.
     *
     * @param gender User gender.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets the user zip code.
     *
     * @return User zip code.
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the user zip code.
     *
     * @param zipCode User zip code.
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Returns a string representation of the user.
     *
     * @return String representation.
     */
    @Override
    public String toString() {
        return "Ex02UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
