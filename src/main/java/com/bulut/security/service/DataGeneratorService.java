package com.bulut.security.service;


import com.bulut.security.dto.SampleDTO;

import java.util.List;

public interface DataGeneratorService {

    List<SampleDTO> getSampleData();

    SampleDTO save(SampleDTO sampleDTO);

    void delete(long id);

    SampleDTO update(SampleDTO sampleDTO);
}
