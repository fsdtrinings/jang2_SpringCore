package com.abc.bankapp.util;

import com.abc.bankapp.dto.AccountResponseDTOAdmin;
import com.abc.bankapp.dto.AccountResponseDTOClient;
import com.abc.bankapp.entity.Account;

// create all static method
public class AccountToAccountDTOConvertion {

	public static AccountResponseDTOClient doDTOCLientConvertion(Account a)
	{
		AccountResponseDTOClient dtoForClient = new AccountResponseDTOClient();
		
		dtoForClient.setAccountNumber(a.getAccountNumber());
		dtoForClient.setBalance(a.getBalance());
		dtoForClient.setFirstName(a.getUserDeatils().getFirstName());
		dtoForClient.setLastName(a.getUserDeatils().getLastName());
		dtoForClient.setPanCard(a.getUserDeatils().getPanNumber());
		dtoForClient.setUsername(a.getUsername());
		dtoForClient.setPhoneNumber(a.getUserDeatils().getMobileNumber());
		
		return dtoForClient;
	}
	
	public static AccountResponseDTOAdmin doDTOAdminConvertion(Account a)
	{
		AccountResponseDTOAdmin dtoForAdmin = new AccountResponseDTOAdmin();
		
		dtoForAdmin.setAccountNumber(a.getAccountNumber());
		dtoForAdmin.setBalance(a.getBalance());
		dtoForAdmin.setFirstName(a.getUserDeatils().getFirstName());
		dtoForAdmin.setLastName(a.getUserDeatils().getLastName());
		
		boolean isKyc = (a.getUserDeatils().getPanNumber()!=null)?true:false;
		
		dtoForAdmin.setKycStatus(isKyc);
		dtoForAdmin.setPhoneNumber(a.getUserDeatils().getMobileNumber());
		
		return dtoForAdmin;
	}
	
	
	
}
