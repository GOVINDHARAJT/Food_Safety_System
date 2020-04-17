package controller;
import java.util.*;

import dao.*;
import model.*;
import service.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
class FirstClass {
//Food Functions	
	void food() {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("1.Add food items");
			System.out.println("2.Delete food items");
			System.out.println("3.Update food items");
			System.out.println("4.View all food items");
			System.out.println("5.View expired food items");
			System.out.println("6.Exit");
			System.out.println("\nWhich Action You want to Perform?(1-6)");
			System.out.println("*----------------------------------------*");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			FoodDAO fooddao = new FoodDAO();
			FoodDisplay fooddisplay = new FoodDisplay();
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					System.out.println("*----------------------------------------*");
					System.out.println("            Enter Food Details            ");
					System.out.println("*----------------------------------------*");
					System.out.print("Enter Food ID : ");
					int food_id = sc.nextInt();
					System.out.print("Enter Food Type : ");
					String food_type = sc.next();
					System.out.print("Enter Food Name : ");
					String food_name = sc.next();
					System.out.print("Enter Food M.F.Date(DD-MM-YYYY) : ");
					String mdate = sc.next();
				    LocalDate m_f_date = LocalDate.parse(mdate, formatter);
					System.out.print("Enter Food Expiry Date(DD-MM-YYYY) : ");
					String edate = sc.next();
					LocalDate expiry_date = LocalDate.parse(edate, formatter);
	
					Food food = new Food(food_id,food_type,food_name,m_f_date,expiry_date);
					fooddao.insertFood(food);
					System.out.println("*----------------------------------------*");
					break;
				case 2:
					System.out.println("*----------------------------------------*");
					System.out.println("            Delete Food Details           ");
					System.out.println("*----------------------------------------*");
					System.out.print("Enter Food ID You Wants to Delete : ");
					food_id = sc.nextInt();
					fooddao.deleteFood(food_id);
					System.out.println("*----------------------------------------*");
					break;
				case 3:
					System.out.println("*----------------------------------------*");
					System.out.println("           Update Food Details            ");
					System.out.println("*----------------------------------------*");
					System.out.print("Enter Food ID You Wants to Update : ");
					food_id = sc.nextInt();
					fooddao.updateFood(food_id);
					System.out.println("*----------------------------------------*");
					break;
	
				case 4:
					System.out.println("*--------------------------------------------------------------------------------------*");
					System.out.println("                              View All Food Item Details                                ");
					System.out.println("*--------------------------------------------------------------------------------------*");
					System.out.println("Food_ID\t\tFood_Name\tFood_M.F.Date\t\tFood_Expiry_Date");
					System.out.println("*--------------------------------------------------------------------------------------*");
					fooddisplay.viewAllFoodDetails();
					System.out.println("*--------------------------------------------------------------------------------------*");

					break;
				case 5:
					System.out.println("*--------------------------------------------------------------------------------------*");
					System.out.println("                            View Expired Food Item Details                              ");
					System.out.println("*--------------------------------------------------------------------------------------*");
					System.out.println("Food_ID\t\tFood_Name\tFood_M.F.Date\t\tFood_Expiry_Date");
					System.out.println("*--------------------------------------------------------------------------------------*");
					fooddisplay.viewExpiredFood();
					System.out.println("*--------------------------------------------------------------------------------------*");
					break;
				case 6:
					
					break;
				default:
					System.out.println("Wrong Choice");
					break;
				}
		}while(choice!=6);
	}
//Category Functions
	void category() {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("1.Add food category");
			System.out.println("2.Delete food category");
			System.out.println("3.Update food category");
			System.out.println("4.View all food categories");
			System.out.println("5.Exit");
			System.out.println("\nWhich Action You want to Perform?(1-5)");
			System.out.println("*----------------------------------------*");
			CategoryDAO categorydao = new CategoryDAO();
			CategoryDisplay categorydisplay = new CategoryDisplay();			
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					System.out.println("*----------------------------------------*");
					System.out.println("            Enter Category Details        ");
					System.out.println("*----------------------------------------*");
					System.out.print("Enter Category ID : ");
					int category_id = sc.nextInt();
					System.out.print("Enter Category Name : ");
					String category_name = sc.next();
					Category category = new Category(category_id, category_name);
					categorydao.insertCategory(category);
					System.out.println("*----------------------------------------*");
					break;
				case 2:
					System.out.println("*----------------------------------------*");
					System.out.println("            Delete Category Details           ");
					System.out.println("*----------------------------------------*");
					System.out.print("Enter Category ID You Wants to Delete : ");
					category_id = sc.nextInt();
					categorydao.deleteCategory(category_id);
					System.out.println("*----------------------------------------*");
					break;
				case 3:
					System.out.println("*----------------------------------------*");
					System.out.println("           Update Category Details        ");
					System.out.println("*----------------------------------------*");
					System.out.print("Enter Category ID You Wants to Update : ");
					category_id = sc.nextInt();
					categorydao.updateCategory(category_id);
					System.out.println("*----------------------------------------*");
					break;
	
				case 4:
					System.out.println("*----------------------------------------------*");
					System.out.println("          View All Category Details             ");
					System.out.println("*----------------------------------------------*");
					System.out.println("Category_ID\t\tCategory_Name");
					System.out.println("*-------------------------------------------- -*");
					categorydisplay.viewAllCategoryDetails();
					System.out.println("*--------------------------------------------- *");

					break;
				case 5:
				
					break;
				default:
					System.out.println("Wrong Choice");
					break;
				}
		}while(choice!=5);

	}

