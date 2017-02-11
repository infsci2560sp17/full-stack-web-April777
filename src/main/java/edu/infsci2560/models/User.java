package edu.infsci2560.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author April
 */
@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    
    protected User(){
        
    }
    
    public User(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    @Override
    public String toString(){
        return String.format("User[id=%d,firstName='%s',lastName='%s']",getId(), getFirstName(), getLastName());
    }
    
    /**
     * @return the id
     */
    public Long getId(){
        return id;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(Long id){
        this.id = id;
    }
    
    /**
     * @return the firstName
     */
    public String getFirstName(){
        return firstName;
    }
    
    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    /**
     * @return the lastName
     */
    public String getLastName(){
        return lastName;
    }
    
    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

}