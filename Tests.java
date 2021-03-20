package OOP;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Tests {

    @Test
    public void test1_getDetails_ProcessorX86() {
        ProcessorX86 processorX86 = new ProcessorX86(4.1, 7, 32);
        String actual = processorX86.getDetails();
        String expected = "Частота процессора: 4.1 GHz, кеш: 7.0 Mb, разрядность: 32-bit, architecture: X86";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test2_getDetails_ProcessorARM() {
        ProcessorArm processorArm = new ProcessorArm(4.1, 7, 32);
        String actual = processorArm.getDetails();
        String expected = "Частота процессора: 4.1 GHz, кеш: 7.0 Mb, разрядность: 32-bit, architecture: ARM";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test3_dataProcessString_ProcessorX86() {
        ProcessorX86 processorX86 = new ProcessorX86(4.1, 7, 32);
        String actual = processorX86.dataProcess("333");
        String expected = "processor is using on architecture x86 333";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test4_dataProcessString_ProcessorARM() {
        ProcessorArm processorArm = new ProcessorArm(4.1, 7, 32);
        String actual = processorArm.dataProcess("333");
        String expected = "PROCESSOR IS USING ON ARCHITECTURE ARM 333";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test5_dataProcessLong_ProcessorX86() {
        ProcessorX86 processorX86 = new ProcessorX86(4.1, 7, 32);
        String actual = processorX86.dataProcess(333);
        String expected = "processor is using on architecture x86 333";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test6_dataProcessLong_ProcessorARM() {
        ProcessorArm processorArm = new ProcessorArm(4.1, 7, 32);
        String actual = processorArm.dataProcess(333);
        String expected = "processor is using on architecture arm 333";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test7_readLast_Memory() {
        String[] str = new String[]{"str", "fix", "QA"};
        Memory memory = new Memory(str);
        String actual = memory.readLast();
        String expected = "QA";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test8_removeLast_Memory() {
        String[] str = new String[]{"str", "fix", "QA"};
        Memory memory = new Memory(str);
        String actual = memory.removeLast();
        String expected = "QA";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test9_save_false_Memory() {
        String[] str = new String[]{"str", "fix", "QA"};
        Memory memory = new Memory(str);
        boolean actual = memory.save("test");
        boolean expected = false;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test10_save_true_Memory() {
        String[] str = new String[]{"str", "fix", null};
        Memory memory = new Memory(str);
        boolean actual = memory.save("test");
        boolean expected = true;
        Assertions.assertEquals(actual, expected);
    }

    private final List<Device> devicesList = new ArrayList<>();
    private final String[] dataForTest = {"str", "fix", "QA"};
    Device computer1 = new Device(new ProcessorArm(2.7, 3, 32), new Memory(new String[5]));
    Device computer2 = new Device(new ProcessorX86(2.9, 4, 64), new Memory(new String[8]));
    Device computer3 = new Device(new ProcessorArm(3.1, 3, 32), new Memory(new String[3]));
    Device computer4 = new Device(new ProcessorX86(3.3, 6, 64), new Memory(new String[6]));
    Device computer5 = new Device(new ProcessorArm(3.5, 7, 64), new Memory(new String[7]));
    Device computer6 = new Device(new ProcessorX86(3.7, 8, 32), new Memory(new String[6]));
    Device computer7 = new Device(new ProcessorArm(3.5, 1, 64), new Memory(new String[7]));
    Device computer8 = new Device(new ProcessorArm(3.12, 2, 64), new Memory(new String[7]));
    Device computer9 = new Device(new ProcessorX86(3.21, 3, 64), new Memory(new String[5]));
    Device computer10 = new Device(new ProcessorArm(3.31, 4, 32), new Memory(new String[7]));

    Device[] devices = new Device[]{computer1, computer2, computer3, computer4, computer5, computer6, computer7, computer8, computer9, computer10};

    @Test
    public void test11_filterByArchitecture() {
        List<Device> expected = new ArrayList<>();
        expected.add(computer1);
        expected.add(computer3);
        expected.add(computer5);
        expected.add(computer7);
        expected.add(computer8);
        expected.add(computer10);
        List<Device> actual = Filter.filtrateByArchitecture(devices, "ARM");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test12_filterByCash() {
        List<Device> expected = new ArrayList<>();
        expected.add(computer1);
        expected.add(computer3);
        expected.add(computer9);
        List<Device> actual = Filter.filtrateByCash(devices, 3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test13_filterByFrequency() {
        List<Device> expected = new ArrayList<>();
        expected.add(computer5);
        expected.add(computer7);
        List<Device> actual = Filter.filtrateByFrequency(devices, 3.5);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test14_filterByBitCapacity() {
        List<Device> expected = new ArrayList<>();
        expected.add(computer2);
        expected.add(computer4);
        expected.add(computer5);
        expected.add(computer7);
        expected.add(computer8);
        expected.add(computer9);
        List<Device> actual = Filter.filtrateByBitCapacity(devices, 64);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test15_filter_ByTotalMemory() {
        List<Device> expected = new ArrayList<>();
        expected.add(computer1);
        expected.add(computer9);
        List<Device> actual = Filter.filtrateByTotalMemory(devices, 5);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test16_filter_ByOccupiedMemory() {
        List<Device> expected = new ArrayList<>();
        String[] a = {"Test"};
        computer1.save(a);
        expected.add(computer1);
        List<Device> actual = Filter.filtrateByOccupiedMemory(devices, 20.00);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void test17_filter_TotalMemory_MoreThan_Value() {
        List<Device> expected = new ArrayList<>();
        expected.add(computer2);
        List<Device> actual = Filter.filtrateByMoreTotalMemory(devices, 7);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test18_filter_TotalMemory_LessThan_Value() {
        List<Device> expected = new ArrayList<>();
        expected.add(computer3);
        List<Device> actual = Filter.filtrateByLessTotalMemory(devices, 5);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test19_filter_ByMoreOccupiedMemory() {
        List<Device> expected = new ArrayList<>();
        String[] a = {"Test", "Robot"};
        computer1.save(a);
        String[] b = {"Test", "Robot", "Cash"};
        computer3.save(b);
        expected.add(computer1);
        expected.add(computer3);
        List<Device> actual = Filter.filtrateByMoreOccupiedMemory(devices, 20.1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test20_filter_ByLessOccupiedMemory() {
        List<Device> expected = new ArrayList<>();
        String[] a = {"Test", "Robot"};
        computer1.save(a);
        String[] b = {"Test", "Robot", "Cash"};
        computer3.save(b);
        expected.add(computer2);
        expected.add(computer4);
        expected.add(computer5);
        expected.add(computer6);
        expected.add(computer7);
        expected.add(computer8);
        expected.add(computer9);
        expected.add(computer10);
        List<Device> actual = Filter.filtrateByLessOccupiedMemory(devices, 10.1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test21_save_readAll_DeviceClass() {
        String[] a = {"Test", "Robot"};
        computer1.save(a);
        String[] actual = computer1.readAll();
        String[] expected = {"Test", "Robot"};
    }

    @Test
    public void test22_dataProcessing_DeviceClass() {
        Device device = new Device(new ProcessorArm(2.11,4,64), new Memory(new String[3]));
        device.save(new String[]{"Test", "Robot", "Cash"});
        device.dataProcessing();
        String [] memoryCell = new String[]{"Cash_ABC", "Robot_ABC", "Test_ABC"};
        Assertions.assertArrayEquals(memoryCell, device.getMemory().getMemoryCell());
    }

    @Test
    public void test23_getSystemInfo_DeviceClass() {
        Device device = new Device(new ProcessorArm(2.11,4,64), new Memory(new String[3]));
        device.getSystemInfo();
        String  expected = "MemoryInfo{totalMemory=3, occupiedMemory=0.0} Частота процессора: 2.11 GHz, кеш: 4.0 Mb, разрядность: 64-bit, architecture: ARM";
        String actual = device.getSystemInfo();
        Assertions.assertEquals(actual, expected);
    }
}
