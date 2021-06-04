package com.mda.server.service.Location;

import com.mda.server.domain.evalDetail.QEvalDetail;
import com.mda.server.domain.place.Place;
import com.mda.server.domain.place.QPlace;
import com.mda.server.domain.schedule.Schedule;
import com.mda.server.domain.schedule.ScheduleRepository;
import com.mda.server.web.dto.LocInitSet;
import com.mda.server.web.dto.midAndPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.ArrayList;
import java.util.List;

@Transactional(value = "transactionManager")
@Service("locationService2")


public class LocationService extends QuerydslRepositorySupport{

    public LocationService() {
        super(midAndPlace.class);
    }
    private @Autowired ScheduleRepository scheduleRepository;

    public List<Place>getPlaceDetailInfo(LocInitSet locset, String stnNm){

        QPlace place = QPlace.place;
        QEvalDetail evalDt = QEvalDetail.evalDetail;
        List<Place> placeList = new ArrayList<>();
//        String[]tempSchTypeArray = locset.getSchType().split(" #");
//        Integer[]schTypeArray = new Integer[tempSchTypeArray.length];
//        for (int i=0; i<tempSchTypeArray.length; i++){
//            schTypeArray[i] = Integer.parseInt(tempSchTypeArray[i]);
//        }



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


    public int saveSchedule(Schedule sc){
        Schedule schedule = scheduleRepository.save(sc);
        int schId = schedule.getScheduleId();
        return schId;
    }


}
