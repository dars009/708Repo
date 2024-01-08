package com.jbk.controllers;

public class Pojo {
Integer passengerID;
String passengerNAME;
String passengerAddress;
String PassenegerSourceINFo;
String PassenegerDestinationINFo;
public Pojo() {
	super();
	// TODO Auto-generated constructor stub
}
public Pojo(Integer passengerID, String passengerNAME, String passengerAddress, String passenegerSourceINFo,
		String passenegerDestinationINFo) {
	super();
	this.passengerID = passengerID;
	this.passengerNAME = passengerNAME;
	this.passengerAddress = passengerAddress;
	PassenegerSourceINFo = passenegerSourceINFo;
	PassenegerDestinationINFo = passenegerDestinationINFo;
}
public Integer getPassengerID() {
	return passengerID;
}
public void setPassengerID(Integer passengerID) {
	this.passengerID = passengerID;
}
public String getPassengerNAME() {
	return passengerNAME;
}
public void setPassengerNAME(String passengerNAME) {
	this.passengerNAME = passengerNAME;
}
public String getPassengerAddress() {
	return passengerAddress;
}
public void setPassengerAddress(String passengerAddress) {
	this.passengerAddress = passengerAddress;
}
public String getPassenegerSourceINFo() {
	return PassenegerSourceINFo;
}
public void setPassenegerSourceINFo(String passenegerSourceINFo) {
	PassenegerSourceINFo = passenegerSourceINFo;
}
public String getPassenegerDestinationINFo() {
	return PassenegerDestinationINFo;
}
public void setPassenegerDestinationINFo(String passenegerDestinationINFo) {
	PassenegerDestinationINFo = passenegerDestinationINFo;
}
@Override
public String toString() {
	return "Pojo [passengerID=" + passengerID + ", passengerNAME=" + passengerNAME + ", passengerAddress="
			+ passengerAddress + ", PassenegerSourceINFo=" + PassenegerSourceINFo + ", PassenegerDestinationINFo="
			+ PassenegerDestinationINFo + "]";
}



}
