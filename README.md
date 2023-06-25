ISS Location Email Notification

This code is a Java program that sends an email notification if the International Space Station (ISS) is passing over the user's location. It utilizes the JavaMail API and retrieves the ISS's current position and the next pass time for the user's location.

Prerequisites

Before running this program, make sure you have the following:

Java Development Kit (JDK) installed.
Access to a Gmail account with the correct credentials (username and password).
Internet connectivity to retrieve the ISS position and send the email.
Setup

Clone or download the SStation package to your local machine.
Open the SStatioin.java file in a Java development environment or text editor.
Replace the following placeholders with your Gmail account details:
your_email_address@gmail.com: Replace it with your Gmail address.
your_email_password: Replace it with your Gmail account password.
Save the changes.
Execution

To run the program, follow these steps:

Open a command prompt or terminal.
Navigate to the directory where the SStation package is located.
Compile the Java file by executing the following command:
javac SStatioin.java
Run the program using the following command:
java SStatioin
Program Flow

The program sets up the email properties, including the SMTP host, port, sender's email address, and recipient's email address.
It retrieves the current position of the ISS using the ISSLocation class, which provides the latitude and longitude coordinates.
The program then checks if the ISS is passing over the user's location using the ISSPassTime class. If a pass time is available, it proceeds to send an email notification. If not, it displays a message indicating that the ISS is not passing over the user's location at the moment.
The sendEmail method is responsible for sending the email using the JavaMail API. It sets up the email properties, creates an email message, and sends it using the SMTP server.
Troubleshooting

If you encounter any issues, ensure that you have a stable internet connection and that you have correctly provided your Gmail account credentials.
Make sure that the required libraries are properly set up and included in the classpath.
Check for any error messages or exceptions that might be displayed in the console.
Note

This program uses the JavaMail API, which requires proper configuration and authentication. Be cautious when handling email credentials and ensure that you are complying with any applicable security policies.
The program uses the Gmail SMTP server by default (smtp.gmail.com), but you can modify it to work with other email providers by changing the host and port variables.
The ISSLocation and ISSPassTime classes used in this program are not provided here. Please ensure that you have the necessary dependencies or implement those classes according to your requirements.
References

JavaMail API Documentation: https://javaee.github.io/javamail/
International Space Station API: https://wheretheiss.at/ (for ISSLocation and ISSPassTime classes)
