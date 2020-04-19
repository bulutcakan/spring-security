package com.bulut.security.service.impl;


import com.bulut.security.dto.SampleDTO;
import com.bulut.security.service.DataGeneratorService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Service
public class DataGenaratorServiceImpl implements DataGeneratorService {

    ArrayList<SampleDTO> data = new ArrayList();
    int i = 1;

    @Override
    @Cacheable("demoDataCache")
    public List<SampleDTO> getSampleData() {

        IntStream.range(0, 100)
                .forEach(index -> {
                    SampleDTO sp = new SampleDTO();
                    sp.setId(i);
                    sp.setName(generateRandomString());
                    sp.setSurname(generateRandomString());
                    sp.setAge(getRandomNumberInRange(1, 100));
                    data.add(sp);
                    i++;

                });
        return data;
    }

    @Override
    @CachePut(value = "demoDataCache", key = "#sampleDTO.id")
    public SampleDTO save(SampleDTO sampleDTO) {
        sampleDTO.setId(i);
        data.add(sampleDTO);
        return sampleDTO;
    }

    @Override
    @CacheEvict(value = "demoDataCache", key = "#id")
    public void delete(long id) {
        data.removeIf(sampleDTO -> sampleDTO.getId() == id);
    }

    @Override
    @CacheEvict(value = "demoDataCache", key = "#sampleDTO.id")
    public SampleDTO update(SampleDTO sampleDTO) {
        SampleDTO sp = data.stream().filter(sampleDTO1 -> sampleDTO1.getId() ==
                sampleDTO.getId()).findFirst().get();
        sp.setName(sampleDTO.getName());
        sp.setSurname(sampleDTO.getSurname());
        sp.setAge(sampleDTO.getAge());
        return sampleDTO;
    }

    public String generateRandomString() {
        return RandomStringUtils.randomAlphabetic(4);
    }

    private int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.ints(min, (max + 1)).findFirst().getAsInt();
    }
}
