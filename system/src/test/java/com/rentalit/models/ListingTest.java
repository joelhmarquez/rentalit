package com.rentalit.models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ListingTest {
	private Listing listing;

	@Before
	public void setUp() throws Exception {
		listing = new Listing();
//		listing.setId("mockId");
		listing.setCondition("GOOD");
		listing.setDescription("Mock Descrition");
		listing.setProductName("Mock name");
		listing.setRented(0);
	}

	@Test
	public void testAcceptRental() throws Exception {
		assertEquals(listing.getCurrentState(), listing.availableState);
//		listing.acceptRental();
		assertEquals(listing.getCurrentState(), listing.rentedState);
	}

	@Test
	public void testRequestRental() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testReturnRental() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

}
