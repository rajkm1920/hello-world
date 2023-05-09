package com.hello;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

	private int id;
	private String name;
    private String blog;
    
    public User(int id, String name, String blog) {
    	this.id=id;
    	this.name=name;
    	this.blog=blog;
    }
    
    }
