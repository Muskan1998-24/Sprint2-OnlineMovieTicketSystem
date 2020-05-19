package com.capg.seatmgt.service;

import com.capg.seatmgt.entities.Seat;
import com.capg.seatmgt.exceptions.SeatNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import java.util.List;

@DataJpaTest// for jpa tests
@ExtendWith(SpringExtension.class)// integrate spring test framework with junit5
@Import(SeatServiceImpl.class)
// importing RoomServiceImpl class as @DatajpaTest will only only search for repositories
class SeatManagementServiceImplTests
{

    @Autowired
    private ISeatService service;

    @Autowired
    private EntityManager entityManager;


}
