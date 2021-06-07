package com.mda.server.service.Location;

import com.mda.server.domain.evalDetail.QEvalDetail;
import com.mda.server.domain.place.Place;
import com.mda.server.domain.place.QPlace;
import com.mda.server.domain.schedule.QSchedule;
import com.mda.server.domain.schedule.Schedule;
import com.mda.server.domain.schedule.ScheduleRepository;
import com.mda.server.web.dto.LocInitSet;
import com.mda.server.web.dto.midAndPlace;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional(value = "transactionManager")
@Service("locationService2")


public class LocationService extends QuerydslRepositorySupport{

    public LocationService() {
        super(midAndPlace.class);
    }
    private @Autowired ScheduleRepository scheduleRepository;

    public List<Place>getPlaceDetailInfo(LocInitSet locset, String stnNm) throws UnsupportedEncodingException {

        QPlace place = QPlace.place;
        QEvalDetail evalDt = QEvalDetail.evalDetail;
        List<Place> placeList = new ArrayList<>();
        String[]tempSchTypeArray = locset.getSchType().split(" #");
        Integer[]schTypeArray = new Integer[tempSchTypeArray.length];
        for (int i=0; i<tempSchTypeArray.length; i++){
            schTypeArray[i] = Integer.parseInt(tempSchTypeArray[i]);
        }

        placeList.addAll( from(place).join(evalDt).on(place.placeId.eq(evalDt.placeId)).where(place.placeArea.eq(stnNm).and(place.placeCategory.eq(locset.getSchPlaceCate())
                .and(evalDt.evalDetailGender.eq(locset.getSchGender()).and(evalDt.evalDetailAge.eq(locset.getSchAge()).and(evalDt.evalSubId.in(schTypeArray)).and(evalDt.evalDetailRatings.gt("3"))))))
                .groupBy(place.placeId)
                .fetch());
        return placeList;

    }

    public List<Place>getTestPlaceDetail(LocInitSet locset, String stnNm){
        List<Place> placeList = new ArrayList<>();

        return placeList;
    }


    public int saveSchedule(Schedule sc){
        Schedule sch = new Schedule();
        sc.setScheduleId(null);
        sch = scheduleRepository.save(sc);
        int schId = sch.getScheduleId();
        return schId;
    }


}
