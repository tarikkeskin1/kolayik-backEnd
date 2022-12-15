package com.fmss.kolayik.controller;

import com.fmss.kolayik.client.dto.request.DayOffRequestDto;
import com.fmss.kolayik.client.dto.request.UpdateDayOffRequestDto;
import com.fmss.kolayik.client.dto.response.DayOffResponseDto;
import com.fmss.kolayik.service.abstracts.DayOffService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/dayOff")
public class DayOffController {
    private final DayOffService dayOffService;


    public DayOffController(DayOffService dayOffService) {
        this.dayOffService = dayOffService;
    }

    @PostMapping()
        public void createDayOff(@RequestBody DayOffRequestDto dayOffRequestDto){
       dayOffService.createDayOff(dayOffRequestDto);
    }
    @GetMapping()
    public ResponseEntity<List<DayOffResponseDto>> getAllDayOff(){

       return ResponseEntity.ok(dayOffService.getAllDayOff());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<DayOffResponseDto>> getAllDayOffByUserId(@PathVariable Long userId){

        return ResponseEntity.ok(dayOffService.getDayOffByUserId(userId));
    }
    @DeleteMapping("/{dayOffId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteDayOff(@PathVariable Long dayOffId){
        dayOffService.deleteDayOffById(dayOffId);
    }

    @PutMapping("/{dayOffId}")
    public UpdateDayOffRequestDto updateDayOff (@PathVariable Long dayOffId,@RequestBody UpdateDayOffRequestDto updateDayOffRequestDto){
        return dayOffService.updateDayOff(dayOffId,updateDayOffRequestDto);
    }



}
