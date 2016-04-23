import java.lang.Thread;            // We will extend Java's base Thread class
import java.net.Socket;
import java.io.ObjectInputStream;   // For reading Java objects off of the wire
import java.io.ObjectOutputStream;  // For writing Java objects to the wire
/**
 * A simple server thread.  This class just echoes the messages sent
 * over the socket until the socket is closed.
 **/
public class FileThread extends Thread
{
    private final Socket socket;// The socket that we'll be talking over
    /**
     * Constructor that sets up the socket we'll chat over
     * @param _socket The socket passed in from the server
     **/
    public FileThread(Socket _socket)
    {
		socket = _socket;
    }
    /**
     * run() is basically the main method of a thread.  This thread
     * simply reads Message objects off of the socket.
     **/
    public void run()
    {
		try
		{
			// Print incoming message
			System.out.println("** New connection from " + socket.getInetAddress() + ":" + socket.getPort() + " **");
			// set up I/O streams with the client
			final ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			final ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			// Loop to read messages
			SampleFile_1 file = null;
			int count = 0;
			do
			{
				// read and print message
				file = (SampleFile_1)input.readObject();
				System.out.println("[" + socket.getInetAddress() 
										+ ":" 
										+ socket.getPort() + ":"
										+ file.analysisID + ":"
										+ file.sampleID + ":"
										+ file.fidelity + ":"
										+ file.expectedFidelity + ":" 
										+ file.status + ":"
										+ file.testType + ":"
										+ file.company + ":"
										+ file.dueDate + ":"
										+ file.sentDate + ":"
										+ file.completedDate + ":"
										+ file.receivedDate + ":"
										+ file.pNumber + ":"
										+ "] ");
				// Write an ACK back to the sender
				count++;
				//output.writeObject(new SampleFile("Recieved message #" + count));
			}while(/*!file.theFile.toUpperCase().equals("EXIT")*/count < 2);
			// Close and cleanup
			System.out.println("** Closing connection with " + socket.getInetAddress() + ":" + socket.getPort() + " **");
			socket.close();
		}
		catch(Exception e)
		{
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace(System.err);
		}
    }
}