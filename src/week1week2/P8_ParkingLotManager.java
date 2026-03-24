package week1week2;

class P8_ParkingLotManager {
    String[] table;
    int size;

    P8_ParkingLotManager(int n) {
        size = n;
        table = new String[n];
    }

    int hash(String plate) {
        return Math.abs(plate.hashCode()) % size;
    }

    public int park(String plate) {
        int idx = hash(plate);
        while (table[idx] != null) {
            idx = (idx + 1) % size;
        }
        table[idx] = plate;
        return idx;
    }

    public static void main(String[] args) {
        P8_ParkingLotManager obj = new P8_ParkingLotManager(10);
        System.out.println(obj.park("ABC123"));
        System.out.println(obj.park("XYZ999"));
    }
}