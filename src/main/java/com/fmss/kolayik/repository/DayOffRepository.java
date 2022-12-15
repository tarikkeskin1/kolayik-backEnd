package com.fmss.kolayik.repository;

import com.fmss.kolayik.model.DayOff;
import com.fmss.kolayik.model.enums.DayOffType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface DayOffRepository extends JpaRepository<DayOff,Long> {
    List<DayOff> findAllByUser_UserId(Long id);

    void deleteById(Long dayOffId);
    @Transactional
    @Modifying
    @Query(value="update DayOff d " +
            "set d.dayOffComment=:dayOffComment," +
            "d.dayOffType=:dayOffType, " +
            "d.startDate=:startDate," +
            "d.finishDate=:finishDate " +
            "where d.dayOffId=:dayOffId"
    )
    void updateDayOff(String dayOffComment, DayOffType dayOffType,LocalDate startDate,LocalDate finishDate,Long dayOffId);

}
