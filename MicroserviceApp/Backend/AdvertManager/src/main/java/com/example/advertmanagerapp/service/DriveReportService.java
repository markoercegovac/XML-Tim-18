package com.example.advertmanagerapp.service;

import com.example.advertmanagerapp.dto.DriveReportDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DriveReportService {

    void addNewReport(DriveReportDto newReport);
    List<DriveReportDto> getAllReportsByCarId(Long carId);
}
