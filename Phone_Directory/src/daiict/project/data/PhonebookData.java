package daiict.project.data;

public class PhonebookData {

	private String lastName;
	private String primaryNumber;
	private String secondaryNumber;
	private String emailAddress;
	private String firstName;
	
	
	
	public PhonebookData(String lastName, String primaryNumber,
			String secondaryNumber, String emailAddress, String firstName) {
		super();
		this.lastName = lastName;
		this.primaryNumber = primaryNumber;
		this.secondaryNumber = secondaryNumber;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPrimaryNumber() {
		return primaryNumber;
	}
	public void setPrimaryNumber(String primaryNumber) {
		this.primaryNumber = primaryNumber;
	}
	public String getSecondaryNumber() {
		return secondaryNumber;
	}
	public void setSecondaryNumber(String secondaryNumber) {
		this.secondaryNumber = secondaryNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Override
	public String toString() {
		return "PhonebookData [lastName=" + lastName + ", primaryNumber="
				+ primaryNumber + ", secondaryNumber=" + secondaryNumber
				+ ", emailAddress=" + emailAddress + "]";
	}
	
	
}
