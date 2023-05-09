package com.hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {
	
		    
	   
	
	@Async
	    public String processSomethingForLong() {
	    	 User user;
	    	 List<User> users= new ArrayList<User>();
	    	 List<User> failedusers= new ArrayList<User>();
	    	  for(int i=0;i<10;i++) {
	            	user= new User(i,"name_"+i,"Blog_"+i);
	            	users.add(user);
	            }
	    	  
	        try {
	        	User user1;
	            
	            
	            for(User u:users) {
	            	user1=saveUserToDBCache(u);
	            	if(user1!=null) {
	            		failedusers.add(user1);
	            	}
	            }
	            System.err.println("After Async method Called");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	      return "Hello World Took milliseconds ! and the current Thread is ";
	    }
	    @Async 
	    public User saveUserToDBCache(User user)  {
	    	
	    	try {
	    		Thread.sleep(10000);
	    		saveUserToDB(user);
	    		saveUserToCache(user);
	    		return null;
	    		
	    	}catch(Exception e) {
	    		//System.err.println("Exception: "+user.getId());
	    		return user;
	    	}
	    	
	    }
	    @Async
 public User saveUserToDB(User user) throws Exception  {
	 if(user.getId()==8 || user.getId()==9) {
		 Thread.sleep(10000);
	 		throw new Exception();	
	 	}else {
	 		return null;
	 	}
	 	
	    }
	    @Async
 public User saveUserToCache(User user)throws Exception   {
 	
	    	Thread.sleep(10000);
 	if(user.getId()==6 || user.getId()==7) {
 		throw new Exception();		
 	}else {
 		return null;
 	}
 	
 	
 	
 }
	    

}
