package com.mea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mea.document.StockDetails;
import com.mongodb.client.result.UpdateResult;

@Service("stockService")
public class StockMgmtServiceImpl implements IStockMgmtService {

	@Autowired
	private MongoTemplate template;

	@Override
	public String registerStockDetails(StockDetails details) {
		StockDetails details1 = template.save(details);
		return "Document is saved with " + details1.getId() + " id value";
	}

	@Override
	public List<StockDetails> showStockDetailsByName(String name) {

		// prepare the query object
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));
		List<StockDetails> list = template.find(query, StockDetails.class);
		return list;
	}

	@Override
	public List<StockDetails> showStockDetailsByPriceRange(double start, double end) {
		// prepare the query object
		Query query = new Query();
		query.addCriteria(Criteria.where("price").gte(start).lte(end));
		List<StockDetails> list = template.find(query, StockDetails.class);
		return list;
	}

	@Override
	public List<StockDetails> showStockDetailsByNames(String... names) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").in(names));
		List<StockDetails> list = template.find(query, StockDetails.class);
		return list;
	}

	@Override
	public String showAndUpdateStockDetailsByName(String name, String newExchange, double newPrice) {
		// Query obj to select document
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));

		// update object to modify document
		Update update = new Update();
		update.set("price", newPrice);
		update.set("exchange", newExchange);

		StockDetails andModify = template.findAndModify(query, update, StockDetails.class);
		return andModify == null ? "Document NOT FOUND to UPDATE."
				: "Doucument Found and Updated Successfully with name :" + andModify.getName();
	}

	@Override
	public String modifyExchangeByStockPriceRange(double start, double end, String newExchange) {
		// Query obj to select document
		Query query = new Query();
		query.addCriteria(Criteria.where("price").gte(start).lte(end));

		// update object to modify document
		Update update = new Update();
		update.set("exchange", newExchange);

		UpdateResult updateResult = template.updateMulti(query, update, StockDetails.class);
		return updateResult.getModifiedCount() + " no. of records modified and updated successfully";

	}

	@Override
	public String updateOrInsertStockDetails(String name, String exchange, double price, String company) {

		// Query obj to select document
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));

		// keep data for updation or insertion
		Update update = new Update();
		update.set("price", price);
		update.set("exchange", exchange); // will be used for both isertion and updation activity
		update.setOnInsert("name", name);
		update.setOnInsert("company", company); // will be used only for insertion activity

		// update the object
		UpdateResult updateResult = template.upsert(query, update, StockDetails.class);
		if (updateResult.getModifiedCount() == 0)
			return "Document is Inserted";
		else
			return "Document is Updated.";
	}

	@Override
	public String fetchAndRemoveByStockName(String name) {

		// Query obj to select document
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));

		StockDetails details = template.findAndRemove(query, StockDetails.class);
		return details == null ? "StockNotFound" : "Stock Found And Deleted Successfully...";
	}

	@Override
	public String removeStockDetailsByPriceRange(Double start, Double end) {
		// Query obj to select document
		Query query = new Query();
		query.addCriteria(Criteria.where("price").gte(start).lte(end));
		
		//remove the docs
		int count=template.findAllAndRemove(query, StockDetails.class).size();
		return count+" records are found and deleted successfully...";
	}

}
