package collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = false;
        if (!citizens.containsKey(citizen)) {
            citizens.put(citizen.getPassport(), citizen);
            rsl = true;
        }
        return rsl;
    }

    public Citizen get(String passport) {
        Citizen rsl = null;
        for (String key : citizens.keySet()) {
            if (citizens.get(key).getPassport().equals(passport)) {
                rsl = citizens.get(key);
            }
        }
        return rsl;
    }
}