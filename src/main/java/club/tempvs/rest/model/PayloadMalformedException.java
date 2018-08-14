package club.tempvs.rest.model;

/**
 * Is thrown by an instance of class that implements the {@link Payload} interface if the expected data format,
 * structure or integrity is not met.
 */
public class PayloadMalformedException extends RuntimeException {

    /**
     * A single constructor that extends the one from {@link RuntimeException}
     * @param message Always contains the failure reason
     */
    public PayloadMalformedException(String message) {
        super(message);
    }
}
