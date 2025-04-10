package coreImplmtn.RegModule.Pojo;

import java.util.List;

public class RegGetAlertPojo {
	private List<RegAlerts> alerts;
	private String dayCount;

	public void setAlerts(List<RegAlerts> alerts) {
		this.alerts = alerts;
	}

	public List<RegAlerts> getAlerts() {
		return alerts;
	}

	public String getDayCount() {
		return dayCount;
	}

	public void setDayCount(String dayCount) {
		this.dayCount = dayCount;
	}
}
