package com.example.advert_search.model;



import com.example.advert_search.dto.AdvertCopyDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@RequiredArgsConstructor
@Data
@Entity
@Table
public class CarReservedDate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long carReservedDateId;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column
    private Date startOfAdvert;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column
    private Date endOfAdvert;



    public CarReservedDate(Date datep1, Date datek1) {
        this.startOfAdvert=datep1;
        this.endOfAdvert=datek1;
    }
}
