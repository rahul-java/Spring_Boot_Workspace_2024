package com.mea.service;

import java.util.List;

public interface IOneToManyMgmtService {

	public List<Object[]> fetchParentToChildJoinsData();
	public List<Object[]> fetchChildToParentJoinsData();
}
