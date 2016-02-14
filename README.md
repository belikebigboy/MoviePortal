Configuring and running the application
--------------------
1. Database used is SQLLite. Place the MoviePortal.db in a convenient location.
2. Configure the database file location in src/main/resources/application.properties.
3. Create the database structure using create_tables.sql script from src/main/resources/sql folder.
4. Run "mvn clean verify" to start the application and browse to localhost:8989/portal