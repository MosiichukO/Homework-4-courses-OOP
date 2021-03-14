package OOP;

public class ProcessorX86 extends Processor {
    final String ARCHITECTURE = "X86";

    @Override
    String dataProcess(String data) {
        return data.toLowerCase();
    }

    @Override
    String dataProcess(long data) {
        return String.valueOf(data / 2);
    }

    String getARCHITECTURE () {
        return ARCHITECTURE;
    }
}
