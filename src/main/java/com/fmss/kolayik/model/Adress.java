package com.fmss.kolayik.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="adress")
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="adress_id")
    private Long adressId;

    @Column(name="adress")
    private String adress;

    @Column(name="country")
    private String country;

    @Column(name="city")
    private String city;

    @Column(name="post_code")
    private String postCode;

    @Column(name="phone_number")
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", referencedColumnName = "user_id")
    private User user;


}
