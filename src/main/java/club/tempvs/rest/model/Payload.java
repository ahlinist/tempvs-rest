package club.tempvs.rest.model;

/**
 * Interface that is being implemented by various JSON-corresponsing POJOs.
 */
public interface Payload {

    /**
     * A method that throws {@link PayloadMalformedException} if the payload instance doesn't correspond the expected
     * data structure, format or integrity.
     */
    void validate();
}
