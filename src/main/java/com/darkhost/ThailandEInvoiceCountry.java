package com.darkhost;

public class ThailandEInvoiceCountry {
    private String CountryCode;
    private String CountryName;
    private Boolean EnablePostalCode = false;

    public String getCountryCode() {
	return CountryCode;
    }

    public String getCountryName() {
	return CountryName;
    }

    public Boolean getEnablePostalCode() {
	return EnablePostalCode;
    }

    public void setCountryCode(String countryCode) {
	CountryCode = countryCode;
    }

    public void setCountryName(String countryName) {
	CountryName = countryName;
    }

    public void setEnablePostalCode(Boolean enablePostalCode) {
	EnablePostalCode = enablePostalCode;
    }

}
