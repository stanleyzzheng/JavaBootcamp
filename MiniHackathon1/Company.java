public class Company {
    private String index, organizationId, salesRepId, name, website, country, description, founded, industry,
            numberOfEmployees;
    public Company(String index, String organizationId, String name, String website, String country, String description, String founded, String industry, String numberOfEmployees){
        this.index=index;
        this.organizationId=organizationId;
        this.name=name;
        this.website=website;
        this.country=country;
        this.description=description;
        this.founded=founded;
        this.industry=industry;
        this.numberOfEmployees=numberOfEmployees;
    }

    public Company(){}

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getDescription() {
        return description;
    }

    public String getFounded() {
        return founded;
    }

    public String getIndex() {
        return index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public String getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public String getRepId() {
        return salesRepId;
    }


    public String getWebsite() {
        return website;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setFounded(String founded) {
        this.founded = founded;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public void setNumberOfEmployees(String numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public void setRepId(String salesRepId) {
        this.salesRepId = salesRepId;
    }

}