//Sub_Category Functions
	void subcategory() {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("1.Add food sub-category");
			System.out.println("2.Delete food sub-category");
			System.out.println("3.Update food sub-category");
			System.out.println("4.View all food sub-categories");
			System.out.println("5.Exit");
			System.out.println("\nWhich Action You want to Perform?(1-5)");
			System.out.println("*----------------------------------------*");
			SubCategoryDAO subcategorydao = new SubCategoryDAO();
			SubCategoryDisplay subcategorydisplay = new SubCategoryDisplay();
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					System.out.println("*----------------------------------------*");
					System.out.println("            Enter Sub-Category Details        ");
					System.out.println("*----------------------------------------*");
					System.out.print("Enter Sub-Category ID : ");
					int sub_category_id = sc.nextInt();
					System.out.print("Enter Sub-Category Name : ");
					String sub_category_name = sc.next();
					SubCategory subcategory = new SubCategory(sub_category_id, sub_category_name);
					subcategorydao.insertSubCategory(subcategory);
					System.out.println("*----------------------------------------*");
					break;
				case 2:
					System.out.println("*----------------------------------------*");
					System.out.println("          Delete Sub-Category Details     ");
					System.out.println("*----------------------------------------*");
					System.out.print("Enter Sub-Category ID You Wants to Delete : ");
					sub_category_id = sc.nextInt();
					subcategorydao.deleteSubCategory(sub_category_id);
					System.out.println("*----------------------------------------*");
					break;
				case 3:
					System.out.println("*----------------------------------------*");
					System.out.println("           Update Sub-Category Details        ");
					System.out.println("*----------------------------------------*");
					System.out.print("Enter Sub-Category ID You Wants to Update : ");
					sub_category_id = sc.nextInt();
					subcategorydao.updateSubCategory(sub_category_id);
					System.out.println("*----------------------------------------*");
					break;
	
				case 4:
					System.out.println("*----------------------------------------------*");
					System.out.println("           View All Sub-Category Details        ");
					System.out.println("*----------------------------------------------*");
					System.out.println("Sub-Category_ID\t\tSub-Category_Name");
					System.out.println("*-------------------------------------------- -*");
					subcategorydisplay.viewAllSubCategoryDetails();
					System.out.println("*--------------------------------------------- *");

					break;
				case 5:
				
					break;
				default:
					System.out.println("Wrong Choice");
					break;
				}
		}while(choice!=5);

	}

//Admin Functions	
	void admin() {
		Scanner sc = new Scanner(System.in);
		UserDAO userdao = new UserDAO();
		FeedbackDisplay feedbackdisplay = new FeedbackDisplay();
		int choice;
		do {
			System.out.println("1.Food Items");
			System.out.println("2.Food Category");
			System.out.println("3.Food SubCategory");
			System.out.println("4.View User Details");
			System.out.println("5.View User Feedbacks");
			System.out.println("6.Exit");
			System.out.println("\nWhich Action You want to Perform?(1-6)");
			System.out.println("*----------------------------------------*");
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					food();
					break;
				case 2:
					category();
					break;
				case 3:
					subcategory();
					break;
				case 4:
					System.out.println("*-------------------------------------------------------------*");
					System.out.println("                        View User Details                      ");
					System.out.println("*-------------------------------------------------------------*");
					System.out.println("User_Mobileno\t\tUser_Name\t\tUser_Password");
					System.out.println("*-------------------------------------------------------------*");
					userdao.viewUserDetails();
					System.out.println("*------------------------------------------------------------ *");

					break;
				case 5:
					System.out.println("*--------------------------------------------------------------------------------------*");
					System.out.println("                              View User Feedbacks                                       ");
					System.out.println("*--------------------------------------------------------------------------------------*");
					System.out.println("User_Mobileno\t\tUser_Name\tFood_Name\t\tComments");
					System.out.println("*--------------------------------------------------------------------------------------*");
					feedbackdisplay.viewFeedbacks();
					System.out.println("*--------------------------------------------------------------------------------------*");
					break;
				case 6:
					break;
				default:
					System.out.println("Wrong Choice");
					break;
			}
		}while(choice!=6);
	}
	
