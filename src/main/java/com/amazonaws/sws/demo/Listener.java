package com.amazonaws.sws.demo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent.SQSMessage;

public class Listener implements RequestHandler<SQSEvent, Void> {

	@Override
	public Void handleRequest(SQSEvent event, Context context) {
		EmailSender emailSender = new EmailSender();
        for(SQSMessage msg : event.getRecords()){
        	System.out.println("============================================================");
        	System.out.println("Message Received - START");
        	String message = new String(msg.getBody());
            System.out.println(message);
            emailSender.sendEmail(message);
            System.out.println("Message Received - END");
            System.out.println("============================================================");
        }
		return null;
	}
	
	

}
