package com.search.challenge;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.PrintStream;
import org.mockito.Mockito;
import com.search.challenge.constants.Messages;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;

@SpringBootTest
class ChallengeApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private ChallengeApplication challenge;
	
	@SuppressWarnings("static-access")
	@Test
	public void testPrintInstructionsOnSearch() {
		// value to be printed in the console
		PrintStream mockedPrintStream = Mockito.mock(PrintStream.class);
		System.setOut(mockedPrintStream);

		challenge.printInstructionsOnSearch();		
		
		String expectedSelectSearchOptionsMsg = Messages.SELECT_SEARCH_OPTIONS;
		String expectedPressOne = Messages.PRESS_ONE;
		String expectedPressTwo = Messages.PRESS_TWO;
		String expectedExit = Messages.EXIT;

		Mockito.verify(mockedPrintStream).println(expectedSelectSearchOptionsMsg);
		Mockito.verify(mockedPrintStream).println(expectedPressOne);
		Mockito.verify(mockedPrintStream).println(expectedPressTwo);
		Mockito.verify(mockedPrintStream).println(expectedExit);
	}
	
	@SuppressWarnings({ "unchecked", "static-access" })
	@Test
	public void testProcessMatchValuesForUser() throws JSONException {
		JSONObject actualUsersJsonObj = new JSONObject();
		actualUsersJsonObj.put("_id", 24);
		actualUsersJsonObj.put("url", "http://initech.tokoin.io.com/api/v2/users/24.json");
		actualUsersJsonObj.put("external_id", "c01c2b7a-30cd-41d1-98e7-2cdd42d55d84");
		actualUsersJsonObj.put("alias", "Miss Gates");
		actualUsersJsonObj.put("created_at", "2016-03-02T03:35:41 -11:00");
		actualUsersJsonObj.put("active", false);
		actualUsersJsonObj.put("verified", false);
		actualUsersJsonObj.put("shared", false);
		actualUsersJsonObj.put("locale", "zh-CN");
		actualUsersJsonObj.put("timezone", "Cameroon");
		actualUsersJsonObj.put("last_login_at", "2013-05-11T10:41:04 -10:00");
		actualUsersJsonObj.put("email", "gatescopeland@flotonic.com");
		actualUsersJsonObj.put("phone", "9855-882-406");
		actualUsersJsonObj.put("signature", "Don't Worry Be Happy!");
		actualUsersJsonObj.put("organization_id", 110);
		actualUsersJsonObj.put("tags", new JSONArray(new Object[] { "Kieler", "Swartzville", "Salvo", "Guthrie" }));
		actualUsersJsonObj.put("suspended", false);
		actualUsersJsonObj.put("role", "agent");

		// value to be printed in the console
		PrintStream mockedPrintStream = Mockito.mock(PrintStream.class);
		System.setOut(mockedPrintStream);

		challenge.processMatchValuesForUser(actualUsersJsonObj);
		
		String expectedExternalId = "external_id \t\t" + "c01c2b7a-30cd-41d1-98e7-2cdd42d55d84";
		String expectedAias = "alias \t\t\t" + "Miss Gates";
		String expectedCreatedAt = "created_at \t\t" + "2016-03-02T03:35:41 -11:00";
		String expectedActive = "active \t\t\t" + false;
		String expectedVerified = "verified \t\t" + false;
		String expectedShared = "shared \t\t\t" + false;
		String expectedLocale = "locale \t\t\t" + "zh-CN";
		String expectedTimeZone = "timezone \t\t" + "Cameroon";
		String expectedLastLoginAt = "last_login_at \t\t" + "2013-05-11T10:41:04 -10:00";
		String expectedEmail = "email \t\t\t" + "gatescopeland@flotonic.com";
		String expectedPhone = "phone \t\t\t" + "9855-882-406";
		String expectedSignature = "signature \t\t" + "Don't Worry Be Happy!";
		String expectedOrganization = "organization_id \t" + 110;
		String expectedTags = "tags \t\t\t" + "[\"Kieler\",\"Swartzville\",\"Salvo\",\"Guthrie\"]";
		String expectedSuspended = "suspended \t\t" + false;
		String expectedRole = "role \t\t\t" + "agent";

		Mockito.verify(mockedPrintStream).println(expectedExternalId);
		Mockito.verify(mockedPrintStream).println(expectedAias);
		Mockito.verify(mockedPrintStream).println(expectedCreatedAt);
		Mockito.verify(mockedPrintStream).println(expectedActive);
		Mockito.verify(mockedPrintStream).println(expectedVerified);
		Mockito.verify(mockedPrintStream).println(expectedShared);
		Mockito.verify(mockedPrintStream).println(expectedLocale);
		Mockito.verify(mockedPrintStream).println(expectedTimeZone);
		Mockito.verify(mockedPrintStream).println(expectedLastLoginAt);
		Mockito.verify(mockedPrintStream).println(expectedEmail);
		Mockito.verify(mockedPrintStream).println(expectedPhone);
		Mockito.verify(mockedPrintStream).println(expectedSignature);
		Mockito.verify(mockedPrintStream).println(expectedOrganization);
		Mockito.verify(mockedPrintStream).println(expectedTags);
		Mockito.verify(mockedPrintStream).println(expectedSuspended);
		Mockito.verify(mockedPrintStream).println(expectedRole);
	}


}
