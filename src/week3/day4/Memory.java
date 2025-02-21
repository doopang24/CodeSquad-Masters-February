package week3.day4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Memory {

    private final int POINTER_SIZE = 8;
    private final Map<String, Integer> typeSize = new HashMap<>();  // 타입 세팅 <타입, 크기>
    private final Map<Integer, Map<String, Integer>> heapMemoryStatus = new HashMap<>(); // 저장 상태 <포인터, <타입, 할당 크기>>

    private byte[] heapMemory;
    private int baseAddress;
    private int pointer = 0;    // 포인터는 오프셋 주소 (상대 주소)


    // Base Address 지정, 기본 주소는 0부터 40960까지
    public String init(int heapSize) {
        heapMemory = new byte[heapSize];
        int max = 40960;
        baseAddress = (int) (Math.random() * (max + 1));
        return Integer.toHexString(baseAddress);
    }

    // 이미 등록한 타입이 있는지 검사
    // 1, 2, 4, 8, 16, 32 외의 사이즈가 들어왔는지 검사
    public void setSize(String type, int length) {
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
    public String malloc(String type, int count) {
        if (!typeSize.containsKey(type)) throw new IllegalArgumentException("타입을 등록하세요.");

        int sizeOfInputType = typeSize.get(type);   // 저장할 타입의 크기
        int pointOffsetValue = pointer;             // 포인터 시작 위치 (포인터는 로직 중에 커지니까)
        int allocatedSize;                          // 할당 크기
        Map<String, Integer> allocateInfo = new HashMap<>();    // 포인터 위치에 저장할 타입과 할당크기

        if (sizeOfInputType <= POINTER_SIZE) {      // 타입 크기가 1, 2, 4
            allocatedSize = POINTER_SIZE * count;
        } else {                                    // 타입 크기가 8, 16, 32
            allocatedSize = sizeOfInputType * count;
        }
        allocateInfo.put(type, allocatedSize);

        if (pointer + allocatedSize > heapMemory.length - 1) throw new IllegalArgumentException("남은 메모리가 부족합니다.");

        heapMemoryStatus.put(pointer, allocateInfo);    // heapMemoryStatus 에 포인터, 타입, 할당량 저장

        for (int i = 0; i < allocatedSize; i++) {       // byte 배열에서 할당량만큼 1로 변환
            heapMemory[pointer + i] = 1;
        }

        pointer += allocatedSize;

        return "0x" + Integer.toHexString(pointOffsetValue);
    }

    public void free(String pointer) {
        int startPoint = Integer.parseInt(pointer.replace("0x", ""), 16);

        if (!heapMemoryStatus.containsKey(startPoint)) throw new IllegalArgumentException("해당 포인터가 존재하지 않습니다.");

        Map<String, Integer> allocateInfo = heapMemoryStatus.get(startPoint);
        String storedType = allocateInfo.keySet().iterator().next();    // 첫 번째 키를 가져온다
        int clearSize = allocateInfo.get(storedType);

        for (int i = 0; i < clearSize; i++) {
            heapMemory[startPoint + i] = 0;
        }
        heapMemoryStatus.remove(startPoint);
    }

    // 힙 영역 전체 크기, 사용 중인 용량, 남은 용량
    public void usage() {
        System.out.println("메모리 크기 : " + Integer.toHexString(heapMemory.length));

        int usedMemory = 0;
        for (Map<String, Integer> allocateInfo : heapMemoryStatus.values()) {
            for (int memory : allocateInfo.values()) {
                usedMemory += memory;
            }
        }
        System.out.println("\n사용 중인 메모리 : " + Integer.toHexString(usedMemory));

        int availableMemory = heapMemory.length - usedMemory;
        System.out.println("남은 용량 : " + Integer.toHexString(availableMemory));

    }

    public List<String> heapDump() {
        List<String> allocationList = new ArrayList<>();
        String status = "";

        for (Map.Entry<Integer, Map<String, Integer>> entry : heapMemoryStatus.entrySet()) {
            String pointer = Integer.toHexString(entry.getKey());
            Map<String, Integer> allocateInfo = entry.getValue();

            for (Map.Entry<String, Integer> alloEntry : allocateInfo.entrySet()) {
                String type = alloEntry.getKey();
                String allocatedSize = Integer.toHexString(alloEntry.getValue());
                status = "포인터 위치 : " + pointer + ", 타입 : " + type + ", 할당된 크기 : " + allocatedSize;
            }
            allocationList.add(status);
        }
        return allocationList;
    }
}
