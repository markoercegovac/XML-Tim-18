package com.example.request.convertor;

import com.example.request.dto.AdRequestForClientDTO;
import com.example.request.model.RequestBundle;

public abstract class FromRequestBundleToAdRequestForClient {

    public static AdRequestForClientDTO convert(RequestBundle bundle) {
        AdRequestForClientDTO retVal = new AdRequestForClientDTO();
        retVal.setAdvertOwnerEmail(bundle.getOwnerEmail());
        retVal.setPriceWithDiscount(bundle.getPriceWithDiscount());
        retVal.setRequestBundleId(bundle.getRequestBundleId());
        retVal.setStatus(bundle.getAdvertState().toString());

        return retVal;
    }
}
