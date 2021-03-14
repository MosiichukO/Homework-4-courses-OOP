package OOP;


public class Device {
    Processor processor;
    Memory memory;

    Device (ProcessorArm processorArm, Memory memory) {
        this.processor = processorArm;
        this.memory = memory;
    }

    Device (ProcessorX86 processorX86, Memory memory) {
        this.processor = processorX86;
        this.memory = memory;
    }

    void save(String[] data) {  // сохранение в память всех элементов в массиве
        if (data.length <= memory.memoryCell.length) {
            for (int i = 0; i <= data.length - 1; i++) {
                memory.memoryCell[i] = data[i];
            }
        } else {
            throw new IllegalArgumentException("");
        }
    }

    public String[] readAll() { // вычитка всех элементов из памяти, затем стирание данных
        String[] ret = new String[memory.memoryCell.length];
        for (int i = 0; i <= memory.memoryCell.length - 1; i++) {
            ret[i] = memory.memoryCell[i];
            memory.memoryCell[i] = null;
        }
        return ret;
    }

    public void dataProcessing() { // преобразование всех данных, записанных в памяти
        String[] ret = new String[memory.memoryCell.length];
        for (int i = 0; i <= memory.memoryCell.length - 1; i++) {
            ret[i] = memory.memoryCell[i].toUpperCase();
        }
        memory.memoryCell = ret;
    }

    String getSystemInfo() { // получение строки с информацией о системе (информация о процессоре, памяти)
        return "Processor: " + processor.getDetails() + "; " + "memory: " + memory.getMemoryInfo() + " %";
    }


}





