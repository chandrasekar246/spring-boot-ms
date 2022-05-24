package com.github.chandrasekar246.shr.sample.entity;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class OVD {

	private String pan;

	private String passport;

}