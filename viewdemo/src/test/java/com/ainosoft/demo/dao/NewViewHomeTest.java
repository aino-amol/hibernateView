package com.ainosoft.demo.dao;

import org.junit.Assert;
import org.junit.Test;

import com.ainosoft.demo.pojo.NewView;
import com.ainosoft.demo.pojo.NewViewId;

public class NewViewHomeTest {

	
//	@Test
	public void testPersist() {
		NewViewHome nvh=new NewViewHome();
		NewViewId nvi=new NewViewId(1,"history",1,"MH","India","pune");
		NewView nv=new NewView(nvi);
		NewView nv1=nvh.persist(nv);
		Assert.assertTrue(nv1.equals(nv));
	}


//	@Test
	public void testDelete() {
		NewViewHome nvh=new NewViewHome();
		NewViewId nvi=new NewViewId(2,"history",2,"MH","India","pune");
		NewView nv=new NewView(nvi);
		NewView nv1=nvh.persist(nv);
		nvh.delete(nv1);
		Assert.assertTrue(nv1.equals(nv));
	}

	
}
