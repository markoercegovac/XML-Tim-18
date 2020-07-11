package com.example.advertmanagerapp.mq.service;

import com.example.advertmanagerapp.dto.PictureDto;
import com.example.advertmanagerapp.model.*;
import com.example.advertmanagerapp.mq.dto.*;
import com.example.advertmanagerapp.repository.*;
import com.example.advertmanagerapp.service.PictureService;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SoapConsumer {

	@Autowired
	private Gson gson;
	@Autowired
	private CarBrandRepository carBrandRepository;
	@Autowired
	private CarModelRepository carModelRepository;
	@Autowired
	private CarClassRepository carClassRepository;
	@Autowired
	private CarFuelTypeRepository carFuelTypeRepository;
	@Autowired
	private CarTransmissionTypeRepository carTransmissionTypeRepository;
	@Autowired
	private ConcreteCarRepository concreteCarRepository;
	@Autowired
	private PriceRepository priceRepository;
	@Autowired
	private PictureRepository pictureRepository;
	@Autowired
	private PictureService pictureService;
	@Autowired
	private CaptureRepository captureRepository;
	@Autowired
	private AdvertRepository advertRepository;
	@Autowired
	private DriveReportRepository driveReportRepository;
	@Autowired
	private OwnersCarRepository ownersCarRepository;

	@RabbitListener(queues="${rabbitmq.queue.soap.soap.ad}")
	public void recievedMessage(String msg) {
		System.out.println("MQ>> Got from Soap" +msg);

		String[] message = msg.split("-");

		try {
			if(message[0].equals("CarBrand")) {
				CarBrandMQ mq = gson.fromJson(msg, CarBrandMQ.class);
				CarBrand b = new CarBrand();
				b.setId(mq.getId()==0?null:mq.getId());
				b.setName(mq.getName());
				b.setRemoved(mq.isDeleted());

				carBrandRepository.save(b);
			} else if(message[0].equals("CarModel")) {
				CarModelMQ mq = gson.fromJson(msg, CarModelMQ.class);
				CarModel m = new CarModel();
				m.setId(mq.getId()==0?null:mq.getId());
				m.setModelName(mq.getName());
				m.setRemoved(mq.isDeleted());

				carModelRepository.save(m);
			} else if(message[0].equals("CarClass")) {
				CarClassMQ mq = gson.fromJson(msg, CarClassMQ.class);
				CarClass b = new CarClass();
				b.setId(mq.getId()==0?null:mq.getId());
				b.setClassName(mq.getName());
				b.setRemoved(mq.isDeleted());

				carClassRepository.save(b);
			} else if(message[0].equals("CarFuelType")) {
				CarFuelTypeMQ mq = gson.fromJson(msg, CarFuelTypeMQ.class);
				CarFuelType b = new CarFuelType();
				b.setId(mq.getId()==0?null:mq.getId());
				b.setFuelType(mq.getName());
				b.setRemoved(mq.isDeleted());

				carFuelTypeRepository.save(b);
			} else if(message[0].equals("CarTransmission")) {
				CarTransmissionMQ mq = gson.fromJson(msg, CarTransmissionMQ.class);
				CarTransmissionType b = new CarTransmissionType();
				b.setId(mq.getId()==0?null:mq.getId());
				b.setTransmissionType(mq.getName());
				b.setRemoved(mq.isDeleted());

				carTransmissionTypeRepository.save(b);
			} else if(message[0].equals("Car")) {
				CarMQ mq = gson.fromJson(msg, CarMQ.class);
				ConcreteCar b = new ConcreteCar();
				b.setId(mq.getId()==0?null:mq.getId());
				b.setCarBrand(carBrandRepository.getOne(mq.getCarBrandId()));
				b.setCarClass(carClassRepository.getOne(mq.getCarClassId()));
				b.setCarFuelType(carFuelTypeRepository.getOne(mq.getCarFuelTypeId()));
				b.setCarModel(carModelRepository.getOne(mq.getCarModelId()));
				b.setCarTransmissionType(carTransmissionTypeRepository.getOne(mq.getCarTransmissionId()));
				b.setTravelDistanceConstraint( mq.getTraveledDistanceConstraint().intValue());
				b.setChildrenSitNumber(mq.getChildrenSitNumber());
				concreteCarRepository.save(b);
			} else if(message[0].equals("CarBrand")) {
				CarBrandMQ mq = gson.fromJson(msg, CarBrandMQ.class);
				CarBrand b = new CarBrand();
				b.setId(mq.getId()==0?null:mq.getId());
				b.setName(mq.getName());
				b.setRemoved(mq.isDeleted());

				carBrandRepository.save(b);
			} else if(message[0].equals("Price")) {
				PriceMQ mq = gson.fromJson(msg, PriceMQ.class);
				Price b = new Price();
				b.setId(mq.getId()==0?null:mq.getId());
				b.setName(mq.getName());
				b.setDiscount(mq.getDiscount());
				b.setDistanceOverflowPrice(mq.getDistanceOverflowPrice());
				b.setInsurancePrice(mq.getInsurancePrice());
				b.setPricePerDay(mq.getPricePerDay());
				b.setPriceName(mq.getName());
				b.setRemoved(mq.isDeleted());

				priceRepository.save(b);
			} else if(message[0].equals("Picture")) {
				PictureMQ mq = gson.fromJson(msg, PictureMQ.class);
				Picture b = new Picture();
				b.setId(mq.getId()==0?null:mq.getId());
				b.setDeleted(mq.isDeleted());
				b.setPath(mq.getName());
				PictureDto dto = new PictureDto();
				dto.setPath(mq.getName());
				dto.setPicture(mq.getBase64());
				pictureService.savePicture(dto);
				pictureRepository.save(b);
			} else if(message[0].equals("Capture")) {
				CaptureMQ mq = gson.fromJson(msg, CaptureMQ.class);
				Capture b = new Capture();
				b.setId(mq.getId()==0?null:mq.getId());
				b.setLeaveDate(mq.getEnd());
				b.setTakeDate(mq.getStart());
				//fali advert id
				captureRepository.save(b);
			} else if(message[0].equals("Advert")) {
				AdvertMQ mq = gson.fromJson(msg, AdvertMQ.class);
				Advert b = new Advert();
				b.setId(mq.getId()==0?null:mq.getId());
				b.setConcreteCar(concreteCarRepository.getOne(mq.getCarId()));
				b.setProfilePicture(pictureRepository.getOne(mq.getProfileImgId()).getPath());
				mq.getGalleryImgIds().forEach(img -> {
					b.getPictureSet().add(pictureRepository.getOne(img));
				});
				b.setStartOfAdvert(mq.getStart());
				b.setEndOfAdvert(mq.getEnd());
				b.setDescription(mq.getDescription());
				b.setActive(!mq.isDeleted());
				mq.getCaptureIds().forEach(cap -> {
					b.getCaptures().add(captureRepository.getOne(cap));
				});

				advertRepository.save(b);
			} else if(message[0].equals("DriveReport")) {
				DriveReportMQ mq = gson.fromJson(msg, DriveReportMQ.class);

				DriveReport report = new DriveReport();
				ConcreteCar car = this.concreteCarRepository.findAllById(mq.getCarId());
				report.setId(mq.getId());
				report.setDateOfReport(mq.getDateOfReport());
				report.setDescribe(mq.getDescription());
				report.setTraveledDistance(mq.getTraveledDistance());

				car.getReports().add(report);
				concreteCarRepository.save(car);

//				driveReportRepository.save(report);
			}

		} catch(Exception e) {
			System.out.println("MQ>> EXCEPTION");
		}
	}
}
