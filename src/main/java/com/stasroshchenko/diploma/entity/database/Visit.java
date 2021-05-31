package com.stasroshchenko.diploma.entity.database;

import com.stasroshchenko.diploma.annotation.constraint.DateOfVisitConstraint;
import com.stasroshchenko.diploma.entity.database.person.ClientData;
import com.stasroshchenko.diploma.entity.database.person.DoctorData;
import com.stasroshchenko.diploma.util.VisitStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity

//@DateIsFreeConstraint
@DateOfVisitConstraint
public class Visit {

    private static final String SEQUENCE_NAME = "visit_sequence";

    @Id
    @SequenceGenerator(
            name = SEQUENCE_NAME,
            sequenceName = SEQUENCE_NAME,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = SEQUENCE_NAME
    )
    @EqualsAndHashCode.Exclude
    private Long id;

    @OneToOne
    @JoinColumn(
            nullable = false,
            name = "doctor_id",
            foreignKey = @ForeignKey(name="FK_DOCTOR_DATA")
    )
    private DoctorData doctorData;

    @OneToOne
    @JoinColumn(
            nullable = false,
            name = "client_id",
            foreignKey = @ForeignKey(name="FK_CLIENT_DATA")
    )
    private ClientData clientData;

    @Column(nullable = false)
    private String complaint;
    private LocalDateTime acceptedAt;

    private LocalDateTime appointsAt;

    @Transient
    private String appointsAtInput;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VisitStatus status;

    public void setAppointsAtInput(String appointsAtInput) {
        this.appointsAtInput = appointsAtInput;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");

        try {
            this.appointsAt = LocalDateTime.parse(appointsAtInput, formatter);
        } catch (DateTimeParseException ex) {
            throw new IllegalStateException(ex.getMessage());
        }

    }

}
