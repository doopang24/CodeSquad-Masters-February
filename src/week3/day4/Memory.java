package week3.day4;

import java.util.HashMap;
import java.util.Map;

public class Memory {

    private final int POINTER_SIZE = 8;

    private byte[] heapMemory;
    private int baseAddress;
    private int pointer = 0;    // 포인터는 오프셋 주소 (상대 주소)
    private Map<Integer, Integer> heapMemoryStatus = new HashMap<>();
    private Map<String, Integer> typeSize = new HashMap<>();

    // Base Address 지정, 기본 주소는 0부터 40960까지
    public String init(int heapSize) {
        heapMemory = new byte[heapSize];
        int max = 40960;
        baseAddress = (int) (Math.random() * (max + 1));
        return Integer.toHexString(baseAddress);
    }

    // 이미 등록한 타입이 있는지 검사
    // 1, 2, 4, 8, 16, 32 외의 사이즈가 들어왔는지 검사
    public void setSize(String type, int length) throws IllegalArgumentException {
        if (typeSize.containsKey(type)) {
            throw new IllegalArgumentException("이미 등록한 타입은 바꿀 수 없습니다.");
        } else if (!(length == 1 || length == 2 || length == 4 || length == 8 || length == 16 || length == 32)) {
            throw new IllegalArgumentException("유효한 사이즈를 입력하세요.");
        }
        typeSize.put(type, length);
    }

    // 리턴하는 포인터는 상대 주소(Offset)를 나타낸다
    // 입력한 만큼 메모리를 할당할 수 있는지 여부 확인
    // 해당 타입이 등록되어 있는지 검사
    public String malloc(String type, int count) throws IllegalArgumentException {
        if (!typeSize.containsKey(type)) throw new IllegalArgumentException("타입을 등록하세요.");

        int sizeOfInputType = typeSize.get(type);
        int pointOffsetValue = pointer;
        int allocatedSize;

        if (sizeOfInputType <= POINTER_SIZE) {
            allocatedSize = POINTER_SIZE * count;
        } else {
            allocatedSize = sizeOfInputType * count;
        }

        if (pointer + allocatedSize > heapMemory.length) throw new IllegalArgumentException("남은 메모리가 부족합니다.");

        heapMemoryStatus.put(pointer, allocatedSize);

        for (int i = 0; i < allocatedSize; i++) {
            heapMemory[pointer + i] = 1;
        }

        pointer += allocatedSize;

        return "0x" + Integer.toHexString(pointOffsetValue);
    }

    public void free(String pointer) throws IllegalArgumentException {
        int startPoint = Integer.parseInt(pointer.replace("0x",""), 16);

        if(!heapMemoryStatus.containsKey(startPoint)) throw new IllegalArgumentException("해당 포인터가 존재하지 않습니다.");

        int clearSize = heapMemoryStatus.get(startPoint);

        for (int i = 0; i < clearSize; i++) {
            heapMemory[startPoint + i] = 0;
        }
        heapMemoryStatus.remove(startPoint);
    }

    // 힙 영역 전체 크기, 사용 중인 용량, 남은 용량
    public void usage() {

    }

    public void heapDump() {


    }
}
