package com.example.advertmanagerapp.aspect;

import com.example.advertmanagerapp.dto.CaptureDto;
import com.example.advertmanagerapp.dto.PictureDto;
import com.example.advertmanagerapp.generate.CreateCarBrandResponse;
import com.example.advertmanagerapp.model.*;
import com.example.advertmanagerapp.mq.service.SoapProducer;
import com.example.advertmanagerapp.repository.*;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SoapAspect {

	@Autowired
	private SoapProducer soapProducer;
	@Autowired
	private CarBrandRepository carBrandRepository;
	@Autowired
	private CarClassRepository carClassRepository;
	@Autowired
	private CarFuelTypeRepository carFuelTypeRepository;
	@Autowired
	private CarModelRepository carModelRepository;
	@Autowired
	private CarTransmissionTypeRepository carTransmissionTypeRepository;
	@Autowired
	private PictureRepository pictureRepository;
	@Autowired
	private AdvertRepository advertRepository;

	//BRAND
	@AfterReturning(value = "execution(* com.example.advertmanagerapp.service.impl.CarBrandServiceImpl.saveCarBrand(..))", returning = "carBrand")
	public void afterSavedCarBrand(JoinPoint joinPoint, CarBrand carBrand) {
		soapProducer.produceCarBrand(carBrand);
	}
	@After(value = "execution(* com.example.advertmanagerapp.service.impl.CarBrandServiceImpl.updateCarBrand(..)) and args(carBrand)")
	public void afterUpdateCarBrand(JoinPoint joinPoint, CarBrand carBrand) {
		soapProducer.produceCarBrand(carBrand);
	}
	@After(value = "execution(* com.example.advertmanagerapp.service.impl.CarBrandServiceImpl.deleteCarBrand(..)) and args(id)")
	public void afterDeleteCarBrand(JoinPoint joinPoint, Long id) {
		soapProducer.produceCarBrand(carBrandRepository.getOne(id));
	}
	//CLASS
	@AfterReturning(value = "execution(* com.example.advertmanagerapp.service.impl.CarClassServiceImpl.saveCarClass(..))", returning = "carClass")
	public void afterSavedCarClass(JoinPoint joinPoint, CarClass carClass) {
		soapProducer.produceCarClass(carClass);
	}
	@After(value = "execution(* com.example.advertmanagerapp.service.impl.CarClassServiceImpl.deleteCarClass(..)) and args(id)")
	public void afterDeleteCarClass(JoinPoint joinPoint, Long id) {
		soapProducer.produceCarClass(carClassRepository.getOne(id));
	}
	//FUEL TYPE
	@AfterReturning(value = "execution(* com.example.advertmanagerapp.service.impl.CarFuelTypeServiceImpl.saveFuelType(..))", returning = "carFuelType")
	public void afterSavedCarFuel(JoinPoint joinPoint, CarFuelType carFuelType) {
		soapProducer.produceCarFuelType(carFuelType);
	}
	@After(value = "execution(* com.example.advertmanagerapp.service.impl.CarFuelTypeServiceImpl.deleteFuelTypeService(..)) and args(id)")
	public void afterDeleteCarFuel(JoinPoint joinPoint, Long id) {
		soapProducer.produceCarFuelType(carFuelTypeRepository.getOne(id));
	}
	//MODEL
	@AfterReturning(value = "execution(* com.example.advertmanagerapp.service.impl.CarModelServiceImpl.saveCarModel(..))", returning = "carModel")
	public void afterSavedCarModel(JoinPoint joinPoint, CarModel carModel) {
		soapProducer.produceCarModel(carModel);
	}
	@After(value = "execution(* com.example.advertmanagerapp.service.impl.CarModelServiceImpl.deleteCarModel(..)) and args(id)")
	public void afterDeleteCarModel(JoinPoint joinPoint, Long id) {
		soapProducer.produceCarModel(carModelRepository.getOne(id));
	}
	//TRANSMISSIOM
	@AfterReturning(value = "execution(* com.example.advertmanagerapp.service.impl.CarTranssmisionTypeServiceImpl.saveCarTranssmisionType(..))", returning = "carTransmissionType")
	public void afterSavedCarTransmission(JoinPoint joinPoint, CarTransmissionType carTransmissionType) {
		soapProducer.produceCarTransmission(carTransmissionType);
	}
	@After(value = "execution(* com.example.advertmanagerapp.service.impl.CarTranssmisionTypeServiceImpl.deleteCarTranssmision(..)) and args(id)")
	public void afterDeleteCarTransmissin(JoinPoint joinPoint, Long id) {
		soapProducer.produceCarTransmission(carTransmissionTypeRepository.getOne(id));
	}
	//Picture
	@AfterReturning(value = "execution(* com.example.advertmanagerapp.service.impl.PictureServiceImplementation.savePicture(..)) and args(picture)")
	public void afterSavedCarPicture(JoinPoint joinPoint, PictureDto picture) {
		soapProducer.producePicture(pictureRepository.findByPath(picture.getPath()));
	}
	//PRICE
	@AfterReturning(value = "execution(* com.example.advertmanagerapp.service.impl.PriceServiceImplementation.savePrice(..)", returning = "price")
	public void afterSavedPrice(JoinPoint joinPoint, Price price) {
		soapProducer.producePrice(price);
	}
	//ADVERT
	@AfterReturning(value = "execution(* com.example.advertmanagerapp.service.impl.AdvertServiceImpl.createAdvert(..)) and args(ad)")
	public void afterSavedAdvert(JoinPoint joinPoint, Advert ad) {
		soapProducer.produceAdvert(ad);
	}
	//CAPTURE
	@AfterReturning(value = "execution(* com.example.advertmanagerapp.service.impl.CaptureServiceImplementation.createNewCapture(..)) and args(captureDto)", returning = "capture")
	public void afterCreateCapture(JoinPoint joinPoint, CaptureDto captureDto, Capture capture) {

		soapProducer.produceCapture(capture);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {}

		soapProducer.produceAdvert(advertRepository.getOne(captureDto.getAdvertId()));
	}
	//Drive REPORT


}


