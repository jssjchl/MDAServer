package com.mda.server.service.Location;

import com.mda.server.domain.evalDetail.QEvalDetail;
import com.mda.server.domain.place.Place;
import com.mda.server.domain.place.QPlace;
import com.mda.server.web.dto.LocInitSet;
import com.querydsl.core.types.CollectionExpression;
import com.querydsl.core.types.Projections;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional(value = "transactionManager")
@Service("locationService")
//extends QueryDslRepositorySupport
public class LocationService{
    public List<Place>getPlaceDetailInfo(LocInitSet locset, String stnNm){
        /*QPlace place = QPlace.place;
        QEvalDetail evalDt = QEvalDetail.evalDetail;
        List<String> schType = new ArrayList<String>();
        List<Place> placeList = new ArrayList<Place>();
        String[]schTypeArray = locset.getSchType().split("#");
        placeList.addAll( from(place).where(place.placeArea.eq(stnNm).and(place.placeCategory.eq(locset.getSchPlaceCate())
                .and(evalDt.evalDetailGender.eq(locset.getSchGender()).and(evalDt.evalDetailAge.eq(locset.getSchAge()).and(evalDt.evalSubId.in((CollectionExpression<?, ? extends Integer>) schType))))))
                .groupBy(place.placeId)
                .select(Projections.bean(Place.class, place.placeId, place.placeName, place.placeArea, place.placeType))
                .fetch());
        return placeList; */
        return null;
    }


}
