package com.example.request.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.example.request.model.AdvertStateEnum;
import com.example.request.model.RequestBundle;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace=Replace.NONE)
// @SpringBootTest(classes = RequestApplication.class)
public class RequestBundleCreationDateTest {
	
	@Autowired
	private RequestBundleRepository bundleRepository;

	private String pera = "pera@mail.com";
	private String mika = "mika@mail.com";

	private Date today = new Date();
	private Date yesterDay;
	private Date twoDaysBefore;

	@Before
	public void setUp() {

		RequestBundle b1 = new RequestBundle();
		RequestBundle b2 = new RequestBundle();
		RequestBundle b3 = new RequestBundle();
		RequestBundle b4 = new RequestBundle();
		RequestBundle b5 = new RequestBundle();
		RequestBundle b6 = new RequestBundle();

		b1.setRequestBundleId(1l);
		b2.setRequestBundleId(2l);
		b3.setRequestBundleId(3l);
		b4.setRequestBundleId(4l);
		b5.setRequestBundleId(5l);
		b6.setRequestBundleId(6l);

		b1.setRequestingUserEmail(pera);
		b1.setAdvertState(AdvertStateEnum.PENDING);
		b1.setPriceWithDiscount(30l);
		b2.setRequestingUserEmail(pera);
		b2.setAdvertState(AdvertStateEnum.PENDING);
		b2.setPriceWithDiscount(30l);
		b3.setRequestingUserEmail(pera);
		b3.setAdvertState(AdvertStateEnum.PENDING);
		b3.setPriceWithDiscount(30l);
		b4.setRequestingUserEmail(pera);
		b4.setAdvertState(AdvertStateEnum.PENDING);
		b4.setPriceWithDiscount(30l);
		b5.setRequestingUserEmail(pera);
		b5.setAdvertState(AdvertStateEnum.PENDING);
		b5.setPriceWithDiscount(30l);
		b6.setRequestingUserEmail(pera);
		b6.setAdvertState(AdvertStateEnum.PENDING);
		b6.setPriceWithDiscount(30l);

		b1.setOwnerEmail(pera);
		b2.setOwnerEmail(pera);
		b3.setOwnerEmail(pera);
		b4.setOwnerEmail(pera);
		b5.setOwnerEmail(mika);
		b6.setOwnerEmail(mika);

		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -1);
		yesterDay = c.getTime();

		Calendar c1 = Calendar.getInstance();
		c1.add(Calendar.DATE, -2);
		twoDaysBefore = c1.getTime();

		b1.setCreationDateAndTime(today);
		b2.setCreationDateAndTime(yesterDay);
		b3.setCreationDateAndTime(yesterDay);
		b4.setCreationDateAndTime(twoDaysBefore);
		b5.setCreationDateAndTime(today);
		b6.setCreationDateAndTime(yesterDay);

		bundleRepository.save(b1);
		bundleRepository.save(b2);
		bundleRepository.save(b3);
		bundleRepository.save(b4);
		bundleRepository.save(b5);
		bundleRepository.save(b6);
	}

	@Test
	public void shouldReturnb2b3b4() {
		
		List<RequestBundle> foundBundles = bundleRepository.findAllByOwnerEmailAndCreationDateAndTimeBefore(
			pera, yesterDay).orElse(null);

		assertNotNull(foundBundles);
		assert(foundBundles.size() == 3);
		foundBundles.forEach(bundle -> {
			assert(bundle.getRequestBundleId().equals(4l) ||
				bundle.getRequestBundleId().equals(2l) ||
				bundle.getRequestBundleId().equals(3l));
		});
	}

	@Test
	public void shouldReturnb4() {
		
		List<RequestBundle> foundBundles = bundleRepository.findAllByOwnerEmailAndCreationDateAndTimeBefore(
			pera, twoDaysBefore).orElse(null);

		assertNotNull(foundBundles);
		assert(foundBundles.size() == 1);
		foundBundles.forEach(bundle -> {
			assert(bundle.getRequestBundleId().equals(4l));
		});
	}

	@Test
	public void shouldReturnb5b6() {
		
		List<RequestBundle> foundBundles = bundleRepository.findAllByOwnerEmailAndCreationDateAndTimeBefore(
			mika, today).orElse(null);

		assertNotNull(foundBundles);
		assert(foundBundles.size() == 2);
		foundBundles.forEach(bundle -> {
			assert(bundle.getRequestBundleId().equals(5l) ||
				bundle.getRequestBundleId().equals(6l));
		});
	}
}