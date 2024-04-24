package com.project.Questionnaire.portal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.Questionnaire.portal.enums.FieldType;
import com.project.Questionnaire.portal.enums.PostgreSQLEnumType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;


import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "fields")
@TypeDef(name = "fieldType",
        typeClass = PostgreSQLEnumType.class)
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column (name = "label")
    private String label;

    @Column (name = "type")
    @Enumerated(EnumType.STRING)
    @Embedded
    @Type(type = "fieldType")
    private FieldType type;

    @Column (name = "is_required")
    private boolean required;

    @Column (name = "is_active")
    private boolean isActive;

    @JsonIgnore
    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL)
    private List<Answer> answerList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
