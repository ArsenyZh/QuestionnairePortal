package com.project.Questionnaire.portal.enums;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public enum FieldType {
    Combobox,
    Radiobutton,
    Textline,
}
