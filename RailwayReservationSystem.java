package railway_ticket_booking;

//package Project;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class RailwayReservationSystem {

	private static List<Ticket> tickets = new ArrayList<>();
	private static List<Customers> customers = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String user, name, address;
		int age, amt;
		long aadhar;
		long phone;

		System.out.print(
				"--------------------------------------------------------------------------------------------------------\n");
		System.out.println("		              Indian Railway Catering and Tourism Corporation");
		System.out.print(
				"--------------------------------------------------------------------------------------------------------\n");
		System.out.println("Welcome to IRCTC");

		System.out.print("Enter 1 for login!\n");
		System.out.print("Enter 2 for new registration!\n");
		System.out.print("Enter 3 to skip and continue!\n");
		System.out.println("Enter Choice: ");
		int choice = scanner.nextInt();
		scanner.nextLine(); // Consume newline character

		switch (choice) {
		case 1:
			System.out.print(
					"----------------------------------------------------------------------------------------------\n");
			System.out.println(
					"-------------------------------------- Login -------------------------------------------------");
			System.out.println("Enter username : ");
			user = scanner.nextLine();
			System.out.println("Enter password : ");
			String pass = scanner.nextLine();

			System.out.println("Redirecting to your account ");
			for (int i = 0; i <= 5; i++) {
				try {
					System.out.print(".");
					Thread.sleep(100);
				} catch (InterruptedException ie) {
				}
			}
			System.out.print(
					"\n--------------------------------------------------------------------------------------------\n");
			break;

		case 2:
			System.out.print(
					"----------------------------------------------------------------------------------------------\n");
			System.out.println("                                 New Registration");
			System.out.println(
					"\n" + "---------------------------------------------------------------------------------------\n");

			System.out.println("Enter your name: ");
			name = scanner.nextLine();
			System.out.println("Enter your age: ");
			age = scanner.nextInt();
			scanner.nextLine(); // Consume newline character
			System.out.println("Enter your address: ");
			address = scanner.nextLine();
			System.out.println("Enter your phone no: ");
			phone = scanner.nextLong(); // Use nextLong() to handle large phone numbers
			scanner.nextLine(); // Consume newline character
			System.out.println("Enter your Aadhar no: ");
			aadhar = scanner.nextLong();
			scanner.nextLine(); // Consume newline characters

			System.out.println("Would you like to add money to our wallet for one click payment (Enter Y/N): ");
			String opt = scanner.nextLine();
			if (opt.equals("Y")) {
				System.out.println("Enter amount to be added: ");
				amt = scanner.nextInt();
				if (amt >= 1500) {
					System.out.println("Enter your choice: ");
					System.out.println("Enter 1 for online \tEnter 2 for card payment \tEnter 3 to cancel ");
					choice = scanner.nextInt();
					scanner.nextLine(); // Consume the newline character
					switch (choice) {
					case 1:
						System.out.println("Enter UPI: ");
						String UPI = scanner.nextLine();
						System.out.print("Processing Payment");
						for (int i = 0; i <= 5; i++) {
							try {
								System.out.print(".");
								Thread.sleep(100);
							} catch (InterruptedException ie) {
							}
						}
						System.out.println("Amount had been successfully added to your wallet");
						break;
					case 2:
						System.out.println("Enter Card no: ");
						int card_no = scanner.nextInt();
						scanner.nextLine(); // Consume the newline character
						System.out.println("Enter Amount: ");
						System.out.print("Processing Payment");
						for (int i = 0; i <= 5; i++) {
							try {
								System.out.print(".");
								Thread.sleep(100);
								System.out.println();
							} catch (InterruptedException ie) {
							}
						}
						System.out.println("\nAmount had been successfully added to your wallet");
						break;

					default:
						System.out.println("Payment Cancelled");
						break;
					}
				} else {
					System.out.println("Please enter amount more than 1500 to add in wallet");
				}
			}
			Customers newCustomer = new Customers(name, age, address, phone, aadhar);
			customers.add(newCustomer);
			System.out.println(newCustomer);

			System.out.println("\nRegistration completed successfully!");
			System.out.println("Redirecting to your account ");
			for (int i = 0; i <= 5; i++) {
				try {
					System.out.print(".");
					Thread.sleep(100);
				} catch (InterruptedException ie) {
				}
			}
			System.out.println(
					"\n" + "--------------------------------------------------------------------------------------\n");
			break;

		default:
			break;

		}
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException ie) {
////            	System.out.println("Time out!");
//            }

		while (true) {
			System.out.print("-------------------------------------------------------------------------------\n");
			System.out.println("		 Indian Railway Catering and Tourism Corporation");
			System.out.print("-------------------------------------------------------------------------------\n");
			System.out.println("Train Ticket System Menu:");
			System.out.println("1. Display Account Details");
			System.out.println("2. Book Ticket");
			System.out.println("3. Edit Ticket");
			System.out.println("4. Cancel Ticket");
			System.out.println("5. Search Train");
			System.out.println("6. Display Tickets");
			System.out.println("7. Exit");

			System.out.print("Enter your choice: ");
			int ch = scanner.nextInt();

			switch (ch) {
			case 1:
				displayDetails();
				break;
			case 2:
				bookTicket();
				break;
			case 3:
				editTicket();
				break;
			case 4:
				cancelTicket();
				break;
			case 5:
				searchTrain();
				break;
			case 6:
				displayTickets();
				break;
			case 7:
				System.out.println("Exiting the program. Goodbye!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private static void displayDetails() {
		if (customers.isEmpty()) {
			System.out.println("No Accounts booked yet.");
		} else {
			System.out.println("Your Account Details:");
			for (int i = 0; i < customers.size(); i++) {
				Customers customer = customers.get(i);
				System.out.println("Account " + (i + 1) + ":");
				System.out.println("Name: " + customer.getName());
				System.out.println("Age: " + customer.getAge());
				System.out.println("Address: " + customer.getAddress());
				System.out.println("Phone: " + customer.getPhone());
				System.out.println("Aadhar: " + customer.getAadhar());
				System.out.println();
			}
		}
	}

	private static void bookTicket() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Book Ticket:");

		System.out.println("Are you booking ticket for yourself (Y/N): ");
		String op = scanner.nextLine();

		if (op.equals("Y")) {
//        	customers.get(0);
			// Assume customerName and customerAge are variables containing the customer
			// information
			
			System.out.println("Name  :  "+Customers.getSavedName());
			System.out.println("Age   :  "+Customers.getSavedAge());
			
			System.out.print("Enter date (dd-MM-yyyy): ");
			String dateStr = scanner.nextLine();
			System.out.print("Enter boarding place: ");
			String boardingPlace = scanner.nextLine();
			System.out.print("Enter destination place: ");
			String destinationPlace = scanner.nextLine();

			String combinedInput = boardingPlace.toLowerCase() + "-" + destinationPlace.toLowerCase();
			System.out.println("-----------------Available trains----------------------");
			if (combinedInput.equals("amravati-pune")) {
				String[] train = { "Garibrath Express", "Azad-Hind Express", "Pune-Nagpur SF Express" };

				System.out.println("0. Garibrath Express");
				System.out.println("1. Azad-Hind Express");
				System.out.println("2. Pune-Nagpur SF Express");
//                    System.out.println("\n"+ "--------------------------------------------------\n");
				System.out.println(
						"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
				int ticket = scanner.nextInt();
				System.out.println("Ticket for " + train[ticket] + " has been reserved !");
			} else if (combinedInput.equals("amravati-mumbai")) {
				String[] train = { "Amravati-Mumbai Amba Express", "Hawla Express", "Doronto Express" };
				System.out.println("0. Amravati-Mumbai Amba Express");
				System.out.println("1. Hawla Express");
				System.out.println("2. Doronto Express");
//                System.out.println("\n"+ "--------------------------------------------------\n");
				System.out.println(
						"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
				int ticket = scanner.nextInt();
				System.out.println("Ticket for " + train[ticket] + " has been reserved !");

			} else if (combinedInput.equals("pune-mumbai")) {
				String[] train = { "Pune-Mumbai Deccan Queen", "Mumbai-Pune Intercity Expres", "Sinhagad Express" };
				System.out.println("0. Pune-Mumbai Deccan Queen");
				System.out.println("1. Mumbai-Pune Intercity Express");
				System.out.println("2. Sinhagad Express");
				System.out.println(
						"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
				int ticket = scanner.nextInt();
				System.out.println("Ticket for " + train[ticket] + " has been reserved !");
			}

			else if (combinedInput.equals("nagpur-mumbai")) {
				String[] train = { "Vidarbha Express", "Maharashtra Sampark Kranti Express",
						"Nagpur-Mumbai Duronto Express" };
				System.out.println("1. Vidarbha Express");
				System.out.println("2. Maharashtra Sampark Kranti Express");
				System.out.println("3. Nagpur-Mumbai Duronto Express");
				System.out.println(
						"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
				int ticket = scanner.nextInt();
				System.out.println("Ticket for " + train[ticket] + " has been reserved !");
			}

			else if (combinedInput.equals("delhi-kolkata")) {
				String[] train = { "Rajdhani Express", "Duronto Express", "Shatabdi Express" };

				System.out.println("0. Rajdhani Express");
				System.out.println("1. Duronto Express");
				System.out.println("2. Shatabdi Express");
				System.out.println(
						"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
				int ticket = scanner.nextInt();
				System.out.println("Ticket for " + train[ticket] + " has been reserved !");
			}

			else if (combinedInput.equals("bangalore-chennai")) {
				String[] train = { "Bangalore-Chennai Express", "Bangalore-Chennai Shatabdi", "Chennai Mail" };
				System.out.println("0. Bangalore-Chennai Express");
				System.out.println("1. Bangalore-Chennai Shatabdi");
				System.out.println("2. Chennai Mail");
				System.out.println(
						"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
				int ticket = scanner.nextInt();
				System.out.println("Ticket for " + train[ticket] + " has been reserved !");
			}

			else if (combinedInput.equals("delhi-mumbai")) {
				String[] train = { "Rajdhani Express", "Duronto Express", "Garib Rath Express" };

				System.out.println("0. Rajdhani Express");
				System.out.println("1. Duronto Express");
				System.out.println("2. Garib Rath Express");
				System.out.println(
						"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
				int ticket = scanner.nextInt();
				System.out.println("Ticket for " + train[ticket] + " has been reserved !");
			}

			else if (combinedInput.equals("chennai-hyderabad")) {
				String[] train = { "Charminar Express", "Chennai Express", "Hyderabad Express" };

				System.out.println("0. Charminar Express");
				System.out.println("1. Chennai Express");
				System.out.println("2. Hyderabad Express");
				System.out.println(
						"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
				int ticket = scanner.nextInt();
				System.out.println("Ticket for " + train[ticket] + " has been reserved !");
//                    break;
			}

			else if (combinedInput.equals("kolkata-bangalore")) {
				String[] train = { "Howrah Express", "Kolkata-Bangalore Mail", "Kaveri Express" };

				System.out.println("0. Howrah Express");
				System.out.println("1. Kolkata-Bangalore Mail");
				System.out.println("2. Kaveri Express");
				System.out.println(
						"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
				int ticket = scanner.nextInt();
				System.out.println("Ticket for " + train[ticket] + " has been reserved !");
			}

			else if (combinedInput.equals("lucknow-jaipur")) {
				String[] train = { "Lucknow-Jaipur Express", "Pink City Express", "Udaipur Express" };

				System.out.println("0. Lucknow-Jaipur Express");
				System.out.println("1. Pink City Express");
				System.out.println("2. Udaipur Express");
				System.out.println(
						"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
				int ticket = scanner.nextInt();
				System.out.println("Ticket for " + train[ticket] + " has been reserved !");
			}

			else if (combinedInput.equals("mumbai-ahmedabad")) {
				String[] train = { "Mumbai-Ahmedabad Shatabdi Express", "Chennai Express", "Hyderabad Express" };

				System.out.println("0. Mumbai-Ahmedabad Shatabdi Express");
				System.out.println("1. Karnavati Express");
				System.out.println("2. Gujarat Mail");
				System.out.println(
						"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
				int ticket = scanner.nextInt();
				System.out.println("Ticket for " + train[ticket] + " has been reserved !");
			}

			else if (combinedInput.equals("hyderabad-bangalore")) {
				String[] train = { "Hyderabad-Bangalore Rajdhani Express", "Chennai Express", "Hyderabad Express" };

				System.out.println("0. Hyderabad-Bangalore Rajdhani Express");
				System.out.println("1. Kacheguda Express");
				System.out.println("2. Bangalore-Hyderabad Express");
				System.out.println(
						"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
				int ticket = scanner.nextInt();
				System.out.println("Ticket for " + train[ticket] + " has been reserved !");
			}

			else if (combinedInput.equals("jaipur-delhi")) {
				String[] train = { "Jaipur-Delhi Double Decker Express", "Pink City Superfast Express",
						"Delhi-Jaipur Duronto Express" };

				System.out.println("0. Jaipur-Delhi Double Decker Express");
				System.out.println("1. Pink City Superfast Express");
				System.out.println("2. Delhi-Jaipur Duronto Express");
				System.out.println(
						"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
				int ticket = scanner.nextInt();
				System.out.println("Ticket for " + train[ticket] + " has been reserved !");
			}

			else if (combinedInput == "chennai-mumbai") {
				String[] train = { "Chennai-Mumbai Express", "Mumbai-Chennai Central Express", "Mumbai Mail" };
				System.out.println("0. Chennai-Mumbai Express");
				System.out.println("1. Mumbai-Chennai Central Express");
				System.out.println("2. Mumbai Mail");
				System.out.println(
						"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
				int ticket = scanner.nextInt();
				System.out.println("Ticket for " + train[ticket] + " has been reserved !");
			}

			else if (combinedInput.equals("kolkata-delhi")) {
				String[] train = { "Howrah-Delhi Rajdhani Express", "Kolkata-Delhi Duronto Express",
						"Purushottam Express" };

				System.out.println("0. Howrah-Delhi Rajdhani Express");
				System.out.println("1. Kolkata-Delhi Duronto Express");
				System.out.println("2. Purushottam Express");
				System.out.println(
						"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
				int ticket = scanner.nextInt();
				System.out.println("Ticket for " + train[ticket] + " has been reserved !");
			} else {
				System.out.println("No trains available for the specified route.");
			}

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

			try {
				Date date = dateFormat.parse(dateStr);
				String name = Customers.getSavedName();
				int age = Customers.getSavedAge();
				Ticket newTicket = new Ticket(name, age, date, boardingPlace, destinationPlace);
				tickets.add(newTicket);
				
				System.out.println("\nTicket booked successfully!");
			} catch (Exception e) {
				System.out.println("Error parsing date or time. Please check the format and try again.");
			}

		}
		
		
		else {
		System.out.print("Enter name: ");
		String name = scanner.nextLine();
		System.out.print("Enter age: ");
		int age = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter date (dd-MM-yyyy): ");
		String dateStr = scanner.nextLine();
		System.out.print("Enter boarding place: ");
		String boardingPlace = scanner.nextLine();
		System.out.print("Enter destination place: ");
		String destinationPlace = scanner.nextLine();

		String combinedInput = boardingPlace.toLowerCase() + "-" + destinationPlace.toLowerCase();
		System.out.println("-----------------Available trains----------------------");
		if (combinedInput.equals("amravati-pune")) {
			String[] train = { "Garibrath Express", "Azad-Hind Express", "Pune-Nagpur SF Express" };

			System.out.println("0. Garibrath Express");
			System.out.println("1. Azad-Hind Express");
			System.out.println("2. Pune-Nagpur SF Express");
//                System.out.println("\n"+ "--------------------------------------------------\n");
			System.out.println(
					"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
			int ticket = scanner.nextInt();
			System.out.println("Ticket for " + train[ticket] + " has been reserved !");
		} else if (combinedInput.equals("amravati-mumbai")) {
			String[] train = { "Amravati-Mumbai Amba Express", "Hawla Express", "Doronto Express" };
			System.out.println("0. Amravati-Mumbai Amba Express");
			System.out.println("1. Hawla Express");
			System.out.println("2. Doronto Express");
//            System.out.println("\n"+ "--------------------------------------------------\n");
			System.out.println(
					"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
			int ticket = scanner.nextInt();
			System.out.println("Ticket for " + train[ticket] + " has been reserved !");

		} else if (combinedInput.equals("pune-mumbai")) {
			String[] train = { "Pune-Mumbai Deccan Queen", "Mumbai-Pune Intercity Expres", "Sinhagad Express" };
			System.out.println("0. Pune-Mumbai Deccan Queen");
			System.out.println("1. Mumbai-Pune Intercity Express");
			System.out.println("2. Sinhagad Express");
			System.out.println(
					"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
			int ticket = scanner.nextInt();
			System.out.println("Ticket for " + train[ticket] + " has been reserved !");
		}

		else if (combinedInput.equals("nagpur-mumbai")) {
			String[] train = { "Vidarbha Express", "Maharashtra Sampark Kranti Express",
					"Nagpur-Mumbai Duronto Express" };
			System.out.println("1. Vidarbha Express");
			System.out.println("2. Maharashtra Sampark Kranti Express");
			System.out.println("3. Nagpur-Mumbai Duronto Express");
			System.out.println(
					"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
			int ticket = scanner.nextInt();
			System.out.println("Ticket for " + train[ticket] + " has been reserved !");
		}

		else if (combinedInput.equals("delhi-kolkata")) {
			String[] train = { "Rajdhani Express", "Duronto Express", "Shatabdi Express" };

			System.out.println("0. Rajdhani Express");
			System.out.println("1. Duronto Express");
			System.out.println("2. Shatabdi Express");
			System.out.println(
					"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
			int ticket = scanner.nextInt();
			System.out.println("Ticket for " + train[ticket] + " has been reserved !");
		}

		else if (combinedInput.equals("bangalore-chennai")) {
			String[] train = { "Bangalore-Chennai Express", "Bangalore-Chennai Shatabdi", "Chennai Mail" };
			System.out.println("0. Bangalore-Chennai Express");
			System.out.println("1. Bangalore-Chennai Shatabdi");
			System.out.println("2. Chennai Mail");
			System.out.println(
					"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
			int ticket = scanner.nextInt();
			System.out.println("Ticket for " + train[ticket] + " has been reserved !");
		}

		else if (combinedInput.equals("delhi-mumbai")) {
			String[] train = { "Rajdhani Express", "Duronto Express", "Garib Rath Express" };

			System.out.println("0. Rajdhani Express");
			System.out.println("1. Duronto Express");
			System.out.println("2. Garib Rath Express");
			System.out.println(
					"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
			int ticket = scanner.nextInt();
			System.out.println("Ticket for " + train[ticket] + " has been reserved !");
		}

		else if (combinedInput.equals("chennai-hyderabad")) {
			String[] train = { "Charminar Express", "Chennai Express", "Hyderabad Express" };

			System.out.println("0. Charminar Express");
			System.out.println("1. Chennai Express");
			System.out.println("2. Hyderabad Express");
			System.out.println(
					"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
			int ticket = scanner.nextInt();
			System.out.println("Ticket for " + train[ticket] + " has been reserved !");
//                break;
		}

		else if (combinedInput.equals("kolkata-bangalore")) {
			String[] train = { "Howrah Express", "Kolkata-Bangalore Mail", "Kaveri Express" };

			System.out.println("0. Howrah Express");
			System.out.println("1. Kolkata-Bangalore Mail");
			System.out.println("2. Kaveri Express");
			System.out.println(
					"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
			int ticket = scanner.nextInt();
			System.out.println("Ticket for " + train[ticket] + " has been reserved !");
		}

		else if (combinedInput.equals("lucknow-jaipur")) {
			String[] train = { "Lucknow-Jaipur Express", "Pink City Express", "Udaipur Express" };

			System.out.println("0. Lucknow-Jaipur Express");
			System.out.println("1. Pink City Express");
			System.out.println("2. Udaipur Express");
			System.out.println(
					"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
			int ticket = scanner.nextInt();
			System.out.println("Ticket for " + train[ticket] + " has been reserved !");
		}

		else if (combinedInput.equals("mumbai-ahmedabad")) {
			String[] train = { "Mumbai-Ahmedabad Shatabdi Express", "Chennai Express", "Hyderabad Express" };

			System.out.println("0. Mumbai-Ahmedabad Shatabdi Express");
			System.out.println("1. Karnavati Express");
			System.out.println("2. Gujarat Mail");
			System.out.println(
					"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
			int ticket = scanner.nextInt();
			System.out.println("Ticket for " + train[ticket] + " has been reserved !");
		}

		else if (combinedInput.equals("hyderabad-bangalore")) {
			String[] train = { "Hyderabad-Bangalore Rajdhani Express", "Chennai Express", "Hyderabad Express" };

			System.out.println("0. Hyderabad-Bangalore Rajdhani Express");
			System.out.println("1. Kacheguda Express");
			System.out.println("2. Bangalore-Hyderabad Express");
			System.out.println(
					"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
			int ticket = scanner.nextInt();
			System.out.println("Ticket for " + train[ticket] + " has been reserved !");
		}

		else if (combinedInput.equals("jaipur-delhi")) {
			String[] train = { "Jaipur-Delhi Double Decker Express", "Pink City Superfast Express",
					"Delhi-Jaipur Duronto Express" };

			System.out.println("0. Jaipur-Delhi Double Decker Express");
			System.out.println("1. Pink City Superfast Express");
			System.out.println("2. Delhi-Jaipur Duronto Express");
			System.out.println(
					"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
			int ticket = scanner.nextInt();
			System.out.println("Ticket for " + train[ticket] + " has been reserved !");
		}

		else if (combinedInput == "chennai-mumbai") {
			String[] train = { "Chennai-Mumbai Express", "Mumbai-Chennai Central Express", "Mumbai Mail" };
			System.out.println("0. Chennai-Mumbai Express");
			System.out.println("1. Mumbai-Chennai Central Express");
			System.out.println("2. Mumbai Mail");
			System.out.println(
					"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
			int ticket = scanner.nextInt();
			System.out.println("Ticket for " + train[ticket] + " has been reserved !");
		}

		else if (combinedInput.equals("kolkata-delhi")) {
			String[] train = { "Howrah-Delhi Rajdhani Express", "Kolkata-Delhi Duronto Express",
					"Purushottam Express" };

			System.out.println("0. Howrah-Delhi Rajdhani Express");
			System.out.println("1. Kolkata-Delhi Duronto Express");
			System.out.println("2. Purushottam Express");
			System.out.println(
					"Which train would you like to book (to choose pls enter the no associated with the train before its name): ");
			int ticket = scanner.nextInt();
			System.out.println("Ticket for " + train[ticket] + " has been reserved !");
		} else {
			System.out.println("No trains available for the specified route.");
		}
		

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		try {
			Date date = dateFormat.parse(dateStr);

			Ticket newTicket = new Ticket(name, age, date, boardingPlace, destinationPlace);
			tickets.add(newTicket);

			System.out.println("\nTicket booked successfully!");
		} catch (Exception e) {
			System.out.println("Error parsing date or time. Please check the format and try again.");
		}
		}
	}

	private static void editTicket() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter ticket number to edit: ");
		int ticketNumber = scanner.nextInt();

		if (ticketNumber >= 1 && ticketNumber <= tickets.size()) {
			Ticket ticketToEdit = tickets.get(ticketNumber - 1);

			System.out.println("Edit Ticket:");

			System.out.print("Enter new name: ");
			String newName = scanner.nextLine();
			if (!newName.isEmpty()) {
				ticketToEdit.setName(newName);
			}

			System.out.print("Enter new age: ");
			int newAge = scanner.nextInt();
			if (newAge > 0) {
				ticketToEdit.setAge(newAge);
			}

			scanner.nextLine();

			System.out.print("Enter new date (dd-MM-yyyy): ");
			String newDateStr = scanner.nextLine();
			if (!newDateStr.isEmpty()) {
				try {
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
					Date newDate = dateFormat.parse(newDateStr);
					ticketToEdit.setDate(newDate);
				} catch (Exception e) {
					System.out.println("Error parsing date. Please check the format and try again.");
				}
			}

			System.out.print("Enter new boarding place: ");
			String newBoardingPlace = scanner.nextLine();
			if (!newBoardingPlace.isEmpty()) {
				ticketToEdit.setBoardingPlace(newBoardingPlace);
			}

			System.out.print("Enter new destination place: ");
			String newDestinationPlace = scanner.nextLine();
			if (!newDestinationPlace.isEmpty()) {
				ticketToEdit.setDestinationPlace(newDestinationPlace);
			}

			System.out.println("\nTicket edited successfully:\n" + ticketToEdit);
		} else {
			System.out.println("Invalid ticket number. Please try again.");
		}
	}

	private static void cancelTicket() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter ticket number to cancel: ");
		int ticketNumber = scanner.nextInt();

		if (ticketNumber >= 1 && ticketNumber <= tickets.size()) {
			Ticket ticketToCancel = tickets.remove(ticketNumber - 1);
			System.out.println("Ticket canceled successfully:\n" + ticketToCancel);
		} else {
			System.out.println("Invalid ticket number. Please try again.");
		}
	}

	private static void searchTrain() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter source: ");
		String source = scanner.nextLine().trim(); // Trim the input string
		System.out.println("Enter destination: ");
		String destination = scanner.nextLine().trim();
		System.out.println("Enter date: ");
		String date = scanner.nextLine();

		System.out.println("Search Results:");

		String combinedInput = source.toLowerCase() + "-" + destination.toLowerCase();
		System.out.println("-----------------Available trains----------------------");
		switch (combinedInput) {
		case "amravati-pune":
			System.out.println("1. Garibrath Express");
			System.out.println("2. Azad-Hind Express");
			System.out.println("3. Pune-Nagpur SF Express");
			System.out.println("\n" + "--------------------------------------------------\n");

			break;
		case "amravati-mumbai":
			System.out.println("1. Amravati-Mumbai Amba Express");
			System.out.println("2. Hawla Express");
			System.out.println("3. Doronto Express");
			System.out.println("\n" + "--------------------------------------------------\n");

			break;
		case "pune-mumbai":
			System.out.println("1. Pune-Mumbai Deccan Queen");
			System.out.println("2. Mumbai-Pune Intercity Express");
			System.out.println("3. Sinhagad Express");
			System.out.println("\n" + "--------------------------------------------------\n");

			break;
		case "nagpur-mumbai":
			System.out.println("1. Vidarbha Express");
			System.out.println("2. Maharashtra Sampark Kranti Express");
			System.out.println("3. Nagpur-Mumbai Duronto Express");
			System.out.println("\n" + "--------------------------------------------------\n");

			break;
		case "delhi-kolkata":
			System.out.println("1. Rajdhani Express");
			System.out.println("2. Duronto Express");
			System.out.println("3. Shatabdi Express");
			System.out.println("\n" + "--------------------------------------------------\n");

			break;
		case "bangalore-chennai":
			System.out.println("1. Bangalore-Chennai Express");
			System.out.println("2. Bangalore-Chennai Shatabdi");
			System.out.println("3. Chennai Mail");
			System.out.println("\n" + "--------------------------------------------------\n");

			break;
		case "delhi-mumbai":
			System.out.println("1. Rajdhani Express");
			System.out.println("2. Duronto Express");
			System.out.println("3. Garib Rath Express");
			System.out.println("\n" + "--------------------------------------------------\n");

			break;
		case "chennai-hyderabad":
			System.out.println("1. Charminar Express");
			System.out.println("2. Chennai Express");
			System.out.println("3. Hyderabad Express");
			System.out.println("\n" + "--------------------------------------------------\n");

			break;
		case "kolkata-bangalore":
			System.out.println("1. Howrah Express");
			System.out.println("2. Kolkata-Bangalore Mail");
			System.out.println("3. Kaveri Express");
			System.out.println("\n" + "--------------------------------------------------\n");

			break;
		case "ahmedabad-surat":
			System.out.println("1. Ahmedabad-Surat Intercity");
			System.out.println("2. Saurashtra Express");
			System.out.println("3. Gujarat Express");
			System.out.println("\n" + "--------------------------------------------------\n");

			break;
		case "lucknow-jaipur":
			System.out.println("1. Lucknow-Jaipur Express");
			System.out.println("2. Pink City Express");
			System.out.println("3. Udaipur Express");
			System.out.println("\n" + "--------------------------------------------------\n");

			break;
		case "mumbai-ahmedabad":
			System.out.println("1. Mumbai-Ahmedabad Shatabdi Express");
			System.out.println("2. Karnavati Express");
			System.out.println("3. Gujarat Mail");
			System.out.println("\n" + "--------------------------------------------------\n");

			break;
		case "hyderabad-bangalore":
			System.out.println("1. Hyderabad-Bangalore Rajdhani Express");
			System.out.println("2. Kacheguda Express");
			System.out.println("3. Bangalore-Hyderabad Express");
			break;
		case "jaipur-delhi":
			System.out.println("1. Jaipur-Delhi Double Decker Express");
			System.out.println("2. Pink City Superfast Express");
			System.out.println("3. Delhi-Jaipur Duronto Express");
			System.out.println("\n" + "--------------------------------------------------\n");

			break;
		case "chennai-mumbai":
			System.out.println("1. Chennai-Mumbai Express");
			System.out.println("2. Mumbai-Chennai Central Express");
			System.out.println("3. Mumbai Mail");
			System.out.println("\n" + "--------------------------------------------------\n");

			break;
		case "kolkata-delhi":
			System.out.println("1. Howrah-Delhi Rajdhani Express");
			System.out.println("2. Kolkata-Delhi Duronto Express");
			System.out.println("3. Purushottam Express");
			System.out.println("\n" + "--------------------------------------------------\n");

			break;
		// Add more cases and corresponding trains as needed
		default:
			System.out.println("No trains available for the specified route.");
			break;
		}

	}

	private static void displayTickets() {
		if (tickets.isEmpty()) {
			System.out.println("No tickets booked yet.");
		} else {
			System.out.println("All Booked Tickets:");
			for (int i = 0; i < tickets.size(); i++) {
				System.out.println("Ticket " + (i + 1) + ":\n" + tickets.get(i) + "\n");
			}
		}
	}

//         Ticket class to store ticket details.
	private static class Ticket {
		private String name;
		private int age;
		private Date date;

		private String boardingPlace;
		private String destinationPlace;

		public Ticket(String name, int age, Date date, String boardingPlace, String destinationPlace) {
			this.name = name;
			this.age = age;
			this.date = date;
			this.boardingPlace = boardingPlace;
			this.destinationPlace = destinationPlace;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public String getBoardingPlace() {
			return boardingPlace;
		}

		public void setBoardingPlace(String boardingPlace) {
			this.boardingPlace = boardingPlace;
		}

		public String getDestinationPlace() {
			return destinationPlace;
		}

		public void setDestinationPlace(String destinationPlace) {
			this.destinationPlace = destinationPlace;
		}

		public String toString() {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			return "Name: " + name + "\nAge: " + age + "\nDate: " + dateFormat.format(date) + "\nBoarding Place: "
					+ boardingPlace + "\nDestination Place: " + destinationPlace;
		}
	}

}

class Customers {
	private String name;
	private int age;
	private String address;
	private long phone;
	private long aadhar;
	private static String savedName;
	private static int savedAge;

	// Constructor
	public Customers(String name, int age, String address, long phone, long aadhar) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.phone = phone;
		this.aadhar = aadhar;
		Customers.savedAge=age;
		Customers.savedName=name;
	}

	// Getters
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public long getPhone() {
		return phone;
	}

	public long getAadhar() {
		return aadhar;
	}
	public static String getSavedName() {
		return savedName;
	}
	public static int getSavedAge() {
		return savedAge;
	}
}
