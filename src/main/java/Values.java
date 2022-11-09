
public class Values {
	private String FN,LN,RN,EID,PS,PN,imageFilename;

	public Values() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Values(String fN, String lN, String rN,String pN, String eID, String pS,String imageFilename) {
		super();
		FN = fN;
		LN = lN;
		RN = rN;
		PN=pN;
		EID = eID;
		PS = pS;
		this.imageFilename=imageFilename;
		
	}

	public String getFN() {
		return FN;
	}

	public void setFN(String fN) {
		FN = fN;
	}

	public String getLN() {
		return LN;
	}

	public void setLN(String lN) {
		LN = lN;
	}

	public String getRN() {
		return RN;
	}

	public void setRN(String rN) {
		RN = rN;
	}

	public String getPN() {
		return PN;
	}

	public void setPN(String pN) {
		PN = pN;
	}

	public String getEID() {
		return EID;
	}

	public void setEID(String eID) {
		EID = eID;
	}

	public String getPS() {
		return PS;
	}

	public void setPS(String pS) {
		PS = pS;
	}

	public String getImageFilename() {
		return imageFilename;
	}

	public void setImageFilename(String imageFilename) {
		this.imageFilename = imageFilename;
	}

	
	

}
