package in.co.zybotech.dao.criteria.placement;

import java.util.Map;

import in.co.zybotech.core.dao.criteria.impl.BaseSearchCriteria;

public class OpeningListCriteria extends BaseSearchCriteria {

	public OpeningListCriteria() {
		setDefaultSort("createdDate");
		setDir("desc");
	}

	@Override
	protected String getSelectSql() {
		return "select po";
	}

	@Override
	protected String getBaseSql() {
		return "from PlacementOpening po";
	}

	@Override
	protected void addColumns(Map<String, String> columnMap) {
		columnMap.put("createdDate", "createdDate");
	}

	@Override
	protected void addParameters(Map<String, Object> parameters) {

	}

}
