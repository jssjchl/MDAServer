package com.mda.server.service.Location;

import com.mda.server.domain.evalDetail.QEvalDetail;
import com.mda.server.domain.place.Place;
import com.mda.server.domain.place.QPlace;
import com.mda.server.web.dto.LocInitSet;
import com.mda.server.web.dto.PlaceResponseDto;
import com.mda.server.web.dto.midAndPlace;
import com.querydsl.core.types.CollectionExpression;
import com.querydsl.core.types.Projections;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Transactional(value = "transactionManager")
@Service("locationService2")
//extends QueryDslRepositorySupport

public class LocationService extends QuerydslRepositorySupport{

    public LocationService() {
        super(midAndPlace.class);
    }

    public List<Place>getPlaceDetailInfo(LocInitSet locset, String stnNm){

        QPlace place = QPlace.place;
        QEvalDetail evalDt = QEvalDetail.evalDetail;
        List<Place> placeList = new ArrayList<>();
        String[]tempSchTypeArray = locset.getSchType().split("#");
        Integer[]schTypeArray = new Integer[tempSchTypeArray.length];
        for (int i=0; i<tempSchTypeArray.length; i++){
            schTypeArray[i] = Integer.parseInt(tempSchTypeArray[i]);
        }



         /*
        placeList.addAll( from(place).join(evalDt).on(place.placeId.eq(evalDt.placeId)).where(place.placeArea.eq(stnNm).and(place.placeCategory.eq(locset.getSchPlaceCate())
                .and(evalDt.evalDetailGender.eq(locset.getSchGender()).and(evalDt.evalDetailAge.eq(locset.getSchAge()).and(evalDt.evalSubId.in(schTypeArray))))))
                .groupBy(place.placeId)
                .select(Projections.bean(Place.class, place.placeId, place.placeName, place.placeArea, place.placeType))
                .fetch());
        return placeList;
        */

        placeList.addAll( from(place).fetch());
        return placeList;

    }

}
