package OOP;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class DeviceCombination {
    ProcessorArm pa1 = new ProcessorArm();
    ProcessorArm pa2 = new ProcessorArm();
    ProcessorArm pa3 = new ProcessorArm();

    ProcessorX86 px1 = new ProcessorX86();
    ProcessorX86 px2 = new ProcessorX86();
    ProcessorX86 px3 = new ProcessorX86();

    Memory m1 = new Memory();
    Memory m2 = new Memory();
    Memory m3 = new Memory();

    Device device1 = new Device(pa1, m1);
    Device device2 = new Device(pa2, m2);
    Device device3 = new Device(pa3, m3);
    Device device4 = new Device(px1, m1);
    Device device5 = new Device(px2, m2);
    Device device6 = new Device(px3, m3);
    Device device7 = new Device(pa1, m2);
    Device device8 = new Device(pa3, m1);
    Device device9 = new Device(px1, m2);
    Device device10 = new Device(px3, m1);

    ArrayList<Device> ar = new ArrayList<>();

    void AddObjects() {
        ar.add(device1);
        ar.add(device2);
        ar.add(device3);
        ar.add(device4);
        ar.add(device5);
        ar.add(device6);
        ar.add(device7);
        ar.add(device8);
        ar.add(device9);
        ar.add(device10);
    }

//    void filterArchitecture() {
//        Device[] array = new Device[ar.size()];
//        ar.toArray(array);
//        for (int i = 0; i < array.length - 1; i++) {
//            if (array[i].) {
//
//            }
//        }
//
//    }
}
