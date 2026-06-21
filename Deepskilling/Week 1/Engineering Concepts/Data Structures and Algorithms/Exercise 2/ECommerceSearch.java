package Cognizant_DN.DeepSkilling.Week1.EngineeringConcepts.DataStructuresAndAlgorithms.Exercise2;

import java.util.Arrays;
import java.util.Comparator;

public class ECommerceSearch {

    public static SearchProduct linearSearch(SearchProduct[] products, String name) {
        for (SearchProduct product : products) {
            if (product.productName.equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public static SearchProduct binarySearch(SearchProduct[] products, String name) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int result = products[mid].productName.compareToIgnoreCase(name);

            if (result == 0) {
                return products[mid];
            } else if (result < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        SearchProduct[] products = {
                new SearchProduct(1, "Laptop", "Electronics"),
                new SearchProduct(2, "Mouse", "Electronics"),
                new SearchProduct(3, "Phone", "Electronics")
        };

        System.out.println(linearSearch(products, "Mouse").productName);

        Arrays.sort(products, Comparator.comparing(p -> p.productName));

        System.out.println(binarySearch(products, "Phone").productName);
    }
}