package com.fsoinstaller.common;

import static org.testng.Assert.assertNotNull;

import java.net.URI;
import java.net.URISyntaxException;

import org.testng.annotations.Test;

public class BaseURLTest {
	@Test
	public void testUrlIsOkayPass() throws InvalidBaseURLException {
		// GIVEN
		String validSiteUrl = "http://www.fsoinstaller.com/files/installer/java/";

		// WHEN
		BaseURL baseurl = new BaseURL(validSiteUrl);

		// THEN
		assertNotNull(baseurl);
	}

	@Test(expectedExceptions = InvalidBaseURLException.class)
	public void testUrlHaveNoHttpFail() throws InvalidBaseURLException {
		// GIVEN
		String invalidSiteUrl = "www.fsoinstaller.com/files/installer/java/";

		// WHEN
		new BaseURL(invalidSiteUrl);

		// THEN
		// Exception
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testUrlIsNullFail() throws InvalidBaseURLException, URISyntaxException {
		// GIVEN
		URI theURL = null;
		// WHEN
		BaseURL.validateURL(theURL);

		// THEN
		// Exception
	}

}
