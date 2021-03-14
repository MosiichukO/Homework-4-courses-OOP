package OOP;

public abstract class Processor {
    int frequency;
    int cache;
    int bitCapacity;

    String getDetails() {
        return "frequency: " + frequency + "cache" + cache + "bitCapacity" + bitCapacity;
    }

    abstract String dataProcess(String data);
    abstract String dataProcess(long data);
}
