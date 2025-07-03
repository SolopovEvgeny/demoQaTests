package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TextBoxFormModel {
    private String fullName;
    private String email;
    private String currentAddress;
    private String permanentAddress;
}
