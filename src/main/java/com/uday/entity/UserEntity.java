package com.uday.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "User_DTLS")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userTraceId;

	private String planId;

	private Double benefitAmt;

	private LocalDate eligStartDate;

	private LocalDate eligEndDate;

	private String denialRsn;

	private Long giftNum;

	private String giftVocherStatus;

}
