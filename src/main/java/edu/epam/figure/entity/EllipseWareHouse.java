package edu.epam.figure.entity;

import java.util.HashMap;
import java.util.Map;

public class EllipseWareHouse {

    private static EllipseWareHouse instance;
    private Map<Long, EllipseData> ellipses;

    private EllipseWareHouse() {
        this.ellipses = new HashMap<>();
    }

    public static EllipseWareHouse getInstance() {
        if (instance == null) {
            instance = new EllipseWareHouse();
        }
        return instance;
    }

    public void put(long ellipseId, EllipseData data) {
        ellipses.put(ellipseId, data);
    }

    public void remove(long ellipseId) {
        ellipses.remove(ellipseId);
    }

    public EllipseData get(long id) {
        return new HashMap<>(ellipses).get(id);
    }
}
