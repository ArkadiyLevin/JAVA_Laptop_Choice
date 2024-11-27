package Final_Work;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();

        laptops.add(new Laptop("Acer", 18.9, 16, 256, "Windows", "Black"));
        laptops.add(new Laptop("Apple", 18.9, 32, 512, "IOS", "Gold"));
        laptops.add(new Laptop("ASUS", 15.9, 8, 128, "Linux", "Black"));
        laptops.add(new Laptop("Lenovo", 18.9, 16, 256, "Windows", "Write"));
        laptops.add(new Laptop("ASUS", 20.0, 32, 512, "Windows", "Blue"));
        laptops.add(new Laptop("Acer", 18.9, 32, 256, "Windows", "Write"));
        laptops.add(new Laptop("Apple", 20.0, 32, 1024, "IOS", "Pink"));

        Map<Integer, String> criteria = new HashMap<>();
        criteria.put(1, "Бренд");
        criteria.put(2, "Диагональ");
        criteria.put(3, "ОЗУ");
        criteria.put(4, "Объем ЖД");
        criteria.put(5, "ОП");
        criteria.put(6, "Цвет");


        Scanner scanner = new Scanner(System.in);
        Map<String, Object> filters = new HashMap<>();

        boolean continueFiltering = true;

        while (continueFiltering) {
            System.out.println("Введите цифру, соответсвующую необходимому критерию: ");
            for (Map.Entry<Integer, String> entry : criteria.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
            int criterion = scanner.nextInt();
            scanner.nextLine();

            switch (criterion) {
                case 1:
                    System.out.print("Выберете бренд ноутбука (Apple; ASUS; Lenovo; Acer.): ");
                    filters.put("brand", scanner.nextLine());
                    //scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Введите минимальное значение диагонали (в дюймах (15.9″; 18.9″; 20.0″)): ");
                    filters.put("diagonal", scanner.nextDouble());
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.print("Введите минимальное значение ОЗУ (в ГБ): ");
                    filters.put("ram", scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.print("Введите минимальное значение объема ЖД (в ГБ): ");
                    filters.put("hdc", scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 5:
                    System.out.print("Введите операционную систему (IOS; Windows; Linux.): ");
                    filters.put("operSystem", scanner.nextLine());
                    //scanner.nextLine();
                    break;
                case 6:
                    System.out.print("Введите цвет (Black; Write; Blue; Pink; Gold.): ");
                    filters.put("color", scanner.nextLine());
                    //scanner.nextLine();
                    break;
                default:
                    System.out.println("Некорректный критерий!");
            }
            System.out.print("Добавить еще критерий? (+/-): ");
            String response = scanner.nextLine();
            continueFiltering = response.equalsIgnoreCase("+");
        }
        filterLaptops(laptops, filters);
    }


    public static void filterLaptops(Set<Laptop> laptops, Map<String, Object> filters) {
        for (Laptop laptop : laptops) {
            boolean matches = true;

            if (filters.containsKey("brand") && !laptop.getBrand().equalsIgnoreCase((String) filters.get("brand"))) {
                matches = false;
            }
            if (filters.containsKey("diagonal") && laptop.getDiagonal() < (double) filters.get("diagonal")) {
                matches = false;
            }
            if (filters.containsKey("ram") && laptop.getRam() < (int) filters.get("ram")) {
                matches = false;
            }
            if (filters.containsKey("hdc") && laptop.getHdc() < (int) filters.get("hdc")) {
                matches = false;
            }
            if (filters.containsKey("operSystem") && !laptop.getOperSystem().equalsIgnoreCase((String) filters.get("operSystem"))) {
                matches = false;
            }
            if (filters.containsKey("color") && !laptop.getColor().equalsIgnoreCase((String) filters.get("color"))) {
                matches = false;
            }
            if (matches){
                System.out.println(laptop);
            }
        }
    }
}
