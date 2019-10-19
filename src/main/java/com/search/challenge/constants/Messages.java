package com.search.challenge.constants;

/**
 * This class is to define Messages as constants
 * 
 * @author SajithChamara
 *
 */
public final class Messages {

	private Messages() {
		// avoid creating objects
	}

	public static final String EXIT_OR_CONTINUE = "Type 'quit' to exit at any time, Press 'Enter' to continue \n";
	public static final String SELECT_SEARCH_OPTIONS = "\t Select search options:";
	public static final String PRESS_ONE = "\t  \u2219 Press 1 to search";
	public static final String PRESS_TWO = "\t  \u2219 Press 2 to view a list of searchable fields";
	public static final String EXIT = "\t  \u2219 Type 'quit' to exit";
	public static final String QUIT = "quit";
	public static final String ENTER = "";
	public static final String INVALID_INPUT = "Sorry! You entered an invalid input. " + EXIT_OR_CONTINUE;
	public static final String INVALID_SEARCH_OPTION = "Sorry! You entered an invalid search option. Please enter a valid option given above to continue";
	public static final String INVALID_SEARCH_TERM = "Invalid Search Term";
	public static final String ONE = "1";
	public static final String ONE_WITH_BRACKET = "1)";
	public static final String TWO = "2";
	public static final String TWO_WITH_BRACKET = "2)";
	public static final String THREE = "3";
	public static final String THREE_WITH_BRACKET = "3)";
	public static final String SELECT_JSON_FILE = "Select 1) Users or 2) Tickets or 3) Organizations";
	public static final String SEARCHABLE_USER_FIELDS = "============================================== \n "
			+ "Search Users with " + "\n _id" + "\n url" + "\n external_id" + "\n name" + "\n alias" + "\n created_at"
			+ "\n active" + "\n verified" + "\n shared" + "\n locale" + "\n timezone" + "\n last_login_at" + "\n email"
			+ "\n phone" + "\n signature" + "\n organization_id" + "\n tags" + "\n suspended" + "\n role" + "\n";
	public static final String SEARCHABLE_TICKET_FIELDS = "============================================== \n "
			+ "Search Tickets with " + "\n _id" + "\n url" + "\n external_id" + "\n type" + "\n subject"
			+ "\n description" + "\n priority" + "\n status" + "\n submitter_id" + "\n assignee_id"
			+ "\n organization_id" + "\n tags" + "\n has_incidents" + "\n due_at" + "\n via" + "\n";
	public static final String SEARCHABLE_ORGANIZATION_FIELDS = "============================================== \n "
			+ "Search Organizations with " + "\n _id" + "\n url" + "\n external_id" + "\n name" + "\n domain_names"
			+ "\n created_at" + "\n details" + "\n shared_tickets" + "\n tags" + "\n";
	public static final String SEARCH_TERM = "Enter Search Term";
	public static final String SEARCH_VALUE = "Enter Search Value";
	public static final String SEARCHABLE_USER_FIELDS_ARR[] = { "_id", "url", "external_id", "name", "alias",
			"created_at", "active", "verified", "shared", "locale", "timezone", "last_login_at", "email", "phone",
			"signature", "organization_id", "tags", "suspended", "role" };
	public static final String SEARCHABLE_TICKET_FIELDS_ARR[] = { "_id", "url", "external_id", "type", "subject",
			"description", "priority", "status", "submitter_id", "assignee_id", "organization_id", "tags",
			"has_incidents", "due_at", "via" };
	public static final String SEARCHABLE_ORGANIZATION_FIELDS_ARR[] = { "_id", "url", "external_id", "name",
			"domain_names", "created_at", "details", "status", "shared_tickets", "tags" };
	public static final String SEARCHABLE_USER_FIELDS_INT_ARR[] = { "_id", "organization_id" };
	public static final String SEARCHABLE_ORGANIZATION_FIELDS_INT_ARR[] = { "_id" };
	public static final String SEARCHABLE_TICKET_FIELDS_INT_ARR[] = { "submitter_id", "assignee_id", "organization_id" };
	public static final String NOT_FOUND = "No results found";
	public static final String NOT_NUMERIC = "Please insert a numerical value";
}
