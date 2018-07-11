package club.tempvs.rest.json;

public class PayloadMalformedException extends RuntimeException {

    public PayloadMalformedException(String message) {
        super(message);
    }
}
