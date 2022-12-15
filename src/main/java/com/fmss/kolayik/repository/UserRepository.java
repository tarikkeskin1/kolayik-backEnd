package com.fmss.kolayik.repository;

import com.fmss.kolayik.client.dto.response.UserResponseDto;
import com.fmss.kolayik.model.Adress;

import com.fmss.kolayik.model.User;
import com.fmss.kolayik.model.enums.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = """ 
            select new com.fmss.kolayik.client.dto.response.UserResponseDto(
            u.userId,
            u.name,
            u.surName,
            u.email,
            u.startDateToJob,
            u.title,
            u.level,
            u.department,
            a.adress,
            a.country,
            a.city,
            a.phoneNumber)
            from User u
            inner JOIN Adress a on u.userId=a.user.userId
""")
       List<UserResponseDto> findAllUsers();



    @Query(value = """ 
            select new com.fmss.kolayik.client.dto.response.UserResponseDto(
            u.userId,
            u.name,
            u.surName,
            u.email,
            u.startDateToJob,
            u.title,
            u.level,
            u.department,
            a.adress,
            a.country,
            a.city,
            a.phoneNumber)
            from User u
            inner JOIN Adress a on u.userId=a.user.userId
            where u.userId=:userId
""")
    UserResponseDto findUserById(@Param("userId")Long userId );


    @Transactional
    @Modifying
    @Query(value ="update User u " +
            "set u.email=:email, " +
            "u.department=:department," +
            "u.salary=:salary " +
            "where u.userId=:userId"
    )
    void updateUser(String email, Department department, BigDecimal salary,Long userId);

}


