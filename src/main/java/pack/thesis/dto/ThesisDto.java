package pack.thesis.dto;

import java.util.Date;

public class ThesisDto {
    private Long id;

    private String thesisTitle;

    private String aspirantFio;

    private Date dissDefTime;

    private String thesisType;

    private String scienceCode;

    private String scienceField;

    private String organization;

    public ThesisDto(Long id, String thesisTitle, String aspirantFio, Date dissDefTime, String thesisType, String scienceCode, String scienceField, String organization) {
        this.id = id;
        this.thesisTitle = thesisTitle;
        this.aspirantFio = aspirantFio;
        this.dissDefTime = dissDefTime;
        this.thesisType = thesisType;
        this.scienceCode = scienceCode;
        this.scienceField = scienceField;
        this.organization = organization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getThesisTitle() {
        return thesisTitle;
    }

    public void setThesisTitle(String thesisTitle) {
        this.thesisTitle = thesisTitle;
    }

    public String getAspirantFio() {
        return aspirantFio;
    }

    public void setAspirantFio(String aspirantFio) {
        this.aspirantFio = aspirantFio;
    }

    public Date getDissDefTime() {
        return dissDefTime;
    }

    public void setDissDefTime(Date dissDefTime) {
        this.dissDefTime = dissDefTime;
    }

    public String getThesisType() {
        return thesisType;
    }

    public void setThesisType(String thesisType) {
        this.thesisType = thesisType;
    }

    public String getScienceField() {
        return scienceField;
    }

    public void setScienceField(String scienceField) {
        this.scienceField = scienceField;
    }

    public String getScienceCode() {
        return scienceCode;
    }

    public void setScienceCode(String scienceCode) {
        this.scienceCode = scienceCode;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}