//User Functions
	void user() {
		Scanner sc = new Scanner(System.in);
		FoodDisplay fooddisplay = new FoodDisplay();
		CategoryDisplay categorydisplay = new CategoryDisplay();
		SubCategoryDisplay subcategorydisplay = new SubCategoryDisplay();
		FeedbackDAO feedbackdao = new FeedbackDAO();
		int choice;
		do {
			System.out.println("1.View All Food Items");
			System.out.println("2.View All Food SubCategory");
			System.out.println("3.Search By Category");
			System.out.println("4.Search By Food Name");
			System.out.println("5.View One Day Life Span Foods");
			System.out.println("6.View One Week Life Span Foods");
			System.out.println("7.View Long Day Life Span Foods");
			System.out.println("8.Give a feedback about food items");
			System.out.println("9.Exit");
			System.out.println("\nWhich Action You want to Perform?(1-9)");
			System.out.println("*----------------------------------------*");
			choice = sc.nextInt();
			switch( choice ) {
			case 1:
				System.out.println("*--------------------------------------------------------------------------------------*");
				System.out.println("                              View All Food Item Details                                ");
				System.out.println("*--------------------------------------------------------------------------------------*");
				System.out.println("Food_ID\t\tFood_Name\tFood_M.F.Date\t\tFood_Expiry_Date");
				System.out.println("*--------------------------------------------------------------------------------------*");
				fooddisplay.viewAllFoodDetails();
				System.out.println("*--------------------------------------------------------------------------------------*");
				break;

			case 2:
				System.out.println("*----------------------------------------------*");
				System.out.println("      View All Sub-Category Details             ");
				System.out.println("*----------------------------------------------*");
				System.out.println("Sub-Category_ID\t\tSub-Category_Name");
				System.out.println("*-------------------------------------------- -*");
				subcategorydisplay.viewAllSubCategoryDetails();
				System.out.println("*--------------------------------------------- *");
				break;
			case 3:
				System.out.println("*--------------------------------------------- *");
				System.out.println("       (Like : dairy,veg,fruit,meat,grain)      ");
				System.out.println("*--------------------------------------------- *");
				System.out.print("Enter Food Category Type : ");
				String food_type = sc.next();
				System.out.println("*--------------------------------------------------------------------------------------*");
				System.out.println("                              View "+food_type+" Food Items                             ");
				System.out.println("*--------------------------------------------------------------------------------------*");
				System.out.println("Food_ID\t\tFood_Name\tFood_M.F.Date\t\tFood_Expiry_Date");
				System.out.println("*--------------------------------------------------------------------------------------*");
				fooddisplay.searchbyCategory(food_type);
				System.out.println("*--------------------------------------------------------------------------------------*");
				break;
			case 4:
				System.out.print("Enter Food Name : ");
				String str = sc.next();
				String food_n = str.substring(0, 1).toUpperCase() + str.substring(1);
				System.out.println("*--------------------------------------------------------------------------------------*");
				System.out.println("                                View "+ food_n+" Details                                ");
				System.out.println("*--------------------------------------------------------------------------------------*");
				System.out.println("Food_ID\t\tFood_Name\tFood_M.F.Date\t\tFood_Expiry_Date");
				System.out.println("*--------------------------------------------------------------------------------------*");
				fooddisplay.searchbyFoodname(food_n);
				System.out.println("*--------------------------------------------------------------------------------------*");
				break;
			case 5:
				System.out.println("*----------------------------------------------*");
				System.out.println("      View One Day Life Span Foods              ");
				System.out.println("*----------------------------------------------*");
				System.out.println("Food_ID\t\tFood_Name");
				System.out.println("*-------------------------------------------- -*");
				fooddisplay.viewbyLifespan(1);
				System.out.println("*--------------------------------------------- *");
				break;
			case 6:
				System.out.println("*----------------------------------------------*");
				System.out.println("      View One Week Life Span Foods              ");
				System.out.println("*----------------------------------------------*");
				System.out.println("Food_ID\t\tFood_Name");
				System.out.println("*-------------------------------------------- -*");
				fooddisplay.viewbyLifespan(3);
				System.out.println("*--------------------------------------------- *");
				break;
			case 7:
				System.out.println("*----------------------------------------------*");
				System.out.println("      View Long Day Life Span Foods              ");
				System.out.println("*----------------------------------------------*");
				System.out.println("Food_ID\t\tFood_Name");
				System.out.println("*-------------------------------------------- -*");
				fooddisplay.viewbyLifespan(4);;
				System.out.println("*--------------------------------------------- *");
				break;
			case 8:
				System.out.println("*----------------------------------------------*");
				System.out.println("          Feedback About Food Items             ");
				System.out.println("*----------------------------------------------*");
				System.out.print("Enter your mobileno : ");
				Long mobileno = sc.nextLong();
				System.out.print("Enter your name : ");
				String username = sc.next();
				System.out.print("Enter food name : ");
				String foodname = sc.next();
				System.out.println("Leave your comments about food : ");
				String comment = sc.next();
				Feedback feedback = new Feedback(mobileno,username,foodname,comment);
				feedbackdao.insertFeedback(feedback);
				System.out.println("*----------------------------------------------*");
				break;
			case 9:
				System.out.println("THANK YOU COME AGAIN!");
				System.out.println("*----------------------------------------*");
				break;
			default:
				System.out.println("Wrong Choice");
				break;
			}
		}while(choice!=9);
	}
}


