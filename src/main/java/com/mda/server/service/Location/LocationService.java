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
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


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
        String cate = locset.getSchPlaceCate();
        String[]tempSchTypeArray = locset.getSchType().split(" #");
        Integer[]schTypeArray = new Integer[tempSchTypeArray.length];
        for (int i=0; i<tempSchTypeArray.length; i++){
            switch (tempSchTypeArray[i]){
                case "Western_Food": schTypeArray[i] = 1;
                    break;
                case "Korean_Food": schTypeArray[i] = 2;
                    break;
                case "Japenese_Food": schTypeArray[i] = 3;
                    break;
                case "Date":
                        if(cate.equalsIgnoreCase("restaurant")){
                            schTypeArray[i] = 4;
                        }else if(cate.equalsIgnoreCase("cafe")){
                            schTypeArray[i] = 16;
                        }else{
                            schTypeArray[i] = 19;
                        }
                    break;
                case "Good_vibes":
                        if(cate.equalsIgnoreCase("restaurant")){
                            schTypeArray[i] = 5;
                        }else if(cate.equalsIgnoreCase("cafe")){
                            schTypeArray[i] = 10;
                        }
                    break;
                case "Anniversary":
                        if(cate.equalsIgnoreCase("restaurant")){
                            schTypeArray[i] = 6;
                        }else if(cate.equalsIgnoreCase("activity")){
                            schTypeArray[i] = 23;
                        }
                    break;
                case "Franchise":
                        if(cate.equalsIgnoreCase("restaurant")){
                            schTypeArray[i] = 7;
                        }else if(cate.equalsIgnoreCase("cafe")){
                            schTypeArray[i] = 15;
                        }
                    break;
                case "Family_meal": schTypeArray[i] = 8;
                    break;
                case "Pic_of_day": schTypeArray[i] = 9;
                    break;
                case "Brunch": schTypeArray[i] = 11;
                    break;
                case "Studying": schTypeArray[i] = 12;
                    break;
                case "Dessert": schTypeArray[i] = 13;
                    break;
                case "MeetingRoom": schTypeArray[i] = 14;
                    break;
                case "Active": schTypeArray[i] = 17;
                    break;
                case "Shopping": schTypeArray[i] = 18;
                    break;
                case "Friend": schTypeArray[i] = 20;
                    break;
                case "healing": schTypeArray[i] = 21;
                    break;
                case "Kids": schTypeArray[i] = 22;
                    break;
                case "Pet": schTypeArray[i] = 24;
                    break;
            }
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
        sch = this.scheduleRepository.save(sc);
        int schId = sch.getScheduleId();
        return schId;
    }


}
