/**
 * Very stupid-simple message class.  By implementing the Serializble
 * interface, objects of this class can be serialized automatically by
 * Java to be sent across IO streams.  
 **/
public class SampleFile_1 implements java.io.Serializable
{
    /** The text string encoded in this Message object */
	public long analysisID;
	public long sampleID;
	public long pNumber;
	public double fidelity;
	public double expectedFidelity;
	public String status;
	public String testType;
	public String company;
	public String dueDate;
	public String sentDate;
	public String completedDate;
	public String receivedDate;
    /**
     * Constructor.
     * @param _msg The string to be encoded in this Message object
     */
    public SampleFile_1(long analysisID, long sampleID, double fidelity, double expectedFidelity,
					  String status,  String testType, String company, String dueDate, 
					  String sentDate, String completedDate, String receivedDate, long pNumber)
	{
		this.analysisID = analysisID;
		this.sampleID = sampleID;
		this.fidelity = fidelity;
		this.expectedFidelity = expectedFidelity;
		this.status = status;
		this.testType = testType;
		this.company = company;
		this.dueDate = dueDate;
		this.sentDate = sentDate; 
		this.completedDate = completedDate;
		this.receivedDate = receivedDate;
		this.pNumber = pNumber;
    }
}  //-- End class Message