package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvoiceManager {
	
	// HashMap to store date as key and list of invoice numbers as value
	private Map<String, List<String>> invoiceMap;
	public InvoiceManager() {
	invoiceMap = new HashMap<>();
	}
	/**
	* Adds invoice numbers to a specific date if they do not already exist.
	*
	* @param date The date for which invoice numbers are to be added.
	* @param invoiceNumbers The list of invoice numbers to be added.
	* @return true if the invoice numbers were successfully added, false if any invoice number already exists for the date.
	*/
	public boolean addInvoices(String date, List<String> invoiceNumbers) {
	// Check if the date already exists in the map
	if (invoiceMap.containsKey(date)) {
	List<String> existingInvoices = invoiceMap.get(date);
	// Check for any duplicate invoice numbers
	for (String invoice : invoiceNumbers) {
	if (existingInvoices.contains(invoice)) {
	return false;
	}
	}
	// Add new invoice numbers to the existing list
	existingInvoices.addAll(invoiceNumbers);
	} else {
	// If the date does not exist, add the date and the list of invoice numbers
	invoiceMap.put(date, new ArrayList<>(invoiceNumbers));
	}
	return true;
	}
	/**
	* Prints the current state of the invoice map.
	*/
	public void printInvoices() {
	for (Map.Entry<String, List<String>> entry : invoiceMap.entrySet()) {
	System.out.println("Date: " + entry.getKey() + ", Invoices: " + entry.getValue());
	}
	}
	public static void main(String[] args) {
	InvoiceManager manager = new InvoiceManager();
	// Adding invoices to a date
	List<String> invoices1 = Arrays.asList("INV001", "INV002", "INV003");
	System.out.println(manager.addInvoices("2023-05-27", invoices1)); // true
	// Adding more invoices to the same date
	List<String> invoices2 = Arrays.asList("INV004", "INV005");
	System.out.println(manager.addInvoices("2023-05-27", invoices2)); // true
	// Trying to add duplicate invoice
	List<String> invoices3 = Arrays.asList("INV006", "INV002");
	System.out.println(manager.addInvoices("2023-05-27", invoices3)); // false
	// Printing the current state of invoices
	manager.printInvoices();
	}

}
