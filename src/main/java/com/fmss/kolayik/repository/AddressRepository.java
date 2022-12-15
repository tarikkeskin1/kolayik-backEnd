package com.fmss.kolayik.repository;

import com.fmss.kolayik.model.Adress;
import com.fmss.kolayik.model.DayOff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Adress,Long> {
}
