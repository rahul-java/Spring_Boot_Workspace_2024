package com.mea.document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Document(collection = "COLLECTION_ARTIST_INFO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtistInfo {

	@Id
	private String id;
	private String name;
	private String category;
	private Double remuneration;
	
	private String[] friends;
	private List<String> nickNames;
	private Set<Long> phoneNumbers;
	private Map<String, Integer> moviesInfo;
	private Properties idDetails;
	
}