public class Main {
		
		public static void main(String[] args)throws IOException, ParseException{
			Scanner sc = new Scanner(System.in);
			System.out.println("*----------------------------------------*");
			System.out.println("             FOOD SAFETY SYSTEM           ");
			System.out.println("*----------------------------------------*");
			while (true) {
				System.out.println("1.Admin");
				System.out.println("2.User");
				System.out.println("3.Exit");
				System.out.println("*----------------------------------------*");
				String username;
				String password;
				FirstClass fc = new FirstClass();
				Validations validate = new Validations();
				Admin admin = new Admin();
				User user = new User();
				int choice = sc.nextInt();
				switch(choice) {
			//Admin Login functions 
				case 1:
					System.out.print("Enter your username : ");
				    username = sc.next();
					System.out.print("Enter your password : ");
					password = sc.next();
					admin.setUsername(username);
					admin.setPassword(password);
					boolean ValidateAdmin = validate.LoginAdmin(admin);
					if(ValidateAdmin){
						System.out.println("Login Successfull!");
						System.out.println("*----------------------------------------*");
						fc.admin();
					}
					else {
						System.out.println("Check your username and password");
					    System.out.println("*----------------------------------------*");
					}
					break;
			//User SignUp and SignIN
				case 2:
					int choice1;
					System.out.println("*----------------------------------------*");
					System.out.println("       WELCOME TO FOOD SAFETY SYSTEM      ");
					System.out.println("*----------------------------------------*");
					do {
						System.out.println("1.Sign Up");
						System.out.println("2.Sign In");
						System.out.println("3.Exit");
						System.out.println("\nWhich Action You want to Perform?(1-3)");
						System.out.println("*----------------------------------------*");
						choice1 = sc.nextInt();
						switch (choice1) {
					//User Sign Up functions
							case 1:
								System.out.print("Enter your mobileno : ");
								Long user_mobileno = sc.nextLong();
								System.out.print("Enter your username : ");
								String user_username = sc.next();
								System.out.print("Enter your password : ");
								String user_password = sc.next();
								System.out.print("Enter your confirm password : ");
								String user_cpassword = sc.next();
								if(user_password.equals(user_cpassword)) {
									user.setMobileno(user_mobileno);
									user.setUsername(user_username);
									user.setPassword(user_password);
									int validatesignup = validate.SignUpUser(user);
									if(validatesignup>0) {
										System.out.println("SignUp Successfull!");	
										System.out.println("*----------------------------------------*");
										fc.user();
									}
									else {
										System.out.println("SignUp Failed");
										System.out.println("*----------------------------------------*");
									}
								}
								else
									System.out.println("Check your password and confirm password");
								break;
							case 2:
						//User Sign In functions
								System.out.print("Enter your username : ");
								user_username = sc.next();
								System.out.print("Enter your password : ");
							    user_password = sc.next();
							    
							    user.setUsername(user_username);
							    user.setPassword(user_password);
							    boolean ValidateUser = validate.SignInUser(user);
							    if(ValidateUser) {
									System.out.println("SignIn Successfull!");
									System.out.println("*----------------------------------------*");
									fc.user();
								}
								else {
									System.out.println("Check your username and password");
								    System.out.println("*----------------------------------------*");
								}
								break;
							case 3:
							
								break;
							default:
								System.out.println("Wrong Choice");
								break;
								}
							}while(choice1!=3);
						break;
					case 3:
						System.out.println("THANK YOU!");
						System.exit(0);
						break;
					default:
						System.out.println("Wrong Choice!!");
						break;
				}
			}

		}
	}
