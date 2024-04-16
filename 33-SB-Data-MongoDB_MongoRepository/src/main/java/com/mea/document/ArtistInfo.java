package com.mea.document;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class ArtistInfo {

	@Id
	private String id;
	@NonNull
	private String name;
	@NonNull
	private String category;
	@NonNull
	private Double remuneration;
	@NonNull
	private LocalDateTime dob;
	@NonNull
	private boolean isMarried;
	
}
