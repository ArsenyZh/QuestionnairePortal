package com.project.Questionnaire.portal.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "options")
public class Options {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "option")
    private String option;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "field_id", referencedColumnName = "id")
    private Field field;
}
