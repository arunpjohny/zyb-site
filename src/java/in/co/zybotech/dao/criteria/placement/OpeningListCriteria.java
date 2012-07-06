package in.co.zybotech.dao.criteria.placement;

import java.util.Map;

import in.co.zybotech.core.dao.criteria.impl.BaseSearchCriteria;

public class OpeningListCriteria extends BaseSearchCriteria {

	private boolean showHidden;

	public OpeningListCriteria() {
		setDefaultSort("createdDate");
		setDir("desc");
	}

	public void setShowHidden(boolean showHidden) {
		this.showHidden = showHidden;
	}

	@Override
	protected String getSelectSql() {
		return "select po";
	}

	@Override
	protected String getBaseSql() {
		return "from PlacementOpening po"
				+ (showHidden ? "" : " where po.hidden = :hidden");
	}

	@Override
	protected void addColumns(Map<String, String> columnMap) {
		columnMap.put("createdDate", "createdDate");
	}

	@Override
	public void addParameters(Map<String, Object> parameters) {
		if (!showHidden) {
			parameters.put("hidden", false);
		}
	}
}
