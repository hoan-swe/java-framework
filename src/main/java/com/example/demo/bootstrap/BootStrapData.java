package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository = inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        List<InhousePart> inhouseParts=(List<InhousePart>) inhousePartRepository.findAll();
        List<Product> products=(List<Product>) productRepository.findAll();
        if(products == null || products.isEmpty()) {
            // Add 5 products
            Product officeDesk = new Product(101, "Office Desk", 180.0, 10);
            Product nightStand = new Product(102, "Night Stand", 99.99, 15);
            Product tvCabinet = new Product(103, "TV Cabinet", 250.49, 7);
            Product officeChair = new Product(104, "Office Chair", 99.99, 2);
            Product coffeeTable = new Product(105, "Coffee Table", 89.99, 10);

            productRepository.save(officeDesk);
            productRepository.save(nightStand);
            productRepository.save(tvCabinet);
            productRepository.save(officeChair);
            productRepository.save(coffeeTable);
        }

        if(outsourcedParts == null || outsourcedParts.isEmpty()) {
            // Add 5 parts
            OutsourcedPart cabinetDoors = new OutsourcedPart();
            cabinetDoors.setCompanyName("Company A");
            cabinetDoors.setName("Cabinet Doors");
            cabinetDoors.setInv(50);
            cabinetDoors.setPrice(24.99);
            cabinetDoors.setId(1001);
            cabinetDoors.setMaxInv(500);
            cabinetDoors.setMinInv(4);

            OutsourcedPart tableTop = new OutsourcedPart();
            tableTop.setCompanyName("Company B");
            tableTop.setName("Table Top");
            tableTop.setInv(3);
            tableTop.setPrice(67.99);
            tableTop.setId(1002);
            tableTop.setMaxInv(500);
            tableTop.setMinInv(1);

            OutsourcedPart tableLegs = new OutsourcedPart();
            tableLegs.setCompanyName("Company B");
            tableLegs.setName("Table Legs");
            tableLegs.setInv(10);
            tableLegs.setPrice(24.99);
            tableLegs.setId(1003);
            tableLegs.setMaxInv(500);
            tableLegs.setMinInv(2);

            outsourcedPartRepository.save(cabinetDoors);
            outsourcedPartRepository.save(tableTop);
            outsourcedPartRepository.save(tableLegs);
        }

        if(inhouseParts == null || inhouseParts.isEmpty()) {
            InhousePart deskLegs = new InhousePart();
            deskLegs.setPartId(1001);
            deskLegs.setName("Desk Legs");
            deskLegs.setInv(10);
            deskLegs.setPrice(14.99);
            deskLegs.setId(1004);
            deskLegs.setMaxInv(500);
            deskLegs.setMinInv(2);

            InhousePart chairCasters = new InhousePart();
            chairCasters.setPartId(1002);
            chairCasters.setName("Chair Casters");
            chairCasters.setInv(100);
            chairCasters.setPrice(9.99);
            chairCasters.setId(1005);
            chairCasters.setMaxInv(500);
            chairCasters.setMinInv(5);
            inhousePartRepository.save(deskLegs);
            inhousePartRepository.save(chairCasters);
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
