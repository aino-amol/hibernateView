package com.ainosoft.demo.dao;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.ainosoft.demo.pojo.Address;

public class AddressHomeTest {

	@Test
	public void testPersist() {
		AddressHome ah=new AddressHome();
		Address ad=new Address(5,"MH","USA","pune");
		Address ad1=ah.persist(ad);
		Assert.assertTrue(ad.getAddressId()==ad1.getAddressId());
	}

	@Test
	public void testDelete() {
		AddressHome ah=new AddressHome();
		Address ad=new Address(7,"DH","RSA","nashik");
		Address ad1=ah.persist(ad);
		ah.delete(ad1);
		List<Address> list= ah.getList();
		Assert.assertFalse(list.contains(ad1));
		
	}

}
