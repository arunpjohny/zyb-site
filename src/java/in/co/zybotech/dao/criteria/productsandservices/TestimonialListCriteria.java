package in.co.zybotech.dao.criteria.productsandservices;

import java.util.Map;

import in.co.zybotech.core.dao.criteria.impl.BaseSearchCriteria;

public class TestimonialListCriteria extends BaseSearchCriteria {

	private boolean showHidden;

	public TestimonialListCriteria() {
		setDefaultSort("order");
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
		return "from Testimonial po"
				+ (showHidden ? "" : " where po.hidden = :hidden");
	}

	@Override
	protected void addColumns(Map<String, String> columnMap) {
		columnMap.put("order", "order");
	}

	@Override
	public void addParameters(Map<String, Object> parameters) {
		if (!showHidden) {
			parameters.put("hidden", false);
		}
	}
}
