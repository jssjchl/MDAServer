package com.mda.server.service.place;

import com.mda.server.domain.place.Place;
import com.mda.server.domain.place.PlaceRepository;
import com.mda.server.domain.user.User;
import com.mda.server.web.dto.PlaceDto;
import com.mda.server.web.dto.PlaceResponseDto;
import com.mda.server.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PlaceService {

    @Autowired
    PlaceRepository placeRepository;

    public List<Place> getPlaceList() {
        return (List<Place>) placeRepository.findAll();
    }

    @Transactional
    public Place save(PlaceDto place) {
        return placeRepository.save(place.toEntity());
    }

    public PlaceResponseDto findById(Integer id) {
        Place entity = placeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("이게뭐냐"));
        return new PlaceResponseDto(entity);
    }

}