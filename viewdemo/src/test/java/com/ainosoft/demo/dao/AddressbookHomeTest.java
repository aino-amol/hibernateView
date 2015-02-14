package com.ainosoft.demo.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ainosoft.demo.pojo.Addressbook;

public class AddressbookHomeTest {

	@Test
	public void testPersist() {
	
		AddressbookHome abh=new AddressbookHome();
		Addressbook ab=new Addressbook("librarybook");
		Addressbook ab1=abh.persist(ab);
		Assert.assertTrue(ab1.getBookId()!=null);
		Assert.assertTrue(ab1.getBookName()=="librarybook");
	}

	@Test
	public void testDelete() {
	
		AddressbookHome abh=new AddressbookHome();
		Addressbook ab=new Addressbook("phonebook");
		Addressbook ab1=abh.persist(ab);
		abh.delete(ab1);
		List<Addressbook> list=	abh.getList();
		Assert.assertFalse(list.contains(ab1));
	}

	
	

}
