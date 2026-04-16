// Practical Assignment – Stream API – Number Generation
// Suppose we have a list of orders, where each order represents a product and its cost. 
// The task is to use the Stream API and collectors to solve the following problems:

// Create a list of orders with different products and their costs.

// Group the orders by product.

// For each product, calculate the total cost of all orders.

// Sort the products in descending order by total cost.

// Select the three most expensive products.

// Output the result: a list of the three most expensive products and their total cost.

package java_stream;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Order {
    private String product;
    private double cost;

    public Order(String product, double cost) {
        this.product = product;
        this.cost = cost;
    }

    public String getProduct() {
        return product;
    }

    public double getCost() {
        return cost;
    }
}

public class StreamCollectorsExample {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0));

        List<Order> sortedTop3Orders = orders.stream()
                // group by name and sum their cost
                .collect(Collectors.groupingBy(Order::getProduct, Collectors.summingDouble(Order::getCost)))
                // convert to entryset and in stream to process furthur
                .entrySet().stream()
                // sort
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                // transform entryset list of the order
                .map(entry -> new Order(entry.getKey(), entry.getValue()))
                .limit(3)
                .toList();
        // .collect(Collectors.toList());

        sortedTop3Orders.forEach(order -> System.out.println(order.getProduct() + "  " + order.getCost()));
    }
}

// Blend of both older + new way

// Map<String, Double> groupedOrders = orders.stream()
// // .sorted((Order o1, Order o2) -> (int) o1.getCost() - (int) o2.getCost())
// .collect(Collectors.groupingBy(Order::getProduct,
// Collectors.summingDouble(Order::getCost)));

// List<Order> sortedOrders = new LinkedList<>();

// for (Map.Entry<String, Double> order : groupedOrders.entrySet()) {
// sortedOrders.add(new Order(order.getKey(), order.getValue()));
// }

// sortedOrders = sortedOrders.stream().sorted((o1, o2) -> {
// if (o2.getCost() - o1.getCost() > 0)
// return 1;
// else if (o2.getCost() - o1.getCost() < 0)
// return -1;
// return 0;
// }).limit(3).collect(Collectors.toList());

// System.out.println(groupedOrders);

// sortedOrders.forEach(o -> {
// System.out.println(o.getProduct() + " " + o.getCost());
// });