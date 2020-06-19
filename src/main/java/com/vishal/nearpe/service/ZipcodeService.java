package com.vishal.nearpe.service;

import com.querydsl.jpa.impl.JPAQuery;
import com.vishal.nearpe.entity.QZipcodes;
import com.vishal.nearpe.entity.Zipcodes;
import com.vishal.nearpe.repository.ZipcodesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ZipcodeService {

    @Autowired
    ZipcodesRepository zipcodesRepository;

    @Autowired
    private EntityManager entityManager;

    public List<String> getState(){

        JPAQuery<Zipcodes> query = new JPAQuery(entityManager);
        QZipcodes zipcodes = QZipcodes.zipcodes;
        List<String> allStates = query.select(zipcodes.state).from(zipcodes).distinct().fetchResults().getResults();

        return allStates;

    }

    public List<String> getCity(String states){

        JPAQuery<Zipcodes> query = new JPAQuery(entityManager);
        QZipcodes zipcodes = QZipcodes.zipcodes;
        List<String> allCities = query.select(zipcodes.city).from(zipcodes).distinct().where(zipcodes.state.eq(states)).fetchResults().getResults();

        return allCities;
    }

    public List<Integer> getZip(String city){

        JPAQuery<Zipcodes> query = new JPAQuery(entityManager);
        QZipcodes zipcodes = QZipcodes.zipcodes;
        List<Integer> zip = query.select(zipcodes.zip).from(zipcodes).where(zipcodes.city.eq(city)).fetchResults().getResults();

        return zip;
    }
}
