package com.tobeto.rentacarworkshop.repositories;

import com.tobeto.rentacarworkshop.entities.Color;
import com.tobeto.rentacarworkshop.services.dtos.color.responses.GetListColorResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ColorRepository extends JpaRepository<Color,Integer>
{
    List<Color> getByNameStartingWith(String name);
    @Query("Select new com.tobeto.rentacarworkshop.services.dtos.color.responses.GetListColorResponse(co.id,co.name)" +
            "From Color co WHERE co.name= :name ")
    List<GetListColorResponse> findByName(String name);
}
