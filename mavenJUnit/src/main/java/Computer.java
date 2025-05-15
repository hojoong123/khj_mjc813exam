public class Computer {

    public enum CPU {
        Gen9_i5, Gen9_i7, Gen9_i9
    }

    public enum StorageType {
        SSD, HDD
    }

    public enum GraphicCard {
        GTX_1660, RTX_4080, Intel_A770
    }

    private String name;
    private CPU cpu;
    private int ramSize; // in GB
    private StorageType storageType;
    private int storageSize; // in GB
    private GraphicCard graphicCard;

    public Computer(String name, CPU cpu, int ramSize, StorageType storageType, int storageSize, GraphicCard graphicCard) {
        this.name = name;
        this.cpu = cpu;
        this.ramSize = ramSize;
        this.storageType = storageType;
        this.storageSize = storageSize;
        this.graphicCard = graphicCard;
    }

    public void boot() {
        System.out.println(name + " 켜졌습니다.");
    }

    public void showSpecs() {
        System.out.println("=== 컴퓨터 사양 ===");
        System.out.println("이름: " + name);
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ramSize + "GB");
        System.out.println("저장장치: " + storageType + " " + storageSize + "GB");
        System.out.println("그래픽카드: " + graphicCard);
    }

    public void shutdown() {
        System.out.println(name + " 꺼졌습니다.");
    }

    public String getName() {
        return name;
    }
}