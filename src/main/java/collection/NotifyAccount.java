package collection;

import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class NotifyAccount {
    public static Set<Account> sent(List<Account> accounts) {
        Set<Account> rsl = new HashSet<>();
        for (Account acc : accounts) {
            rsl.add(acc);
        }
        return rsl;
    }
}

