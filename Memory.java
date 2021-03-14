package OOP;

public class Memory {
    String[] memoryCell;
    int lastElement = memoryCell.length - 1;

    Memory() {
        memoryCell = null;
    }

    public String readLast() {
        int i;
        for (i = memoryCell.length - 1; i >= 0; i--) {
            if (memoryCell[i] != null) {
                break;
            }
        }
        return memoryCell[i];
    }

    public String removeLast() {
        return memoryCell[lastElement] = null;
    }

    boolean save(String str) {
        for (int i = memoryCell.length - 1; i >= 0; i--) {
            if (memoryCell[i] == null) {
                memoryCell[i] = str;
                return true;
            }
        }
        return false;
    }



    public class MemoryInfo {
        MemoryInfo() {
            int totalMemory = memoryCell.length;
            countReturnedElements();
        }

        int countReturnedElements () {
            int occupiedMemory;
            int occupiedElements;
            int elementCounter = 0;
            for (int i = 0; i <= memoryCell.length - 1; i++) {
                if (memoryCell[i] != null) {
                    elementCounter++;
                }
            }
            occupiedElements = (elementCounter / memoryCell.length) * 100;
            return occupiedMemory = occupiedElements;
        }
    }

    MemoryInfo getMemoryInfo() {
        MemoryInfo memoryInfo = new MemoryInfo();
        return memoryInfo;
    }


}
