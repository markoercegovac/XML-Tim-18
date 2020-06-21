package com.example.request.repository;

import java.util.*;

import com.example.request.model.AdvertCopy;
import com.example.request.model.AdvertStateEnum;
import com.example.request.model.Request;
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
public class RequestAdvertsDateBetweenTest {
	
	@Autowired
	private RequestBundleRepository bundleRepository;
	@Autowired
	private RequestRepository requestRepository;
	@Autowired
	private AdvertCopyRepository advertReposiotry;

	private Date[] d;
	private Request[] r;

	@Before
	public void setUp() {

		String email = "ime@mail.com";

		d = new Date[8];
		Calendar c = Calendar.getInstance();
		d[0] =  (Date) c.getTime().clone();

		for(int i=1; i<8; ++i) {
			c.add(Calendar.DATE, +1);
			d[i] = (Date) c.getTime().clone();
		}

		List<Request> req = new ArrayList<>();
		r = new Request[9];
		for(int i=0; i<9; ++i) {
			r[i] = new Request();
			r[i].setRequestId((long) i);
			if(i < 7) {
				r[i].setStartReservationDate(d[i]);
				r[i].setEndReservationDate(d[i+1]);
			} else if(i == 7) {
				r[i].setStartReservationDate(d[1]);
				r[i].setEndReservationDate(d[3]);
			} else {
				r[i].setStartReservationDate(d[4]);
				r[i].setEndReservationDate(d[6]);
			}

			requestRepository.save(r[i]);
			req.add(r[i]);
		}

		RequestBundle b = new RequestBundle();
		b.setAdvertState(AdvertStateEnum.PENDING);
		b.setCreationDateAndTime(new Date());
		b.setOwnerEmail(email);
		b.setRequestingUserEmail(email);
		b.setPriceWithDiscount(100l);
		b.setRequestBundleId(1l);

		b.setRequests(req);
		bundleRepository.save(b);

		AdvertCopy a = new AdvertCopy();
		a.setAdvertCopyId(1l);
		a.setOwnerEmail(email);
		a.setAdvertEndDate(new Date());
		a.setRequests(req);
		advertReposiotry.save(a);
	}

	@Test
	public void test() {

		List<Request> all = requestRepository.findAll();

		List<Request> found = requestRepository.findAllByAdvertIdAndDatesBetween(
			1l,
			d[2],
			d[5]).orElse(null);

		assert(found == null);
	}

	@Test
	public void test1() {

		AdvertCopy a = advertReposiotry.findByRequestsRequestId(1l).orElse(null);

		assert(a.getAdvertCopyId().equals(1l));
	}
}