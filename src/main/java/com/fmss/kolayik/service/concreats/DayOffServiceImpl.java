package com.fmss.kolayik.service.concreats;

import com.fmss.kolayik.client.dto.request.DayOffRequestDto;
import com.fmss.kolayik.client.dto.request.UpdateDayOffRequestDto;
import com.fmss.kolayik.client.dto.response.DayOffResponseDto;
import com.fmss.kolayik.exceptions.DayOffNotFoundException;
import com.fmss.kolayik.mapper.DayOffMapper;
import com.fmss.kolayik.model.DayOff;
import com.fmss.kolayik.repository.DayOffRepository;
import com.fmss.kolayik.service.abstracts.DayOffService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayOffServiceImpl implements DayOffService {

    private final DayOffRepository dayOffRepository;
    private final DayOffMapper dayOffMapper;


    public DayOffServiceImpl(DayOffRepository dayOffRepository, DayOffMapper dayOffMapper) {
        this.dayOffRepository = dayOffRepository;
        this.dayOffMapper = dayOffMapper;
    }




    @Override
    public void createDayOff(DayOffRequestDto dayOffRequestDto) {

        dayOffRepository.save(dayOffMapper.ToDayOffFromDayOffRequestDto(dayOffRequestDto));

    }

    @Override
    public List<DayOffResponseDto> getAllDayOff() {
        return dayOffRepository.findAll().stream().map(dayOffMapper::toDayOffResponseDtoFromDayOff).toList();
    }

    @Override
    public List<DayOffResponseDto> getDayOffByUserId(Long userId) {
        return dayOffRepository.findAllByUser_UserId(userId).stream().map(dayOffMapper::toDayOffResponseDtoFromDayOff).toList();
    }

    @Override
    public void deleteDayOffById(Long dayOffId) {
        dayOffRepository.deleteById(dayOffId);

    }

    @Override
    public UpdateDayOffRequestDto updateDayOff(Long dayOffId, UpdateDayOffRequestDto updateDayOffRequestDto) {
        dayOffRepository.findById(dayOffId).orElseThrow(()->new DayOffNotFoundException("İzin Bulunamadı"));
        dayOffRepository.updateDayOff(updateDayOffRequestDto.getDayOffComment(),
               updateDayOffRequestDto.getDayOffType(),
               updateDayOffRequestDto.getStartDate(),
               updateDayOffRequestDto.getFinishDate(),
               dayOffId);
        return updateDayOffRequestDto;
    }


}
