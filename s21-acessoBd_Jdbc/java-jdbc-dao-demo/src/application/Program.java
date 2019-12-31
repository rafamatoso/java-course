package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("*** Test 1: seller findById ***");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n*** Test 2: seller findByDepartment ***");
        Department department = new Department(3, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj: list) {
            System.out.println(obj);
        }

        System.out.println("\n*** Test 3: seller findAll ***");
        list = sellerDao.findAll();
        for (Seller obj: list) {
            System.out.println(obj);
        }

        /*System.out.println("\n*** Test 4: seller insert ***");
        Seller newSeller = new Seller(null, "Rafael", "rafael@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());*/

        System.out.println("\n*** Test 5: seller update ***");
        seller = sellerDao.findById(8);
        seller.setName("Richard");
        seller.setEmail("richard@gmail.com");
        seller.setBirthDate(new Date());
        seller.setBaseSalary(3500.0);
        seller.setDepartment(department);
        sellerDao.update(seller);
        System.out.println("Update completed!");

        System.out.println("\n*** Test 6: seller delete ***");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed!");
        sc.close();
    }
}
