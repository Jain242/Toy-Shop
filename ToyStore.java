import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ToyStore {
    
    private List<Toy> toys = new ArrayList<>();

    public void addToy(String name, int quantity, double choice) {
        Toy toy = new Toy(name, quantity, choice);
        toys.add(toy);
    }



    public void changeChoice(int toyId, double newChoice) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setChoice(newChoice);
                break;
            }
        }
    }

    public void drawToys() {
        Random random = new Random();
        if (toys.size()==0){
            System.out.println();
            System.out.println("----------------------");
            System.out.println("Список игрушек пуст!");
            System.out.println("----------------------");
            System.out.println();
        }
        else{
        double totalWeight = toys.stream().mapToDouble(Toy::getChoice).sum();
        double randomNumber = random.nextDouble() * totalWeight;

        for (Toy toy : toys) {
            if (randomNumber <= toy.getChoice()) {
                if (toy.getQuantity() > 0) {
                    System.out.println("Вы выиграли игрушку: " + toy.getName());
                    toy.setQuantity(toy.getQuantity() - 1);
                } else {
                    System.out.println("Игрушка " + toy.getName() + " закончилась.");
                }
                break;
            } else {
                randomNumber -= toy.getChoice();
            }
        }
        }
    }

    public void saveToysToFile(String fileName) {
         try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8))) {
            for (Toy toy : toys) {
                writer.println(toy.getId() + "," + toy.getName() + "," + toy.getQuantity() + "," + toy.getChoice());
            }
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении");
            e.printStackTrace();
            
        }
    }

    

    public void loadToysFromFile(String fileName) {
        toys.clear();
        try (Scanner scanner =  new Scanner(new FileInputStream(fileName), StandardCharsets.UTF_8)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int quantity = Integer.parseInt(parts[2]);
                    double weight = Double.parseDouble(parts[3]);
                    addToy( name, quantity, weight);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void displayToys() {
        
        if (toys.size()!=0){
            System.out.println();
            System.out.println("-------------------------------------------------------");
            for (Toy toy : toys) {
            System.out.println("ID: " + toy.getId() + ", Название: " + toy.getName() + ", Количество: " + toy.getQuantity() + ", Шанс: " + toy.getChoice() + "%");
        }
        System.out.println("-------------------------------------------------------");
        }
        else{
            System.out.println();
            System.out.println("----------------------");
            System.out.println("Список игрушек пуст!");
            System.out.println("----------------------");
            System.out.println();
        }
        
        
    }
    public void addQuantityToToy(int toyId, int quantityToAdd) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                int currentQuantity = toy.getQuantity();
                toy.setQuantity(currentQuantity + quantityToAdd);
                System.out.println("Количество игрушек '" + toy.getName() + "' увеличено на " + quantityToAdd + ".");
                return;
            }
        }
        System.out.println("Игрушка с ID " + toyId + " не найдена.");
    }

    }


