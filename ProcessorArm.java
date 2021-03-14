package OOP;

public class ProcessorArm extends Processor {
    final String ARCHITECTURE = "ARM";

    @Override
    String dataProcess(String data) {
        return data.toUpperCase();
    }

    @Override
    String dataProcess(long data) {
        return String.valueOf(data * 2);
    }

    String getARCHITECTURE () {
        return ARCHITECTURE;
    }
}
