package pack.thesis.dto;

public class ScienceFieldCodeDto {
    private String fieldTitle;
    private String code;
    private String codeTitle;

    public ScienceFieldCodeDto(String fieldTitle, String code, String codeTitle) {
        this.fieldTitle = fieldTitle;
        this.code = code;
        this.codeTitle = codeTitle;
    }

    public String getFieldTitle() {
        return fieldTitle;
    }

    public void setFieldTitle(String fieldTitle) {
        this.fieldTitle = fieldTitle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeTitle() {
        return codeTitle;
    }

    public void setCodeTitle(String codeTitle) {
        this.codeTitle = codeTitle;
    }
}
