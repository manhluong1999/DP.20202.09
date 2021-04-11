package subsystem.interbank;

/**
 * @author
 */
public class InterbankConfigs {

    public static final String GET_BALANCE_URL = "https://ecopark-system-api.herokuapp.com/api/card/balance/118609_group1_2020";
    public static final String GET_VEHICLECODE_URL = "https://ecopark-system-api.herokuapp.com/api/get-vehicle-code/1rjdfasdfas";
    public static final String PROCESS_TRANSACTION_URL = "https://ecopark-system-api.herokuapp.com/api/card/processTransaction";
    public static final String RESET_URL = "https://ecopark-system-api.herokuapp.com/api/card/reset";

    static final String PUBLIC_KEY = "AQzdE8O/fR8=";
    static final String SECRET_KEY = "BUXj/7/gHHI=";
    static final String PAY_COMMAND = "pay";
    static final String VERSION = "1.0.0";

    static final String INVALID_CARD = "01";
    static final String NOT_ENOUGH_BALANCE = "02";
    static final String INTERNAL_SERVER_ERROR = "03";
    static final String SUSPICIOUS_TRANSACTION = "04";
    static final String NOT_ENOUGH_TRANSACTION_INFO = "05";
    static final String INVALID_VERSION = "06";
    static final String INVALID_TRANSACTION_AMOUNT = "07";
    static final String NOTHING = "00";
}
