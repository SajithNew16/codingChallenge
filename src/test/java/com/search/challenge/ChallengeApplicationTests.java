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
import org.json.simple.parser.JSONParser;

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

	@SuppressWarnings({ "unchecked", "static-access" })
	@Test
	public void testProcessMatchValuesForTickets() throws JSONException {
		JSONObject actualticketsJsonObj = new JSONObject();
		actualticketsJsonObj.put("_id", "13aafde0-81db-47fd-b1a2-94b0015803df");
		actualticketsJsonObj.put("url",
				"http://initech.tokoin.io.com/api/v2/tickets/13aafde0-81db-47fd-b1a2-94b0015803df.json");
		actualticketsJsonObj.put("external_id", "6161e938-50cc-4545-acff-a4f23649b7c3");
		actualticketsJsonObj.put("created_at", "2016-03-02T03:35:41 -11:00");
		actualticketsJsonObj.put("type", "task");
		actualticketsJsonObj.put("subject", "A Problem in Malawi");
		actualticketsJsonObj.put("description",
				"Lorem ipsum eiusmod pariatur enim. Qui aliquip voluptate cupidatat eiusmod aute velit non aute ullamco.");
		actualticketsJsonObj.put("priority", "urgent");
		actualticketsJsonObj.put("status", "solved");
		actualticketsJsonObj.put("submitter_id", 42);
		actualticketsJsonObj.put("assignee_id", 1);
		actualticketsJsonObj.put("organization_id", 122);
		actualticketsJsonObj.put("tags",
				new JSONArray(new Object[] { "New Mexico", "Nebraska", "Connecticut", "Arkansas" }));
		actualticketsJsonObj.put("has_incidents", false);
		actualticketsJsonObj.put("due_at", "2016-08-08T03:25:53 -10:00");
		actualticketsJsonObj.put("via", "voice");

		// value to be printed in the console
		PrintStream mockedPrintStream = Mockito.mock(PrintStream.class);
		System.setOut(mockedPrintStream);

		challenge.processMatchValuesForTickets(actualticketsJsonObj);

		String expectedExternalId = "external_id \t\t" + "6161e938-50cc-4545-acff-a4f23649b7c3";
		String expectedUrl = "url \t\t\t"
				+ "http://initech.tokoin.io.com/api/v2/tickets/13aafde0-81db-47fd-b1a2-94b0015803df.json";
		String expectedCreatedAt = "created_at \t\t" + "2016-03-02T03:35:41 -11:00";
		String expectedType = "type \t\t\t" + "task";
		String expectedSubject = "subject \t\t" + "A Problem in Malawi";
		String expectedDescription = "description \t\t"
				+ "Lorem ipsum eiusmod pariatur enim. Qui aliquip voluptate cupidatat eiusmod aute velit non aute ullamco.";
		String expectedPriority = "priority \t\t" + "urgent";
		String expectedStatus = "status \t\t\t" + "solved";
		String expectedTags = "tags \t\t\t" + "[\"New Mexico\",\"Nebraska\",\"Connecticut\",\"Arkansas\"]";
		String expectedHasIncidents = "has_incidents \t\t" + false;
		String expectedDueAt = "due_at \t\t\t" + "2016-08-08T03:25:53 -10:00";
		String expectedVia = "via \t\t\t" + "voice";

		Mockito.verify(mockedPrintStream).println(expectedExternalId);
		Mockito.verify(mockedPrintStream).println(expectedUrl);
		Mockito.verify(mockedPrintStream).println(expectedCreatedAt);
		Mockito.verify(mockedPrintStream).println(expectedType);
		Mockito.verify(mockedPrintStream).println(expectedSubject);
		Mockito.verify(mockedPrintStream).println(expectedDescription);
		Mockito.verify(mockedPrintStream).println(expectedPriority);
		Mockito.verify(mockedPrintStream).println(expectedStatus);
		Mockito.verify(mockedPrintStream).println(expectedTags);
		Mockito.verify(mockedPrintStream).println(expectedHasIncidents);
		Mockito.verify(mockedPrintStream).println(expectedDueAt);
		Mockito.verify(mockedPrintStream).println(expectedVia);

	}

	@SuppressWarnings({ "unchecked", "static-access" })
	@Test
	public void testProcessMatchValuesForOrganizations() throws JSONException {
		JSONObject actualOrganizationsJsonObj = new JSONObject();
		actualOrganizationsJsonObj.put("_id", 101);
		actualOrganizationsJsonObj.put("url", "http://initech.tokoin.io.com/api/v2/organizations/101.json");
		actualOrganizationsJsonObj.put("external_id", "9270ed79-35eb-4a38-a46f-35725197ea8d");
		actualOrganizationsJsonObj.put("name", "Enthaze");
		actualOrganizationsJsonObj.put("domain_names",
				new JSONArray(new Object[] { "kage.com", "ecratic.com", "endipin.com", "zentix.com" }));
		actualOrganizationsJsonObj.put("created_at", "2016-03-02T03:35:41 -11:00");
		actualOrganizationsJsonObj.put("details", "MegaCorp");
		actualOrganizationsJsonObj.put("shared_tickets", false);
		actualOrganizationsJsonObj.put("tags", new JSONArray(new Object[] { "Fulton", "West", "Rodriguez", "Farley" }));

		// value to be printed in the console
		PrintStream mockedPrintStream = Mockito.mock(PrintStream.class);
		System.setOut(mockedPrintStream);

		challenge.processMatchValuesForOrganizations(actualOrganizationsJsonObj);

		String expectedExternalId = "external_id \t\t" + "9270ed79-35eb-4a38-a46f-35725197ea8d";
		String expectedUrl = "url \t\t\t" + "http://initech.tokoin.io.com/api/v2/organizations/101.json";
		String expectedName = "name \t\t\t" + "Enthaze";
		String expectedDomainNames = "domain_names \t\t"
				+ "[\"kage.com\",\"ecratic.com\",\"endipin.com\",\"zentix.com\"]";
		String expectedCreatedAt = "created_at \t\t" + "2016-03-02T03:35:41 -11:00";
		String expectedDetails = "details \t\t" + "MegaCorp";
		String expectedSharedTickets = "shared_tickets \t\t" + false;
		String expectedTags = "tags \t\t\t" + "[\"Fulton\",\"West\",\"Rodriguez\",\"Farley\"]";

		Mockito.verify(mockedPrintStream).println(expectedExternalId);
		Mockito.verify(mockedPrintStream).println(expectedUrl);
		Mockito.verify(mockedPrintStream).println(expectedName);
		Mockito.verify(mockedPrintStream).println(expectedDomainNames);
		Mockito.verify(mockedPrintStream).println(expectedCreatedAt);
		Mockito.verify(mockedPrintStream).println(expectedDetails);
		Mockito.verify(mockedPrintStream).println(expectedSharedTickets);
		Mockito.verify(mockedPrintStream).println(expectedTags);

	}

	@SuppressWarnings({ "unchecked", "static-access" })
	@Test
	public void testDisplayOrganizationName() throws JSONException {
		JSONObject actualticketsJsonObj = new JSONObject();
		actualticketsJsonObj.put("_id", "13aafde0-81db-47fd-b1a2-94b0015803df");
		actualticketsJsonObj.put("url",
				"http://initech.tokoin.io.com/api/v2/tickets/13aafde0-81db-47fd-b1a2-94b0015803df.json");
		actualticketsJsonObj.put("external_id", "6161e938-50cc-4545-acff-a4f23649b7c3");
		actualticketsJsonObj.put("created_at", "2016-03-02T03:35:41 -11:00");
		actualticketsJsonObj.put("type", "task");
		actualticketsJsonObj.put("subject", "A Problem in Malawi");
		actualticketsJsonObj.put("description",
				"Lorem ipsum eiusmod pariatur enim. Qui aliquip voluptate cupidatat eiusmod aute velit non aute ullamco.");
		actualticketsJsonObj.put("priority", "urgent");
		actualticketsJsonObj.put("status", "solved");
		actualticketsJsonObj.put("submitter_id", 42);
		actualticketsJsonObj.put("assignee_id", 1);
		actualticketsJsonObj.put("organization_id", 122L);
		actualticketsJsonObj.put("tags",
				new JSONArray(new Object[] { "New Mexico", "Nebraska", "Connecticut", "Arkansas" }));
		actualticketsJsonObj.put("has_incidents", false);
		actualticketsJsonObj.put("due_at", "2016-08-08T03:25:53 -10:00");
		actualticketsJsonObj.put("via", "voice");

		JSONParser jsonParser = new JSONParser();

		// value to be printed in the console
		PrintStream mockedPrintStream = Mockito.mock(PrintStream.class);
		System.setOut(mockedPrintStream);

		// display organization name for tickets
		challenge.displayOrganizationName(jsonParser, actualticketsJsonObj);

		String expectedOrganizationName = "organization_name \t" + "Geekfarm";

		Mockito.verify(mockedPrintStream).println(expectedOrganizationName);

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
		actualUsersJsonObj.put("organization_id", 110L);
		actualUsersJsonObj.put("tags", new JSONArray(new Object[] { "Kieler", "Swartzville", "Salvo", "Guthrie" }));
		actualUsersJsonObj.put("suspended", false);
		actualUsersJsonObj.put("role", "agent");

		// display organization name for users
		challenge.displayOrganizationName(jsonParser, actualUsersJsonObj);

		String expectedOrganizationName1 = "organization_name \t" + "Kindaloo";

		Mockito.verify(mockedPrintStream).println(expectedOrganizationName1);

	}

}
