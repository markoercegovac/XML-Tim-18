package com.example.advertmanagerapp.service.impl;

import com.example.advertmanagerapp.dto.DriveReportDto;
import com.example.advertmanagerapp.model.ConcreteCar;
import com.example.advertmanagerapp.model.DriveReport;
import com.example.advertmanagerapp.repository.ConcreteCarRepository;
import com.example.advertmanagerapp.repository.DriveReportRepository;
import com.example.advertmanagerapp.service.DriveReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DriveReportServiceImpl implements DriveReportService {

    private final DriveReportRepository driveReportRepository;
    private final ConcreteCarRepository carRepository;


    @Override
    public void addNewReport(DriveReportDto newReport) {

        DriveReport report = new DriveReport();
        ConcreteCar car = this.carRepository.findAllById(newReport.getCarId());
        report.setId(newReport.getId());
        report.setDateOfReport(newReport.getDateOfReport());
        report.setDescribe(newReport.getDescribe());
        report.setTraveledDistance(newReport.getTraveledDistance());

        car.getReports().add(report);
        carRepository.save(car);
    }

    @Override
    public List<DriveReportDto> getAllReportsByCarId(Long carId) {

        List<DriveReport> listaPom = new ArrayList<>( this.driveReportRepository.findAll());

        System.out.println("Id auta" + carId);

        List<DriveReport>  lista =new ArrayList<DriveReport>();

        for(DriveReport dr: listaPom) {
            System.out.println(dr);
            ConcreteCar c = carRepository.findByReportsId(dr.getId());

            if(c.getId().equals(carId)) {
                lista.add(dr);
            }
        }

        List<DriveReportDto> listaDto= new ArrayList<>();

        for (DriveReport d: lista) {
            ConcreteCar c = carRepository.findByReportsId(d.getId());
            DriveReportDto report = new DriveReportDto();
            report.setId(d.getId());
            report.setTraveledDistance(d.getTraveledDistance());
            report.setDateOfReport(d.getDateOfReport());
            report.setDescribe(d.getDescribe());
            report.setCarId(c.getId());

            listaDto.add(report);
        }
        return listaDto;
    }
    }

