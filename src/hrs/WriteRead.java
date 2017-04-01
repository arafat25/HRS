/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrs;

/**
 *
 * @author Im_jay
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class WriteRead {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
	
    static void init() throws IOException{
	File file;
	PrintWriter pw;
	file = new File("room123.txt");
	pw = new PrintWriter(new FileWriter(file, true));
	file = new File("rsv.txt");
	pw = new PrintWriter(new FileWriter(file, true));
	file = new File("user.txt");
	pw = new PrintWriter(new FileWriter(file, true));
	file = new File("admin.txt");
	pw = new PrintWriter(new FileWriter(file, true));
	file = new File("staff.txt");
	pw = new PrintWriter(new FileWriter(file, true));
    }

    static void writeRoom(Room room){
	try{
            File file = new File("room123.txt");
            FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
            BufferedWriter bw = new BufferedWriter(fw);
			
            bw.append(room.roomNum);
            bw.append(COMMA_DELIMITER);
            bw.append(room.clean);
            bw.append(COMMA_DELIMITER);
            bw.append(room.available);
            bw.append(COMMA_DELIMITER);
            bw.append(room.type);
            bw.append(COMMA_DELIMITER);
            bw.append(room.price);
            bw.newLine();
            bw.close();
			
	} 
	catch (Exception e) {
            e.printStackTrace();
	} finally {
	}
    } 
	
    static List<Room> readRooms(){
	List<Room> rooms = new ArrayList();
	try {
            FileInputStream fs = new FileInputStream("room123.txt");
            BufferedReader r = new BufferedReader(new InputStreamReader(fs));
			
            String c;
            while ((c = r.readLine()) != null) {
		String[] tokens = c.split(COMMA_DELIMITER);
		if (tokens.length > 4) {
                    Room room = new Room(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4]);
                    rooms.add(room);
		}
            }
            fs.close();
	} 
	catch (Exception e) {
            System.out.println("Error in Rooms FileReader !!!");
            e.printStackTrace();
	} 
	return rooms;
	}
    
    static int getNumRooms(){
	int numRooms=0;
	try {
            FileInputStream fs = new FileInputStream("room123.txt");
            BufferedReader r = new BufferedReader(new InputStreamReader(fs));
			
            String c;
            while ((c = r.readLine()) != null) {
            	numRooms+=1;
            }
            fs.close();
	} 
	catch (Exception e) {
            System.out.println("Error in Rooms FileReader !!!");
            e.printStackTrace();
	} 
	return numRooms;
	}
    
    static String[] getRowInfo(String row){
	try{
            FileInputStream fs = new FileInputStream("room123.txt");
            BufferedReader r = new BufferedReader(new InputStreamReader(fs));
			
            String c;
            while ((c = r.readLine()) != null) {
		String[] tokens = c.split(COMMA_DELIMITER);
		if (tokens[1]== row) {
                    return tokens;
		}
            }
            fs.close(); 
        }
	catch (Exception e) {
            System.out.println("Error in Rooms FileReader !!!");
            e.printStackTrace();
	} 
	return null;
    }
	
    static void writeStaff(Staff staff){
	try{
            File file = new File("staff.txt");
            FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
            BufferedWriter bw = new BufferedWriter(fw);
			
            bw.append(staff.emplid);
            bw.append(COMMA_DELIMITER);
            bw.append(staff.fname);
            bw.append(COMMA_DELIMITER);
            bw.append(staff.lname);
            bw.append(COMMA_DELIMITER);
            bw.append(staff.address);
            bw.append(COMMA_DELIMITER);
            bw.append(staff.city);
            bw.append(COMMA_DELIMITER);
            bw.append(staff.state);
            bw.append(COMMA_DELIMITER);
            bw.append(staff.zip);
            bw.append(COMMA_DELIMITER);
            bw.append(staff.email);
            bw.append(COMMA_DELIMITER);
            bw.append(staff.phone);
            bw.append(COMMA_DELIMITER);
            bw.append(staff.gender);
            bw.append(COMMA_DELIMITER);
            bw.append(staff.position);
            bw.append(COMMA_DELIMITER);
            bw.append(staff.sdate);
            bw.append(COMMA_DELIMITER);
            bw.append(staff.edate);
            bw.newLine();
            bw.close();
			
	} 
	catch (Exception e) {
            e.printStackTrace();
	} finally {
	}
    } 
	
    static List<Staff> readStaff(){
	List<Staff> empls = new ArrayList();
	try {
            FileInputStream fs = new FileInputStream("staff.txt");
            BufferedReader r = new BufferedReader(new InputStreamReader(fs));
			
            String c;
            while ((c = r.readLine()) != null) {
		String[] tokens = c.split(COMMA_DELIMITER);
		if (tokens.length > 10) {
                    Staff staff = new Staff(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6],tokens[7],tokens[8],tokens[9],tokens[10],tokens[11],tokens[12]);
                    empls.add(staff);
		}
            }
            fs.close();
	} 
	catch (Exception e) {
            System.out.println("Error in Staff FileReader !!!");
            e.printStackTrace();
	} 
	return empls;
    }
    
    static int getNumStaff(){
	int numStaff=0;
	try {
            FileInputStream fs = new FileInputStream("staff.txt");
            BufferedReader r = new BufferedReader(new InputStreamReader(fs));
			
            String c;
            while ((c = r.readLine()) != null) {
		numStaff+=1;
            }
            fs.close();
	} 
	catch (Exception e) {
            System.out.println("Error in Staff FileReader !!!");
            e.printStackTrace();
	} 
	return numStaff;
    }
    
    static String[] getRowInfoS(String row, String file){
	try{
            FileInputStream fs = new FileInputStream(file);
            BufferedReader r = new BufferedReader(new InputStreamReader(fs));
			
            String c;
            while ((c = r.readLine()) != null) {
            	String[] tokens = c.split(COMMA_DELIMITER);
		if (tokens[1]== row) {
                    return tokens;
		}
            }
            fs.close(); 
	}
	catch (Exception e) {
            System.out.println("Error in Staff FileReader !!!");
            e.printStackTrace();
	} 
	return null;
    }
    
    static void editRowStaff(String rowNum, Staff staff){
	try{
	//Create temporary file
	File temp = new File("temp.txt");
	temp.createNewFile();
	//Open temporary file
	FileWriter fw = new FileWriter(temp.getAbsoluteFile(),true);
	BufferedWriter bw = new BufferedWriter(fw);
	//Open Rooms file
	File rooms = new File("staff.txt");
	FileInputStream fs = new FileInputStream("staff.txt");
	BufferedReader r = new BufferedReader(new InputStreamReader(fs));
			
	//Read through rooms file. If not correct row write to temp file. If correct row, write new info to temp file.
	String c;
	while ((c = r.readLine()) != null) {
            String[] tokens = c.split(COMMA_DELIMITER);
            if (!tokens[0].equals(rowNum)) {
		bw.append(c);
		bw.newLine();
            }else{
                bw.append(staff.emplid);
                bw.append(COMMA_DELIMITER);
                bw.append(staff.fname);
                bw.append(COMMA_DELIMITER);
                bw.append(staff.lname);
                bw.append(COMMA_DELIMITER);
                bw.append(staff.address);
                bw.append(COMMA_DELIMITER);
                bw.append(staff.city);
                bw.append(COMMA_DELIMITER);
                bw.append(staff.state);
                bw.append(COMMA_DELIMITER);
                bw.append(staff.zip);
                bw.append(COMMA_DELIMITER);
                bw.append(staff.email);
                bw.append(COMMA_DELIMITER);
                bw.append(staff.phone);
                bw.append(COMMA_DELIMITER);
                bw.append(staff.gender);
                bw.append(COMMA_DELIMITER);
                bw.append(staff.position);
                bw.append(COMMA_DELIMITER);
                bw.append(staff.sdate);
                bw.append(COMMA_DELIMITER);
                bw.append(staff.edate);
		bw.newLine();
            }
	}
	fs.close();
	bw.close();
	fw.close();
	r.close();
	rooms.delete();
	temp.renameTo(rooms);
	}
	catch (Exception e) {
	System.out.println("Error in RoomsFileReader !!!");
	e.printStackTrace();
	} 
		
    }

	
    static void editRowRoom(String rowNum, Room room){
	try{
	//Create temporary file
	//File temp = new File("temp.txt");
	//PrintWriter pw = new PrintWriter(new FileWriter(temp, true));
	File temp = new File("temp.txt");
	temp.createNewFile();
	//Open temporary file
	FileWriter fw = new FileWriter(temp.getAbsoluteFile(),true);
	BufferedWriter bw = new BufferedWriter(fw);
	//Open Rooms file
	File rooms = new File("room.txt");
	FileInputStream fs = new FileInputStream("room.txt");
	BufferedReader r = new BufferedReader(new InputStreamReader(fs));
			
	//Read through rooms file. If not correct row write to temp file. If correct row, write new info to temp file.
	String c;
	while ((c = r.readLine()) != null) {
            String[] tokens = c.split(COMMA_DELIMITER);
            if (!tokens[0].equals(rowNum)) {
		bw.append(c);
		bw.newLine();
            }else{
		bw.append(rowNum);
		bw.append(COMMA_DELIMITER);
		bw.append(room.clean);
		bw.append(COMMA_DELIMITER);
		bw.append(room.available);
		bw.append(COMMA_DELIMITER);
		bw.append(room.type);
		bw.append(COMMA_DELIMITER);
		bw.append(room.price);
		bw.newLine();
            }
	}
	fs.close();
	bw.close();
	fw.close();
	r.close();
	rooms.delete();
	temp.renameTo(rooms);
	}
	catch (Exception e) {
	System.out.println("Error in RoomsFileReader !!!");
	e.printStackTrace();
	} 
		
    }
	
    static int readLines(File file) throws IOException{
	FileReader ftr = new FileReader(file);
	BufferedReader bf = new BufferedReader(ftr);
	
	String aLine;
	int numberOfLines = 0;
	
	while ((aLine = bf.readLine()) != null){
            numberOfLines++;
	}
	bf.close();
	return numberOfLines;
    }

    static void writeAdmin(Admin admin){
	try{
            File file = new File("admin.txt");
            FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
            BufferedWriter bw = new BufferedWriter(fw);
			
            bw.append(admin.fName);
            bw.append(COMMA_DELIMITER);
            bw.append(admin.lName);
            bw.append(COMMA_DELIMITER);
            bw.append(admin.username);
            bw.append(COMMA_DELIMITER);
            bw.append(admin.password);
            bw.newLine();
            bw.close();
		
	} 
	catch (Exception e) {
            e.printStackTrace();
	} finally {
	}
    } 

    static List<Admin> readAdmins(){
	BufferedReader fileReader = null;
	List<Admin> admins = new ArrayList();

	try {
            String line = ""; 
            fileReader = new BufferedReader(new FileReader("admin.txt"));
			
            //Read the CSV file header to skip it
            fileReader.readLine();
			
            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
            //Get all tokens available in line
		String[] tokens = line.split(COMMA_DELIMITER);
		if (tokens.length > 3) {
		//Create a new student object and fill his  data
                    Admin room = new Admin(tokens[0],tokens[1],tokens[2],tokens[3]);
                    admins.add(room);
		}
            }
	} 
	catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
	} finally {
            try {
		fileReader.close();
            } catch (IOException e) {
		System.out.println("Error while closing fileReader !!!");
		e.printStackTrace();
            }
	}
	return admins;
    }

    static void writeUser(User user){
	try{
            File file = new File("user.txt");
            FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
            BufferedWriter bw = new BufferedWriter(fw);
			
            bw.append(user.fName);
            bw.append(COMMA_DELIMITER);
            bw.append(user.lName);
            bw.append(COMMA_DELIMITER);
            bw.append(user.username);
            bw.append(COMMA_DELIMITER);
            bw.append(user.password);
            bw.append(COMMA_DELIMITER);
            bw.append(user.dob);
            bw.newLine();
            bw.close();
        } 
	catch (Exception e) {
            e.printStackTrace();
	} finally {
	}
    }
    
    static List<User> readUsers(){
	BufferedReader fileReader = null;
	List<User> users = new ArrayList();

	try {
            String line = ""; 
            fileReader = new BufferedReader(new FileReader("user.txt"));
			
            //Read the CSV file header to skip it
            fileReader.readLine();
		
            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
		//Get all tokens available in line
		String[] tokens = line.split(COMMA_DELIMITER);
		if (tokens.length > 3) {
                    //Create a new student object and fill his  data
                    User use = new User(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4]);
                    users.add(use);
		}
            }
	} 
	catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
            } finally {
		try {
                    fileReader.close();
                } catch (IOException e) {
                    System.out.println("Error while closing fileReader !!!");
                    e.printStackTrace();
		}
            }
            return users;	
	}
	
    static void writeRes(Reservations rsv){
	FileWriter fileWriter = null;
	try {
            fileWriter = new FileWriter("rsv.txt",true);				
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.append(rsv.startD);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(rsv.endD);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(rsv.user);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(rsv.rooms);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(rsv.username);
            fileWriter.append(NEW_LINE_SEPARATOR);
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
            try {
		fileWriter.flush();
		fileWriter.close();
		} catch (IOException e) {
                    System.out.println("Error while flushing/closing fileWriter !!!");
                    e.printStackTrace();
		}	
	}
    }
	
    static List<Reservations> readRSV(){
	BufferedReader fileReader = null;
	List<Reservations> rsvs = new ArrayList();

	try {
            String line = ""; 
            fileReader = new BufferedReader(new FileReader("rsv.txt"));
			
            //Read the CSV file header to skip it
            fileReader.readLine();
			
            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
		//Get all tokens available in line
		String[] tokens = line.split(COMMA_DELIMITER);
		if (tokens.length > 3) {
                    //Create a new student object and fill his  data
                    Reservations rsv = new Reservations(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4]);
                    rsvs.add(rsv);
		}
            }		
	} 
	catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
	} finally {
            try {
		fileReader.close();
            } catch (IOException e) {
		System.out.println("Error while closing fileReader !!!");
		e.printStackTrace();
            }
	}
	return rsvs;	
    }

    static class Room{
	String roomNum;
	String clean;
	String available;
	String type;
	String price;
	public Room(String roomNum, String status, String states, String type,String price) {
            this.roomNum = roomNum;
            this.clean = status;
            this.available = states;
            this.type = type;
            this.price = price;
	}
    }

    static class Admin{
    	String fName;
    	String lName;
    	String username;
	String password;
	public Admin(String fName, String lName, String username,String password) {
            super();
            this.fName = fName;
            this.lName = lName;
            this.username = username;
            this.password = password;
	}
    }

    static class User{
	String fName;
	String lName;
	String username;
	String password;
	String dob;
	public User(String fName, String lName, String username,String password, String dob) {
            this.fName = fName;
            this.lName = lName;
            this.username = username;
            this.password = password;
            this.dob=dob;
	}
    }
	
    static class Staff{
	String emplid;
	String fname;
	String lname;
	String address;
	String city;
        String state;
	String zip;
	String email;
	String phone;
	String gender;
	String position;
	String sdate;
	String edate;
		
	public Staff(String emplid,String fname,String lname,String address,String city,String state,String zip,String email,String phone,String gender,String position,String sdate,String edate) {
            this.emplid = emplid;
            this.fname = fname;
            this.lname = lname;
            this.address = address;
            this.city = city;
            this.state = state;
            this.zip = zip;
            this.email = email;
            this.phone = phone;
            this.gender = gender;
            this.position = position;
            this.sdate = sdate;
            this.edate = edate;
        }
    }
	
    static class Reservations{
	String startD;
    	String endD;
	String user;
	String rooms;
	String username;
	public Reservations(String startD, String endD, String user,String rooms, String username) {
            this.startD = startD;
            this.endD = endD;
            this.user = user;
            this.rooms = rooms;
            this.username = username;
	}
    }
}