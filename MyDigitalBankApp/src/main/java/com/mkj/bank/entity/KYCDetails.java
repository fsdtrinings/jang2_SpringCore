package com.mkj.bank.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KYCDetails {

	@Value("Pancard - 123")
	String KYCInfo;

	public String getKYCInfo() {
		return KYCInfo;
	}

	public void setKYCInfo(String kYCInfo) {
		KYCInfo = kYCInfo;
	}

	@Override
	public String toString() {
		return " "+KYCInfo;
	}

	
}
