package com.search.challenge;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.json.JsonParser;

import com.search.challenge.constants.FileNames;
import com.search.challenge.constants.Messages;

@SpringBootApplication
public class ChallengeApplication {

	public static void printInstructionsOnSearch() {
		System.out.println(Messages.SELECT_SEARCH_OPTIONS);
		System.out.println(Messages.PRESS_ONE);
		System.out.println(Messages.PRESS_TWO);
		System.out.println(Messages.EXIT);
	}

	public static void processMatchValuesForUser(JSONObject usersJsonObject) {
		System.out.println("external_id \t\t" + usersJsonObject.get("external_id"));
		System.out.println("name \t\t\t" + usersJsonObject.get("name"));
		System.out.println("alias \t\t\t" + usersJsonObject.get("alias"));
		System.out.println("created_at \t\t" + usersJsonObject.get("created_at"));
		System.out.println("active \t\t\t" + usersJsonObject.get("active"));
		System.out.println("verified \t\t" + usersJsonObject.get("verified"));
		System.out.println("shared \t\t\t" + usersJsonObject.get("shared"));
		System.out.println("locale \t\t\t" + usersJsonObject.get("locale"));
		System.out.println("timezone \t\t" + usersJsonObject.get("timezone"));
		System.out.println("last_login_at \t\t" + usersJsonObject.get("last_login_at"));
		System.out.println("email \t\t\t" + usersJsonObject.get("email"));
		System.out.println("phone \t\t\t" + usersJsonObject.get("phone"));
		System.out.println("signature \t\t" + usersJsonObject.get("signature"));
		System.out.println("organization_id \t" + usersJsonObject.get("organization_id"));
		System.out.println("tags \t\t\t" + usersJsonObject.get("tags").toString().replace("\\/", "/"));
		System.out.println("suspended \t\t" + usersJsonObject.get("suspended"));
		System.out.println("role \t\t\t" + usersJsonObject.get("role"));
	}

	public static void processMatchValuesForTickets(JSONObject ticketsJsonObject) {
		System.out.println("external_id \t\t" + ticketsJsonObject.get("external_id"));
		System.out.println("url \t\t\t" + ticketsJsonObject.get("url"));
		System.out.println("created_at \t\t" + ticketsJsonObject.get("created_at"));
		System.out.println("type \t\t\t" + ticketsJsonObject.get("type"));
		System.out.println("subject \t\t" + ticketsJsonObject.get("subject"));
		System.out.println("description \t\t" + ticketsJsonObject.get("description"));
		System.out.println("priority \t\t" + ticketsJsonObject.get("priority"));
		System.out.println("status \t\t\t" + ticketsJsonObject.get("status"));
		System.out.println("tags \t\t\t" + ticketsJsonObject.get("tags").toString().replace("\\/", "/"));
		System.out.println("has_incidents \t\t" + ticketsJsonObject.get("has_incidents"));
		System.out.println("due_at \t\t\t" + ticketsJsonObject.get("due_at"));
		System.out.println("via \t\t\t" + ticketsJsonObject.get("via"));
	}

	public static void processMatchValuesForOrganizations(JSONObject organizationJsonObject) {
		System.out.println("external_id \t\t" + organizationJsonObject.get("external_id"));
		System.out.println("url \t\t\t" + organizationJsonObject.get("url"));
		System.out.println("name \t\t\t" + organizationJsonObject.get("name"));
		System.out.println("domain_names \t\t" + organizationJsonObject.get("domain_names"));
		System.out.println("created_at \t\t" + organizationJsonObject.get("created_at"));
		System.out.println("details \t\t" + organizationJsonObject.get("details"));
		System.out.println("shared_tickets \t\t" + organizationJsonObject.get("shared_tickets"));
		System.out.println("tags \t\t\t" + organizationJsonObject.get("tags"));
	}

