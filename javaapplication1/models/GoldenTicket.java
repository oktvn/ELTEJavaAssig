package javaapplication1.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GoldenTicket{
	private String code;
        private boolean raffledState;
	private Date registeredDate;
	private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	public GoldenTicket(){
		this.registeredDate = new Date();
	}

	public GoldenTicket(String code, Date registeredDate){
		this.code = code;
		this.registeredDate = registeredDate;
	}

	public GoldenTicket(String code, String registeredDate) throws Exception {
		this.code = code;
		this.registeredDate = format.parse(registeredDate);
	}

	//Getters
	public String getCode(){
		return code;
	}
        
	public void setRaffled(){
		this.raffledState = true;
	}
        
	public boolean getRaffled(){
		return raffledState;
	}

	//Setters
	public void setCode(String code){
		this.code = code;
	}

	@Override
	public String toString(){
		return "Ticket's code: " + code + ", Date registered: " + format.format(registeredDate);
	}

}