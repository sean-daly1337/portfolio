package service;

import models.requests.ServerLocation;

public interface MapLocationService {

    ServerLocation getMapLocation(String propertyId);

}
