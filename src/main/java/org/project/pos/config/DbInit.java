package org.project.pos.config;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.project.pos.auth.model.entity.RoleEntity;
import org.project.pos.auth.model.entity.UserEntity;
import org.project.pos.auth.repository.RoleRepo;
import org.project.pos.auth.repository.UserRepo;
import org.project.pos.form.category.model.CategoryEntity;
import org.project.pos.form.category.repo.CategoryRepo;
import org.project.pos.form.customers.model.CustomersEntity;
import org.project.pos.form.customers.repo.CustomersRepo;
import org.project.pos.form.products.model.ProductEntity;
import org.project.pos.form.products.repo.ProductRepo;
import org.project.pos.order.model.OrderEntity;
import org.project.pos.order.repo.OrderRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DbInit implements CommandLineRunner {
    private final PasswordEncoder encoder;
    private final CategoryRepo categoryRepo;
    private final CustomersRepo customersRepo;
    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public void run(String... args) throws Exception {
        initCategory();
        initCustomers();
        initProducts();
        initOrder();
        initRole();
        initUser();
    }

    private void initCategory(){
        if (!this.categoryRepo.findAll().isEmpty()){
            return;
        }

        List<CategoryEntity> categoryEntityList = Arrays.asList(
                new CategoryEntity("1", "product-1.png", "Smart Phone", "Choose from wide range of smartphones from popular brands", "$99129", 1947),
                new CategoryEntity("2", "product-2.png", "Electronics", "Choose from wide range of electronics from popular brands", "$2512.50", 7283),
                new CategoryEntity("3", "product-3.png", "Clocks", "Choose from wide range of clocks from popular brands", "$1612.34", 2954),
                new CategoryEntity("4", "product-4.png", "Shoes", "Explore the latest shoes from Top brands", "$3612.98", 4940),
                new CategoryEntity("5", "product-5.png", "Accessories", "Explore best selling accessories from Top brands", "$79129", 4665)
        );

        try {
            this.categoryRepo.saveAll(categoryEntityList);
            log.info("Save Category SuccessFully");
        }catch (Exception e){
            log.error("Save Category Failed, Error: {}", e.getMessage());
        }
    }

    private void initCustomers() {
        if (!this.customersRepo.findAll().isEmpty()){
            return;
        }

        List<CustomersEntity> customersEntityList = Arrays.asList(
                new CustomersEntity("1", "Stanfield Baser", 879861, "sbaser0@boston.com", "Sri Lanka", "lk", 157, "$2074.22", "3.png"),
                new CustomersEntity("2", "Laurie Dax", 178408, "ldax1@lycos.com", "Russia", "ru", 663, "$2404.19", "2.png")
        );

        try {
            this.customersRepo.saveAll(customersEntityList);
            log.info("Save Customer SuccessFully");
        } catch (Exception e) {
            log.error("Save Customer Failed, Error: {}", e.getMessage());
        }
    }

    private void initProducts() {
        if (!this.productRepo.findAll().isEmpty()) {
            return;
        }

        List<ProductEntity> result = Arrays.asList(
                new ProductEntity("1", "iPhone 14 Pro", 2, 1, 19472, "$999", 665, 3, "product-1.png", "Super Retina XDR display, footnote Pro Motion technology"),
                new ProductEntity("2", "Echo Dot (4th gen)", 2, 0, 72836, "$25.50", 6857, 2, "product-2.png", "Super Retina XDR display, footnote Pro Motion technology")
        );

        try {
            this.productRepo.saveAll(result);
            log.info("Save Product SuccessFully");
        } catch (Exception e) {
            log.error("Save Product Failed, Error: {}", e.getMessage());
        }
    }

    private void initOrder() {
        if (!this.orderRepo.findAll().isEmpty()) {
            return;
        }

        List<OrderEntity> result = Arrays.asList(
                new OrderEntity("1", 5434, "Gabrielle Feyer", "gfeyer@nyu.edu", "8.png", 1, 1, "$73.98", "paypal_logo", "5/16/2022", "2:11 AM", 6522),
                new OrderEntity("2", 5342, "Jackson Deignan", "jdeignan1@dell.com", "2.png", 3, 1, "$72.98", "paypal_logo", "5/3/2022", "7:26 PM", 7538)
        );

        try {
            this.orderRepo.saveAll(result);
            log.info("Save Order SuccessFully");
        } catch (Exception e) {
            log.error("Save Order Failed, Error: {}", e.getMessage());
        }
    }

    private void initRole(){
        if (this.roleRepo.count() > 0){
            log.info("Role has been initialized");
            return;
        }

        try {
            var roleList = Arrays.asList(
                    new RoleEntity("ROLE_USER"),
                    new RoleEntity("ROLE_ADMIN"),
                    new RoleEntity("ROLE_SUPER_USER")
            );
            this.roleRepo.saveAllAndFlush(roleList);
            log.info("Role has been initialized");
        }catch (Exception e){
            log.error("Save role error: {}", e.getMessage());
        }
    }

    public void initUser() {
        if (this.userRepo.count() > 0){
            log.info("User has been initialized");
            return;
        }
        List<UserEntity> userEntityList = new ArrayList<>();
        RoleEntity roleUser = roleRepo.findByName("ROLE_USER").orElse(null);
        if (roleUser != null){
            userEntityList.add(new UserEntity("user", "satu", "user01@gmail.com", encoder.encode("Us3r1234"), Arrays.asList(roleUser)));
        }

        RoleEntity roleAdmin = roleRepo.findByName("ROLE_ADMIN").orElse(null);
        if (roleAdmin != null){
            userEntityList.add(new UserEntity("admin", "satu", "admin01@gmail.com", encoder.encode("P@ssW0rd32!"), Arrays.asList(roleAdmin)));
        }

        RoleEntity roleSuperUser = roleRepo.findByName("ROLE_SUPER_USER").orElse(null);
        if (roleSuperUser != null){
            userEntityList.add(new UserEntity("super", "user", "super.user@gmail.com", encoder.encode("P@ssW0rd32!"), Arrays.asList(roleSuperUser)));
        }

        try {
            this.userRepo.saveAllAndFlush(userEntityList);
            log.info("User has been initialized");
        }catch (Exception e){
            log.error("Save user error: {}", e.getMessage());
        }
    }
}
