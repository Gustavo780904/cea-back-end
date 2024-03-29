package com.cea.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import com.cea.models.Lead;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeadDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String email;
	private String phone;
	private UUID deviceId;

	public Lead toEntity() {

		Date date = new Date();

		Lead lead = new Lead();

		lead.setName(this.name);
		lead.setEmail(this.email);
		lead.setPhone(this.phone);
		lead.setCreatedAt(date);
		lead.setDeviceId(deviceId);

		return lead;

	}

}
