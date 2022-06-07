package com.example.demooauth2forcloudio.entity;


import javax.persistence.*;

@Entity
public class EndPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer value;

    public EndPoint(Long id, String name, String description, Integer value) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public EndPoint(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
