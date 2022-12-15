package com.fmss.kolayik.service.abstracts;

import com.fmss.kolayik.client.dto.request.DayOffRequestDto;
import com.fmss.kolayik.client.dto.request.UpdateDayOffRequestDto;
import com.fmss.kolayik.client.dto.response.DayOffResponseDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface DayOffService {


    void createDayOff(DayOffRequestDto dayOffRequestDto);
    List<DayOffResponseDto> getAllDayOff();
    List<DayOffResponseDto> getDayOffByUserId(Long userId);
    void deleteDayOffById(Long dayOffId);

    UpdateDayOffRequestDto updateDayOff(Long dayOffId, UpdateDayOffRequestDto updateDayOffRequestDto);
}
