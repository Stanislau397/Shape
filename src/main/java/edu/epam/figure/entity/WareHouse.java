package edu.epam.figure.entity;

import java.util.HashMap;
import java.util.Map;

public class WareHouse {

    private static WareHouse instance;
    private Map<Long, EllipseData> ellipses;

    private WareHouse() {
        this.ellipses = new HashMap<>();
    }

    public static WareHouse getInstance() {
        if (instance == null) {
            instance = new WareHouse();
        }
        return instance;
    }

    public void putToWareHouse(long ellipseId, EllipseData data) {
        ellipses.put(ellipseId, data);
    }

    public void removeFromWareHouseById(long ellipseId) {
        ellipses.remove(ellipseId);
    }

    public Map<Long, EllipseData> getEllipses() {
        return new HashMap<>(ellipses);
    }
}
