package com.uscs.model;


public class DocumentVO {
	
	String documentType;
	String fileName;
	String title;
	String dateAdded;
	String whseNumber;
	String customerNumber;
	String tktRcptNumber;
	String custOrderNumber;
	String poCustRefNumber;
	String appointmentNumber;
	String shipReceiptDate;
	String consigneeShipFromNumber;
	String carrierNumber;
	String loadNumber;
	
	
	
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}
	public String getWhseNumber() {
		return whseNumber;
	}
	public void setWhseNumber(String whseNumber) {
		this.whseNumber = whseNumber;
	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getTktRcptNumber() {
		return tktRcptNumber;
	}
	public void setTktRcptNumber(String tktRcptNumber) {
		this.tktRcptNumber = tktRcptNumber;
	}
	public String getCustOrderNumber() {
		return custOrderNumber;
	}
	public void setCustOrderNumber(String custOrderNumber) {
		this.custOrderNumber = custOrderNumber;
	}
	public String getPoCustRefNumber() {
		return poCustRefNumber;
	}
	public void setPoCustRefNumber(String poCustRefNumber) {
		this.poCustRefNumber = poCustRefNumber;
	}
	public String getAppointmentNumber() {
		return appointmentNumber;
	}
	public void setAppointmentNumber(String appointmentNumber) {
		this.appointmentNumber = appointmentNumber;
	}
	public String getShipReceiptDate() {
		return shipReceiptDate;
	}
	public void setShipReceiptDate(String shipReceiptDate) {
		this.shipReceiptDate = shipReceiptDate;
	}
	public String getConsigneeShipFromNumber() {
		return consigneeShipFromNumber;
	}
	public void setConsigneeShipFromNumber(String consigneeShipFromNumber) {
		this.consigneeShipFromNumber = consigneeShipFromNumber;
	}
	public String getCarrierNumber() {
		return carrierNumber;
	}
	public void setCarrierNumber(String carrierNumber) {
		this.carrierNumber = carrierNumber;
	}
	public String getLoadNumber() {
		return loadNumber;
	}
	public void setLoadNumber(String loadNumber) {
		this.loadNumber = loadNumber;
	}
	
	@Override
	public String toString() {
		return "webdocsModel [documentType=" + documentType + ", fileName="
				+ fileName + ", title=" + title + ", dateAdded=" + dateAdded
				+ ", whseNumber=" + whseNumber + ", customerNumber="
				+ customerNumber + ", tktRcptNumber=" + tktRcptNumber
				+ ", custOrderNumber=" + custOrderNumber + ", poCustRefNumber="
				+ poCustRefNumber + ", appointmentNumber=" + appointmentNumber
				+ ", shipReceiptDate=" + shipReceiptDate
				+ ", consigneeShipFromNumber=" + consigneeShipFromNumber
				+ ", carrierNumber=" + carrierNumber + ", loadNumber="
				+ loadNumber + "]";
	}
	
	
}
