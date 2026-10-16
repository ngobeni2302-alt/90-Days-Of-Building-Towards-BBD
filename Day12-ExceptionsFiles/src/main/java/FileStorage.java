import java.io.*;
import java.util.*;

public class FileStorage {

    public static void saveToFile(Company company, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Employee e : company.getAll()) {
                String line = "";
                if (e instanceof Developer) {
                    Developer d = (Developer) e;
                    line = String.format(Locale.US, "Developer,%s,%s,%.2f,%.2f", d.getId(), d.getName(), d.getBaseSalary(), d.getCodingBonus());
                } else if (e instanceof Manager) {
                    Manager m = (Manager) e;
                    line = String.format(Locale.US, "Manager,%s,%s,%.2f,%.2f", m.getId(), m.getName(), m.getBaseSalary(), m.getManagementBonus());
                } else if (e instanceof Intern) {
                    line = String.format("Intern,%s,%s,%.2f,0.0", e.getId(), e.getName(), e.getBaseSalary());
                }
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public static Company loadFromFile(String filename) throws IOException, DuplicateIdException {
        Company company = new Company();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 5) continue; // Skip bad lines

                String role = parts[0];
                String id = parts[1];
                String name = parts[2];
                double baseSalary = Double.parseDouble(parts[3]);
                double extra = Double.parseDouble(parts[4]);

                Employee e = null;
                if (role.equals("Developer")) {
                    e = new Developer(name, id, baseSalary, extra);
                } else if (role.equals("Manager")) {
                    e = new Manager(name, id, baseSalary, extra);
                } else if (role.equals("Intern")) {
                    e = new Intern(name, id, baseSalary);
                }

                if (e != null) {
                    company.addEmployee(e);
                }
            }
        }
        return company;
    }
}