package com.mea.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("menu")
@Data
public class HotelMenu {

	@Value("${dosa.price}")
	private Float dosaRate;
	
	@Value("${idly.price}")
	private Float idlyRate;
	
	@Value("${wada.price}")
	private Float wadaRate;
	
	@Value("${poha.price}")
	private Float pohaRate;
	
	@Value("${poori.price}")
	private Float pooriRate;
	
	@Value("${tea.price}")
	private Float teaRate;
	
	@Value("${coffee.price}")
	private Float coffeeRate;

	@Override
	public String toString() {
		return "HotelMenu [dosaRate=" + dosaRate + ", idlyRate=" + idlyRate + ", wadaRate=" + wadaRate + ", pohaRate="
				+ pohaRate + ", pooriRate=" + pooriRate + ", teaRate=" + teaRate + ", coffeeRate=" + coffeeRate + "]";
	}
	
	
}
