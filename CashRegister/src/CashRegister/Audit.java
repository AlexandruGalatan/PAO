package CashRegister;

import java.sql.Timestamp;

public class Audit {
    private static Audit single_instance = null;

    DataStore dataStore = DataStore.getInstance();

    public static Audit getInstance()
    {
        if (single_instance == null)
            single_instance = new Audit();

        return single_instance;
    }

    public void log(String actionName){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String csv = actionName.concat(",").concat(String.valueOf(timestamp));
        dataStore.writeUsingBufferedWriter(csv, "audit.csv");
    }
}
