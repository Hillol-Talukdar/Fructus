package com.example.fructus;

import java.util.ArrayList;

public class Util {
    private ArrayList<Fruit> allFruits;

    private static int id = 0;

    public Util() {
        if (null == allFruits) {
            allFruits = new ArrayList<>();
            initAllBooks();
        }
    }

    public ArrayList<Fruit> getAllFruits () {
        return allFruits;
    }

    private void initAllBooks () {
        String title = "";
        String headline = "";
        String image = "";
        String description = "";
        ArrayList<String> gradientColors = new ArrayList<>();
        ArrayList<String> nutrition = new ArrayList<>();

        id++;
        title = "Blueberry";
        headline = "Blueberries are sweet, nutritious and wildly popular fruit all over the world.";
        image = "blueberry";
        description = " Blueberries are perennial flowering plants with blue or purple berries. They are classified in the section Cyanococcus within the genus Vaccinium. Vaccinium also includes cranberries, bilberries, huckleberries and Madeira blueberries." +"/n" +
          "Commercial blueberries—both wild (lowbush) and cultivated (highbush)—are all native to North America. The highbush varieties were introduced into Europe during the 1930s.\n" +
          "Blueberries are usually prostrate shrubs that can vary in size from 10 centimeters (3.9 in) to 4 meters (13 ft) in height. In commercial production of blueberries, the species with small, pea-size berries growing on low-level bushes are known as \"lowbush blueberries\" (synonymous with \"wild\"), while the species with larger berries growing on taller cultivated bushes are known as \"highbush blueberries\".\n" +
          "Canada is the leading producer of lowbush blueberries, while the United States produces some 40% of the world supply of highbush blueberries.\n" +
          "USES\n" +
          "Blueberries are sold fresh or are processed as individually quick frozen (IQF) fruit, purée, juice, or dried or infused berries. These may then be used in a variety of consumer goods, such as jellies, jams, blueberry pies, muffins, snack foods, or as an additive to breakfast cereals.\n" +
          "Blueberry jam is made from blueberries, sugar, water, and fruit pectin. Blueberry sauce is a sweet sauce prepared using blueberries as a primary ingredient.\n" +
          "Blueberry wine is made from the flesh and skin of the berry, which is fermented and then matured; usually the lowbush variety is used.\n" +
          "NUTRIENTS\n" +
          "Blueberries consist of 14% carbohydrates, 0.7% protein, 0.3% fat and 84% water (table). They contain only negligible amounts of micronutrients, with moderate levels (relative to respective Daily Values) (DV) of the essential dietary mineral manganese, vitamin C, vitamin K and dietary fiber (table).\n" +
          "Generally, nutrient contents of blueberries are a low percentage of the DV (table). One serving provides a relatively low caloric value of 57 kcal with a glycemic load of 6.\n";


//                nutrition: ["240 kJ (57 kcal)","9.96 g","0.33 g","0.74 g","A, B1, B2, B3, B5, B6, B9, C, E, K","Calcium, Iron, Magnasium, Manganese, Phosphorus, Sodium, Zinc"]
        //        gradientColors = [Color("ColorBlueberryLight"), Color("ColorBlueberryDark")];

        allFruits.add(new Fruit(id, title, headline, image, description));


        id++;
        title= "Strawberry";
        headline= "Widely appreciated for its characteristic aroma,  red color, juicy texture, and sweetness.";
        image= "strawberry";
        description= "The garden strawberry (or simply strawberry; Fragaria × ananassa) is a widely grown hybrid species of the genus Fragaria, collectively known as the strawberries, which are cultivated worldwide for their fruit. The fruit is widely appreciated for its characteristic aroma, bright red color, juicy texture, and sweetness. It is consumed in large quantities, either fresh or in such prepared foods as jam, juice, pies, ice cream, milkshakes, and chocolates. Artificial strawberry flavorings and aromas are also widely used in products such as candy, soap, lip gloss, perfume, and many others.\n" +
          "The strawberry is not, from a botanical point of view, a berry. Technically, it is an aggregate accessory fruit, meaning that the fleshy part is derived not from the plant's ovaries but from the receptacle that holds the ovaries.[4] Each apparent \"seed\" (achene) on the outside of the fruit is actually one of the ovaries of the flower, with a seed inside it.\n" +
          "CULINARY\n" +
          "In addition to being consumed fresh, strawberries can be frozen or made into jam or preserves,[45] as well as dried and used in prepared foods, such as cereal bars. Strawberries and strawberry flavorings are a popular addition to dairy products, such as strawberry milk, strawberry ice cream, strawberry milkshakes/smoothies and strawberry yogurts.\n" +
          "In the United Kingdom, \"strawberries and cream\" is a popular dessert consumed at the Wimbledon tennis tournament.[5] Strawberries and cream is also a staple snack in Mexico, usually available at ice cream parlors. In Sweden, strawberries are a traditional dessert served on St John's Day, also known as Midsummer's Eve. Depending on area, strawberry pie, strawberry rhubarb pie, or strawberry shortcake are also common. In Greece, strawberries may be sprinkled with sugar and then dipped in Metaxa, a brandy, and served as a dessert. In Italy, strawberries are used for various desserts and as a common flavoring for gelato (gelato alla fragola).\n" +
          "Suonenjoki in North Savonia, Finland is famous small town for its strawberries, that's why is also known as \"the Strawberry Town\" or \"the Strawberry Capital\". Lots of foreign people, mainly from Ukraine and Russia, come to Suonenjoki in summer to work on strawberry farms. That makes Suonenjoki the most international town of Finland at summer. There is a party in Suonenjoki in July called Mansikkakarnevaalit, \"Strawberry Carnival\".\n" +
          "NUTRITION\n" +
          "One serving (100 g; see Table) of strawberries contains approximately 33 kilocalories, is an excellent source of vitamin C, a good source of manganese, and provides several other vitamins and dietary minerals in lesser amounts.\n" +
          "Strawberries contain a modest amount of essential unsaturated fatty acids in the achene (seed) oil.\n";
//                nutrition: ["136 kJ (33 kcal)","4.89 g","0.3 g","0.67 g","B1, B2, B3, B5, B6, B9, Choline, C, E, K","Calcium, Iron, Magnasium, Manganese, Phosphorus, Potassium, Sodium, Zinc"]
//                gradientColors: [Color("ColorStrawberryLight"), Color("ColorStrawberryDark")],

        allFruits.add(new Fruit(id, title, headline, image, description));

    }
}
