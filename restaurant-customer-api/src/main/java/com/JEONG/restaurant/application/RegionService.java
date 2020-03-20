package com.JEONG.restaurant.application;

import com.JEONG.restaurant.domain.Region;
import com.JEONG.restaurant.domain.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    private RegionRepository regionRepository;

@Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> getRegions() {

      List<Region> regions = regionRepository.findAll();

        return regions;
    }


}
