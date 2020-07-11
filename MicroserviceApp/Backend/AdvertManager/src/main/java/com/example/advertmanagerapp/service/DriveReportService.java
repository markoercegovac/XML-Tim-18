package com.example.advertmanagerapp.service;

import com.example.advertmanagerapp.dto.DriveReportDto;
import com.example.advertmanagerapp.model.DriveReport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DriveReportService {

    DriveReport addNewReport(DriveReportDto newReport);
    List<DriveReportDto> getAllReportsByCarId(Long carId);
}
