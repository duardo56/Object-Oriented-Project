import java.net.Socket;             // Used to connect to the server
import java.io.ObjectInputStream;   // Used to read objects sent from the server
import java.io.ObjectOutputStream;  // Used to write objects to the server
import java.io.BufferedReader;      // Needed to read from the console
import java.io.InputStreamReader;   // Needed to read from the console
//Simple client class.  This class connects to an FileServer to send
//text back and forth.  Java message serialization is used to pass
//Message objects around.
public class Client
{
    public static void main(String[] args) // First argument specifies the server to connect to
    {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String exit = "";
		// Error checking for arguments
		if(args.length != 1)
		{
			System.err.println("Not enough arguments.\n");
			System.err.println("Usage:  java EchoClient <Server name or IP>\n");
			System.exit(-1);
		}
		try
		{
			// Connect to the specified server
			final Socket sock = new Socket(args[0], FileServer.SERVER_PORT);
			System.out.println("Connected to " + args[0] + " on port " + FileServer.SERVER_PORT);
			// Set up I/O streams with the server
			final ObjectOutputStream output = new ObjectOutputStream(sock.getOutputStream());
			final ObjectInputStream input = new ObjectInputStream(sock.getInputStream());
			// loop to send messages
			SampleFile_1 file = null; // sampleObject.
			SampleFile_1 resp = null;
			do
			{
				// Read and send message.  Since the Message class
				// implements the Serializable interface, the
				// ObjectOutputStream "output" object automatically
				// encodes the Message object into a format that can
				// be transmitted over the socket to the server.
				file = new SampleFile_1(842595,325636,89,70,"Good","OIL","HomeDepot","11-12-16","11-01-16","11-02-16","11-11-16",999888);
				output.writeObject(file);
				// Get ACK and print.  Since Message implements
				// Serializable, the ObjectInputStream can
				// automatically read this object off of the wire and
				// encode it as a Message.  Note that we need to
				// explicitly cast the return from readObject() to the
				// type Message.
				resp = (SampleFile_1)input.readObject();
				System.out.println("\nServer says: " + resp.analysisID       +":"+ resp.sampleID     +":"+ resp.fidelity +":"
									                 + resp.expectedFidelity +":"+ resp.status       +":"+ resp.testType +":"
									                 + resp.company          +":"+ resp.dueDate      +":"+ resp.sentDate +":"
									                 + resp.completedDate    +":"+ resp.receivedDate +":"+ resp.pNumber  +"]\n");
				System.out.printf("Exit?");
				exit = in.readLine();
			}while(!exit.toUpperCase().equals("EXIT"));
			
		}// shut things down
		catch(Exception e)
		{
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace(System.err);
		}
    }
} //-- end class EchoClient