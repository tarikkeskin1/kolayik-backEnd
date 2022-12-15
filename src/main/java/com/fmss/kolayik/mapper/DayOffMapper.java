package com.fmss.kolayik.mapper;

import com.fmss.kolayik.client.dto.request.DayOffRequestDto;
import com.fmss.kolayik.client.dto.response.DayOffResponseDto;
import com.fmss.kolayik.model.DayOff;
import com.fmss.kolayik.model.User;
import org.springframework.stereotype.Component;

@Component
public class DayOffMapper {


    public DayOffResponseDto toDayOffResponseDtoFromDayOff(DayOff dayOff){
     final var dayOffResponseDto=new DayOffResponseDto();

      dayOffResponseDto.setDayOffComment(dayOff.getDayOffComment());
      dayOffResponseDto.setTotalDay(dayOff.getTotalDay());
      dayOffResponseDto.setStartDate(dayOff.getStartDate());
      dayOffResponseDto.setFinishDate(dayOff.getFinishDate());
      dayOffResponseDto.setUserId(User.builder().userId(dayOff.getUser().getUserId()).build().getUserId());
      dayOffResponseDto.setSurName((dayOff.getUser().getSurName()));
      dayOffResponseDto.setUserName(dayOff.getUser().getName());
      dayOffResponseDto.setDayOffId(dayOff.getDayOffId());
      return dayOffResponseDto;

    }

    public DayOff ToDayOffFromDayOffRequestDto(DayOffRequestDto dayOffRequestDto){
          final var dayOff=new DayOff();
         dayOff.setUser(User.builder().userId(dayOffRequestDto.getUserId()).build());
         dayOff.setTotalDay(dayOffRequestDto.getTotalDay());
         dayOff.setStartDate(dayOffRequestDto.getStartDate());
         dayOff.setFinishDate(dayOffRequestDto.getFinishDate());
         dayOff.setDayOffType(dayOffRequestDto.getDayOffType());
         dayOff.setDayOffComment(dayOffRequestDto.getDayOffComment());
         return dayOff;
    }
}