	/**
	 * display organization name
	 * 
	 * @param jsonParser
	 * @param usersJsonObject
	 */
	public static void displayOrganizationName(JSONParser jsonParser, JSONObject usersOrTicketsJsonObject) {
		try (FileReader readerForOrganization = new FileReader(FileNames.ORGANIZATION_FILE)) {
			// Read JSON file
			Object organizationObj = jsonParser.parse(readerForOrganization);

			JSONArray organizationList = (JSONArray) organizationObj;
			for (int j = 0; j < organizationList.size(); j++) {
				JSONObject organizationJsonObject = (JSONObject) organizationList.get(j);
				if (usersOrTicketsJsonObject.get("organization_id") == organizationJsonObject.get("_id")) {
					System.out.println("organization_name \t" + organizationJsonObject.get("name"));
					break;
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	/**
	 * display assignee name
	 * 
	 * @param jsonParser
	 * @param ticketsJsonObject
	 */
	public static void displayAssigneeName(JSONParser jsonParser, JSONObject ticketsJsonObject) {
		try (FileReader readerForUser = new FileReader(FileNames.USER_FILE)) {
			// Read JSON file
			Object userObj = jsonParser.parse(readerForUser);

			JSONArray userList = (JSONArray) userObj;
			for (int j = 0; j < userList.size(); j++) {
				JSONObject userJsonObject = (JSONObject) userList.get(j);
				if (ticketsJsonObject.get("assignee_id") == userJsonObject.get("_id")) {
					System.out.println("assignee_name \t\t" + userJsonObject.get("name"));
					break;
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	/**
	 * display submitter name
	 * 
	 * @param jsonParser
	 * @param ticketsJsonObject
	 */
	public static void displaySubmitterName(JSONParser jsonParser, JSONObject ticketsJsonObject) {
		try (FileReader readerForUser = new FileReader(FileNames.USER_FILE)) {
			// Read JSON file
			Object userObj = jsonParser.parse(readerForUser);

			JSONArray userList = (JSONArray) userObj;
			for (int j = 0; j < userList.size(); j++) {
				JSONObject userJsonObject = (JSONObject) userList.get(j);
				if (ticketsJsonObject.get("submitter_id") == userJsonObject.get("_id")) {
					System.out.println("submitter_name \t\t" + userJsonObject.get("name"));
					break;
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	/**
	 * display user name
	 * 
	 * @param jsonParser
	 * @param ticketsJsonObject
	 */
	public static void displayUserName(JSONParser jsonParser, JSONObject organizationsJsonObject) {
		try (FileReader readerForUser = new FileReader(FileNames.USER_FILE)) {
			// Read JSON file
			Object userObj = jsonParser.parse(readerForUser);

			JSONArray userList = (JSONArray) userObj;
			for (int j = 0; j < userList.size(); j++) {
				JSONObject userJsonObject = (JSONObject) userList.get(j);
				if (organizationsJsonObject.get("_id") == userJsonObject.get("organization_id")) {
					System.out.println("user_name \t\t" + userJsonObject.get("name"));
					break;
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	/**
	 * display tickets subjects for users
	 * 
	 * @param jsonParser
	 * @param usersJsonObject
	 */
	public static void displayTicketsSubjectsForUsers(JSONParser jsonParser, JSONObject usersJsonObject) {
		try (FileReader readerForTickets = new FileReader(FileNames.TICKET_FILE)) {

			// initialize ticket subjects array list
			List<String> ticketsArrayList = new ArrayList<String>();

			// Read JSON file
			Object ticketsObj = jsonParser.parse(readerForTickets);

			JSONArray ticketsList = (JSONArray) ticketsObj;
			for (int j = 0; j < ticketsList.size(); j++) {
				JSONObject ticketJsonObject = (JSONObject) ticketsList.get(j);
				if (ticketJsonObject.get("submitter_id") == usersJsonObject.get("_id")) {
					ticketsArrayList.add(ticketJsonObject.get("subject").toString());
				}
			}

			for (int k = 0; k < ticketsArrayList.size(); k++) {
				System.out.println("ticket_" + k + "\t\t" + ticketsArrayList.get(k));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * display tickets subjects for organizations
	 * 
	 * @param jsonParser
	 * @param usersJsonObject
	 */
	public static void displayTicketsSubjectsForOrganizations(JSONParser jsonParser,
			JSONObject organizationJsonObject) {
		try (FileReader readerForTickets = new FileReader(FileNames.TICKET_FILE)) {

			// initialize ticket subjects array list
			List<String> ticketsArrayList = new ArrayList<String>();

			// Read JSON file
			Object ticketsObj = jsonParser.parse(readerForTickets);

			JSONArray ticketsList = (JSONArray) ticketsObj;
			for (int j = 0; j < ticketsList.size(); j++) {
				JSONObject ticketJsonObject = (JSONObject) ticketsList.get(j);
				if (ticketJsonObject.get("organization_id") == organizationJsonObject.get("_id")) {
					ticketsArrayList.add(ticketJsonObject.get("subject").toString());
				}
			}

			for (int k = 0; k < ticketsArrayList.size(); k++) {
				System.out.println("ticket_" + k + "\t\t" + ticketsArrayList.get(k));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// scanner object creation to get user input
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		System.out.println(Messages.EXIT_OR_CONTINUE);

		String userInput = input.nextLine();

		boolean isExecuted = false;

		// if user type quit
		if (userInput.equalsIgnoreCase(Messages.QUIT)) {
			return;
		} else {
			while (userInput.equalsIgnoreCase(Messages.ENTER) || !userInput.equalsIgnoreCase(Messages.QUIT)) {
				if (!userInput.equalsIgnoreCase(Messages.ENTER) && !userInput.equalsIgnoreCase(Messages.QUIT)
						&& !isExecuted) {
					System.out.print(Messages.INVALID_INPUT);
					userInput = input.nextLine();
					continue;
				}
				printInstructionsOnSearch();
				userInput = input.nextLine();

				while (userInput.equals(Messages.ONE) || userInput.equals(Messages.TWO)
						|| !userInput.equalsIgnoreCase(Messages.QUIT)) {
					if (userInput.equals(Messages.ONE)) {
						System.out.println(Messages.SELECT_JSON_FILE);
						userInput = input.nextLine();
						while (userInput.equals(Messages.ONE) || userInput.equals(Messages.ONE_WITH_BRACKET)
								|| userInput.equals(Messages.TWO) || userInput.equals(Messages.TWO_WITH_BRACKET)
								|| userInput.equals(Messages.THREE) || userInput.equals(Messages.THREE_WITH_BRACKET)
								|| !userInput.equalsIgnoreCase(Messages.QUIT)) {

							if (userInput.equals(Messages.ONE) || userInput.equals(Messages.ONE_WITH_BRACKET)) {
								System.out.println(Messages.SEARCH_TERM);
								userInput = input.nextLine();
								if (Arrays.stream(Messages.SEARCHABLE_USER_FIELDS_ARR).anyMatch(userInput::equals)) {
									System.out.println(Messages.SEARCH_VALUE);
									// get the search value from user
									String searchValue = input.nextLine();

									// Json Parser Object to parse and read the file
									JSONParser jsonParser = new JSONParser();

									try (FileReader reader = new FileReader(FileNames.USER_FILE)) {
										// Read JSON file
										Object obj = jsonParser.parse(reader);

										JSONArray userList = (JSONArray) obj;

										boolean isFound = false;

										for (int i = 0; i < userList.size(); i++) {
											JSONObject usersJsonObject = (JSONObject) userList.get(i);

											// if it's not a numerical input field
											if (!Arrays.stream(Messages.SEARCHABLE_USER_FIELDS_INT_ARR)
													.anyMatch(userInput::equals)) {
												String value = (String) usersJsonObject.get(userInput);

												if (searchValue.equals(value)) {
													isFound = true;
													processMatchValuesForUser(usersJsonObject);

													// display organization name
													displayOrganizationName(jsonParser, usersJsonObject);

													// display tickets subjects
													displayTicketsSubjectsForUsers(jsonParser, usersJsonObject);

													break;
												}
											} else { // if it's a numerical input field
												Long value = (Long) usersJsonObject.get(userInput);
												Long sValue = null;
												try {
													sValue = Long.parseLong(searchValue);
												} catch (Exception e) {
													System.out.println(Messages.NOT_NUMERIC);
													searchValue = input.nextLine();
													continue;
												}
												if (value == sValue) {
													isFound = true;
													processMatchValuesForUser(usersJsonObject);

													// display organization name
													displayOrganizationName(jsonParser, usersJsonObject);
													// display tickets subjects
													displayTicketsSubjectsForUsers(jsonParser, usersJsonObject);

													break;
												}
											}

										}

										if (!isFound) {
											System.out.println("Searching users for " + userInput + " with a value of "
													+ searchValue);
											System.out.println(Messages.NOT_FOUND);
											isExecuted = true;

											break;
										}

									} catch (FileNotFoundException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (ParseException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}

									isExecuted = true;

									break;
									
								} else {
									System.out.println(Messages.INVALID_SEARCH_TERM);
								}
							} else if (userInput.equals(Messages.TWO) || userInput.equals(Messages.TWO_WITH_BRACKET)) {
								System.out.println(Messages.SEARCH_TERM);
								userInput = input.nextLine();
								if (Arrays.stream(Messages.SEARCHABLE_TICKET_FIELDS_ARR).anyMatch(userInput::equals)) {
									System.out.println(Messages.SEARCH_VALUE);
									// get the search value from user
									String searchValue = input.nextLine();

									// Json Parser Object to parse and read the file
									JSONParser jsonParser = new JSONParser();

									try (FileReader ticketFileReader = new FileReader(FileNames.TICKET_FILE)) {
										// Read JSON file
										Object obj = jsonParser.parse(ticketFileReader);

										JSONArray ticketList = (JSONArray) obj;

										boolean isFound = false;

										for (int i = 0; i < ticketList.size(); i++) {
											JSONObject ticketsJsonObject = (JSONObject) ticketList.get(i);
											// if it's not a numerical input field
											if (!Arrays.stream(Messages.SEARCHABLE_TICKET_FIELDS_INT_ARR)
													.anyMatch(userInput::equals)) {
												String value = (String) ticketsJsonObject.get(userInput);

												if (searchValue.equals(value)) {
													isFound = true;
													processMatchValuesForTickets(ticketsJsonObject);

													// display assignee name
													displayAssigneeName(jsonParser, ticketsJsonObject);

													// display submitter name
													displaySubmitterName(jsonParser, ticketsJsonObject);

													// display organization names
													displayOrganizationName(jsonParser, ticketsJsonObject);

													break;
												}
											} else { // if it's a numerical input field
												Long value = (Long) ticketsJsonObject.get(userInput);
												Long sValue = null;
												try {
													sValue = Long.parseLong(searchValue);
												} catch (Exception e) {
													System.out.println(Messages.NOT_NUMERIC);
													searchValue = input.nextLine();
													continue;
												}
												if (value == sValue) {
													isFound = true;
													processMatchValuesForTickets(ticketsJsonObject);

													// display assignee name
													displayAssigneeName(jsonParser, ticketsJsonObject);

													// display submitter name
													displaySubmitterName(jsonParser, ticketsJsonObject);

													// display organization names
													displayOrganizationName(jsonParser, ticketsJsonObject);

													break;
												}
											}

										}

										if (!isFound) {
											System.out.println("Searching tickets for " + userInput
													+ " with a value of " + searchValue);
											System.out.println(Messages.NOT_FOUND);
											isExecuted = true;

											break;
										}

									} catch (FileNotFoundException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (ParseException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}

									isExecuted = true;

									break;

								} else {
									System.out.println(Messages.INVALID_SEARCH_TERM);
								}
							} else if (userInput.equals(Messages.THREE)
									|| userInput.equals(Messages.THREE_WITH_BRACKET)) {
								System.out.println(Messages.SEARCH_TERM);
								userInput = input.nextLine();
								if (Arrays.stream(Messages.SEARCHABLE_ORGANIZATION_FIELDS_ARR)
										.anyMatch(userInput::equals)) {
									System.out.println(Messages.SEARCH_VALUE);
									// get the search value from user
									String searchValue = input.nextLine();
									// Json Parser Object to parse and read the file
									JSONParser jsonParser = new JSONParser();
									try (FileReader OrganizationFileReader = new FileReader(
											FileNames.ORGANIZATION_FILE)) {
										// Read JSON file
										Object obj = jsonParser.parse(OrganizationFileReader);
										JSONArray organizationList = (JSONArray) obj;

										boolean isFound = false;

										for (int i = 0; i < organizationList.size(); i++) {
											JSONObject organizationJsonObject = (JSONObject) organizationList.get(i);
											// if it's not a numerical input field
											if (!Arrays.stream(Messages.SEARCHABLE_ORGANIZATION_FIELDS_INT_ARR)
													.anyMatch(userInput::equals)) {
												String value = (String) organizationJsonObject.get(userInput);
												if (searchValue.equals(value)) {
													isFound = true;
													processMatchValuesForOrganizations(organizationJsonObject);

													// display user name
													displayUserName(jsonParser, organizationJsonObject);

													// display ticket subjects for organizations
													displayTicketsSubjectsForOrganizations(jsonParser,
															organizationJsonObject);

													break;
												}
											} else { // if it's a numerical input field
												Long value = (Long) organizationJsonObject.get(userInput);
												Long sValue = null;
												try {
													sValue = Long.parseLong(searchValue);
												} catch (Exception e) {
													System.out.println(Messages.NOT_NUMERIC);
													searchValue = input.nextLine();
													continue;
												}
												if (value == sValue) {
													isFound = true;
													processMatchValuesForOrganizations(organizationJsonObject);

													// display user name
													displayUserName(jsonParser, organizationJsonObject);

													// display ticket subjects for organizations
													displayTicketsSubjectsForOrganizations(jsonParser,
															organizationJsonObject);

													break;
												}
											}

										}
										if (!isFound) {
											System.out.println("Searching organizations for " + userInput
													+ " with a value of " + searchValue);
											System.out.println(Messages.NOT_FOUND);
											isExecuted = true;

											break;
										}

									} catch (FileNotFoundException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (ParseException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									isExecuted = true;

									break;
									
								} else {
									System.out.println(Messages.INVALID_SEARCH_TERM);
								}
							} else if (!userInput.equalsIgnoreCase(Messages.QUIT)) {
								System.out.println(Messages.INVALID_SEARCH_OPTION);
								userInput = input.nextLine();
								continue;
							}

							break;
						}

						break;
						
					} else if (userInput.equals(Messages.TWO)) {
						System.out.print(Messages.SEARCHABLE_USER_FIELDS + Messages.SEARCHABLE_TICKET_FIELDS
								+ Messages.SEARCHABLE_ORGANIZATION_FIELDS + "\n");
						printInstructionsOnSearch();
						userInput = input.nextLine();
						continue;
						
					} else if (!userInput.equalsIgnoreCase(Messages.QUIT)) {
						System.out.println(Messages.INVALID_SEARCH_OPTION);
						userInput = input.nextLine();
						continue;
					}

				}
			}
		}

		SpringApplication.run(ChallengeApplication.class, args);
	}

}
