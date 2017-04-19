package com.ingweb.business;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ingweb.business.ClienteBusiness;
import com.ingweb.exception.SuperException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "file:springconfiguration.xml")
public class ClienteBusinessTest {
	@Autowired
	ClienteBusiness clientBusiness;

	@Test
	public void obtenerTest() {
		try {
			assertTrue(clientBusiness.obtener().size() > 0);
		} catch (SuperException e) {
			fail(e.getMessage());
		}
	}
}
