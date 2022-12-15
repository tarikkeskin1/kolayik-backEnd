package com.fmss.kolayik.model;

import com.fmss.kolayik.model.enums.DayOffType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name="day_off")
public class DayOff implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="day_off_id")
    private Long dayOffId;

    @Column(name="total_day")
    private int totalDay;

    @Column(name="start_date")
    private LocalDate startDate;

    @Column(name="finish_date")
    private LocalDate finishDate;

    @Column(name="day_off_comment")
    private String dayOffComment;

    @Column(name="day_off_type")
    @Enumerated(EnumType.STRING)
    private DayOffType dayOffType;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;




}
