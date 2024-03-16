import java.util.Arrays;
import java.util.Comparator;

public class lab4 {
    public static void main(String[] args) {
        Boat[] boats = {
                new Boat("Арабське судно \"Дау\"", "Тип 1", 25, 45,300),
                new Boat("Козацький човен \"Чайка\"", "Тип 2", 20, 50, 100),
                new Boat("Підводний човен \"Запоріжжя\"", "Тип 3", 91, 70, 2500),
                new Boat("Сіменйий надувний човен \"Ладья\"", "Тип 4", 3.3, 5, 0.439),
                new Boat("Парусна яхта \"Олена\"", "Тип 5", 8, 5, 25)
        };

        Arrays.sort(boats, Comparator.comparingDouble(Boat::getCapacity));

        System.out.println("Відсортований по вантажопідйомністі за зростанням:");
        for (Boat boat : boats) {
            System.out.println(boat);
        }

        Arrays.sort(boats, Comparator.comparingDouble(Boat::getLength).reversed());

        System.out.println("Відсортований по довжині за спаданням:");
        for (Boat boat : boats) {
            System.out.println(boat);
        }
    }
}

class Boat {
    private String name;
    private String type;
    private double length;
    private int crewSize;
    private double capacity;

    public Boat(String name, String type, double length, int crewSize, double capacity) {
        this.name = name;
        this.type = type;
        this.length = length;
        this.crewSize = crewSize;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getLength() {
        return length;
    }

    public int getCrewSize() {
        return crewSize;
    }

    public double getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + ", Тип: " + type + ", Довжина [м]: " + length + ", Екіпаж: " + crewSize + ", Вантажопідйомність [т]: " + capacity;
    }
}

