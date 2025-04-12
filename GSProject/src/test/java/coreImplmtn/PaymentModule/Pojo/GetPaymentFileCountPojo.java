package coreImplmtn.PaymentModule.Pojo;

public class GetPaymentFileCountPojo {
	String eod_closed;
	String date;
	String num_files;
	
	public String getEod_closed() {
		return eod_closed;
	}
	public void setEod_closed(String eod_closed) {
		this.eod_closed = eod_closed;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNum_files() {
		return num_files;
	}
	public void setNum_files(String num_files) {
		this.num_files = num_files;
	}
}
