package BEAN;

public class Member 
{
	private int nemberid;
	private String fullname;
	private String nembername;
	private String nemberpass;
	private int categorymemberid;
	private String nemberimage;
	public int getNemberid() {
		return nemberid;
	}
	public void setNemberid(int nemberid) {
		this.nemberid = nemberid;
	}
	public String getNembername() {
		return nembername;
	}
	public void setNembername(String nembername) {
		this.nembername = nembername;
	}
	public String getNemberpass() {
		return nemberpass;
	}
	public void setNemberpass(String nemberpass) {
		this.nemberpass = nemberpass;
	}
	public int getCategorymemberid() {
		return categorymemberid;
	}
	public void setCategorymemberid(int categorymemberid) {
		this.categorymemberid = categorymemberid;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getNemberimage() {
		return nemberimage;
	}
	public void setNemberimage(String nemberimage) {
		this.nemberimage = nemberimage;
	}
}
