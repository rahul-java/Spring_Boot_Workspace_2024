package com.mea.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("hotel")
@Data
public class Hotelinfo {

	@Value("1001")
	private Integer id;
	
	@Value("${hotel.name}")
	private String hotelName;
	
	@Value("${hotel.location}")
	private String location;
	
	@Value("${cust.name}")
	private String custName;

	@Value("#{menu.dosaRate + menu.idlyRate + menu.teaRate}")  //SPEL
	private Float billAmount;
	
	@Value("${os.name}") //system property ${fixedKey}
	private String osName;
	@Value("${Path}")
	private String pathData;
	@Value("${user.name}")
	private String windowsUserName;
	
	
	@Override
	public String toString() {
		return "Hotelinfo [id=" + id + ", hotelName=" + hotelName + ", location=" + location + ", custName=" + custName
				+ ", billAmount=" + billAmount + ", osName=" + osName + ", pathData=" + pathData
				+ ", windowsUserName=" + windowsUserName + "]";
	}

	
	
	
	
}
