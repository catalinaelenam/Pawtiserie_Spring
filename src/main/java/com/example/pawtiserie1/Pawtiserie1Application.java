package com.example.pawtiserie1;

import com.example.pawtiserie1.model.*;
import com.example.pawtiserie1.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Pawtiserie1Application implements CommandLineRunner {

	@Autowired
	private CakeCategoryRepository cakeCategoryRepository;
	@Autowired
	private CakeRepository cakeRepository;
	@Autowired
	private HistoryRepository historyRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private DeliveryAddressRepository deliveryAddressRepository;
	@Autowired
	private OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(Pawtiserie1Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		CakeCategory tunaCakesCategory = new CakeCategory("tuna", "all made from all-natural ingredients!");
        CakeCategory liverCakesCategory = new CakeCategory("liver cakes(best seller for dogs)", "cakes with liver");
        CakeCategory salmonCakesCategory = new CakeCategory("salmon cakes(best seller for cats)", "your cat will love it!");
        CakeCategory beefCakesCategory = new CakeCategory("beef cakes", "this one is soooo loved!");
        CakeCategory appleCarrotsCakesCategory = new CakeCategory("apple carrots cake", "perfect for a birthday party!");

		cakeCategoryRepository.save(tunaCakesCategory);
		cakeCategoryRepository.save(liverCakesCategory);
		cakeCategoryRepository.save(salmonCakesCategory);
		cakeCategoryRepository.save(beefCakesCategory);
		cakeCategoryRepository.save(appleCarrotsCakesCategory);

		Client client1 = new Client("catalinaelena", "pass1234");
		Client client2 = new Client("TestingUser","test1234");
		Client client3= new Client("HappyOne", "pass1234");

		clientRepository.save(client1);
		clientRepository.save(client2);
		clientRepository.save(client3);

		Cake cake1 = new Cake(Cake.Type.PortraitCakes, 11.00);
		Cake cake2 = new Cake(Cake.Type.BirthdayCakes, 10.00);
		Cake cake3 = new Cake(Cake.Type.BirthdayCakes, 10.00);
		Cake cake4 = new Cake(Cake.Type.PortraitCakes, 11.00);

		cake1.setCakeCategory(tunaCakesCategory);
		cake2.setCakeCategory(beefCakesCategory);
		cake3.setCakeCategory(salmonCakesCategory);
		cake4.setCakeCategory(beefCakesCategory);
		cakeRepository.save(cake1);
		cakeRepository.save(cake2);
		cakeRepository.save(cake3);
		cakeRepository.save(cake4);


		Order order1 = new Order(cake1.getPrice() + cake2.getPrice(), Set.of(cake1,cake2));
		Order order2 = new Order(cake1.getPrice() + cake2.getPrice() + cake3.getPrice(), Set.of(cake1,cake2,cake3));
		Order order3 = new Order(cake3.getPrice() + cake2.getPrice() + cake4.getPrice(), Set.of(cake3,cake2,cake4));

		orderRepository.save(order1);
		orderRepository.save(order2);
		orderRepository.save(order3);

		Set<Order> orders = new HashSet<>();
		orders.add(order1);
		orders.add(order2);
		DeliveryAddress delivery1 = new DeliveryAddress(orders,false,client1);
		orders.remove(order2);
		orders.add(order3);
		DeliveryAddress delivery2 = new DeliveryAddress(orders,true,client2);

		deliveryAddressRepository.save(delivery1);
		deliveryAddressRepository.save(delivery2);

		Date d1 = new Date(2023,12,27);
		Date d2 = new Date(2023, 12, 29);
		History history1 = new History(delivery1, History.Status.Pregatire,d1);
		History history2 = new History(delivery2, History.Status.Livrat,d2);

		historyRepository.save(history1);
		historyRepository.save(history2);














	}
}
