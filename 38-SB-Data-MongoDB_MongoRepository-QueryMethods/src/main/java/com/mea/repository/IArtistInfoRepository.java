package com.mea.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mea.document.ArtistInfo;

public interface IArtistInfoRepository extends MongoRepository<ArtistInfo, String> {

	@Query(fields = "{name:1,category:1,remuneration:1}", value = "{category:?0}")  //valid, by-default id property will be involved automatically
	//@Query(fields = "{id:0,name:1,category:1,remuneration:1}", value = "{category:?0}")  //valid, id property will not be involved bcoz id:0
	//@Query(fields = "{id:1,name:1,category:1,remuneration:1}", value = "{category:?0}")  //valid, id property will be involved bcoz id:1
	//@Query(fields = "{id:1,name:0,category:1,remuneration:1}", value = "{category:?0}")  //invalid, 0/1 is allowed only for id property.
	public List<Object[]> getArtistDataByCategory(String category);
	
	//without Query methods
	public List<ArtistInfo> getAllArtistInfosByCategory(String category);
	
	
	//@Query(value = "{category:?0}") //valid
	@Query(fields = "{}" , value = "{category:?0}") //valid
	public List<ArtistInfo> fetchAllArtistInfosByCategory(String category);
	
	
	@Query(fields = "{}" , value = "{category:?0,name:?1}") //valid
	public List<ArtistInfo> fetchAllArtistInfosByCategoryAndName(String category,String name);
	
	//@Query(fields = "{}" , value = "{remuneration:{$gte:?0},remuneration:{$lte:?1}}") //valid =>where remuneration>= ?0 OR remuneration<= ?1
	@Query(fields = "{}" , value = "{remuneration:{$gte:?0,$lte:?1}}") //valid =>where remuneration>= ?0 AND remuneration<= ?1
	public List<ArtistInfo> getArtistInfosAllDataByRemuneration(double start,double end);
	
	//@Query(fields = "{id:1,name:1,category:1,remuneration:1}", value = "{category:?0,name:?1}")  // where category:?0 AND name:?1
	@Query(fields = "{id:1,name:1,category:1,remuneration:1}", value = "{$or[{category:?0},{name:?1}]}") //where category:?0 OR name:?1
	//@Query(fields = "{id:1,name:1,category:1,remuneration:1}", value = "{{category:?0},{name:?1}]}") //where category:?0 OR name:?1
	public List<Object[]> getArtistDataByCategoryOrName(String category,String name);
	
	//@Query(value = "{name:{'$regex':?0,'$options':'i'}}")  //'i' for disabling case-sensitivity 'r/R'=> like '%initialChars%'
	@Query(value = "{name:{'$regex':?0}}")  //this is case-sensitivity 'r'=> like '%initialChars%'
	public List<ArtistInfo> getArtistDataByNameInitialChars(String initialChars);
}
