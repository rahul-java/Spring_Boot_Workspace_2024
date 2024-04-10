package com.mea.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class JobSeekerInfo implements Serializable {

	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "JSID_SEQ",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer jsId;
	
	@NonNull
	@Column(length = 20)
	private String jsName;
	@NonNull
	@Column(length = 20)
	private String jsQlfy;
	@NonNull
	private Boolean married;
	
	@Lob
	@NonNull
	private byte[] photo;
	@Lob
	@NonNull
	private char[] resume;
	
	@Version
	private Integer updationCount;
	@CreationTimestamp
	private LocalDateTime openedOn;
	@UpdateTimestamp
	private LocalDateTime lastAccessedOn;
	
}
