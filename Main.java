import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        
        ToyStore toyStore = new ToyStore();
        //toyStore.loadToysFromFile("toys.csv");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Розыгрыш игрушек");
            System.out.println("2. Добавить количество имеющхся игрушек");
            System.out.println("3. Изменить шанс выпадания игрушки");
            System.out.println("4. Добавить новую игрушку");
            System.out.println("5. Показать список игрушек");
            System.out.println("6. Сохранить игрушки в файл");
            System.out.println("7. Загрузить игрушки из файла");
            System.out.println("8. Выйти");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    toyStore.drawToys();
                    break;

                case 2:
                    toyStore.displayToys();
                    System.out.print("Введите ID игрушки для увеличения количества: ");
                    int toyIdToAddQuantity = scanner.nextInt();
                    System.out.print("Введите количество для добавления: ");
                    int quantityToAdd = scanner.nextInt();
                    toyStore.addQuantityToToy(toyIdToAddQuantity, quantityToAdd);
                    break;
            
           
                case 3:
                    toyStore.displayToys();
                    System.out.print("Введите ID игрушки для изменения шанса выпадания: ");
                    int toyId = scanner.nextInt();
                    System.out.print("Введите новый шанс выпадания игрушки (в % от 100): ");
                    double newWeight = scanner.nextDouble();
                    toyStore.changeChoice(toyId, newWeight);
                    break;

                case 4:
                    System.out.print("Введите название игрушки: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите количество игрушек: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Введите шанс выпадания игрушки (в % от 100): ");
                    double weight = scanner.nextDouble();
                    toyStore.addToy(name, quantity, weight);
                    break;
                    
                case 5:
                    toyStore.displayToys();
                    break;
                    
                case 6:
                    toyStore.saveToysToFile("toys.csv");
                    break;

                case 7 :
                    System.out.println("Введите имя файла:");
                    String fileName = scanner.nextLine();
                    toyStore.loadToysFromFile(fileName);
                    break;

                case 8:
                    scanner.close();
                    System.exit(0);
                    
            }
            
        }


    }
}
