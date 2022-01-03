package com.perigea.tracker.timesheet.service;

import com.perigea.tracker.timesheet.dto.CommessaNonFatturabileDto;

public interface TrackerCommessaInterface {

	public void createCommessaNonFatturabile(CommessaNonFatturabileDto commessaParam);

	public void readCommessaNonFatturabile(CommessaNonFatturabileDto dtoParam);

	public void updateCommessaNonFatturabile(CommessaNonFatturabileDto dtoParam);

	public void deleteCommessaNonFatturabile(CommessaNonFatturabileDto dtoParam);

}
