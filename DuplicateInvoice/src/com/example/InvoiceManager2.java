package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvoiceManager2 {
	
	// HashMap to store date as key and list of invoice numbers as value
    private Map<String, List<String>> invoiceMap;
    // Variable to store the last date when invoices were added
    private LocalDate lastDate;
 
    public InvoiceManager2() {
        invoiceMap = new HashMap<>();
        lastDate = LocalDate.now(); // Initialize lastDate with the current date
    }
 
    /**
     * Adds invoice numbers to the current date if they do not already exist.
     *
     * @param invoiceNumbers The list of invoice numbers to be added.
     * @return true if the invoice numbers were successfully added, false if any invoice number already exists for the date.
     */
    public boolean addInvoices(List<String> invoiceNumbers) {
        LocalDate currentDate = LocalDate.now();
 
        // Check if the current date is different from the last date
        if (!currentDate.equals(lastDate)) {
            // Clear the map if a new day is detected
            invoiceMap.clear();
            lastDate = currentDate;
        }
 
        String dateKey = currentDate.toString();
 
        // Check if the date already exists in the map
        if (invoiceMap.containsKey(dateKey)) {
            List<String> existingInvoices = invoiceMap.get(dateKey);
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
            invoiceMap.put(dateKey, new ArrayList<>(invoiceNumbers));
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
        InvoiceManager2 manager = new InvoiceManager2();
        // Adding invoices to the current date
        List<String> invoices1 = Arrays.asList("INV001", "INV002", "INV003");
        System.out.println(manager.addInvoices(invoices1)); // true
 
        // Adding more invoices to the same date
        List<String> invoices2 = Arrays.asList("INV004", "INV005");
        System.out.println(manager.addInvoices(invoices2)); // true
 
        // Trying to add duplicate invoice
        List<String> invoices3 = Arrays.asList("INV002", "INV006");
        System.out.println(manager.addInvoices(invoices3)); // false
        // Printing the current state of invoices
        manager.printInvoices();
 
        // Simulate adding invoices on a new day
        // For demonstration, manually change the lastDate to yesterday
        manager.lastDate = LocalDate.now().minusDays(1);
        List<String> invoices4 = Arrays.asList("INV007", "INV008");
        System.out.println(manager.addInvoices(invoices4)); // true, map should be cleared and only INV007, INV008 should be present
 
        // Printing the current state of invoices
        manager.printInvoices();
    }

}
