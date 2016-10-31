package com.gmail.quobod.testdb.core.utils;



import java.nio.file.FileSystems;

public class GlobalConstants {
	// Platform Constants
	public final static String OS = System.getProperty("os.name").toLowerCase();
	public final static String OS_ARCH = System.getProperty("os.arch").toLowerCase();
	public final static String OS_VERSION = System.getProperty("os.version").toLowerCase();
	public final static String FILESEPARATOR = FileSystems.getDefault().getSeparator();
	public final static String LINESEPARATOR = System.getProperty("line.separator");
	public final static String USRDIR = System.getProperty("user.dir") + FILESEPARATOR;
	public final static String USRHOME = System.getProperty("user.home") + FILESEPARATOR;
	
	// Serialized File Name
	public final static String POSTGRESQLHOSTANDPORTSERIAL = "postgresql.ser";
	public final static String MONGODBHOSTANDPORTSERIAL = "mongodb.ser";
	public final static String MYSQLHOSTANDPORTSERIAL = "mysql.ser";
	
	// Connection Status
	public final static String CONNECTED = "connected";
	public final static String DISCONNECTED  = "disconnected";	
	
	// Connection Configuration
	public final static String HOST = "Host";
	public final static String PORT = "Port";
	public final static String USER = "User";
	public final static String PWD = "Password";
	public final static String DBN = "DB Name";
	public final static String VENDORS = "Vendors";
	
	public final static String CONNECTIONERROR = "connection error";
	
	// Query Status
	public final static String QUERYERROR = "query error";	
	
	// DB Vendor
	public final static String POSTGRESQL = "PostgreSQL";
	public final static String MONGODB = "MongoDB";
	public final static String MYSQL = "MySQL";
	public final static String[] DBS = new String[] {POSTGRESQL, MONGODB, MYSQL};
	
	// DB Driver String
	public final static String POSTGRESQLDRIVERSTRING = "org.postgresql.Driver";// Class.forName("org.postgresql.Driver");
	public final static String MONGODBLOCALDRIVER = "mongodb://localhost";
	/**
		Running on localhost and default port: MongoClient mongoClient = new MongoClient();
		
		or MongoClient mongoClient = new MongoClient("localhost");
		
		Named server on default port: MongoClient mongoClient = new MongoClient("localhost");
		
		or MongoClient mongoClient = new MongoClient("localhost", 27017");
		
		or MongoClient mongoClient = new MongoClient("db1.server.com");
		
		or MongoClient mongoClient = new MongoClient("db1.server.com", 27018);
		 ------------------------------------------------------------
		 	Here are some connection string URI examples:
			Connecting to the MongoDB server running on localhost at the default port:
			mongodb://localhost
			
			Connecting to the admin database on a named MongoDB server db1.server.com running on port 27027 with user root and password secret:
			mongodb://root:secret@db1.server.com:27027
			
			Connecting to the users database on server db2.server.com:
			mongodb://db2.server.com/users
			
			Connecting to the products database on a named MongoDB server db3.server.com running on port 27027 with user tom and password secret:
			mongodb://tom:secret@db3.server.com:27027/products
			
			Connecting to a replica set of three servers:
			mongodb://db1.server.com,db2.server.com,db3.server.com
		 ------------------------------------------------------------
			String dbURI = "mongodb://localhost";
			MongoClient mongoClient = new MongoClient(new MongoClientURI(dbURI));
		 ------------------------------------------------------------
		 try {
             
            MongoClient mongoClient = new MongoClient("localhost");
             
            List<String> databases = mongoClient.getDatabaseNames();
             
            for (String dbName : databases) {
                System.out.println("- Database: " + dbName);
                 
                DB db = mongoClient.getDB(dbName);
                 
                Set<String> collections = db.getCollectionNames();
                for (String colName : collections) {
                    System.out.println("\t + Collection: " + colName);
                }
            }
             
            mongoClient.close();
             
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
		
	*/
	public final static String MYSQLDRIVER = "com.mysql.jdbc.Driver";
		/**
		 * try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        -----------------------------------------------
        try {
		    conn = DriverManager.getConnection("jdbc:mysql://localhost/test?" +
		                                   "user=minty&password=greatsqldb");
		
		    // Do something with the Connection
		
		   ...
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		 * */
	
	// DB URLs
	public final static String POSTGRESQLURL = "jdbc:postgresql://";// jdbc:postgresql://<Host-Name>/<Database-Name>
	
	// App Name
	public final static String APPNAME = "DB Manager";
	
	// Menu Labels
	public final static String MENUFILE = "file";
	public final static String MENUCLOSECONNECTION = "close connection";
	public final static String MENUOPENCONNECTION = "open connection";
	public final static String MENUEXITPROGRAM = "exit";
	public final static String MENUOPTIONS = "options";
	public final static String MENUSAVEQUERIES = "save queries";
	public final static String MENUSAVECONNECTION = "save connection";
	public final static String MENUHELPPAGE = "help";
	
	// Button Label
	public final static String BUTTONQUERY = "Send Query";
	
	// Action Commands
	public final static String CLOSECONNECTION = "closeconnection";
	public final static String OPENCONNECTION = "openconnection";
	public final static String EXITPROGRAM = "exit";
	public final static String SAVEQUERIES = "savequeries";
	public final static String DISCARDQUERIES = "discardqueries";
	public final static String SAVECONNECTION = "saveconnection";
	public final static String DISCARDCONNECTION = "discardconnection";
	public final static String HELPPAGE = "helppage";
	
}
