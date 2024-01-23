package com.darkhost;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class CsvToJsonConverter {
    private static Gson gson = null;

    public static void main(String[] args) {
	List<ThailandEInvoiceCountry> dataList = readAllDataAtOnce("/Users/eleos/Desktop/file/inetcountrylist.csv");
	try {
	    gson = new Gson();
	    String json = gson.toJson(dataList); // converts to json
	    System.out.println(json);
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    public static List<ThailandEInvoiceCountry> readAllDataAtOnce(String file) {
	String csvFile = file;
	String line;
	String csvSplitBy = ",";

	List<ThailandEInvoiceCountry> dataList = new ArrayList<ThailandEInvoiceCountry>();

	try (BufferedReader br = new BufferedReader(new FileReader(new File(csvFile)))) {
	    while ((line = br.readLine()) != null) {
		String[] data = line.split(csvSplitBy);
		String code = data[0];
		String name = data[1];
		ThailandEInvoiceCountry dataobj = new ThailandEInvoiceCountry();
		dataobj.setCountryCode(code);
		dataobj.setCountryName(name);
		if (code != null && code.equals("TH")) {
		    dataobj.setEnablePostalCode(true);
		}
		dataList.add(dataobj);
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}

	for (ThailandEInvoiceCountry data : dataList) {
	    System.out.println(
		    data.getCountryCode() + "###" + data.getCountryName() + "###" + data.getEnablePostalCode());
	}
	return dataList;
    }
}
