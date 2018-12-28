package com.brownfield.pss.checkin;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brownfield.pss.checkin.component.CheckinComponent;
import com.brownfield.pss.checkin.entity.CheckInRecord;
import com.brownfield.pss.checkin.repository.CheckinRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	@Autowired
	CheckinRepository repository;
	
	//Added by Ramesh K.
	@Autowired
	CheckinComponent checkinComponent;
	//end of changes made by Ramesh
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String... strings) throws Exception {
		CheckInRecord record = new CheckInRecord("Franc", "Gean","28A",new Date(),"BF101","22-JAN-16",1);
		if(checkinComponent.checkIn(record) == -1){ 
			logger.info("Wrong booking id "+ record.getBookingId());
		}
		
		if(checkinComponent.checkIn(record) == -2){ 
			logger.info("Already checkd In against booking id "+ record.getBookingId());
		}
	}
}
